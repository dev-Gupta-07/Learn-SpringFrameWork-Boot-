package com.example.demoApp.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // for creating conf file for self filter chain customization
    //@Bean
   // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //    return http.build();
   // } this by default adding above closes security filters

    @Bean // my own filter
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       // http.csrf(customizer->customizer.disable());
     // http.authorizeHttpRequests(request->request.anyRequest().authenticated());
     // http.formLogin(Customizer.withDefaults());
     // http.formLogin(form->form.loginPage("/login"));
        // for rest
       // http.httpBasic(Customizer.withDefaults());
        //http.logout(Customizer.withDefaults());
        // if csrf not use how to make stateless
       // http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));





        return http.build();
    }



}
