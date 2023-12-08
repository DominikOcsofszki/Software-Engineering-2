package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.StelleService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StelleController extends AbstractControllerWomm {
//    public class StelleController extends AbstractControllerWommExtends<StelleDTO> {

    StelleService stelleService;

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
    public StelleDTO getById(@PathVariable Long id)  {
//    public StelleDTO getById(@PathVariable Long id) throws NotFoundException {
        Optional<StelleDTO> stelleDTO = stelleService.getById(id);
        if (stelleDTO.isPresent()) {
            return stelleDTO.get();
        } else {
            return null;
//            throw new NotFoundException("Stelle mit der id: " + id + " nicht gefunden.");
        }
    }

    @PostMapping("/stellen")
    public ResponseEntity<StelleDTO> saveStelle(@RequestBody StelleDTO stelleDTO) {
        return new ResponseEntity<>(stelleService.saveStelle(stelleDTO), HttpStatus.OK);
    }

//    @Override
//    @GetMapping("all")
//    public ResponseEntity<List<? extends AbstractDTO>> getAll() {
//        return new ResponseEntity<>(
//                stelleService.getAll(),
//                HttpStatus.OK
//        );
//    }


    @Override
    public ResponseEntity<? extends AbstractDTO> getDTObyPrimaryKeyIfNegativeAll(long primaryKey) {
        return null;
    }
}
