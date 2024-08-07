package com.example.web_boot.Configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.http.HttpRequest;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class AuthConfig {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public  void account(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(bCryptPasswordEncoder.encode("1111")).roles("GUEST")
                .and()
                .withUser("user2").password(bCryptPasswordEncoder.encode("1111")).roles("USER", "GUEST")
                .and()
                .withUser("user3").password(bCryptPasswordEncoder.encode("1111")).roles("USER", "USER", "ADMIN");


    }

    @Bean
    public void configure(HttpRequest httpRequest) throws Exception{

        httpRequest.

    }

}
