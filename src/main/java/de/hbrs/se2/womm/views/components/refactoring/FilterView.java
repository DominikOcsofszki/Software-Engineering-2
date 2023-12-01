package de.hbrs.se2.womm.views.components.refactoring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.controller.UnternehmenController;
import de.hbrs.se2.womm.views.components.done.ComponentUnternehmenDTO;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;

@PageTitle("MainView")
@AnonymousAllowed
@Route(value = "filter", layout = LoggedOutLayout.class)
public class FilterView extends AbstractView<UnternehmenController> {


    public FilterView(UnternehmenController controller) {
        super(controller);
        doSth();
    }

    private void doSth() {
        add(vaadinBuilderWomm.ButtonBuilder.createButton("doSthTranslateMe"));
        add(vaadinBuilderWomm.ButtonBuilder.createButton("doSth"));
        add(vaadinBuilderWomm.TextFieldBuilder.createTextField("sthNew"));
//        Button buttonToShowMissingTranslated = new vaadinBuilderWomm.ButtonBuilder.createButton("buttonToShowMissingTranslated");

    }

}
