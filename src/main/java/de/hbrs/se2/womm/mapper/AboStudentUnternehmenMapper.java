package de.hbrs.se2.womm.mapper;

import de.hbrs.se2.womm.dtos.AboStudentUnternehmenDTO;
import de.hbrs.se2.womm.entities.AboStudentUnternehmen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AboStudentUnternehmenMapper {
    AboStudentUnternehmenMapper INSTANCE = Mappers.getMapper(AboStudentUnternehmenMapper.class);

    AboStudentUnternehmen aboStudentUnternehmenDTOToAboStudentUnternehmen(AboStudentUnternehmenDTO aboStudentUnternehmenDTO);
    AboStudentUnternehmenDTO aboStudentUnternehmenToaboStudentUnternehmenDTO(AboStudentUnternehmen aboStudentUnternehmen);
}
