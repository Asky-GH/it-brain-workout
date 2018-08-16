package kz.abishev.askhat.itbrainworkout.configs;

import kz.abishev.askhat.itbrainworkout.utils.MySQLUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MySQLUserDetailsService mySQLUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mySQLUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/users", "/subjects/new").hasRole("ADMIN")
                .antMatchers("/questions/{subjectTitle}/pending").hasRole("MODER")
                .antMatchers("/js/**", "/images/**").permitAll()
                .antMatchers("/", "/auth/registration", "/subjects/{subjectTitle}", "/{subjectTitle}/test", "/result").permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login").permitAll()
            .and()
                .logout().permitAll();
    }
}
