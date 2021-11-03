package kr.co.linkhub.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.popbill.api.CashbillService;
import com.popbill.api.cashbill.CashbillServiceImp;

import kr.co.linkhub.autoconfigure.properties.CashbillProperties;
import kr.co.linkhub.autoconfigure.properties.TaxinvoiceProperties;

@Configuration
@EnableConfigurationProperties(TaxinvoiceProperties.class)
public class CashbillAutoConfiguration {
    @Autowired
    private CashbillProperties cashbillProperties;

    private static final Logger logger = LoggerFactory.getLogger(CashbillAutoConfiguration.class);

    @Lazy
    @Bean(name = "CashbillService")
    @ConditionalOnClass({ CashbillService.class })
    public CashbillService CashbillServiceConfig() {
        logger.info("POPBiLL Initializing CashbillService");
        CashbillService cashbillService;

        CashbillServiceImp cashbillServiceImp = new CashbillServiceImp();
        cashbillServiceImp.setLinkID(cashbillProperties.getLinkid());
        cashbillServiceImp.setSecretKey(cashbillProperties.getSecretkey());
        cashbillServiceImp.setUseStaticIP(cashbillProperties.isUsestaticip());
        cashbillServiceImp.setUseGAIP(cashbillProperties.isUsegaip());
        cashbillServiceImp.setUseLocalTimeYN(cashbillProperties.isUselocaltimeyn());
        cashbillServiceImp.setIPRestrictOnOff(cashbillProperties.isIprestrectonoff());

        cashbillService = cashbillServiceImp;

        return cashbillService;
    }
}
