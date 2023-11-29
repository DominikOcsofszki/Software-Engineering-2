package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.mapper.BewerbungMapper;
import de.hbrs.se2.womm.repositories.BewerbungRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BewerbungService implements IgetAllService {
    BewerbungRepository bewerbungRepository;
    BewerbungMapper bewerbungMapper = BewerbungMapper.INSTNACE;

    public BewerbungService(BewerbungRepository bewerbungRepository) {
        this.bewerbungRepository = bewerbungRepository;
    }

    public List<BewerbungDTO> getAll() {
        return bewerbungRepository.findAll()
                .stream()
                .map(bewerbungMapper::bewerbungToBewerbungDto)
                .toList();
    }

    public Optional<BewerbungDTO> getById(Long id) {
        return bewerbungRepository.findById(id)
                .map(bewerbungMapper::bewerbungToBewerbungDto);
    }

    @Override
    public List<? extends AbstractDTO> getAllService() {
        return bewerbungRepository.findAll()
                .stream()
                .map(bewerbungMapper::bewerbungToBewerbungDto).toList();
    }
    public void save(BewerbungDTO bewerbungDTO) {
        bewerbungRepository.save(bewerbungMapper.bewerbungDtoToBewerbung(bewerbungDTO));
    }
}
