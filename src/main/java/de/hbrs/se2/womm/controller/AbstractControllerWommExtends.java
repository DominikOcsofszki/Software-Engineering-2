package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractControllerWommExtends<ExtendsAbstractDTO extends AbstractDTO> {
    public abstract ResponseEntity<List<ExtendsAbstractDTO>> getAll();
//    public abstract ResponseEntity<List<? extends AbstractDTO>> getAllFilteredBy(); //ToDo
    public abstract ResponseEntity<ExtendsAbstractDTO> getDTObyNutzerId(String nutzerIdString);
}
