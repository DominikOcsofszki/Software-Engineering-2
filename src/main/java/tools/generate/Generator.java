package tools.generate;

import de.hbrs.se2.womm.dtos.*;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    GenerateNutzerDTO generateNutzerDTO = new GenerateNutzerDTO();
    GenerateBewerbungDTO generateBewerbungDTO = new GenerateBewerbungDTO();
    GenerateStelleDTO generateStelleDTO = new GenerateStelleDTO();
    GenerateUnternehmenDTO generateUnternehmenDTO = new GenerateUnternehmenDTO();
    GenerateAbonnementsDTOStillUnternehmen generateAbonnementsDTO = new GenerateAbonnementsDTOStillUnternehmen();
    GenerateBenachrichtigungenDTOStillUnternehmen generateBenachrichtigungenDTO = new GenerateBenachrichtigungenDTOStillUnternehmen();



    public void generateAll(int howMany){
        List<List<? extends AbstractDTO>> listOfAllDTO = new ArrayList<>();
        List<NutzerDTO> nutzerDTOList = generateNutzerDTO.generateNutzerDTO(howMany);
        List<BewerbungDTO> bewerbungDTOList = generateBewerbungDTO.generateBewerbungDTO(howMany);
        List<StelleDTO> stelleDTOList = generateStelleDTO.generateStelleDTO(howMany);
        List<UnternehmenDTO> unternehmenDTOList =generateUnternehmenDTO.generateUnternehmenDTO(howMany);
        List<UnternehmenDTO> doToChange =generateAbonnementsDTO.generateAbonnementsDTO(howMany);
        List<UnternehmenDTO> doToChange2 =generateBenachrichtigungenDTO.generateBenachrichtigungenDTO(howMany);
        listOfAllDTO.add(nutzerDTOList);
        listOfAllDTO.add(bewerbungDTOList);
        listOfAllDTO.add(stelleDTOList);
        listOfAllDTO.add(unternehmenDTOList);
        listOfAllDTO.add(doToChange);
        listOfAllDTO.add(doToChange2);
        System.out.println(listOfAllDTO);
    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.generateAll(1);
    }

}
