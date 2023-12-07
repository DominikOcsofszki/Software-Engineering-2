package de.hbrs.se2.womm.config;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
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
        if (context != null && context.getAuthentication() != null) {
            Object principal = context.getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                return (UserDetails) context.getAuthentication().getPrincipal();
            }
        }
        // Anonymous or no authentication.
        return null; //ToDo: @Toni redirect to login?
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

    public String getLoggedInPrimaryKey() {
        String username = getAuthenticatedUser().getUsername();
//        return username;
        return mapperForDev(username);
    }

    private String mapperForDev(String username) {

        switch (username) {
            case "Grinsekatze1":
                return "52";
            case "TheManTheMythTheLegend":
                return "152";
            case "unternehmen":
                return "202";
            case "student":
                return "203";
            case "TestUsername":
                return "252";
            case "test123":
                return "352";
            case "Test":
                return "452";
            case "DominikOcsofszki":
                return "502";
            default:
                return "0";
        }

//        switch (username) {
//            case "Grinsekatze1":
//                return "1";
//            case "TheManTheMythTheLegend":
//                return "2";
//            case "unternehmen":
//                return "52";
//            case "student":
//                return "53";
//            case "TestUsername":
//                return "102";
//            case "test123":
//                return "202";
//            case "Test":
//                return "302";
//            case "DominikOcsofszki":
//                return "352";
//            default:
//                return "0";
//        }

//        switch (username) {
////            case "admin":
////                return "1";
//            case "unternehmen":
//                return "52";
//            case "student":
//                return "3";
//            case "DominikOcsofszki":
//                return "352";
//            default:
//                return "0";
//        }

    }
}