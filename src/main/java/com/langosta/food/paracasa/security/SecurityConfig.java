package com.langosta.food.paracasa.security;

import com.langosta.food.paracasa.config.CustomAccessDeniedHandler;
import com.langosta.food.paracasa.security.service.UserDetailsServiceImpl;
import com.langosta.food.paracasa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

   /* @Autowired
    private BCryptPasswordEncoder bcrypt;*/

    @Bean
    AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
   @Bean
   public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
   /*     http
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();*/
      /*  http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/usuario/save").permitAll()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();

*/
        String[] resources = new String[]{
                "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
        };
    /*    http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/register","/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/userForm")
                .failureUrl("/login?error=true")
                .usernameParameter("nombreUsuario")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");*/
        http.authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers(   "/login", "/register" )
                .permitAll()
                .antMatchers("/usuario/save")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/index")
                .usernameParameter("nombreUsuario")
                .passwordParameter("password")
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll()
                .deleteCookies("JSESSIONID");


    }




}
