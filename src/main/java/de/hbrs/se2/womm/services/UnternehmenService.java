package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.entities.Unternehmen;
import de.hbrs.se2.womm.mapper.UnternehmenMapper;
import de.hbrs.se2.womm.repositories.UnternehmenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnternehmenService {


    private final UnternehmenRepository unternehmenRepository;
    private final UnternehmenMapper unternehmenMapper = UnternehmenMapper.INSTANCE;

    public UnternehmenService(UnternehmenRepository unternehmenRepository) {
        this.unternehmenRepository = unternehmenRepository;
    }

    public UnternehmenDTO getUnternehmenPerID(long id){
        return unternehmenRepository.findUnternehmenByUnternehmenId(id)
                .map(unternehmenMapper::unternehmenZuDTO)
                .orElse(null);
    }

    public UnternehmenDTO getByNutzerID(long id){
        return unternehmenRepository.findUnternehmenByNutzer_NutzerId(id)
                .map(unternehmenMapper::unternehmenZuDTO)
                .orElse(null);
    }

    public List<UnternehmenDTO> getUnternehmenDTOPerName(String unternehmenName) {
        return unternehmenRepository.findUnternehmenByNameIgnoreCaseContaining(unternehmenName)
                .stream()
                .map(unternehmenMapper::unternehmenZuDTO).toList();
    }
    public List<UnternehmenDTO> getAll() {
        return unternehmenRepository.findAll()
                .stream()
                .map(unternehmenMapper::unternehmenZuDTO).toList();
    }

    public void saveUnternehmen(UnternehmenDTO unternehmenDTO){
        Unternehmen unternehmen = unternehmenMapper.dtoZuUnternehmen(unternehmenDTO);
        unternehmenRepository.save(unternehmen);
    }
}
