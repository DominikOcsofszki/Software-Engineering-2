package de.hbrs.se2.womm.config;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import de.hbrs.se2.womm.services.AuthenticationService;
import de.hbrs.se2.womm.services.UserDetailsManagerImpl;
import de.hbrs.se2.womm.views.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {
    @Autowired
    private AuthenticationService authenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        APIRequestMatcher aPIRequestMatcher = new APIRequestMatcher();
        http.authorizeHttpRequests(urlRegistry -> {
            urlRegistry.requestMatchers(aPIRequestMatcher)
                    .permitAll();
        });
        super.configure(http);
        setLoginView(http, LoginView.class);
    }




    //ToDo Connect to DB
    @Bean
    UserDetailsManager userDetailsManager() {
        return new UserDetailsManagerImpl();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("student")
//                .password(passwordEncoder.encode("student"))
//                .roles("STUDENT")
//                .build();
//
//        UserDetails admin = User.withUsername("unternehmen")
//                .password(passwordEncoder.encode("unternehmen"))
//                .roles("UNTERNEHMEN")
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
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService((UserDetailsService) authenticationService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
