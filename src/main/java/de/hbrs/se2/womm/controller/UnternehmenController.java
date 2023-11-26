package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.UnternehmenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UnternehmenController {
    UnternehmenService unternehmenService;

    public UnternehmenController(UnternehmenService unternehmenService){
        this.unternehmenService = unternehmenService;
    }

    @GetMapping("/Unternehmen")
    public ResponseEntity<List<UnternehmenDTO>> getAllUnternehmen() {
        return new ResponseEntity<>(unternehmenService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/Unternehmen/{id}")
    public ResponseEntity<UnternehmenDTO> getUnternehmenById(@PathVariable long id){
        UnternehmenDTO gefunden = unternehmenService.getUnternehmenPerID(id);
        return new ResponseEntity<>(gefunden,HttpStatus.OK);
    }

    @GetMapping("/Unternehmen")
    public ResponseEntity<List<UnternehmenDTO>> getUnternehmenByName(@RequestParam(name = "name") String name) {
        List<UnternehmenDTO> gefunden = unternehmenService.getUnternehmenDTOPerName(name);
        return new ResponseEntity<>(gefunden,HttpStatus.OK);
    }

    @PatchMapping("/Unternehmen/{id}")
    public ResponseEntity<Void> updateUnternehmen(@PathVariable String id, @RequestBody UnternehmenDTO request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/Unternehmen/{id}/offers")
    public ResponseEntity<Void> getAllOffersByUnternehmen(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/Unternehmen/{UnternehmenId}/offer/{offerId}")
    public ResponseEntity<Void> getAllOffersByUnternehmen(@PathVariable String UnternehmenId, @PathVariable String offerId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
