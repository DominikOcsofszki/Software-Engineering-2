package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.ChatNewDTO;
import de.hbrs.se2.womm.mapper.ChatMapper;
import de.hbrs.se2.womm.repositories.ChatNewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatNewService {
    ChatMapper chatMapper = ChatMapper.INSTANCE;
    ChatNewRepository chatNewRepository;

    public ChatNewService(ChatNewRepository chatNewRepository) {
        this.chatNewRepository = chatNewRepository;
    }

    public List<ChatNewDTO> getByNutzerId(long nutzerid1, long nutzerid2){
        return chatNewRepository.findChatNewByNutzerid1AndNutzerid2(nutzerid1,nutzerid2)
                .stream()
                .map(chatMapper::chatNewtoChatNewDTO)
                .toList();
    }
}
