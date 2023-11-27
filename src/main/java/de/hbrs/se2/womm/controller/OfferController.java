package de.hbrs.se2.womm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offers")
public class OfferController extends AbstractControllerForFilter {

    // TODO add logic to methods and suitable return types for ResponseEntities

    @GetMapping("")
    public ResponseEntity<Void> getAllOffers() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createOffer() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/offer/{id}/applications")
    public ResponseEntity<Void> getAllApplicationsForOffer(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/offer/{offerId}/application/{appId}")
    public ResponseEntity<Void> getApplicationForOffer(@PathVariable String offerId, @PathVariable String appId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
