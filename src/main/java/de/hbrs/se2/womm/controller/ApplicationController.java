package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController extends AbstractControllerWomm {

    // TODO add logic to methods and suitable return types for ResponseEntities

    @PostMapping("/")
    public ResponseEntity<Void> createApplication(@RequestBody BewerbungDTO request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<? extends AbstractDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<? extends AbstractDTO> getDTObyPrimaryKey(String primaryKey) {
        return null; //ToDo
    }
}
