package de.hbrs.se2.womm.config;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.spring.security.AuthenticationContext;
import de.hbrs.se2.womm.model.Roles;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    public UserDetails getAuthenticatedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Object principal = context.getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return (UserDetails) context.getAuthentication().getPrincipal();
        }
        // Anonymous or no authentication.
        return null;
    }

    public void logout() {
        UI.getCurrent().getPage().setLocation(ROUTING.ALL.LandingPageView);
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(
                VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
                null);
    }

    public boolean isUserAdmin() {
        return getAuthenticatedUser().getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_" + Roles.ADMIN.name()));
    }

    public boolean isUserUnternehmen() {
        return getAuthenticatedUser().getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_" + Roles.UNTERNEHMEN.name()));
    }

    public boolean isUserStudent() {
        return getAuthenticatedUser().getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_" + Roles.STUDENT.name()));
    }

}