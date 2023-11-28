package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.entities.Unternehmen;
import de.hbrs.se2.womm.views.components.using.ComponentFilterGridControllerBenachrichtigungen;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;
import org.atmosphere.config.service.DeliverTo;

import java.util.Arrays;
import java.util.List;

@Route(value = ROUTING.STUDENT.SNotificationView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("NotificationView")
public class SNotificationView extends VerticalLayout {

    public SNotificationView() {
        setUpHeader();
        setUpSNotification();
        add(new ComponentFilterGridControllerBenachrichtigungen());
    }

    private void setUpHeader(){
        HorizontalLayout header = new HorizontalLayout();
        //Suchfeld
        header.add(new H1("Neue Benachrichtigungen"));
        add(header);
    }

    private static final String LIT_TEMPLATE_HTML = """
            <vaadin-button title="Go to ..."
                           @click="${clickHandler}"
                           theme="tertiary-inline small link">
                ${item.id}
            </vaadin-button>""";

    private void setUpSNotification() {
        VerticalLayout notification = new VerticalLayout();

        //Todo Für Studenten zugehörige Benachrichtigungen anzeigen
        //ToDo demoInhalte ersetzen

        Image image1 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image2 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image3 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image4 = new Image(ASSETS.RANDOM.USER, "Alternative image text");

        image1.setHeight(40, Unit.PIXELS);
        image2.setHeight(40, Unit.PIXELS);
        image3.setHeight(40, Unit.PIXELS);
        image4.setHeight(40, Unit.PIXELS);

        List<demoInhalt> inhalt = Arrays.asList(
                new demoInhalt(image1,"Apple", "1 Neue Stellenausschreibung verfügbar!"),
                new demoInhalt(image2,"Microsoft", "1 Neue Stellenausschreibung verfügbar!"),
                new demoInhalt(image3,"HBRS", "3 Neue Stellenausschreibung verfügbar!"),
                new demoInhalt(image4,"W.O.M.M", "10 Neue Stellenausschreibung verfügbar!"));

        Grid<demoInhalt> grid = new Grid<>(demoInhalt.class, false);

        //ToDo Verlinkung zum entsprechenden Unternehmen anpassen

        grid.setItems(inhalt);
        grid.addComponentColumn(demoInhalt::getImage).setHeader("Logo").setWidth("10%");
        grid.addColumn(LitRenderer.<demoInhalt>of(LIT_TEMPLATE_HTML)
                .withProperty("id", demoInhalt::getName)
                .withFunction("clickHandler", person -> {
                    UI.getCurrent().navigate(SFirmProfileDisplayView.class);
                })).setHeader("Name").setWidth("25%").setSortable(true);
        grid.addColumn(demoInhalt::getMessage).setHeader("Nachricht").setWidth("65%");
        notification.add(grid);
        grid.recalculateColumnWidths();

        notification.setWidth("100%");

        add(notification);

    }

    private class demoInhalt{
        Image image;
        String name;
        String message;

        private Image getImage(){
            return image;
        }
        private String getName(){
            return name;
        }
        private String getMessage(){
            return message;
        }

        private demoInhalt(Image image,String name, String message){
            this.image = image;
            this.name = name;
            this.message = message;
        }
    }

}
