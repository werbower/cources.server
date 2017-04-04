package com.softgroup.restserver.config.security;

import com.softgroup.token.TokenConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by user on 18.03.2017.
 */
@Configuration
@Import({ TokenConfig.class})
@EnableWebSecurity
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    MyFilterOfJWT myFilter;
    @Autowired
    MyProvider myProvider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/register");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
//                .authorizeRequests()
//                .antMatchers("/register")
//                .permitAll()
//                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
        //
        http
                .addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
