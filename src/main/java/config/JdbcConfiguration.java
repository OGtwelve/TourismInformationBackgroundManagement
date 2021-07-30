/**
 * 
 */
package config;





import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


import com.alibaba.druid.pool.DruidDataSource;


/**
 * JDBC �������ӳ�
 * @author 3187102230 ���ѱ�
 * ����������
 *
 */
public class JdbcConfiguration {
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;


	/**
	 * �� DataSource ��ӵ� ioc bean ��
	 * @return DataSource
	 */
	@Bean("dataSource")
	public DataSource createDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
