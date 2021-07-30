/**
 * 
 */
package TravelWebsite.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import TravelWebsite.dao.AccountDao;
import TravelWebsite.dao.UserDao;
import TravelWebsite.domain.Account;
import TravelWebsite.domain.User;
import TravelWebsite.service.LoginService;

/**
 * @author 3187102230 Õıº—±¶
 * ≥©”Œ¬√”ŒÕ¯
 *
 */
@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AccountDao accountDao;
	

	public User findUserByUserName(String userNameString) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(userNameString);
	}

	public Account findAccountByPhone(String accountPhoneString) {
		// TODO Auto-generated method stub
		return accountDao.findAccountByPhone(accountPhoneString);
	}

	public Account findAccountByEmail(String accountEmailString) {
		// TODO Auto-generated method stub
		return accountDao.findAccountByEmail(accountEmailString);
	}
	
	
	 @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertLogin(User user, Account account) {
		// TODO Auto-generated method stub
		 userDao.insertUser(user);
		account.setAccountUserIdInteger(user.getUserIdInteger());
		accountDao.insertAccount(account);
	}
	 @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateLogin(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	public User findUserById(Integer userIdInteger) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userIdInteger);
	}

}
