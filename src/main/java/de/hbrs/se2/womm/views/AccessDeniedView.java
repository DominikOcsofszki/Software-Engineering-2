package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.History;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.CONFIGS;
import de.hbrs.se2.womm.views.layouts.ROUTING;

@Route(value = ROUTING.ALL.AccessDeniedView)
public class AccessDeniedView extends VerticalLayout implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // You can add logic to handle permissions or conditions here
        // For example, check if the user has access rights to the view
        // If not, redirect or display an access denied message

        // Here's a simple example showing an access denied message
        Text accessDeniedText = new Text("Access Denied!");
        add(accessDeniedText);
        if (CONFIGS.DEVMODE) {
            Button buttonLogin = new Button("login");
            buttonLogin.addClickListener(e -> UI.getCurrent().navigate(new RouterLink("login ", LoginView.class).getHref()));
            buttonLogin.addClickListener(
                    e -> UI.getCurrent().getPage().open(
                            (new RouterLink("", LoginView.class).getHref()),
                            "_blank")
            );
            History history = UI.getCurrent().getPage().getHistory();
            Button button = new Button("Go back");
            button.addClickListener(e -> history.back());
            add(buttonLogin);
            add(button);
        }
    }
}
