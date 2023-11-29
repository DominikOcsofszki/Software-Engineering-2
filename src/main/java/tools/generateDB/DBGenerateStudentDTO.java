package tools.generateDB;

import de.hbrs.se2.womm.controller.StudentController;
import de.hbrs.se2.womm.dtos.StudentDTO;
import tools.generate.GenerateStudentDTO;

import java.util.List;
public class DBGenerateStudentDTO {

    DBGenerateStudentDTO(StudentController studentController) {

    }

    public static void fillDBGenerateStudentDTO(int howMany,StudentController studentController) {
        List<StudentDTO> studentDTOList = GenerateStudentDTO.generate(howMany);
        for (StudentDTO studentDTO : studentDTOList) {
            System.out.println(studentDTO);
            studentController.updateStudent(studentDTO);
        }
    }

}