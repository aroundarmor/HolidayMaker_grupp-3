package com.newton.holidaymaker.security;

import com.newton.holidaymaker.services.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsService userDetailsService;
    @Autowired private SuccessHandler customSuccessHandler;
    @Autowired private FailureHandler customFailureHandler;

    private MyUserDetailsService myUserDetailsService;

    @Bean
    public UserAuthenticationFilter authenticationFilter() throws Exception {
        UserAuthenticationFilter authenticationFilter = new UserAuthenticationFilter();
        authenticationFilter.setAuthenticationSuccessHandler(this.customSuccessHandler);
        authenticationFilter.setAuthenticationFailureHandler(this.customFailureHandler);
        authenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationFilter;
    }

    public SecurityConfiguration(MyUserDetailsService myUserDetailsService){
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/users/**").hasRole("ADMIN")
        .antMatchers("/rest/auth/process").hasAuthority("HOTEL_READ")
        .antMatchers("/secure/auth/**").hasRole("ADMIN")
        .and()
        // login filter
        .addFilterBefore(authenticationFilter(), UserAuthenticationFilter.class);
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(encodePass());
        authProvider.setUserDetailsService(this.myUserDetailsService);
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder encodePass(){
        return new BCryptPasswordEncoder();
    }
}
