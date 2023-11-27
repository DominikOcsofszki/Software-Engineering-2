package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.mapper.StelleMapper;
import de.hbrs.se2.womm.repositories.StelleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StelleService implements IgetAllService {
    private final StelleRepository stelleRepository;
    private final StelleMapper stelleMapper = StelleMapper.INSTANCE;

    public StelleService(StelleRepository stelleRepository) {
        this.stelleRepository = stelleRepository;
    }

    public List<StelleDTO> getByUnternehmenId(Long unternehmenId) {
        return stelleRepository.findByUnternehmen_UnternehmenId(unternehmenId)
                .stream()
                .map(stelleMapper::stelleToStelleDto)
                .toList();
    }

    public Optional<StelleDTO> getById(Long id) {
        return stelleRepository.findById(id)
                .map(stelleMapper::stelleToStelleDto);
    }

    public void saveStelle(StelleDTO stelleDTO) {
        Stelle stelle = stelleMapper.stelleDtoToStelle(stelleDTO);
        stelleRepository.save(stelle);
    }

    @Override
    public List<? extends AbstractDTO> getAllService() {
        return stelleRepository.findAll()
                .stream()
                .map(stelleMapper::stelleToStelleDto).toList();
    }
}
