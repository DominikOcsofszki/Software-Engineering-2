package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/companies")
public class CompanyController {
    @GetMapping("")
    public ResponseEntity<Void> getAllCompanies() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Void> getCompanyById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/company/{id}")
    public ResponseEntity<Void> updateCompany(@PathVariable String id, @RequestBody UnternehmenDTO request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/company/{id}/offers")
    public ResponseEntity<Void> getAllOffersByCompany(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}/offer/{offerId}")
    public ResponseEntity<Void> getAllOffersByCompany(@PathVariable String companyId, @PathVariable String offerId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
