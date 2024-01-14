package de.hbrs.se2.womm.views.unternehmen;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.extra.TEMPLATE;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;
@Route(value = ROUTING.UNTERNEHMEN.UNotificationView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("NotificationView")
public class UNotificationView extends VerticalLayout {
    public UNotificationView() {
        setUpHeader();
        setUpUNotification();
    }
    private void setUpHeader(){
        HorizontalLayout header = new HorizontalLayout();
        header.add(new H1("Neue Benachrichtigungen"));
        add(header);
    }
    /*private static final String LIT_TEMPLATE_HTML = """
            <vaadin-button title="Go to ..."
                           @click="${clickHandler}"
                           theme="tertiary-inline small link">
                ${item.id}
            </vaadin-button>""";
     */
    private void setUpUNotification() {
        VerticalLayout notification = new VerticalLayout();
        Image image1 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image2 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image3 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image4 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        image1.setHeight(40, Unit.PIXELS);
        image2.setHeight(40, Unit.PIXELS);
        image3.setHeight(40, Unit.PIXELS);
        image4.setHeight(40, Unit.PIXELS);
        List<demoInhalt> inhalt = Arrays.asList(
                new demoInhalt(image1,"Paul Stein", "Bewerbung auf das Stellenangebot : <Bezeichnung des Stellenangebots>"),
                new demoInhalt(image2,"Max Mustermann", "Bewerbung auf das Stellenangebot : <Bezeichnung des Stellenangebots>"),
                new demoInhalt(image3,"Maximilian Paul Karl Heinz Knabe", "Bewerbung auf das Stellenangebot : <Bezeichnung des Stellenangebots>"),
                new demoInhalt(image4,"Max Mustermann", "Bewerbung auf das Stellenangebot : <Bezeichnung des Stellenangebots>"));
        Grid<demoInhalt> grid = new Grid<>(demoInhalt.class, false);
        grid.setItems(inhalt);
        grid.addComponentColumn(demoInhalt::getImage).setHeader("Profilbild").setWidth("10%");
        grid.addColumn(LitRenderer.<demoInhalt>of(TEMPLATE.LIT_TEMPLATE_HTML)
                .withProperty("id",demoInhalt::getName)
                .withFunction("clickHandler", person -> {
                    UI.getCurrent().navigate(UApplicationView.class);
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
