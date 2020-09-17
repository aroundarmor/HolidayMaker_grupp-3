package com.newton.holidaymaker.security;

import com.newton.holidaymaker.repositories.UserRepository;
import com.newton.holidaymaker.services.MainUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
<<<<<<< Updated upstream

    @Bean
    public UserDetailsService userDetailsService (){
        return new MyUserDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }
=======
    @Autowired
    UserRepository userRepository;

    
    MainUserDetailsService mainUserDetailsService;
    public SecurityConfiguration(MainUserDetailsService mainUserDetailsService){
        this.mainUserDetailsService = mainUserDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.authenticationProvider(authProvider());
    }

    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/api").authenticated()
            .antMatchers("/api/test/**").hasRole("ADMIN")
            .antMatchers("/allusers").hasAuthority("USER_READ")
            // .antMatchers("api/test/user/**").hasRole("USER")
            .and()
            .formLogin();
        
            // http.authorizeRequests()    
        //     .antMatchers(
        //         "/rest/**", 
        //         "/users",
        //         "/users/{id}"
        //         )
        //     .authenticated()
        //     .antMatchers("/users/register").anonymous()
        //     .anyRequest()
        //     .permitAll()
        //     .and()
        //     .formLogin();
>>>>>>> Stashed changes

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

<<<<<<< Updated upstream
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/customer").hasAnyRole("ADMIN", "CUSTOMER")
            .antMatchers("/").permitAll()
            .and().formLogin();
=======
    @Bean
    DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(encodePass());
        authenticationProvider.setUserDetailsService(this.mainUserDetailsService);
        return authenticationProvider;
    }
>>>>>>> Stashed changes

    }
    
}
