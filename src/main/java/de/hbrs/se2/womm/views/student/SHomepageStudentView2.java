package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@Route(value = ROUTING.STUDENT.SHomepageStudentView2, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("HomepageStudentView2")
public class SHomepageStudentView2 extends VerticalLayout {
    private StelleService stelleService;
    private final String BUTTON_LABEL_VIEW_SUBSCRIPTIONS = "Abonnements";
    private final String BUTTON_LABEL_NOTIFICATIONS = "Benachrichtigungen";
    private final String BUTTON_LABEL_CHAT = "Chat";
    private final String BUTTON_LABEL_EDIT_PROFILE = "Profil bearbeiten";
    private final String TEXTFIELD_LABEL_SEARCH = "Suche...";
    private final String COMBOBOX_LABEL = "Attribut";
    private String searchTerm;
    private String attribute;

    Grid<StelleDTO> grid = new Grid<>(StelleDTO.class, false);

    public SHomepageStudentView2(StelleService stelleService) {
        this.stelleService = stelleService;
        searchTerm = "";
        attribute = "";

        configureGrid();
        add(getButtons(), getBanner(), getSearchBar(), getGrid());
        updateList();
    }

    private Component getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        Button b1 = new Button(BUTTON_LABEL_NOTIFICATIONS, new Icon(VaadinIcon.EYE));
        Button b2 = new Button(BUTTON_LABEL_VIEW_SUBSCRIPTIONS, new Icon(VaadinIcon.BELL));
        Button b3 = new Button(BUTTON_LABEL_CHAT, new Icon(VaadinIcon.COMMENTS_O));
        Button b4 = new Button(BUTTON_LABEL_EDIT_PROFILE, new Icon(VaadinIcon.PENCIL));

        b1.addClickListener(click -> UI.getCurrent().navigate(SAboStudentView.class));
        b2.addClickListener(click -> UI.getCurrent().navigate(SNotificationView.class));
        b3.addClickListener(click -> UI.getCurrent().navigate(SChatView.class));
        b4.addClickListener(click -> UI.getCurrent().navigate(SCreateChangeStudentProfileView.class));

        b4.getElement().getStyle().set("margin-left", "auto");

        buttons.setWidthFull();
        buttons.add(b1, b2, b3, b4);
        return buttons;
    }

    private Component getBanner() {
        HorizontalLayout banner = new HorizontalLayout();
        Image bannerImage = new Image(ASSETS.BANNER.BANNER2, "Womm Homepage Banner");
        bannerImage.setWidth("100%");
        banner.add(bannerImage);
        return banner;
    }

    private Component getSearchBar() {
        HorizontalLayout searchLayout = new HorizontalLayout();

        TextField searchField = new TextField();
        searchField.setWidth("30%");
        searchField.setPlaceholder(TEXTFIELD_LABEL_SEARCH);
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addValueChangeListener(e -> {
            searchTerm = e.getValue();
            updateList();
        });

        ComboBox<String> comboBox = new ComboBox<>("");
        comboBox.setItems("Titel", "Ort", "Beschreibung", "Website", "Unternehmen");
        comboBox.setAllowCustomValue(false);
        //Set default combobox value
        comboBox.setValue("Titel");
        comboBox.addValueChangeListener(e -> {
            attribute = e.getValue();
            updateList();
        });

        searchLayout.setWidthFull();
        searchLayout.add(searchField, comboBox);
        return searchLayout;
    }

    private Component getGrid() {
        HorizontalLayout content = new HorizontalLayout(grid);
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");

        grid.addColumn(StelleDTO::getStelleId).setHeader("ID");
        grid.addColumn(StelleDTO::getStelleTitel).setHeader("Titel");
        grid.addColumn(StelleDTO::getStelleOrt).setHeader("Ort");
        grid.addColumn(StelleDTO::getStelleBeschreibung).setHeader("Beschreibung");
        grid.addColumn(StelleDTO::getStelleWebsite).setHeader("Website");
        grid.addColumn(stelleDTO -> stelleDTO.getStelleUnternehmen().getName()).setHeader("Unternehmen");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        List<StelleDTO> content = stelleService.getAllByFilter(searchTerm, attribute);
        grid.setItems(content);
    }
}
