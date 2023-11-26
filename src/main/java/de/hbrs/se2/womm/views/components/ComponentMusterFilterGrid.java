package de.hbrs.se2.womm.views.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import de.hbrs.se2.womm.consumer.UnternehmenConsumer;
import de.hbrs.se2.womm.dtos.StudentDTO;


import java.net.URL;
import java.util.List;

public class ComponentMusterFilterGrid extends VerticalLayout {
    TextField filterText = new TextField();
    Select<String> select = new Select<>();
    Grid<StudentDTO> grid = new Grid<>();
    String[] filterByItemsFromDTO = StudentDTO.getAllFilter();


    public ComponentMusterFilterGrid() {
        List<StudentDTO> itemsForGrid = getItemsForGridFromApi();

        setUpGrid(itemsForGrid);
        add(getToolbar(), grid);
        setFilterBy(filterByItemsFromDTO[0]);
        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
    }
    private List<StudentDTO> getItemsForGridFromApi(){
//        UnternehmenConsumer consumer = new UnternehmenConsumer();
//        URL url = new URL("http://localhost:8080/api/users");
//        return consumer.getUnternehmen(url);
//        return new ArrayList<>(StudentDTO.getAllFilter());
        return null;
//        return getAllStudents();
    }
//    public List<StudentDTO> getAllStudents() {
//                try {
//                    URL url = new URL("https://api.covid19api.com/summary");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//                    System.out.println("Response Code: " + responseCode);
//
//                    // Read the response from the API
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//                    reader.close();
//                    System.out.println("Response: " + response.toString());
//                    // Convert the response to JSON
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    StudentDTO dto = objectMapper.readValue(response.toString(), StudentDTO.class);
//
//                    // Use the DTO object
//                    System.out.println("DTO Field: " + dto.getStudentName());
//
//                    // Close the connection
//                    connection.disconnect();
//                    return dto;
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//    }
    private void setUpGrid(List<StudentDTO> itemsForGrid){
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        grid.setItems();
        grid.setItems(itemsForGrid);

    }
    private Select<String> selectFilterMenu() {
        select.setPlaceholder("Filter");
        select.setItems(filterByItemsFromDTO);
//        select.setValue(NAME);
        return select;
    }
    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.setValueChangeTimeout(300);
        Select<String> selecterMenu = selectFilterMenu();
        var toolbar = new HorizontalLayout(filterText,selecterMenu);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
//        grid.addColumn(StudentDTO::getNutzer).setHeader("Nutzer").setSortable(true).setComparator(StudentDTO::getNutzer);
        grid.addColumn(StudentDTO::getStudentId).setHeader("StudentId").setSortable(true).setComparator(StudentDTO::getStudentId);
        grid.addColumn(StudentDTO::getStudentVorname).setHeader("StudentVorname").setSortable(true).setComparator(StudentDTO::getStudentVorname);
        grid.addColumn(StudentDTO::getStudentName).setHeader("StudentName").setSortable(true).setComparator(StudentDTO::getStudentName);
        grid.addColumn(StudentDTO::getStudentGeburtstag).setHeader("StudentGeburtstag").setSortable(true).setComparator(StudentDTO::getStudentGeburtstag);
//        grid.addColumn(StudentDTO::getStudentBenachrichtigung).setHeader("StudentBenachrichtigung").setSortable(true).setComparator(StudentDTO::getStudentBenachrichtigung);
        grid.addColumn(StudentDTO::getStudentBio).setHeader("StudentBio").setSortable(true).setComparator(StudentDTO::getStudentBio);
        grid.addColumn(StudentDTO::getStudentSpezialisierung).setHeader("StudentSpezialisierung").setSortable(true).setComparator(StudentDTO::getStudentSpezialisierung);
        grid.addColumn(StudentDTO::getStudentSemester).setHeader("StudentSemester").setSortable(true).setComparator(StudentDTO::getStudentSemester);

    }


    private void setFilterBy(String searchBy) {
        filterText.addValueChangeListener(
                (AbstractField.ComponentValueChangeEvent<TextField, String> event)
                        -> {
                    String inputSearchNameFilter = event.getValue();
                    ((ListDataProvider<StudentDTO>) grid.getDataProvider()).
                            setFilter((StudentDTO studentDTO)
                                    -> filterFunction(studentDTO, inputSearchNameFilter, searchBy));
                }
        );
    }
    private boolean filterFunction(StudentDTO studentDTO, String inputSearchNameFilter, String searchBy) {
        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
        String checkUnternehmen = switch (searchBy) {
            case "nutzer" -> studentDTO.getNutzer().toString().toLowerCase();
            case "studentId" -> studentDTO.getStudentId().toString().toLowerCase();
            case "studentVorname" -> studentDTO.getStudentVorname().toString().toLowerCase();
            case "studentName" -> studentDTO.getStudentName().toString().toLowerCase();
            case "studentGeburtstag" -> studentDTO.getStudentGeburtstag().toString().toLowerCase();
//            case "studentBenachrichtigung" -> studentDTO.getStudentBenachrichtigung().toString().toLowerCase();
            case "studentBio" -> studentDTO.getStudentBio().toString().toLowerCase();
            case "studentSpezialisierung" -> studentDTO.getStudentSpezialisierung().toString().toLowerCase();
            case "studentSemester" -> studentDTO.getStudentSemester().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkUnternehmen.contains(inputSearchNameFilter);
    }
}
