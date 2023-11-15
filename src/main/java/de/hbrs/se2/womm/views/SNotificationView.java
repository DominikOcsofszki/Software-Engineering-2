package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.STUDENT.SNotificationView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("NotificationView")
public class SNotificationView extends VerticalLayout {

    public SNotificationView() {
        setUpSearchFields();
        setUpNotification();
    }

    private void setUpSearchFields() {
        HorizontalLayout searchFields = new HorizontalLayout();

        //Suchfeld
        searchFields.add(new H1("New Notification"));
        TextField textField = new TextField();
        textField.focus();
        textField.setPlaceholder("Enter company name or keyword");
        textField.setPrefixComponent(VaadinIcon.SEARCH.create());
        textField.setWidth(350, Unit.PIXELS);
        textField.setHeight(50, Unit.PIXELS);
        searchFields.add(textField);

        // Suche-Button
        Button b = new Button("Search", new Icon(VaadinIcon.SEARCH));
        searchFields.add(b);
        textField.getElement().getStyle().set("margin-left", "auto");
        searchFields.setWidthFull();
        add(searchFields);
    }

    private void setUpNotification() {
        HorizontalLayout notification = new HorizontalLayout();
        VerticalLayout notification1 = new VerticalLayout();
        add(notification);

        notification.setWidth("auto");
        notification.setMargin(true);
        notification.setAlignItems(FlexComponent.Alignment.STRETCH);

        Image image = new Image("/image/myimage.png", "Alternative image text");
        notification.add(image);

        notification1.add(new H1("Company Name"));
        notification1.add(new H2("Industry"));
        notification.add(notification1);

        Button primaryButton = new Button("unsubscribe");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
                ButtonVariant.LUMO_CONTRAST);

        notification.add(primaryButton);
        notification.setWidth("98.5%");
    }

}
