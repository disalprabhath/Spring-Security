package com.project.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()

                //step 1
//                .antMatchers("api/v1/account/***","api/v1/loan/**").authenticated()
//                .antMatchers("api/v1/user/**","api/v1/notice/**").permitAll()

                //step 2
                .antMatchers("/api/v1/account/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/v1/loan/**").hasAuthority("ROLE_USER")
                .antMatchers("/api/v1/user/**","/api/v1/notice/**").permitAll()

                //step 3 Methord level security
//                .antMatchers("/api/v1/account/**").authenticated()
//                .antMatchers("/api/v1/loan/**").authenticated()
//                .antMatchers("/api/v1/user/**","/api/v1/notice/**").permitAll()

                .and().formLogin().and().httpBasic();

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        return new InMemoryUserDetailsManager(admin);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
