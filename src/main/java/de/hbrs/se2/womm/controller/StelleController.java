package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.StelleService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class StelleController {

    StelleService stelleService;

    public StelleController(StelleService stelleService) {
        this.stelleService = stelleService;
    }

    @GetMapping("users/unternehmen/{id}/stellen")
    public List<StelleDTO> getStelleByUnternehmenId(@PathVariable Long id) {
        return stelleService.getByUnternehmenId(id);
    }

    @GetMapping("stellen/{id}")
    public StelleDTO getById(@PathVariable Long id) throws NotFoundException {
        Optional<StelleDTO> stelleDTO = stelleService.getById(id);
        if (stelleDTO.isPresent()) {
            return stelleDTO.get();
        } else {
            throw new NotFoundException("Stelle mit der id: " + id + " nicht gefunden.");
        }
    }

    @PostMapping("stellen")
    public void saveStelle(@RequestBody StelleDTO stelleDTO) {
        stelleService.saveStelle(stelleDTO);
    }
}
