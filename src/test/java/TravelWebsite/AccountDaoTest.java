/**
 * 
 */
package TravelWebsite;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import TravelWebsite.dao.AccountDao;
import TravelWebsite.domain.Account;
import config.ApplicationContext;

/**
 * @author 3187102230 李佳庆
 * 畅游旅游网
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class AccountDaoTest {
	@Resource(name = "accountDao")
	public AccountDao accountDao;
	
	@Test
	public void findAccountAll() {
		List<Account> accounts=accountDao.findAccountAll();
		for (Account account : accounts) {
			System.out.println(account);
			System.out.println(account.getUser());
			System.out.println("-------------------------------------------------------------");
		}
	}
//	@Test
	public void insertAccount() {
		Account account =new Account();
		account.setAccountPhoneString("17623097472");
		account.setAccountEmailString("1847783052@qq.com");
		account.setAccountIdCardString("44522119990822210");
		account.setAccountAgeString("22");
		account.setAccountGenderString("男");
		account.setAccountBalanceDouble(99999999.9);
		account.setAccountUserIdInteger(1);
		
		accountDao.insertAccount(account);
		findAccountAll();
	}
//	@Test
	public void updateAccount() {
		Account account =new Account();
		account.setAccountIdInteger(3);
		account.setAccountPhoneString("17623097472");
		account.setAccountEmailString("1847783052@qq.com");
		account.setAccountIdCardString("44522119990822210");
		account.setAccountAgeString("22");
		account.setAccountGenderString("女");
		account.setAccountBalanceDouble(99999.9);
		account.setAccountUserIdInteger(1);
		
		accountDao.insertAccount(account);
		findAccountAll();
	}
//	@Test
	public void delete() {
		accountDao.deleteAccountById(2);
		findAccountAll();
	}
//	@Test
	public void findAccountById() {
		System.out.println(accountDao.findAccountById(1));
	}
//	@Test
	public void findAaccountByPhone() {
		System.out.println(accountDao.findAccountByPhone("17623097472"));
	}
//	@Test
	public void findAaccountByEmail() {
		System.out.println(accountDao.findAccountByEmail("1847783052@qq.com"));
	}
}
