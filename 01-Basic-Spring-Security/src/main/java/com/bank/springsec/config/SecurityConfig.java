package com.bank.springsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        UserDetails user = User
                .withUsername("mani")
                .password("{noop}m@123")
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}a@123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    SecurityFilterChain security(HttpSecurity http) {
        return http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/", "/contact").permitAll()
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/about").authenticated()
                                .anyRequest()
                                .denyAll()
                        )
                .formLogin(Customizer.withDefaults())
                .build();
    }

}
