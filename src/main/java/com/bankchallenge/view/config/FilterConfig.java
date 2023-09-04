package com.bankchallenge.view.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

   @Bean
   public FilterRegistrationBean loginFilter() {
      final FilterRegistrationBean registration = new FilterRegistrationBean();
      registration.setFilter(new LoginFilter());
      registration.addUrlPatterns("/bank-challenge/pages/*", "/pages/*", "/challenge/rest/*");
      return registration;
   }

}
