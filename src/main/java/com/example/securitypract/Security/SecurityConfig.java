package com.example.securitypract.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// role based annotations practice :::::::
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder ;

    @Autowired
    SecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }


    //  creating user
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        System.out.println(ApplicationUserRule.ADMIN.getPermissions());
         UserDetails  shahzaib = User.builder()
                .username("shahzaib")
                .password(passwordEncoder.encode("123"))
//                .roles(ApplicationUserRule.STUDENT.name())
                 //adding custom made authorities
                 .authorities(ApplicationUserRule.STUDENT.getGrantedAuthorities())

                 .build();

        UserDetails  ali = User.builder()
                .username("ali")
                .password(passwordEncoder.encode("123"))
//                .roles(ApplicationUserRule.ADMIN.name())
                //adding custom made authorities
                .authorities(ApplicationUserRule.ADMIN.getGrantedAuthorities())
                .build();
        System.out.println(ApplicationUserRule.ADMIN.getGrantedAuthorities());
        UserDetails  aqib = User.builder()
                .username("aqib")
                .password(passwordEncoder.encode("123"))
//                .roles(ApplicationUserRule.TRAINEE.name())
                //adding custom made authorities
                .authorities(ApplicationUserRule.TRAINEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                shahzaib,
                ali,
                aqib
        );
    }
}
