package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.StelleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StelleController {
    private StelleService stelleService;

    public StelleController(StelleService stelleService) {
        this.stelleService = stelleService;
    }

    @GetMapping("/users/unternehmen/{id}/stellen")
    public ResponseEntity<List<StelleDTO>> getStelleByUnternehmenId(@PathVariable Long id) {
        return new ResponseEntity<>(
                stelleService.getByUnternehmenId(id), //ToDo implement in StelleService
                HttpStatus.OK
        );
    }

    @GetMapping("/stellen/{id}")
    public ResponseEntity<StelleDTO> getById(@PathVariable Long id)  {
//    public StelleDTO getById(@PathVariable Long id) throws NotFoundException {
        Optional<StelleDTO> stelleDTO = stelleService.getById(id);
        if (stelleDTO.isPresent()) {
            return new ResponseEntity<>(stelleDTO.get(), HttpStatus.OK);
        } else {
            return null;
//            throw new NotFoundException("Stelle mit der id: " + id + " nicht gefunden.");
        }
    }

    @PostMapping("/stellen")
    public ResponseEntity<StelleDTO> saveStelle(@RequestBody StelleDTO stelleDTO) {
        return new ResponseEntity<>(stelleService.saveStelle(stelleDTO), HttpStatus.OK);
    }

    public ResponseEntity<List<? extends AbstractDTO>> getDTObyPrimaryKeyIfNegativeAll(long primaryKey) {
        System.out.println("primaryKey:" + primaryKey);
        List<StelleDTO> stelleDTOList = primaryKey < 0 ? stelleService.getAll() : stelleService.getByUnternehmenId(primaryKey);
//        List<StelleDTO> stelleDTOList = stelleService.getByUnternehmenId(2l);

        return new ResponseEntity<>(
//                stelleService.getAll(),
                stelleDTOList,
                HttpStatus.OK);
    }
}
