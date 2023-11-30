
package tools.generate;

import de.hbrs.se2.womm.dtos.*;

import java.util.List;

public class GENERATOR {
    public static final GenerateNutzerDTO GENERATOR_NUTZER_DTO = new GenerateNutzerDTO();
    public static final GenerateUnternehmenDTO GENERATOR_UNTERNEHMEN_DTO = new GenerateUnternehmenDTO();
    public static final GenerateStudentDTO GENERATOR_STUDENT_DTO = new GenerateStudentDTO();
    public static final GenerateBewerbungDTO GENERATOR_BEWERBUNG_DTO = new GenerateBewerbungDTO();
    public static final GenerateStelleDTO GENERATOR_STELLE_DTO = new GenerateStelleDTO();
    public static final GenerateAbonnementsDTOStillUnternehmen GENERATOR_ABONNEMENTS_DTO_STILL_UNTERNEHMEN = new GenerateAbonnementsDTOStillUnternehmen();
    public static final GenerateBenachrichtigungenDTOStillUnternehmen GENERATOR_BENACHRICHTIGUNGEN_DTO_STILL_UNTERNEHMEN = new GenerateBenachrichtigungenDTOStillUnternehmen();

    public GENERATOR() {
    }

    public static NutzerDTO generateOneNutzerDTO() {
        return GENERATOR_NUTZER_DTO.generateNutzerDTO(1).get(0);
    }

    public static List<NutzerDTO> generateNutzerDTO(int howMany) {
        return GENERATOR_NUTZER_DTO.generateNutzerDTO(howMany);
    }

    public static UnternehmenDTO generateOneUnternehmenDTO() {
        return GENERATOR_UNTERNEHMEN_DTO.generateUnternehmenDTO(1).get(0);
    }
    public static List<UnternehmenDTO> generateUnternehmenDTO(int howMany) {
        return GENERATOR_UNTERNEHMEN_DTO.generateUnternehmenDTO(howMany);
    }
    public static StelleDTO generateOneStelleDTO() {
        return GENERATOR_STELLE_DTO.generateStelleDTO(1).get(0);
    }
    public static List<StelleDTO> generateStelleDTO(int howMany) {
        return GENERATOR_STELLE_DTO.generateStelleDTO(howMany);
    }
    //Student
    public static StudentDTO generateOneStudentDTO() {
        return GENERATOR_STUDENT_DTO.generateStudentDTO(1).get(0);
    }
    public static List<StudentDTO> generateStudentDTO(int howMany) {
        return GENERATOR_STUDENT_DTO.generateStudentDTO(howMany);
    }
    //Bewerbung
    public static BewerbungDTO generateOneBewerbungDTO() {
        return GENERATOR_BEWERBUNG_DTO.generateBewerbungDTO(1).get(0);
    }
    public static List<BewerbungDTO> generateBewerbungDTO(int howMany) {
        return GENERATOR_BEWERBUNG_DTO.generateBewerbungDTO(howMany);
    }
}

//
//    public static void generateAll(int howMany){
//        List<List<? extends AbstractDTO>> listOfAllDTO = new ArrayList<>();
//        List<NutzerDTO> nutzerDTOList = GENERATOR_NUTZER_DTO.generateNutzerDTO(howMany);
//        List<BewerbungDTO> bewerbungDTOList = GENERATOR_BEWERBUNG_DTO.generateBewerbungDTO(howMany);
//        List<StelleDTO> stelleDTOList = GENERATOR_STELLE_DTO.generateStelleDTO(howMany);
//        List<UnternehmenDTO> unternehmenDTOList = GENERATOR_UNTERNEHMEN_DTO.generateUnternehmenDTO(howMany);
//        List<UnternehmenDTO> doToChange = GENERATOR_ABONNEMENTS_DTO_STILL_UNTERNEHMEN.generateAbonnementsDTO(howMany);
//        List<UnternehmenDTO> doToChange2 = GENERATOR_BENACHRICHTIGUNGEN_DTO_STILL_UNTERNEHMEN.generateBenachrichtigungenDTO(howMany);
//        listOfAllDTO.add(nutzerDTOList);
//        listOfAllDTO.add(bewerbungDTOList);
//        listOfAllDTO.add(stelleDTOList);
//        listOfAllDTO.add(unternehmenDTOList);
//        listOfAllDTO.add(doToChange);
//        listOfAllDTO.add(doToChange2);
//        System.out.println(listOfAllDTO);
//    }
//
//    public static List<?> StelleDTO(int i) {
//    }
//
////    public static void main(String[] args) {
////        Generator generator = new Generator();
////        generator.generateAll(1);
////    }
//
//}
