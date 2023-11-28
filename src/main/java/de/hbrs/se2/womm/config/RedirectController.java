package de.hbrs.se2.womm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("")
public class RedirectController {
    @Autowired
    SecurityService securityService;
    @GetMapping("/")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        String loggedInUser = securityService.getAuthenticatedUser().getUsername();
        System.out.println("loggedInUser: " + loggedInUser);
        if(loggedInUser != null){
            if(securityService.isUserAdmin()){
                return new RedirectView("vaadin/admin");
            }else if(securityService.isUserUnternehmen()){
                return new RedirectView("vaadin/UHomepageUnternehmenView");
            }else if(securityService.isUserStudent()){
                return new RedirectView("vaadin/SHomepageStudentView");
            }
        }
        return new RedirectView("vaadin/LandingPageView");
    }
}