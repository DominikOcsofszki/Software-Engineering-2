package tools.generate;

import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.collection.Places;
import tools.collection.StellenNameAndBeschreibung;
import tools.collection.UnternehmenAndWebsites;

import java.util.ArrayList;
import java.util.List;

public class GenerateStelleDTO {
    private static long counter = 0;

    private static String getCounterIncrement(){
        counter += 1;
        return String.valueOf(counter);
    }

    public static StelleDTO generateOneRandomStelleDTO(){
        return generateStelleDTO(1).get(0);
    }
    public static List<StelleDTO> generateStelleDTO(int howManyStellen) {
        ArrayList<StelleDTO> stelleDtoList = new ArrayList<>();
        for (int i = 0; i < howManyStellen; i++) {
            StelleDTO stelleDTO = StelleDTO.builder()
                    .stelleId(Long.valueOf(getValueAsString("stelleId")))
                    .stelleTitel(getValueAsString("stelleTitel"))
                    .stelleOrt(getValueAsString("stelleOrt"))
                    .stelleBeschreibung(getValueAsString("stelleBeschreibung"))
                    .stelleWebsite(getValueAsString("stelleWebsite"))
                    .unternehmen(getUnternehmen()).
                    build();

//            StelleDTO stelleDTO = StelleDTO.builder().build();
//            stelleDTO.setStelleId(Long.parseLong(getValueAsString(0)));
//            stelleDTO.setStelleTitel(getValueAsString(1));
//            stelleDTO.setStelleOrt(getValueAsString(2));
//            stelleDTO.setStelleBeschreibung(getValueAsString(3));
//            stelleDTO.setStelleWebsite(getValueAsString(4));
//            stelleDTO.setStelleUnternehmen(getUnternehmen());

            stelleDtoList.add(stelleDTO);
        }
        return stelleDtoList;
    }
    private static UnternehmenDTO getUnternehmen(){
        List<UnternehmenDTO> dto = GenerateUnternehmenDTO.generateUnternehmenDTO(1);
        return dto.get(0);
    }
//    private static Unternehmen unternehmenDTOToUnternehmen(UnternehmenDTO unternehmenDTO){
//        return unternehmenDTO;
//    }
//        return unternehmenDTO.stream()
//                .map(unternehmenMapper::unternehmenZuDTO)
//        ;

    private static String getValueAsString(String switchStatement){
        return switch (switchStatement) {
            case "stelleId" -> getCounterIncrement();
            case "stelleTitel" -> StellenNameAndBeschreibung.getTitleRandom();
            case "stelleOrt" -> Places.getRandomPlace();
            case "stelleBeschreibung" -> StellenNameAndBeschreibung.getBeschreibungRandom();
            case "stelleWebsite" -> UnternehmenAndWebsites.getRandomWebsite();
            default -> throw new IllegalStateException("Unexpected value: " + switchStatement);
        };
    }
//    private static Unternehmen getUnternehmen(){
//        return new Unternehmen();
//    }


    public static void main(String[] args) {
        List<StelleDTO> stelleDTO = generateStelleDTO(5);
        System.out.println(stelleDTO);
    }
}
