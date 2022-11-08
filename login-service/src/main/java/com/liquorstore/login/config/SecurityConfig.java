package com.liquorstore.login.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig  {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Bean
    public InMemoryUserDetailsManager userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.builder().username("mittul").password(passwordEncoder.encode("1234")).roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeHttpRequests().anyRequest().hasRole("USER")
                            .and().formLogin().loginPage("/login.jsp")
                            .failureUrl("/login.jsp?error=1").loginProcessingUrl("/profile")
                            .permitAll().and().logout()
                            .logoutSuccessUrl("/profile/listEmployees.html");
        return http.build();
    }

}
