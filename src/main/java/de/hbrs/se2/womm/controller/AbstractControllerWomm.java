package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import org.springframework.http.ResponseEntity;

public abstract class AbstractControllerWomm {
public abstract ResponseEntity<? extends AbstractDTO> getDTObyPrimaryKeyIfNegativeAll(long primaryKey);
//    return primaryKey < 0 ? xService.getAll() : xService.getDTObyPrimaryKey(primaryKey);
}

