package com.meb.projectmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    private final BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    public SecurityConfiguration(DataSource dataSource, BCryptPasswordEncoder bCryptEncoder) {
        this.dataSource = dataSource;
        this.bCryptEncoder = bCryptEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT username, password, enabled " +
                        "FROM user_accounts WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role " +
                        "FROM user_accounts WHERE username = ?")
                .dataSource(this.dataSource)
                .passwordEncoder(this.bCryptEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/projects/new").hasAuthority("ADMIN")
                .antMatchers("/projects/save").hasAuthority("ADMIN")
                .antMatchers("/employees/new").hasAuthority("ADMIN")
                .antMatchers("/employees/save").hasAuthority("ADMIN")
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin();
    }
}
