/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *create table user(
		user_id int primary key auto_increment,		-- 用户id
		user_name varchar(20),						-- 用户名
		user_password_encryption varchar(32),		-- 加密密码
		user_password_key varchar(10)				-- 密钥	
		user_admin varchar(1)						-- 管理员
		);
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	private Integer userIdInteger;
	private String userNameString;
	private String userPasswordEncryptionString;
	private String userPasswordKeyString;
	private String userAdminString;
	private List<Account> accounts;
	/**
	 * @return the userAdminString
	 */
	public String getUserAdminString() {
		return userAdminString;
	}

	/**
	 * @param userAdminString the userAdminString to set
	 */
	public void setUserAdminString(String userAdminString) {
		this.userAdminString = userAdminString;
	}

	
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Integer getUserIdInteger() {
		return userIdInteger;
	}

	public void setUserIdInteger(Integer userIdInteger) {
		this.userIdInteger = userIdInteger;
	}

	public String getUserNameString() {
		return userNameString;
	}

	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}

	public String getUserPasswordEncryptionString() {
		return userPasswordEncryptionString;
	}

	public void setUserPasswordEncryptionString(String userPasswordEncryptionString) {
		this.userPasswordEncryptionString = userPasswordEncryptionString;
	}

	public String getUserPasswordKeyString() {
		return userPasswordKeyString;
	}

	public void setUserPasswordKeyString(String userPasswordKeyString) {
		this.userPasswordKeyString = userPasswordKeyString;
	}

	@Override
	public String toString() {
		return "User [userIdInteger=" + userIdInteger + ", userNameString=" + userNameString
				+ ", userPasswordEncryptionString=" + userPasswordEncryptionString + ", userPasswordKeyString="
				+ userPasswordKeyString + ", userAdminString=" + userAdminString + "]";
	}
	
	

}
