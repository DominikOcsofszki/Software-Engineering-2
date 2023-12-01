package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import de.hbrs.se2.womm.views.components.refactoring.VaadinBuilderWomm;

abstract class AbstractLayout extends AppLayout {
    HorizontalLayout header = new HorizontalLayout();
    Image nameImage = new Image("themes/theme_1/Womm_text_logo.png", "An image in the theme");

    Image logo = new Image("themes/theme_1/logo.png", "An image in the theme");

    public AbstractLayout() {
        configLogo();
        configName();
        configHeader();
        createDrawer();
        if(CONFIGS.DEVMODE || CONFIGS.ADMIN) {
            ifAdminOrDevModeAddButton();
        }
    }

    void createHeaderWithLogoutButton(Button logout, boolean withMenu) {
        if (withMenu) this.header.add(new DrawerToggle());
//        this.header.add(name,logo);
        this.header.add(nameImage, logo);
        if (logout != null) this.header.add(logout);
        addToNavbar(header);
    }

    void configName() {
//        logo.setWidth(50, Unit.PIXELS);
        nameImage.setHeight(50, Unit.PIXELS);
        nameImage.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.MEDIUM);
    }

    void configLogo() {
        logo.setWidth(50, Unit.PIXELS);
        logo.setHeight(50, Unit.PIXELS);
        logo.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.MEDIUM);
    }

    void configHeader() {
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.addClassNames(
                LumoUtility.Padding.Vertical.NONE,
                LumoUtility.Padding.Horizontal.MEDIUM);
    }


    void createDrawer() {
    }
    void ifAdminOrDevModeAddButton() {
        VaadinBuilderWomm vaadinBuilderWomm = new VaadinBuilderWomm();
        Button buttonToShowMissingTranslated = vaadinBuilderWomm.ButtonBuilder.createButton("buttonToShowMissingTranslated");
        buttonToShowMissingTranslated.addClickListener(
                e -> VaadinBuilderWomm.printAllTextNotTranslatedToConsole()
        );
        header.add(buttonToShowMissingTranslated);
    }
}
