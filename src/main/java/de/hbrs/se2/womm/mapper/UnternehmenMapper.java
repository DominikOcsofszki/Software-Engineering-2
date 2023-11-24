package de.hbrs.se2.womm.mapper;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.entities.Unternehmen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper()
public interface UnternehmenMapper {
    UnternehmenMapper INSTANCE = Mappers.getMapper(UnternehmenMapper.class);

    @Mapping(target = "nutzer", source = "nutzer")
    @Mapping(target = "name", source = "unternehmenName")
    @Mapping(target = "gruendung", source = "unternehmenGruendung")
    @Mapping(target = "beschreibung", source = "unternehmenBeschreibung")
    UnternehmenDTO unternehmenZuDTO(Unternehmen unternehmen);

}
