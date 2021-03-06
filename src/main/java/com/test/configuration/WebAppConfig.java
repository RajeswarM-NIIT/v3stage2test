package com.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
//<mvc:annotation-driven></mvc:annotation-driven>
@EnableWebMvc
//scan the components for creating the beans - controllers, services and repository
@ComponentScan(basePackages="com.test")
public class WebAppConfig extends WebMvcConfigurerAdapter{
	@Bean	
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}


	
	
}


/*
<bean id="javaMailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
<property name="host" value="smtp.gmail.com"/>
<property name="username" value="BuyToysDT5@gmail.com"/>
<property name="password" value="BuyToys@Dt5"/>
<property name="javaMailProperties">
<props>
<prop key="mail.smtp.auth">true</prop>
<prop key="mail.smtp.port">587</prop>
<prop key="mail.smtp.starttls.enable">true</prop>
</props>
</property>
</bean>
*/








/*

<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">  
<!-- one of the properties available; the maximum file size in bytes -->  
<property name="maxUploadSize" value="5242880">  
</property> 
</bean>*/