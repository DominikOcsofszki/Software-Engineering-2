
package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "SChatView2", layout = StudentLayout.class)
@RolesAllowed({ "ADMIN", "STUDENT"})
@PageTitle("ChatView2")
public class SChatView2 extends VerticalLayout implements HasUrlParameter<String> {

    String valueFromQuerry;
    TextField textField = new TextField("GoToSite", "1", "1");

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter == null) {
            add(new H1("No parameter"));
        } else {
            add(String.format("parameter: %s.",
                    parameter));
            valueFromQuerry = parameter;
            textField.setValue(valueFromQuerry);
        }
    }
    public SChatView2() {
        setUpHeader();
    }
    private void setUpHeader() {
        add("ChatView");
        Button b5 = new Button("ClickMeForRouting", new Icon(VaadinIcon.COMMENTS_O));
        b5.addClickListener( e ->
                UI.getCurrent().navigate(
                        SChatView.class,valueFromQuerry
                ));

        add(b5);
    }
}
