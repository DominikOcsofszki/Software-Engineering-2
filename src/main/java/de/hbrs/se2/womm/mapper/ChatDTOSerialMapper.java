package de.hbrs.se2.womm.mapper;

import de.hbrs.se2.womm.dtos.ChatDTO;
import de.hbrs.se2.womm.dtos.ChatDTOEntry;
import de.hbrs.se2.womm.entities.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatDTOSerialMapper {
    ChatDTOSerialMapper INSTANCE = Mappers.getMapper(ChatDTOSerialMapper.class);

    Chat chatDTOToChat(ChatDTOEntry chatDTO);
    ChatDTOEntry chatToChatDTO(Chat chat);
}
