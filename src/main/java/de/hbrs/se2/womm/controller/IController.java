package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

interface IController<ExtendsAbstractDTO extends AbstractDTO> {
    ResponseEntity<List<ExtendsAbstractDTO>> getAll();

    ResponseEntity<List<ExtendsAbstractDTO>> getAllFilteredBy(String filterString);

    ResponseEntity<ExtendsAbstractDTO> getOneDTObyPrimaryKey(String nutzerIdString);
}
