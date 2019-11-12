package com.ipartek.formacion.ejemplocompleto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsService userDetails;
    
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails);
    }
    
    // https://www.browserling.com/tools/bcrypt (10 rounds)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Autowired
//    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetails)
//                .passwordEncoder(passwordEncoder());
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	//.csrf().disable()
        	.exceptionHandling().accessDeniedPage("/403")
        		.and()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/listado").hasAnyRole("USER")
                .anyRequest().hasRole("ADMIN")
                .and()
            .formLogin()
               	.loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

//    @SuppressWarnings("deprecation")
//	@Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//             User.withDefaultPasswordEncoder()
//                .username("javier")
//                .password("contra")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}