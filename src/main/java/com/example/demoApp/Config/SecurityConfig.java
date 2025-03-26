package com.example.demoApp.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService ;
    // for creating conf file for self filter chain customization
    //@Bean
   // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //    return http.build();
   // } this by default adding above closes security filters

    @Bean // my own filter
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer->customizer.disable());
      http.authorizeHttpRequests(request->request.anyRequest().authenticated());
     // http.formLogin(Customizer.withDefaults());
     // http.formLogin(form->form.loginPage("/login"));
        // for rest
       http.httpBasic(Customizer.withDefaults());
        //http.logout(Customizer.withDefaults());
        // if csrf not use how to make stateless
       http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));





        return http.build();
    }
    // want to create my own user
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("sys").password("123").roles("USER").build();
//        UserDetails user2= User.withDefaultPasswordEncoder().username("hr").password("123").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
    // now with database connection
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       // authProvider.setPasswordEncoder((NoOpPasswordEncoder.getInstance()));
        //since now bcrypt
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }




}
