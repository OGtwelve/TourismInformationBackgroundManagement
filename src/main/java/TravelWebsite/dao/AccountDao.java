/**
 * 
 */
package TravelWebsite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import TravelWebsite.domain.Account;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *create table account(
		account_id int primary key auto_increment,	-- 账户id
		account_phone varchar(11),					-- 手机号
		account_email varchar(20),					-- 邮箱
		account_id_card varchar(18),				-- 身份证
		account_age int(2),							-- 年龄
		account_gender varchar(1),					-- 性别
		account_balance decimal(9.1),				-- 余额
		user_id int,
		foreign key(user_id) references user(user_id)
		);
		--------------------------------------------------------------------
			private Integer accountIdInteger;
			private String accountPhoneString;
			private String accountEmailString;
			private String accountIdCardString;
			private String accountAgeString;
			private String accountGenderString ;
			private Double accountBalanceDouble;
			private Integer accountUserIdInteger;
	
			private User user;
 */
public interface AccountDao {
	/**
	 * 查询所有账户
	 * @return List<Account>
	 */
	@Results(id = "findAccountAllMap",value = {
            @Result(id = true,column = "account_id",property = "accountIdInteger"),
            @Result(column = "account_phone",property = "accountPhoneString"),
            @Result(column = "account_email",property = "accountEmailString"),
            @Result(column = "account_id_card",property = "accountIdCardString"),
            @Result(column = "account_age",property = "accountAgeString"),
            @Result(column = "account_gender",property = "accountGenderString"),
            @Result(column = "account_balance",property = "accountBalanceDouble"),
            @Result(column = "user_id",property = "accountUserIdInteger"),
            @Result(property = "user",column = "user_id",one = @One(select = "TravelWebsite.dao.UserDao.findUserById",fetchType = FetchType.EAGER))
    })
	@Select("select * from account")
	public List<Account> findAccountAll();
	
	/**
	 * 通过账户 id 查询
	 * @param accountIdInteger
	 * @return Account
	 */
	@Results(id = "AccountMap",value = {
            @Result(id = true,column = "account_id",property = "accountIdInteger"),
            @Result(column = "account_phone",property = "accountPhoneString"),
            @Result(column = "account_email",property = "accountEmailString"),
            @Result(column = "account_id_card",property = "accountIdCardString"),
            @Result(column = "account_age",property = "accountAgeString"),
            @Result(column = "account_gender",property = "accountGenderString"),
            @Result(column = "account_balance",property = "accountBalanceDouble"),
            @Result(column = "user_id",property = "accountUserIdInteger")
	})
	@Select("select * from account where account_id=#{INTEGER}")
	public Account findAccountById(Integer accountIdInteger);
	
	/**
	 * 通过账户 user_id 查询所有账户
	 * @param userIdInteger
	 * @return List<Account>
	 */
	@ResultMap(value = "AccountMap")
	@Select("select * from account where user_id=#{INTEGER}")
	public List<Account> findAccountAllByUserId(Integer userIdInteger);
	/**
	 * 通过账户 手机号 查询
	 * @param accountPhoneString
	 * @return Account
	 */
	@ResultMap(value = "AccountMap")
	@Select("select * from account where account_phone like #{STRING}")
	public Account findAccountByPhone(String accountPhoneString);
	
	/**
	 * 通过账户 邮箱 查询
	 * @param accountPhoneString
	 * @return Account
	 */
	@ResultMap(value = "AccountMap")
	@Select("select * from account where account_email like #{STRING}")
	public Account findAccountByEmail(String accountEmailString);
	
	/**
	 * 添加账户
	 * @param account
	 */
	@Insert("insert into account values(null,#{accountPhoneString},#{accountEmailString},#{accountIdCardString},#{accountAgeString},#{accountGenderString},#{accountBalanceDouble},#{accountUserIdInteger})")
	public void insertAccount(Account account);
	
	/**
	 * 修改用户
	 * @param account
	 */
	@Update("update account set account_phone=#{accountPhoneString},account_email=#{accountEmailString},account_id_card=#{accountIdCardString},account_age=#{accountAgeString},account_gender=#{accountGenderString},account_balance=#{accountBalanceDouble} where account_id=#{accountIdInteger}")
	public void updateAccount(Account account);
	
	/**
	 * 删除用户
	 * @param accountIdInteger
	 */
	@Delete("delete from account where account_id=#{INTEGER}")
	public void deleteAccountById(Integer accountIdInteger);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
