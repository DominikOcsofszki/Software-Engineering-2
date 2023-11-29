package tools.generate;

import de.hbrs.se2.womm.dtos.StudentDTO;
import tools.collection.*;

import java.util.ArrayList;
import java.util.List;

public class GenerateStudentDTO {
    private static long counter = 0;

    public static StudentDTO generateOneRandomStudentDTO() {
        return generateStudentDTO(1).get(0);
    }
    public static List<StudentDTO> generateStudentDTO(int howManyStellen) {
        ArrayList<StudentDTO> stelleDtoList = new ArrayList<>();
        for (int i = 0; i < howManyStellen; i++) {
            StudentDTO stelleDTO = StudentDTO.builder()
                    .nutzer(GenerateNutzerDTO.generateOneRandomNutzerDTO())
                    .studentId(Long.parseLong(getValueAsString("studentId")))
                    .studentVorname(getValueAsString("studentVorname"))
                    .studentName(getValueAsString("studentName"))
                    .studentGeburtstag(getValueAsString("studentGeburtstag"))
                    .studentBenachrichtigung(true)
                    .studentBio(getValueAsString("studentBio"))
                    .studentSpezialisierung(getValueAsString("studentSpezialisierung"))
                    .studentSemester(Integer.parseInt(getValueAsString("studentSemester")))
                    .build();
            stelleDtoList.add(stelleDTO);
        }
        return stelleDtoList;
    }

    private static String getValueAsString(String switchStatement) {
        return switch (switchStatement) {
//            case "nutzer" -> xxx();
            case "studentId" -> getCounterIncrement();
            case "studentVorname" -> FirstNames.getRandomFirstName();
            case "studentName" -> LastNames.getRandomLastName();
            case "studentGeburtstag" -> Time.randomGeburtstag();
//            case "studentBenachrichtigung" -> xxx();
            case "studentBio" -> LoremText.getRandomText();
            case "studentSpezialisierung" -> Tags.getRandomSpez();
            case "studentSemester" -> Time.randomSemester();
            default -> throw new IllegalStateException("Unexpected value: " + switchStatement);
        };
    }

    private static String getCounterIncrement() {
        counter += 1;
        return String.valueOf(counter);
    }

    public static void main(String[] args) {
        List<StudentDTO> dto = GenerateStudentDTO.generateStudentDTO(1);
        System.out.println(dto);
    }
}
