package de.hbrs.se2.womm.views.chat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatNewService {
    ChatMapper chatMapper = ChatMapper.INSTANCE;
    ChatNewRepository chatNewRepository;

    public ChatNewService(ChatNewRepository chatNewRepository) {
        this.chatNewRepository = chatNewRepository;
    }

    public List<ChatNewDTO> getByTwoNutzerIds(long nutzerid1, long nutzerid2){
        return chatNewRepository.findChatNewByNutzerid1AndNutzerid2(nutzerid1,nutzerid2)
                .stream()
                .map(chatMapper::chatNewtoChatNewDTO)
                .toList();
    }
    public List<ChatNewDTO> getByUnternehmenStudent(long nutzerid1, long nutzerid2){
        return chatNewRepository.findChatNewByNutzerid1AndNutzerid2(nutzerid2,nutzerid1)
                .stream()
                .map(chatMapper::chatNewtoChatNewDTO)
                .toList();
    }
    public void saveChatNewDTO(ChatNewDTO chatNewDTO){
        chatNewRepository.save(chatMapper.chatNewDTOtoChatNew(chatNewDTO));
    }
}
