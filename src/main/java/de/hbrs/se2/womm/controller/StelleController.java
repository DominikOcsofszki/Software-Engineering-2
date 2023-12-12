package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.StelleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stellen")
public class StelleController {
    private StelleService stelleService;

    public StelleController(StelleService stelleService) {
        this.stelleService = stelleService;
    }

    @GetMapping
    public ResponseEntity<List<StelleDTO>> getByUnternehmenId(@RequestParam(name = "unternehmenId") Long unternehmenId) {
        return new ResponseEntity<>(
                stelleService.getByUnternehmenId(unternehmenId),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StelleDTO> getById(@PathVariable Long id) {
        return stelleService.getById(id)
                .map((stelleDTO) -> new ResponseEntity<>(stelleDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/stellen")
    public ResponseEntity<StelleDTO> save(@RequestBody StelleDTO stelleDTO) {
        return new ResponseEntity<>(stelleService.saveStelle(stelleDTO), HttpStatus.OK);
    }
}
