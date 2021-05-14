package com.course.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

    /*
    * Now we create "In memory authentication, we need add this configuration
    * */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // With this code can we add the username, password  and role

        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("password"))
                .roles("ADMIN") // now we will create a new role for give different access to our endpoints
                .and()
                .withUser("user")
                .password(encoder().encode("password1"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* I'm going to create a definition for protect endpoints more exactly
         * now if we want to to access to /products we won't access but another endpoint like
         * /users we will have access
         * */
        http.csrf().disable().authorizeRequests()
                .antMatchers("/products/**").hasRole("ADMIN")
                .antMatchers("/users/**")
                    .authenticated().and().httpBasic();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
