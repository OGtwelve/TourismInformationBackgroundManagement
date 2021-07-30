/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 3187102230 ���ѱ�
 * ����������
 *create table user(
		user_id int primary key auto_increment,		-- �û�id
		user_name varchar(20),						-- �û���
		user_password_encryption varchar(32),		-- ��������
		user_password_key varchar(10)				-- ��Կ	
		user_admin varchar(1)						-- ����Ա
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
