package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;

//@Route(value = "ErrorView", layout = LoggedOutLayout.class)
@Route(value = "", layout = LoggedOutLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN", "STUDENT"})
@AnonymousAllowed
@PageTitle("ErrorView")
public class ErrorView extends VerticalLayout {

    public ErrorView() {
        add(createErrorMessage());
    }

    private VerticalLayout createErrorMessage() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(new H1("ErrorView"));
        add(new H1("Page Not Found"));
        VerticalLayout heroSection = new VerticalLayout();
        heroSection.setAlignItems(FlexComponent.Alignment.CENTER);
        Image heroImage = ASSETS.buildPlaceholder(500,500);
        heroSection.add(heroImage);
        return heroSection;
    }
}
