package com.astonengineers.version1.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@Configuration
@EnableWebSecurity
public class WebConfig {

    /**
     * Authenticating the user by using in memory details - here we hardcode username and password
     * @param passwordEncoder
     * @return instance of the user object
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("kwame")
            .password(passwordEncoder.encode("kwame"))
            .roles("USER")
            .build();

        UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder.encode("admin"))
            .roles("USER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }


    /**
     * SecurityFiler Chain using basic authentication
     * the servlet filter chain proxy that handles all requests to the route defined in spring security.
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
            .csrf().disable()
                .cors().and()
                .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/login/**").hasRole("USER")
                    .requestMatchers("/register/**").hasRole("USER")
                    .anyRequest().authenticated()
                )
           .httpBasic(Customizer.withDefaults());

        return http.build();
    }


    /**
     * Stores the authentication in the session using stateless mechanism
     * @param http
     * @return an instance of ..
     * @throws Exception
     */
//    @Bean
//    SecurityFilterChain web(HttpSecurity http) throws Exception {
//        http
//            // ...
//            .httpBasic((basic) -> basic
//                .addObjectPostProcessor(new ObjectPostProcessor<BasicAuthenticationFilter>() {
//                    @Override
//                    public <O extends BasicAuthenticationFilter> O postProcess(O filter) {
//                        filter.setSecurityContextRepository(new HttpSessionSecurityContextRepository());
//                        return filter;
//                    }
//                })
//            );
//
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) {
//        http
//            .sessionManagement(session -> session
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(true)
//            );
//        return http.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        return encoder;
    }
}
