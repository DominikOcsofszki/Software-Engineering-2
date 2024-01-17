package de.hbrs.se2.womm.mapper;

import de.hbrs.se2.womm.dtos.ChatNewDTO;
import de.hbrs.se2.womm.entities.ChatNew;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);


    ChatNew chatNewDTOtoChatNew(ChatNewDTO chat);
    ChatNewDTO chatNewtoChatNewDTO(ChatNew chat);
}
