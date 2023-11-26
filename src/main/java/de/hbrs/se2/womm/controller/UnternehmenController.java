package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.UnternehmenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UnternehmenController extends AbstractControllerForFilter {
    UnternehmenService unternehmenService;

    public UnternehmenController(UnternehmenService unternehmenService){
        this.unternehmenService = unternehmenService;
    }

    @GetMapping("")
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

    @PostMapping("/Unternehmen")
    public ResponseEntity<Void> saveUnternehmen(@RequestBody UnternehmenDTO zuErstellendesUnternehmen){
        unternehmenService.saveUnternehmen(zuErstellendesUnternehmen);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
