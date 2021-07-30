/**
 * 
 */
package config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *ApplicationContext 相当于 spring.xml
 */
@Configuration
@ComponentScan(value = "TravelWebsite", excludeFilters = { @ComponentScan.Filter(classes = Controller.class) })
@PropertySource(value = "classpath:JdbcDataSource.properties")
@Import(JdbcConfiguration.class)
@EnableTransactionManagement
public class ApplicationContext {
	/**
	 * 基于MyBatis的依赖注入DAOs。
	 * {@code FactoryBean} that creates a MyBatis {@code SqlSessionFactory}. This is the usual way to set up a shared
	 * MyBatis {@code SqlSessionFactory} in a Spring application context; the SqlSessionFactory can then be passed to
	 * MyBatis-based DAOs via dependency injection.
	 * @param dataSource
	 * @return
	 */
	@Bean("sqlSessionFactoryBean")
	public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}

	/**
	 * 从基包开始递归搜索接口
	 * BeanDefinitionRegistryPostProcessor that searches recursively starting from a base package for interfaces and
	 * registers them as {@code MapperFactoryBean}. Note that only interfaces with at least one method will be registered;
	 * concrete classes will be ignored.
	 * @return
	 */
	@Bean("mapperScanner")
	public MapperScannerConfigurer createMapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("TravelWebsite.dao");
		return mapperScannerConfigurer;

	}
	/**
	 * 配置spring aop 事务bean
	 *  * {@link org.springframework.transaction.PlatformTransactionManager}
	 * implementation for a single JDBC {@link javax.sql.DataSource}. This class is
	 * capable of working in any environment with any JDBC driver, as long as the setup
	 * uses a {@code javax.sql.DataSource} as its {@code Connection} factory mechanism.
	 * Binds a JDBC Connection from the specified DataSource to the current thread,
	 * potentially allowing for one thread-bound Connection per DataSource.
	 * @param dataSource
	 * @return
	 */
    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
