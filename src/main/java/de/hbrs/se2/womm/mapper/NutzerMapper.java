package de.hbrs.se2.womm.mapper;

import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.entities.Nutzer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NutzerMapper {
    NutzerMapper INSTANCE = Mappers.getMapper(NutzerMapper.class);

    NutzerDTO nutzerToNutzerDTO(Nutzer nutzer);

    Nutzer nutzerDTOToNutzer(NutzerDTO nutzerDTO);
}
