package com.example.demo;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.jms.annotation.EnableJms;

import com.example.demo.util.filter.CustomFilter;
import com.example.demo.util.listener.CustomListener;
import com.example.demo.util.servlet.CustomServlet;

@EnableRabbit
@EnableJms
@SpringBootApplication
//@ServletComponentScan
public class Demo1Application 
//implements ServletContextInitializer
{

//	@Bean
//	public ServletRegistrationBean servletRegistrationBean(){
//		return new ServletRegistrationBean(new CustomServlet(), "/roncoo");
//	}
//	
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean(){
//		return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
//	}
//	
//	@Bean
//	public ServletListenerRegistrationBean ServletListenerRegistrationBean(){
//		return new ServletListenerRegistrationBean(new CustomListener());
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		servletContext.addServlet("customServlet", new CustomServlet()).addMapping("/roncoo");
//		servletContext.addFilter("customFilter", new CustomFilter())
//				.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
//		servletContext.addListener(new CustomListener());
//	}
}
