package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.BenachrichtigungDTO;
import de.hbrs.se2.womm.entities.Benachrichtigung;
import de.hbrs.se2.womm.mapper.BenachrichtigungMapper;
import de.hbrs.se2.womm.repositories.BenachrichtigungRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenachrichtigungService {
    BenachrichtigungMapper benachrichtigungMapper = BenachrichtigungMapper.INSTANCE;
    BenachrichtigungRepository benachrichtigungRepository;

    public BenachrichtigungService(BenachrichtigungRepository benachrichtigungRepository) {
        this.benachrichtigungRepository = benachrichtigungRepository;
    }

    public List<BenachrichtigungDTO> getByNutzerId(Long nutzer_id){
        return benachrichtigungRepository.findByNutzer_id(nutzer_id)
                .stream()
                .map(benachrichtigungMapper::BenachrichtigungToDto)
                .toList();
    }

    public void setGelesen(BenachrichtigungDTO benachrichtigungDTO){
        benachrichtigungDTO.setGelesen(true);
        Benachrichtigung benachrichtigung = benachrichtigungMapper
                .BenachrichtigungDTOToBenachrichtigung(benachrichtigungDTO);
        benachrichtigungRepository.save(benachrichtigung);
    }
}
