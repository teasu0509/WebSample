package com.tlg.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tlg.web.service.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    // .passwordEncoder(pwdEncoder).withUser("admin").password(pwdEncoder.encode("admin12345678"))
    // .roles("ADMIN", "MEMBER").and() //
    // .withUser("member").password(pwdEncoder.encode("12345678")).roles("MEMBER");
    // // 設定
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests() //
        .antMatchers("/resources/**").permitAll()//
        .antMatchers("/errors/**").permitAll()//
        .antMatchers("/admin/h2/**").hasRole("ADMIN")//
        .anyRequest().authenticated().and()//
        .exceptionHandling().accessDeniedPage("/errors/sysError403").and()//
        .formLogin().loginPage("/login").defaultSuccessUrl("/")//
        .failureUrl("/login?error=true").permitAll().and().logout().logoutSuccessUrl("/login?logout=true")
        .invalidateHttpSession(true).permitAll().and().csrf().disable();
    http.headers().frameOptions().disable();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImp();
  };

}
