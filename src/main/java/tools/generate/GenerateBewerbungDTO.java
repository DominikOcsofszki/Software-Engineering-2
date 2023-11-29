package tools.generate;

import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import tools.collection.BewerbungText;

import java.util.ArrayList;
import java.util.List;

public class GenerateBewerbungDTO {
    private static long counter = 0;

    private static String getCounterIncrement(){
        counter += 1;
        return String.valueOf(counter);
    }

    public static BewerbungDTO generateOneRandomBewerbungDTO(){
        return generateBewerbungDTO(1).get(0);
    }

    public static List<BewerbungDTO> generateBewerbungDTO(int howManyStellen) {
        ArrayList<BewerbungDTO> stelleDtoList = new ArrayList<>();
        for (int i = 0; i < howManyStellen; i++) {
            BewerbungDTO dto = BewerbungDTO.builder()
                    .bewerbungId(Long.parseLong(getValueAsString("bewerbungId")))
                    .bewerbungPdf(getPDF())
                    .bewerbungText(getValueAsString("bewerbungText"))
                    .bewerbungStelle(getStelleRandom())
                    .bewerbungStudent(getStudentRandom())

                    .build();
            stelleDtoList.add(dto);
        }
        return stelleDtoList;
    }
    private static StelleDTO getStelleRandom(){
        List<StelleDTO> dto = GenerateStelleDTO.generateStelleDTO(1);
        return dto.get(0);
    }
    private static StudentDTO getStudentRandom(){
        List<StudentDTO> dto = GenerateStudentDTO.generate(1);
        return dto.get(0);
    }
    private static byte[] getPDF(){
//        return null;
        return new byte[100];
    }
//    private static UnternehmenDTO getUnternehmen(){
//        List<UnternehmenDTO> dto = GenerateUnternehmen.generateUnternehmenDTO(1);
//        return dto.get(0);
//    }

    private static String getValueAsString(String switchStatement){
        return switch (switchStatement) {
            case "bewerbungId" -> getCounterIncrement();
//            case "bewerbungPdf" -> ();
            case "bewerbungText" -> BewerbungText.getBewerbungTextRandom();
//            case "bewerbungStelle" -> ();
//            case "bewerbungStudent" -> xxx();
            default -> throw new IllegalStateException("Unexpected value: " + switchStatement);
        };
    }

    public static void main(String[] args) {
        List<BewerbungDTO> dto = generateBewerbungDTO(1);
        System.out.println(dto);
    }
}
