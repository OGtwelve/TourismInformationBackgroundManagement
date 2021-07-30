/**
 * 
 */
package TravelWebsite;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import TravelWebsite.dao.UserDao;
import TravelWebsite.domain.User;
import TravelWebsite.utils.RandomStringUtil;
import config.ApplicationContext;

/**
 * @author 3187102230 ¿Óº—«Ï ≥©”Œ¬√”ŒÕ¯
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class UserDaoTest {
	@Resource(name = "userDao")
	public UserDao userDao;

	@Test
	public void findUserAll() {
		List<User> users = userDao.findUserAll();
		for (User user : users) {
			System.out.println(user);
			System.out.println(user.getAccounts());
		}
	}
//	@Test
	public void findUserById() {
		System.out.println(userDao.findUserById(2));
	}
//	@Test
	public void findUserByName() {
		System.out.println(userDao.findUserByUserName("¿Óº—«Ï"));
	}
//	@Test
	public void insertUser() {
		User user=new User();
		user.setUserNameString("¿Óº—«Ï");
		user.setUserPasswordKeyString(RandomStringUtil.getRandomString(10));
		user.setUserPasswordEncryptionString(DigestUtils.md5Hex(user.getUserPasswordKeyString()+"123456"));
		
		userDao.insertUser(user);
	}
//	@Test
	public void updateUser() {
		User user=new User();
		user.setUserIdInteger(2);
		user.setUserNameString("∫˙Ê¬");
		user.setUserPasswordKeyString(RandomStringUtil.getRandomString(10));
		user.setUserPasswordEncryptionString(DigestUtils.md5Hex(user.getUserPasswordKeyString()+"123456"));
		userDao.updateUser(user);
	}
//	@Test
	public void delete() {
		userDao.deleteUserById(5);
		findUserAll();
	}
}
