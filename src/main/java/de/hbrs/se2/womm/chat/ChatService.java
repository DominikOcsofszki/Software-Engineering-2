package de.hbrs.se2.womm.chat;

import de.hbrs.se2.womm.dtos.AboStudentUnternehmenDTO;
import de.hbrs.se2.womm.dtos.ChatDTO;
import de.hbrs.se2.womm.entities.AboStudentUnternehmen;
import de.hbrs.se2.womm.entities.Chat;
import de.hbrs.se2.womm.mapper.ChatStudentUnternehmenMapper;
import de.hbrs.se2.womm.repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    ChatRepository chatRepository;
    //    ChatStudentUnternehmenMapper chatStudentUnternehmenMapper = ChatStudentUnternehmenMapper.INSTANCE;
    ChatDTOtoByteMapper chatStudentUnternehmenMapper = new ChatDTOtoByteMapper();
//    ChatDTOtoByteMapper chatDTOtoByteMapper = ChatDTOtoByteMapper.INSTANCE;


    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public ChatDTO getById(long id) {
        return chatRepository
                .findById(id)
                .map(chatStudentUnternehmenMapper::chatToChatDTO)
                .orElse(null);
    }

    public List<ChatDTO> getChatByStudentId(long id) {
        return chatRepository.findChatByStudent_StudentId(id)
                .stream()
                .map(chatStudentUnternehmenMapper::chatToChatDTO)
                .toList();
    }

    public void saveChatDTO(ChatDTO chatDTO) {
        Chat zuSpeichern =
                chatStudentUnternehmenMapper.chatDTOToChat(chatDTO);
        System.out.println("ChatDTO: " + chatDTO);
        chatRepository.save(zuSpeichern);
    }

//
//    public List<AboStudentUnternehmenDTO> getAll(){
//        return chatRepository.findAll()
//                .stream()
//                .map(aboStudentUnternehmenMapper::aboStudentUnternehmenToaboStudentUnternehmenDTO)
//                .toList();
//    }
//

}
