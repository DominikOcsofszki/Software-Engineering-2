package tools.generate;

import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.collection.BenachrichtigungText;
import tools.collection.Time;
import tools.collection.UnternehmenAndWebsites;

import java.util.ArrayList;
import java.util.List;

public class GenerateBenachrichtigungenDTOStillUnternehmen {
    private static long counter = 0;

    public static UnternehmenDTO generateOneBenachrichtigungenDTO() {
        return generateBenachrichtigungenDTO(1).get(0);
    }
    public static List<UnternehmenDTO> generateBenachrichtigungenDTO(int howManyStellen) {
        ArrayList<UnternehmenDTO> stelleDtoList = new ArrayList<>();
        for (int i = 0; i < howManyStellen; i++) {
            UnternehmenDTO stelleDTO = UnternehmenDTO.builder()
                    .unternehmenId(Long.parseLong(getValueAsString("unternehmenId")))
                    .name(getValueAsString("name"))
                    .beschreibung(getValueAsString("beschreibung"))
                    .gruendung(getValueAsString("gruendung"))
                    .nutzer(getNutzerDTO())

                    .build();
            stelleDtoList.add(stelleDTO);
        }
        return stelleDtoList;
    }
    private static String getValueAsString(String switchStatement){
        return switch (switchStatement){
            case "unternehmenId" -> getCounterIncrement();
            case "name" -> UnternehmenAndWebsites.getRandomUnternehmenName();
//            case "beschreibung" -> UnternehmenAndWebsites.getRandomWebsite();
//            case "beschreibung" -> AboText.getRandomText();
            case "beschreibung" -> BenachrichtigungText.getRandomText();
            case "gruendung" -> Time.randomGruendung();
            default -> throw new IllegalArgumentException("switchStatement not found");
        };
    }

    private static NutzerDTO getNutzerDTO(){
        List<NutzerDTO> nutzerDTO = GenerateNutzerDTO.generateNutzerDTO(1);
        return nutzerDTO.get(0);
    }
    private static String getCounterIncrement(){
        counter += 1;
        return String.valueOf(counter);
    }


    public static void main(String[] args) {
        List<UnternehmenDTO> dto = GenerateUnternehmenDTO.generateUnternehmenDTO(5);
        System.out.println(dto);
    }
}