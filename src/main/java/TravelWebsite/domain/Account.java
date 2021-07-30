/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *账户表
		create table account(
		account_id int primary key auto_increment,	-- 账户id
		account_phone varchar(11),					-- 手机号
		account_email varchar(20),					-- 邮箱
		account_id_card varchar(18),				-- 身份证
		account_age varchar(2),							-- 年龄
		account_gender varchar(1),					-- 性别
		account_balance decimal(9.1),				-- 余额
		user_id int,
		foreign key(user_id) references user(user_id)
		);
 */
@SuppressWarnings("serial")
public class Account implements Serializable{
	private Integer accountIdInteger;
	private String accountPhoneString;
	private String accountEmailString;
	private String accountIdCardString;
	private String accountAgeString;
	private String accountGenderString ;
	private Double accountBalanceDouble;
	private Integer accountUserIdInteger;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getAccountIdInteger() {
		return accountIdInteger;
	}
	public void setAccountIdInteger(Integer accountIdInteger) {
		this.accountIdInteger = accountIdInteger;
	}
	public String getAccountPhoneString() {
		return accountPhoneString;
	}
	public void setAccountPhoneString(String accountPhoneString) {
		this.accountPhoneString = accountPhoneString;
	}
	public String getAccountEmailString() {
		return accountEmailString;
	}
	public void setAccountEmailString(String accountEmailString) {
		this.accountEmailString = accountEmailString;
	}
	public String getAccountIdCardString() {
		return accountIdCardString;
	}
	public void setAccountIdCardString(String accountIdCardString) {
		this.accountIdCardString = accountIdCardString;
	}
	public String getAccountAgeString() {
		return accountAgeString;
	}
	public void setAccountAgeString(String accountAgeString) {
		this.accountAgeString = accountAgeString;
	}
	public String getAccountGenderString() {
		return accountGenderString;
	}
	public void setAccountGenderString(String accountGenderString) {
		this.accountGenderString = accountGenderString;
	}
	public Double getAccountBalanceDouble() {
		return accountBalanceDouble;
	}
	public void setAccountBalanceDouble(Double accountBalanceDouble) {
		this.accountBalanceDouble = accountBalanceDouble;
	}
	public Integer getAccountUserIdInteger() {
		return accountUserIdInteger;
	}
	public void setAccountUserIdInteger(Integer accountUserIdInteger) {
		this.accountUserIdInteger = accountUserIdInteger;
	}
	@Override
	public String toString() {
		return "Account [accountIdInteger=" + accountIdInteger + ", accountPhoneString=" + accountPhoneString
				+ ", accountEmailString=" + accountEmailString + ", accountIdCardString=" + accountIdCardString
				+ ", accountAgeString=" + accountAgeString + ", accountGenderString=" + accountGenderString
				+ ", accountBalanceDouble=" + accountBalanceDouble + ", accountUserIdInteger=" + accountUserIdInteger
				+ "]";
	}
	
	
}
