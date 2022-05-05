package com.example.timetable.app.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private MyUserDetailsService DetailService;


    private boolean disableLocalConfigureAuthenticationBldr;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        this.disableLocalConfigureAuthenticationBldr = true;
        auth.userDetailsService(DetailService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public static PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/timetable/department/*").permitAll()
                .antMatchers("/swagger-ui/*").permitAll()
                .antMatchers("/timetable/course/*").permitAll()
                .antMatchers("/timetable/unit/*").permitAll()
                .antMatchers("/timetable/rank/*").permitAll()
                .antMatchers("/timetable/faculty/*").hasAnyAuthority("HOD","chairman")
                .antMatchers("/timetable/institution/*").permitAll()
//              .antMatchers("/timetable/department/fetchAllDepartments/**").hasAnyAuthority("HOD")
                .antMatchers("/timetable/authenticate/**").permitAll()
                .antMatchers("/timetable/login/*").permitAll()

                .antMatchers("/timetable/user/createUser").permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers("/register",
                        "/resources/**",
                        "/css/**",
                        "/fonts/**",
                        "/img/**",
                        "/js/**").permitAll()
                .antMatchers(HttpHeaders.ALLOW).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
                and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and().formLogin().disable();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }




    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs")//
                .antMatchers("/swagger-resources/**")//
                .antMatchers("/swagger--ui/#/**")//
                .antMatchers("/configuration/**")//
                .antMatchers("/webjars/**")//
                .antMatchers("/static/**")
                .antMatchers("/public/**")

                // Un-secure H2 Database (for testing purposes, H2 console shouldn't be
                // unprotected in production)
                .and().ignoring().antMatchers("/h2-console/**/**");
    }

}
