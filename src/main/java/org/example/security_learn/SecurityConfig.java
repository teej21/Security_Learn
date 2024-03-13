package org.example.security_learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain setFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.
                requestMatchers("/").permitAll().
                requestMatchers("/user").hasRole("USER").
                requestMatchers("/admin").hasRole("ADMIN"));
        http.formLogin((form) -> form.loginPage("/login").permitAll());
        http.logout((logout) -> logout.logoutSuccessUrl("/").permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user =
                User.builder()
                        .username("user")
                        .password(encoder.encode("password")) // Password is now encoded
                        .roles("USER")
                        .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("password")) // Password is now encoded
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}

