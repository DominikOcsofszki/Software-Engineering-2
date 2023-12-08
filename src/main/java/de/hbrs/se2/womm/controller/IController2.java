package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IController2 {
    ResponseEntity<List<? extends AbstractDTO>> getAll();
    ResponseEntity<List<? extends AbstractDTO>> getAllFilteredBy(); //ToDo
    ResponseEntity<? extends AbstractDTO> getDTObyPrimaryKey(String primaryKey);
}
