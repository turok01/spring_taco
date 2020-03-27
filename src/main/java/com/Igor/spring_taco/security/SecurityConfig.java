package com.Igor.spring_taco.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

//end::customUserDetailsService[]

    //tag::configureHttpSecurity[]
    //tag::authorizeRequests[]
    //tag::customLoginPage[]
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").access("permitAll")
                //end::authorizeRequests[]

                .and()
                .formLogin()
                .loginPage("/login")
                //end::customLoginPage[]

                // tag::enableLogout[]
                .and()
                .logout()
                .logoutSuccessUrl("/")
                // end::enableLogout[]

                // Make H2-Console non-secured; for debug purposes
                // tag::csrfIgnore[]
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")
                // end::csrfIgnore[]

                // Allow pages to be loaded in frames from the same origin; needed for H2-Console
                // tag::frameOptionsSameOrigin[]
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
        // end::frameOptionsSameOrigin[]

        //tag::authorizeRequests[]
        //tag::customLoginPage[]
        ;
    }
    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());

    }

    //tag::configureAuthentication_jdbc_withQueries[]
    /*@Autowired
    DataSource dataSource;

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth
           .jdbcAuthentication()
                .dataSource(dataSource).usersByUsernameQuery(
                        "select username? password? enabled from Users " +
                         "where username = ?")
        .authoritiesByUsernameQuery(
                "select username, authority from UserAuthorities " +
                "where username=?")
           .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }

    */

    //
    // IN MEMORY AUTHENTICATION EXAMPLE
    //
    /*
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
          .inMemoryAuthentication()
            .withUser("root")
              .password("{noop}root")
                .authorities("ROLE_USER")
        .and()
        .withUser("igor")
        .password(encoder.encode("admin"))
        .authorities("ROLE_USER");
    }
     */
}
