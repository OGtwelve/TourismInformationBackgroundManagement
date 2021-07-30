/**
 * 
 */
package TravelWebsite.dao;

import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import TravelWebsite.domain.User;


/**
 * @author 3187102230 ���ѱ�
 * ����������
 *	private Integer userIdInteger;
	private String userNameString;
	private String userPasswordEncryptionString;
	private String userPasswordKeyString;
	private String userAdminString;
	
	private List<Account> accounts;
	----------------------------------------------------------------------
	user_id int primary key auto_increment,		-- �û�id
	user_name varchar(20),						-- �û���
	user_password_encryption varchar(32),		-- ��������
	user_password_key varchar(10)				-- ��Կ	
	user_admin varchar(1)						-- ����Ա

 */
public interface UserDao {
	/**
	 * ��ѯ�����û�
	 * @return List<User>
	 */
	@Results(id = "findUserAllMap",value = {
            @Result(id = true,column = "user_id",property = "userIdInteger"),
            @Result(column = "user_name",property = "userNameString"),
            @Result(column = "user_password_encryption",property = "userPasswordEncryptionString"),
            @Result(column = "user_password_key",property = "userPasswordKeyString"),
            @Result(column = "user_admin",property = "userAdminString"),
            @Result(property = "accounts",column = "user_id",many = @Many(select = "TravelWebsite.dao.AccountDao.findAccountAllByUserId",fetchType = FetchType.LAZY))
    })
	@Select("select * from user")
	public List<User> findUserAll();
	
	/**
	 * ͨ���û� id ��ѯ
	 * @param userIdInteger
	 * @return User
	 */
	@Results(id = "UserMap",value = {
            @Result(id = true,column = "user_id",property = "userIdInteger"),
            @Result(column = "user_name",property = "userNameString"),
            @Result(column = "user_password_encryption",property = "userPasswordEncryptionString"),
            @Result(column = "user_password_key",property = "userPasswordKeyString"),
            @Result(column = "user_admin",property = "userAdminString")
    })
	@Select("select * from user where user_id=#{INTEGER}")
	public User findUserById(Integer userIdInteger);
	
	/**
	 * ͨ���û� �� ��ѯ
	 * @param userNameString
	 * @return User
	 */
	@ResultMap(value = "UserMap")
	@Select("select * from user where user_name like #{STRING}")
	public User findUserByUserName(String userNameString);
	
	/**
	 * ����û�
	 * @param user
	 */
	@Insert("insert into user values(null,#{userNameString},#{userPasswordEncryptionString},#{userPasswordKeyString},#{userAdminString})")
	@Options(useGeneratedKeys=true, keyProperty="userIdInteger", keyColumn="user_id")
	public void insertUser(User user);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	@Update("update user set user_name=#{userNameString},user_password_encryption=#{userPasswordEncryptionString},user_password_key=#{userPasswordKeyString},user_admin=#{userAdminString} where user_id=#{userIdInteger}")
	public void updateUser(User user);
	
	/**
	 * ɾ���û�
	 * @param userIdInteger
	 */
	@Delete("delete from user where user_id=#{INTEGER}")
	public void deleteUserById(Integer userIdInteger);
}
