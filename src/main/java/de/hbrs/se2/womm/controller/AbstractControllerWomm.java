package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractControllerWomm{
//public abstract class AbstractControllerWomm<ExtendsAbstractDTO extends AbstractDTO>{
//    public abstract ResponseEntity<List<? extends AbstractDTO>> getDTObyPrimaryKeyIfNegativeAll(long primaryKey);
    public abstract ResponseEntity<List<? extends AbstractDTO>> getDTObyPrimaryKeyIfNegativeAll(long primaryKey);

//    return primaryKey < 0 ? xService.getAll() : xService.getDTObyPrimaryKey(primaryKey);
}

