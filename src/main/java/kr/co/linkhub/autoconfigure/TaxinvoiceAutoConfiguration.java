package kr.co.linkhub.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.TaxinvoiceService;
import com.popbill.api.taxinvoice.TaxinvoiceServiceImp;

import kr.co.linkhub.autoconfigure.properties.TaxinvoiceProperties;

@Configuration
@EnableConfigurationProperties(TaxinvoiceProperties.class)
public class TaxinvoiceAutoConfiguration {
    @Autowired
    private TaxinvoiceProperties taxinvoiceProperties;

    private static final Logger logger = LoggerFactory.getLogger(TaxinvoiceAutoConfiguration.class);

    // @Lazy Lazy가 있지만 사용자측에서 Lazy 사용하지 않으면 결국에는 Spring컨텍스트 실행될때 사용해야 하기때문에 Bean 생성됨
    // @Lazy spring 3.0부터 존재
    // application.properties에도 true 설정하면 없어도 지연로딩 됨
    @Lazy
    @Bean(name = "TaxinvoiceService")
    @ConditionalOnClass({ TaxinvoiceService.class })
    public TaxinvoiceService taxinvoiceServiceConfig() {
        logger.info("POPBiLL Initializing TaxinvoiceService");
        TaxinvoiceService taxinvoiceService;

        TaxinvoiceServiceImp taxinvoiceServiceImp = new TaxinvoiceServiceImp();
        taxinvoiceServiceImp.setLinkID(taxinvoiceProperties.getLinkid());
        taxinvoiceServiceImp.setSecretKey(taxinvoiceProperties.getSecretkey());
        taxinvoiceServiceImp.setUseStaticIP(taxinvoiceProperties.isUsestaticip());
        taxinvoiceServiceImp.setUseGAIP(taxinvoiceProperties.isUsegaip());
        taxinvoiceServiceImp.setUseLocalTimeYN(taxinvoiceProperties.isUselocaltimeyn());
        taxinvoiceServiceImp.setIPRestrictOnOff(taxinvoiceProperties.isIprestrectonoff());

        taxinvoiceService = taxinvoiceServiceImp;

        return taxinvoiceService;
    }
}
