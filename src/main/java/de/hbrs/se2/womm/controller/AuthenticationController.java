package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.LoginRequest;
import de.hbrs.se2.womm.dtos.LogoutRequest;
import de.hbrs.se2.womm.dtos.RegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    // TODO add logic to methods and suitable return types for ResponseEntities

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegistrationRequest request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody LoginRequest request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser(@RequestBody LogoutRequest request) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
