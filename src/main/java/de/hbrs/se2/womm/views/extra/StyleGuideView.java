package de.hbrs.se2.womm.views.extra;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;

@AnonymousAllowed
@Route(value = "styleguide", layout = LoggedOutLayout.class)
public class StyleGuideView extends VerticalLayout {
    public Image styleGuide = new Image(ASSETS.STYLEGUIDE, "styleGuide");
    public HorizontalLayout horizontalLayout = new HorizontalLayout();

    public StyleGuideView() {
        horizontalLayout.add(styleGuide);
        add(horizontalLayout);
        styleGuide.setWidth("750px");
    }



}
