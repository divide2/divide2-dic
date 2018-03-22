package com.divide2.auth.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Created by bvvy on 2018/3/18.
 * com.divide2.auth.config
 */
@Configuration
class LoginConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.httpBasic()
                .and()
                .logout().and()
                .authorizeRequests()
                .antMatchers("/join", "/", "/login", "/v1/dic/all", "/v1/label/all")
                .permitAll()
                .anyRequest()
                .authenticated()
    }

}