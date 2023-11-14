package de.hbrs.se2.womm.config;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import de.hbrs.se2.womm.views.newdom.LoginViewDo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        APIRequestMatcher aPIRequestMatcher = new APIRequestMatcher();
        http.authorizeHttpRequests(urlRegistry -> {
            urlRegistry.requestMatchers(aPIRequestMatcher)
                    .permitAll();
        });
        super.configure(http);
        setLoginView(http, LoginViewDo.class);
    }




    //ToDo Connect to DB
    @Bean
    UserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("student")
                        .password("{noop}student").
                        roles("STUDENT").build(),
                User.withUsername("unternehmen")
                        .password("{noop}unternehmen").
                        roles("UNTERNEHMEN").build(),
                User.withUsername("admin")
                        .password("{noop}admin").
                        roles("ADMIN").build()

        );
    }

//    https://www.baeldung.com/spring-boot-security-autoconfiguration

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
    @Override
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
