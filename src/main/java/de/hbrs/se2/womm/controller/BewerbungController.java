package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.services.BewerbungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bewerbung")
public class BewerbungController extends AbstractControllerWomm {

    BewerbungService bewerbungService;

    public BewerbungController(BewerbungService bewerbungService) {
        this.bewerbungService = bewerbungService;
    }

    @GetMapping("")
    public ResponseEntity<List<BewerbungDTO>> getAllBewerbung() {
        return new ResponseEntity<>(bewerbungService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BewerbungDTO> getById(@PathVariable Long id) {
        return bewerbungService.getById(id)
                .map((bewerbungDTO) -> new ResponseEntity<>(bewerbungDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    @Override
    public ResponseEntity<List<? extends AbstractDTO>> getAll() {
        return new ResponseEntity<>(
                bewerbungService.getAll(),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<List<? extends AbstractDTO>> getDTObyID(String primaryKey) {
        return null; //ToDo
    }
}