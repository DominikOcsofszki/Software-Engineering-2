package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractControllerWomm {
    public abstract ResponseEntity<List<? extends AbstractDTO>> getAll();
//    public abstract ResponseEntity<List<? extends AbstractDTO>> getAllFilteredBy(); //ToDo
    public abstract ResponseEntity<? extends AbstractDTO> getDTObyPrimaryKey(String primaryKey);
}
