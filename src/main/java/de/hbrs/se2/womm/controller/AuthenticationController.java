package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.LoginRequest;
import de.hbrs.se2.womm.dtos.LogoutRequest;
import de.hbrs.se2.womm.dtos.RegistrationRequest;
import de.hbrs.se2.womm.exceptions.UsernameAlreadyTakenException;
import de.hbrs.se2.womm.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegistrationRequest request) throws UsernameAlreadyTakenException {
        authenticationService.registerUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody LoginRequest request) {
        // TODO: add logic
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser(@RequestBody LogoutRequest request) {
        // TODO: add logic
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
