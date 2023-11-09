package de.hbrs.se2.womm.views.newdom;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.newdom.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "HomepageStudentView", layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("HomepageStudentView")
public class HomepageStudentView extends VerticalLayout {
    private final SecurityService securityService;

    public HomepageStudentView(SecurityService securityService) {
        this.securityService = securityService;
        setUpTitle();
        setUpHeader();
        setUpBanner();
        seUpSearchFields();
        setUpBigCompanyAnnouncement();

        String u = securityService.getAuthenticatedUser().getUsername();
        Button logout = new Button("Log out " + u, e -> securityService.logout());

        var header = new HorizontalLayout(new DrawerToggle(), logout);
        add(header);
    }

//    public HomepageStudentView() {
//        setUpTitle();
//        setUpHeader();
//        setUpBanner();
//        seUpSearchFields();
//        setUpBigCompanyAnnouncement();
//    }

    private void setUpTitle() {
        H1 h1 = new H1("HomepageStudentView");
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

//    package de.hbrs.ia.erasmux.Views;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.provider.ListDataProvider;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//
//import de.hbrs.ia.erasmux.Entity.SalesMan;
//import de.hbrs.ia.erasmux.Entity.SalesMenEnum;
//import de.hbrs.ia.erasmux.Repository.SalesmanRepository;
//
//import com.vaadin.flow.component.AbstractField;
//
//import java.util.Objects;
//
//    ////
//    @Route(value = "")
//    @PageTitle("Dom")
//    public class MainView extends VerticalLayout {
//        class SalesMan {
//            String firstName;
//            String lastName;
//
//            SalesMan(){
//                this.firstName = "firstName";
//                this.lastName = "lastName";
//                this.email = "email";
//                this.sid = 1;
//            }
//        }
//        Grid<SalesMan> grid = new Grid<>();
//        TextField filterText = new TextField();
//        SalesmanRepository salesmanRepository;
//
//        public MainView(SalesmanRepository salesmanRepository) {
//            this.salesmanRepository = salesmanRepository;
//            addClassName("list-view");
//            setSizeFull();
//            configureGrid();
//            grid.setItems(salesmanRepository.findAll());
//            add(getToolbar(), grid);
//            setFilterBy(SalesMenEnum.SID);
//        }
//
//        private HorizontalLayout getToolbar() {
//            filterText.setPlaceholder("Filter by...");
//            filterText.setClearButtonVisible(true);
//            filterText.setValueChangeMode(ValueChangeMode.LAZY);
//            filterText.setValueChangeTimeout(300);
//            Button addSearchButton = new Button("Search contact");
//            var toolbar = new HorizontalLayout(filterText, addSearchButton);
//            toolbar.addClassName("toolbar");
//            return toolbar;
//        }
//
//        private void configureGrid() {
//            grid.addColumn(SalesMan::getFirstName)
//                    .setSortable(true)
//                    .setComparator(SalesMan::getFirstName)
//                    .setKey("FirstName")
//                    .setHeader("Unternehmen");
////                .setHeader("FirstName");
//            grid.addColumn(SalesMan::getLastName)
//                    .setSortable(true)
//                    .setComparator(SalesMan::getLastName)
//                    .setKey("LastName")
//                    .setHeader("LastName");
//            grid.addColumn(SalesMan::getEmail)
//                    .setSortable(true)
//                    .setComparator(SalesMan::getEmail)
//                    .setKey("Email")
//                    .setHeader("Email");
//            grid.addColumn(SalesMan::getSid)
//                    .setSortable(true)
//                    .setComparator(SalesMan::getSid)
//                    .setKey("Sid")
//                    .setHeader("Sid");
//        }
//
//        private void setFilterBy(SalesMenEnum searchBy) {
//            filterText.addValueChangeListener(
//                    (AbstractField.ComponentValueChangeEvent<TextField, String> event) -> {
//                        String inputSearchNameFilter = event.getValue();
//                        ((ListDataProvider<SalesMan>) grid.getDataProvider()).
//                                setFilter((SalesMan salesMan) -> filterFunction(salesMan, inputSearchNameFilter, searchBy));
////                                    salesMan.getFirstName().toLowerCase().contains(inputSearchNameFilter.toLowerCase()));
//                    }
//            );
//        }
//
//        private boolean filterFunction(SalesMan salesMan, String inputSearchNameFilter, SalesMenEnum searchBy) {
//            inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
//            String checkSalesMen = switch (searchBy) {
//                case FIRSTNAME -> salesMan.getFirstName().toLowerCase();
//                case LASTNAME -> salesMan.getLastName().toLowerCase();
//                case EMAIL -> salesMan.getEmail().toLowerCase();
//                case SID -> salesMan.getSid().toString().toLowerCase();
//                default -> "";
//            };
//
//            return checkSalesMen.contains(inputSearchNameFilter);
//        }
//    }
//
//}
