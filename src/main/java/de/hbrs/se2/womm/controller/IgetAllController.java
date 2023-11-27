package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IgetAllController {

    ResponseEntity<List<? extends AbstractDTO>> getAll();

}