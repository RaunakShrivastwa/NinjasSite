package com.Teaching.config;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Teaching.service.CustomeuserDetailsService;

import javax.sql.DataSource;


@Configuration
 @EnableWebSecurity
public class webConfigFile extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomeuserDetailsService();
    }
     @Autowired
     private DataSource dataSource;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                // .antMatchers("/java").hasAnyRole("ADMIN","NORMAL")
                .antMatchers("/about").hasAnyRole("ADMIN","NORMAL")

                .antMatchers("/bca").hasAnyRole("ADMIN","NORMAL")
                .antMatchers("/mca").hasAnyRole("ADMIN","NORMAL")
                .antMatchers("/certificates").hasAnyRole("ADMIN","NORMAL")
                .antMatchers("/c","/java")

                .authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/cheakPage")
                .usernameParameter("email")

                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/LogOut"))
                .logoutSuccessUrl("/loginPage")
                .invalidateHttpSession(true)        // set invalidation state when logout
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access");
    }


}
