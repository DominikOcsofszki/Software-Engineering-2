package de.hbrs.se2.womm.config;

import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    private final AuthenticationContext authenticationContext;

    public SecurityService(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    public UserDetails getAuthenticatedUser() {
        return authenticationContext.getAuthenticatedUser(UserDetails.class).get();
    }

    public void logout() {
        authenticationContext.logout();
    }

    public boolean isUserAdmin() {
        return getAuthenticatedUser().toString().contains("ADMIN");
    }

    public boolean isUserUnternehmen() {
        return getAuthenticatedUser().toString().contains("UNTERNEHMEN");
    }

    public boolean isUserStudent() {
        return getAuthenticatedUser().toString().contains("STUDENT");
    }

    public long getLoggedInId() {
        return 1;
    }
}