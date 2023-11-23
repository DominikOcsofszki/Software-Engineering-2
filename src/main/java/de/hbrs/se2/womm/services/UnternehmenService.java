package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.mapper.UnternehmenMapper;
import de.hbrs.se2.womm.repositories.UnternehmenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UnternehmenService {
    private final UnternehmenRepository unternehmenRepository;
    private final UnternehmenMapper mapper = UnternehmenMapper.INSTANCE;

    public UnternehmenService(UnternehmenRepository unternehmenRepository) {
        this.unternehmenRepository = unternehmenRepository;
    }

    public UnternehmenDTO getUnternehmenPerID(long id){
        return unternehmenRepository.findUnternehmenByUnternehmenId(id)
                .map(mapper::unternehmenZuDTO)
                .orElse(null);
    }

    public List<UnternehmenDTO> getUnternehmenDTOPerName(String unternehmenName) {
        return unternehmenRepository.findUnternehmenByUnternehmenNameIgnoreCaseContaining(unternehmenName)
                .stream()
                .map(mapper::unternehmenZuDTO).toList();
    }
}
