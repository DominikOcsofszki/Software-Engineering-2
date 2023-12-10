package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.AbstractDTO;

import java.util.List;

public interface IgetDTOListbyPrimaryKeyService {
    List<? extends AbstractDTO> getDTOListbyPrimaryKeyService(long primaryKey);
}
