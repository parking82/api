package com.parking82.api.config;

import com.parking82.api.services.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {

    private final UserDetailService userDetailService;

    public WebConfig(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(encoder());
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable()
                .apply(new CorsConfigurer<HttpSecurity>()) 
                .and()
                .authorizeHttpRequests(
                        authorizeConfig -> {

                            authorizeConfig.requestMatchers(HttpMethod.POST, "/usuario/cadastro").permitAll();
                            authorizeConfig.requestMatchers(HttpMethod.GET, "/usuario/login").permitAll();
                            authorizeConfig.requestMatchers(HttpMethod.GET, "/usuario/admin").hasRole("ADMIN");
                            authorizeConfig.requestMatchers(HttpMethod.GET, "/usuario/user").hasRole("USER");
                            authorizeConfig.anyRequest().authenticated();

                        })

                .formLogin()
                .loginPage("/usuario/login")
                .defaultSuccessUrl("/dashboard")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/usuario/login")
                .permitAll()
                
                .and().httpBasic()
                .and().build();

    }

}
