package TravelWebsite;




import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import TravelWebsite.domain.Account;
import TravelWebsite.domain.User;
import TravelWebsite.service.LoginService;
import TravelWebsite.utils.RandomStringUtil;
import config.ApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class LoginTest {
	@Autowired
	private LoginService loginService;

	@Test
	public void insertLogin() {
		Account account =new Account();
		User user=new User();
		
		user.setUserNameString("ºúæÂ");
		user.setUserPasswordKeyString(RandomStringUtil.getRandomString(10));
		user.setUserPasswordEncryptionString(DigestUtils.md5Hex(user.getUserPasswordKeyString()+"123456"));
		user.setUserAdminString("T");
		
		account.setAccountPhoneString("13950720390");
		account.setAccountEmailString("13950720390@qq.com");
		account.setAccountIdCardString(null);
		account.setAccountAgeString("0");
		account.setAccountGenderString("Å®");
		account.setAccountBalanceDouble(0d);
//		
	
		loginService.insertLogin(user, account);
	}
}
