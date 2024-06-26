//package com.HAH.mapping;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.HAH.mapping.controller")
//public class ServletConfig implements WebMvcConfigurer {
//
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp().prefix("/views/").suffix(".jsp");
//	}
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addRedirectViewController("/", "/course");
//	}
//
//}