package com.codeblog.configuration;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_LIST = { "/", "/posts", "/posts/{id}" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers(AUTH_LIST)
                .permitAll().anyRequest().authenticated().and().formLogin()
                .permitAll().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/loggout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("twsm000")
                .password(passwordEncoder().encode(
                        "ifzwN!u9HJEx@8wiiR!NEXTc%nQhVHAXgi%VhxwCEbH@Rgoh%@^UT2z!Gac%f%@p4Uq7f4!$ZQaP^Vq!aSy5tSn7!znr2!bY&akYEQYFsQFeiMGYK#2ko23wNqR2XBmv"))
                .roles("ADMIN");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bootstrap/**");
    }

}
