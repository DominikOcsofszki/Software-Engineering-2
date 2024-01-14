package de.hbrs.se2.womm.mapper;

import de.hbrs.se2.womm.dtos.AboStudentUnternehmenDTO;
import de.hbrs.se2.womm.dtos.ChatDTO;
import de.hbrs.se2.womm.entities.AboStudentUnternehmen;
import de.hbrs.se2.womm.entities.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatStudentUnternehmenMapper {
    ChatStudentUnternehmenMapper INSTANCE = Mappers.getMapper(ChatStudentUnternehmenMapper.class);

    Chat chatDTOToChat(ChatDTO chatDTO);
    ChatDTO chatToChatDTO(Chat chat);
}
