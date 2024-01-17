package de.hbrs.se2.womm.views.chat;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);


    ChatNew chatNewDTOtoChatNew(ChatNewDTO chat);
    ChatNewDTO chatNewtoChatNewDTO(ChatNew chat);
}
