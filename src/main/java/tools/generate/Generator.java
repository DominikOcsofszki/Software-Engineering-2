package tools.generate;

import de.hbrs.se2.womm.dtos.*;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static final GenerateNutzerDTO generateNutzerDTO = new GenerateNutzerDTO();
    public static final  GenerateBewerbungDTO generateBewerbungDTO = new GenerateBewerbungDTO();
    public static final GenerateStelleDTO generateStelleDTO = new GenerateStelleDTO();
    public static final GenerateUnternehmenDTO generateUnternehmenDTO = new GenerateUnternehmenDTO();
    public static final GenerateAbonnementsDTOStillUnternehmen generateAbonnementsDTO = new GenerateAbonnementsDTOStillUnternehmen();
    public static final GenerateBenachrichtigungenDTOStillUnternehmen generateBenachrichtigungenDTO = new GenerateBenachrichtigungenDTOStillUnternehmen();



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

//    public static void main(String[] args) {
//        Generator generator = new Generator();
//        generator.generateAll(1);
//    }

}
