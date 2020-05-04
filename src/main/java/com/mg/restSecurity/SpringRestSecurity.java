package com.mg.restSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

public class SpringRestSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("password")).roles("USER", "ADMIN");
    }

//    // Secure the endpoins with HTTP Basic authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH, "/").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/").hasRole("ADMIN")
//                .and()
//                .formLogin().disable();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint);
    }
}
