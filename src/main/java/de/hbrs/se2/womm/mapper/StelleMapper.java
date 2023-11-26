package de.hbrs.se2.womm.mapper;

import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.entities.Stelle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StelleMapper {
    StelleMapper INSTANCE = Mappers.getMapper(StelleMapper.class);


    @Mapping(target = "stelleUnternehmen", source = "unternehmen")
    StelleDTO stelleToStelleDto(Stelle stelle);


    @Mapping(target = "unternehmen", source = "stelleUnternehmen")
    Stelle stelleDtoToStelle(StelleDTO stelleDTO);
}
