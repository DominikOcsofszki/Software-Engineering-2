package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.RegistrationRequest;
import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.exceptions.UsernameAlreadyTakenException;
import de.hbrs.se2.womm.repositories.NutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserDetailsManagerImpl userDetailsManager;
    @Autowired
    private NutzerRepository nutzerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(RegistrationRequest request) throws UsernameAlreadyTakenException {
        String username = request.getUsername();
        if (nutzerRepository.existsNutzerByNutzerName(username))
            throw new UsernameAlreadyTakenException("Username " + username + " is already taken!");
        userDetailsManager.createUser(Nutzer.builder()
                .nutzerName(request.getUsername())
                .nutzerMail(request.getEmail())
                .nutzerPasswort(passwordEncoder.encode(request.getPassword()))
                .nutzerOrt(request.getLocation())
                .nutzerAktiv(true)
                .build());
    }
}
