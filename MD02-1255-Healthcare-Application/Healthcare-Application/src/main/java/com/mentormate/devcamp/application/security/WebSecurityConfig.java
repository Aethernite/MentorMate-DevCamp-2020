package com.mentormate.devcamp.application.security;

import com.mentormate.devcamp.application.security.filter.JwtAuthenticationTokenFilter;
import com.mentormate.devcamp.application.security.util.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The Web security config.
 * <p>
 * Configures the web security and all of the ants and their authority roles.
 */
@RequiredArgsConstructor
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    /**
     * Authentication jwt token filter Bean
     *
     * @return new jwt authentication token filter
     */
    @Bean
    public JwtAuthenticationTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Password encoder Bean
     *
     * @return new password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/signup").permitAll()
                .antMatchers("/api/v1/auth/signin").permitAll()
                .antMatchers("/api/v1/appointments").permitAll()
                .antMatchers("/api/v1/appointments/me").hasAuthority("DOCTOR")
                .antMatchers("/api/v1/appointments/*").permitAll()
                .antMatchers("/api/v1/appointments/set/").hasAuthority("DOCTOR")
                .antMatchers("/api/v1/appointments/set/**").hasAuthority("DOCTOR")
                .antMatchers("/api/v1/doctors").hasAnyAuthority("CUSTOMER")
                .antMatchers("/api/v1/drugs").hasAuthority("DOCTOR")
                .antMatchers("/api/v1/drugs/**").hasAuthority("DOCTOR");

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
