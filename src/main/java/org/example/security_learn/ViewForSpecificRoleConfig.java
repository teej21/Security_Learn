package org.example.security_learn;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewForSpecificRoleConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("hello");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/login").setViewName("login");
    }
}
