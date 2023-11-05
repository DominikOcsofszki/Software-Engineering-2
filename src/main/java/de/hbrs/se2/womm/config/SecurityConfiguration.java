package de.hbrs.se2.womm.config;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import de.hbrs.se2.womm.views.LoginViewDo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, LoginViewDo.class);
    }

    @Bean
    UserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("student")
                        .password("{noop}student").
                        roles("STUDENT").build(),
                User.withUsername("unternehmen")
                        .password("{noop}unternehmen").
                        roles("UNTERNHEMEN").build(),
                User.withUsername("admin")
                        .password("{noop}admin").
                        roles("ADMIN").build()

        );
    }
}
