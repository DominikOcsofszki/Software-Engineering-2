package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.AboStudentUnternehmenDTO;
import de.hbrs.se2.womm.entities.AboStudentUnternehmen;
import de.hbrs.se2.womm.mapper.AboStudentUnternehmenMapper;
import de.hbrs.se2.womm.repositories.AboStudentUnternehmenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboStudentUnternehmenService {
    AboStudentUnternehmenRepository aboStudentUnternehmenRepository;
    AboStudentUnternehmenMapper aboStudentUnternehmenMapper;

    public AboStudentUnternehmenService(AboStudentUnternehmenRepository aboStudentUnternehmenRepository,
                                        AboStudentUnternehmenMapper aboStudentUnternehmenMapper){
        this.aboStudentUnternehmenRepository =  aboStudentUnternehmenRepository;
        this.aboStudentUnternehmenMapper = aboStudentUnternehmenMapper;
    }

    public AboStudentUnternehmenDTO getById(long id){
        return aboStudentUnternehmenRepository
                .findById(id)
                .map(aboStudentUnternehmenMapper::aboStudentUnternehmenToaboStudentUnternehmenDTO)
                .orElse(null);
    }

    public List<AboStudentUnternehmenDTO> getByNutzerId(long id){
        return aboStudentUnternehmenRepository.findByStudent_NutzerNutzerIdOrUnternehmen_Nutzer_NutzerId(id,id)
                .stream()
                .map(aboStudentUnternehmenMapper::aboStudentUnternehmenToaboStudentUnternehmenDTO)
                .toList();
    }

    public List<AboStudentUnternehmenDTO> getAll(){
        return aboStudentUnternehmenRepository.findAll()
                .stream()
                .map(aboStudentUnternehmenMapper::aboStudentUnternehmenToaboStudentUnternehmenDTO)
                .toList();
    }

    public void saveAboStudentUnternehmen(AboStudentUnternehmenDTO aboDTO){
        AboStudentUnternehmen zuSpeichern =
                aboStudentUnternehmenMapper.aboStudentUnternehmenDTOToAboStudentUnternehmen(aboDTO);
        aboStudentUnternehmenRepository.save(zuSpeichern);
    }
}
