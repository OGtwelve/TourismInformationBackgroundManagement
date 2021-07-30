package config;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



/**
 * SpringMVCConfiguration �൱�� springMVCConfiguration.xml
 * 
 * @author 3187102230 ���ѱ� ����������
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "TravelWebsite", includeFilters = { @ComponentScan.Filter(classes = Controller.class) })
public class SpringMVCConfiguration implements WebMvcConfigurer {

	/**
	 * ���˾�̬��Դ
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
	}

	/**
	 * ��ͼ������
	 * 
	 * @return
	 */
	@Bean("internalResourceViewResolver")
	public InternalResourceViewResolver createInternalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	/**
	 *  ����Աҳ��������
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new HandlerInterceptor() {
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				// TODO Auto-generated method stub
				
				if(request.getSession().getAttribute("loginId")==null) {
					response.sendRedirect(request.getContextPath()+"/login?text="+ URLEncoder.encode("-���ȵ�¼Ŷ", StandardCharsets.UTF_8));
				}

				
				return true;
			}	
		}).addPathPatterns("/admin/**");
	}
	
	@Bean("multipartResolver")
	public CommonsMultipartResolver createCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760);
		return multipartResolver;
	}

	

}
