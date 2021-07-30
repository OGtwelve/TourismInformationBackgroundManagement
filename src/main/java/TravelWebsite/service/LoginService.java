/**
 * 
 */
package TravelWebsite.service;



 

import TravelWebsite.domain.Account;
import TravelWebsite.domain.User;

/**
 * @author 3187102230 Õıº—±¶
 * ≥©”Œ¬√”ŒÕ¯
 *loginService
 */
public interface LoginService {
	
	public User findUserByUserName(String userNameString);
	public Account findAccountByPhone(String accountPhoneString);
	public Account findAccountByEmail(String accountEmailString);
	public User findUserById(Integer userIdInteger);
	
	public void insertLogin(User user,Account account);
	public void updateLogin(User user);
	
}
