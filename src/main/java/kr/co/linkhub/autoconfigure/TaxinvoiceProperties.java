package kr.co.linkhub.autoconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

//configuration processor는 @ConfigurationProperties를 가지고 있는 모든 클래스와 메소드를 스캔함
//이를 통해서 configuration parameter에 접근하고 ,configuraton metadata를 생성함
@ConfigurationProperties(prefix = "popbill.taxinvoice")
public class TaxinvoiceProperties {
	private static final Log logger = LogFactory.getLog(TaxinvoiceProperties.class);
	
	TaxinvoiceProperties (){
		logger.debug("test");
	}
	
	private String linkid;
	private String secretkey;
	private boolean isTest;
	private boolean usestaticip;
	private boolean usegaip;
	private boolean uselocaltimeyn;
	private boolean iprestrectonoff;
	
	public String getLinkid() {
		return linkid;
	}
	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}
	public String getSecretkey() {
		return secretkey;
	}
	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}
	public boolean isTest() {
		return isTest;
	}
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}
	public boolean isUsestaticip() {
		return usestaticip;
	}
	public void setUsestaticiP(boolean usestaticip) {
		this.usestaticip = usestaticip;
	}
	public boolean isUsegaip() {
		return usegaip;
	}
	public void setUsegaip(boolean usegaip) {
		this.usegaip = usegaip;
	}
	public boolean isUselocaltimeyn() {
		return uselocaltimeyn;
	}
	public void setUselocaltimeyn(boolean uselocaltimeyn) {
		this.uselocaltimeyn = uselocaltimeyn;
	}
	public boolean isIprestrectonoff() {
		return iprestrectonoff;
	}
	public void setIprestrectonoff(boolean iprestrectonoff) {
		this.iprestrectonoff = iprestrectonoff;
	}
	
	
	
}
