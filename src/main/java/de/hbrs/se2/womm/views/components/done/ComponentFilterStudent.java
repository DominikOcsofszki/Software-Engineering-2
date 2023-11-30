package de.hbrs.se2.womm.views.components.done;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import de.hbrs.se2.womm.dtos.StudentDTO;
import tools.generate.GenerateStudentDTO;

import java.util.List;

public class ComponentFilterStudent extends AbstractComponentFilter<StudentDTO> {
    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "Id",
                "Name",
                "Vorname",
                "Email",
                "Studiengang",
                "Semester",
                "Fachsemester",
                "Abschluss",
                "Uni",
                "Stadt",
                "Land",
                "Beschreibung",
                "Website",
                "Unternehmen"
        };
    }

    @Override
    protected List<?> getItemsFromControllerOrGenerate() {
        return GenerateStudentDTO.generateStudentDTO(10);
    }

    @Override
    protected void configureGrid() {
        grid.addColumn(StudentDTO::getStudentId).setHeader("Id").
                setSortable(true).setComparator(StudentDTO::getStudentId);
        grid.addColumn(StudentDTO::getStudentName).setHeader("Name").
                setSortable(true).setComparator(StudentDTO::getStudentName);
        grid.addColumn(StudentDTO::getStudentVorname).setHeader("Vorname").
                setSortable(true).setComparator(StudentDTO::getStudentVorname);
        grid.addColumn(StudentDTO::getNutzer).setHeader("Email");
        grid.addComponentColumn(item -> {
            return new Button("Email", event -> {
                Notification.show("Email: " + item.getNutzer());
            });
        });
    }

    @Override
    protected String checkItem(StudentDTO dto, String searchBy) {
//        switch (searchBy)
        return switch (searchBy) {
            case "nutzer" -> dto.getNutzer().toString().toLowerCase();
            case "studentId" -> dto.getStudentId().toString().toLowerCase();
            case "studentVorname" -> dto.getStudentVorname().toString().toLowerCase();
            case "studentName" -> dto.getStudentName().toString().toLowerCase();
            case "studentGeburtstag" -> dto.getStudentGeburtstag().toString().toLowerCase();
//            case "studentBenachrichtigung" -> studentDTO.getStudentBenachrichtigung().toString().toLowerCase();
            case "studentBio" -> dto.getStudentBio().toString().toLowerCase();
            case "studentSpezialisierung" -> dto.getStudentSpezialisierung().toString().toLowerCase();
            case "studentSemester" -> dto.getStudentSemester().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
    }
}
