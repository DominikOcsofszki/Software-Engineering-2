package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.AbstractDTO;

import java.util.List;

public interface IServicegetDTObyPrimaryKey {
    List<? extends AbstractDTO> getDTOListbyPrimaryKey(long primaryKey);
}
