package tools.generate;

import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.collection.FirstNames;
import tools.collection.LastNames;
import tools.collection.Places;
import tools.collection.UnternehmenAndWebsites;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateUnternehmen {
    private static long counter = 0;

        public static List<UnternehmenDTO> generateUnternehmen(int howManyStellen) {
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
            case "beschreibung" -> UnternehmenAndWebsites.getRandomWebsite();
            case "gruendung" -> Years.randomGruendung();
            default -> throw new IllegalArgumentException("switchStatement not found");
        };
    }

    private static NutzerDTO getNutzerDTO(){
            List<NutzerDTO> nutzerDTO = GenerateNutzer.generateStelle(1);
            return nutzerDTO.get(0);
        }
    private static String getCounterIncrement(){
        counter += 1;
        return String.valueOf(counter);
    }


        public static void main(String[] args) {
            List<UnternehmenDTO> dto = GenerateUnternehmen.generateUnternehmen(5);
            System.out.println(dto);
        }
    }