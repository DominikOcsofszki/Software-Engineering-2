//package de.hbrs.se2.womm.views.components.using;
//
//import com.vaadin.flow.component.AbstractField;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.select.Select;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.provider.ListDataProvider;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import de.hbrs.se2.womm.controller.AbstractControllerWomm;
//import de.hbrs.se2.womm.controller.StudentController;
//import de.hbrs.se2.womm.dtos.AbstractDTO;
//import de.hbrs.se2.womm.dtos.StudentDTO;
//
//import java.util.List;
//
//public class ComponentFilterGridController extends VerticalLayout {
//    TextField filterText = new TextField();
//    Select<String> select = new Select<>();
//    Grid<StudentDTO> grid = new Grid<>();
//    String[] filterByItemsFromDTO = StudentDTO.getAllFilter();
//
//    public ComponentFilterGridController(AbstractControllerWomm controller) {
//        List<? extends AbstractDTO> itemsForGrid = getItemsForGrid(controller);
//        setUpGrid(itemsForGrid);
//        add(getToolbar(), grid);
//        setFilterBy(filterByItemsFromDTO[0]);
//        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
//    }
//    private List<? extends AbstractDTO> getItemsForGrid(AbstractControllerWomm controller){
//        return ((StudentController)controller).getAllStudents().getBody(); //ToDo: change Cast here
//    }
//
//    private void setUpGrid(List<? extends AbstractDTO> itemsForGrid){
//        addClassName("list-view");
//        setSizeFull();
//        configureGrid();
////        grid.setItems();
//        grid.setItems((List<StudentDTO>)itemsForGrid); //TODO: change Cast here
//
//    }
//    private Select<String> selectFilterMenu() {
//        select.setPlaceholder("Filter");
//        select.setItems(filterByItemsFromDTO);
//        return select;
//    }
//    private HorizontalLayout getToolbar() {
//        filterText.setPlaceholder("Filter by...");
//        filterText.setClearButtonVisible(true);
//        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//        filterText.setValueChangeTimeout(300);
//        Select<String> selecterMenu = selectFilterMenu();
//        var toolbar = new HorizontalLayout(filterText,selecterMenu);
//        toolbar.addClassName("toolbar");
//        return toolbar;
//    }
//
//    private void configureGrid() {
////        grid.addColumn(StudentDTO::getNutzer).setHeader("Nutzer").setSortable(true).setComparator(StudentDTO::getNutzer);
//        grid.addColumn(StudentDTO::getStudentId).setHeader("StudentId").setSortable(true).setComparator(StudentDTO::getStudentId);
//        grid.addColumn(StudentDTO::getStudentVorname).setHeader("StudentVorname").setSortable(true).setComparator(StudentDTO::getStudentVorname);
//        grid.addColumn(StudentDTO::getStudentName).setHeader("StudentName").setSortable(true).setComparator(StudentDTO::getStudentName);
//        grid.addColumn(StudentDTO::getStudentGeburtstag).setHeader("StudentGeburtstag").setSortable(true).setComparator(StudentDTO::getStudentGeburtstag);
////        grid.addColumn(StudentDTO::getStudentBenachrichtigung).setHeader("StudentBenachrichtigung").setSortable(true).setComparator(StudentDTO::getStudentBenachrichtigung);
//        grid.addColumn(StudentDTO::getStudentBio).setHeader("StudentBio").setSortable(true).setComparator(StudentDTO::getStudentBio);
//        grid.addColumn(StudentDTO::getStudentSpezialisierung).setHeader("StudentSpezialisierung").setSortable(true).setComparator(StudentDTO::getStudentSpezialisierung);
//        grid.addColumn(StudentDTO::getStudentSemester).setHeader("StudentSemester").setSortable(true).setComparator(StudentDTO::getStudentSemester);
//
//    }
//
//
//    private void setFilterBy(String searchBy) {
//        filterText.addValueChangeListener(
//                (AbstractField.ComponentValueChangeEvent<TextField, String> event)
//                        -> {
//                    String inputSearchNameFilter = event.getValue();
//                    ((ListDataProvider<StudentDTO>) grid.getDataProvider()).
//                            setFilter((StudentDTO studentDTO)
//                                    -> filterFunction(studentDTO, inputSearchNameFilter, searchBy));
//                }
//        );
//    }
//    private boolean filterFunction(StudentDTO studentDTO, String inputSearchNameFilter, String searchBy) {
//        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
//        String checkUnternehmen = switch (searchBy) {
//            case "nutzer" -> studentDTO.getNutzer().toString().toLowerCase();
//            case "studentId" -> studentDTO.getStudentId().toString().toLowerCase();
//            case "studentVorname" -> studentDTO.getStudentVorname().toString().toLowerCase();
//            case "studentName" -> studentDTO.getStudentName().toString().toLowerCase();
//            case "studentGeburtstag" -> studentDTO.getStudentGeburtstag().toString().toLowerCase();
////            case "studentBenachrichtigung" -> studentDTO.getStudentBenachrichtigung().toString().toLowerCase();
//            case "studentBio" -> studentDTO.getStudentBio().toString().toLowerCase();
//            case "studentSpezialisierung" -> studentDTO.getStudentSpezialisierung().toString().toLowerCase();
//            case "studentSemester" -> studentDTO.getStudentSemester().toString().toLowerCase();
//            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
//        };
//        return checkUnternehmen.contains(inputSearchNameFilter);
//    }
//}
