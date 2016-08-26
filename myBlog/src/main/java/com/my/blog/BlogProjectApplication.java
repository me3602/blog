package com.my.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class BlogProjectApplication{
	
    public static void main(String[] args) {
        SpringApplication.run(BlogProjectApplication.class, args);
    }
    
    /*@Bean
    ServletRegistrationBean h2ServletRegistrationBean(){
    	ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
    	registrationBean.addUrlMappings("/console/*");
    	return registrationBean;
    }*/
}
