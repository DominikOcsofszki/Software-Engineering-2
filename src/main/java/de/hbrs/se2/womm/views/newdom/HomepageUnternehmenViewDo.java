package de.hbrs.se2.womm.views.newdom;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@Route(value = "HomepageUnternehmenView", layout = UnternehmenLayout.class)
@PageTitle("HomepageUnternehmenView")
public class HomepageUnternehmenViewDo extends VerticalLayout {
    public HomepageUnternehmenViewDo() {
        setUpTitle();
        setUpHeader();
        setUpBanner();
        seUpSearchFields();
        setUpBigCompanyAnnouncement();
    }

    private void setUpTitle() {
        H1 h1 = new H1("HomepageUnternehmenView");
        add(h1);
    }

    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.add(new H1("Profil bearbeiten"));
        header.add(new H1("Icon"));
        header.add(new H1("Start"));
        header.add(new H1("Logout"));
        add(header);
    }

    private void setUpBanner() {
        Div banner = new Div();
        banner.add(new H1("Banner"));
        add(banner);
    }

    private void seUpSearchFields() {
        HorizontalLayout searchFields = new HorizontalLayout();
        searchFields.add(new H1("Dropdown-Employment"));
        searchFields.add(new H1("Dropdown-Jobart"));
        searchFields.add(new H1("Searchfield"));
        searchFields.add(new H1("Searchfield-Button"));
        searchFields.add(new H1("Remove-Filter-Button"));
        add(searchFields);
    }

    private void setUpBigCompanyAnnouncement() {
        HorizontalLayout bigCompanyAnnouncement = new HorizontalLayout();
        VerticalLayout bigCompanyAnnouncement1 = new VerticalLayout();
        VerticalLayout bigCompanyAnnouncement2 = new VerticalLayout();
        bigCompanyAnnouncement.add(bigCompanyAnnouncement1);
        bigCompanyAnnouncement.add(bigCompanyAnnouncement2);
        add(bigCompanyAnnouncement);
    }
}
