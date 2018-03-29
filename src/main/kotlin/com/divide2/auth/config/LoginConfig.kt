package com.divide2.auth.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource

/**
 * Created by bvvy on 2018/3/18.
 * com.divide2.auth.config
 */
@Configuration
class LoginConfig(val dataSource: DataSource) : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity) {
        http.httpBasic()
                .and()
                .logout().and()
                .authorizeRequests()
                .antMatchers("/gs-guide-websocket/**", "/", "/login/**", "/v1/dic/all", "/v1/label/all")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "select username,password,enabled from sys_user u where u.username = ?"
                )
                .authoritiesByUsernameQuery(
                        "select u.username,r.name from sys_user u left join sys_user_role ur on u.id=ur.user_id left join " +
                                " sys_role r on r.id=ur.role_id where u.username = ?"
                )
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}