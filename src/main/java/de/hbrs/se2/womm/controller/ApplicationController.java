package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.BewerbungDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class ApplicationController extends AbstractControllerForFilter {

    // TODO add logic to methods and suitable return types for ResponseEntities

    @PostMapping("/")
    public ResponseEntity<Void> createApplication(@RequestBody BewerbungDTO request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
