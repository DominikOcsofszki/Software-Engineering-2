package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.CompanyRegistrationRequest;
import de.hbrs.se2.womm.dtos.LoginRequest;
import de.hbrs.se2.womm.dtos.RegistrationRequest;
import de.hbrs.se2.womm.dtos.StudentRegistrationRequest;
import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.entities.Student;
import de.hbrs.se2.womm.entities.Unternehmen;
import de.hbrs.se2.womm.exceptions.AuthenticationException;
import de.hbrs.se2.womm.exceptions.UsernameAlreadyTakenException;
import de.hbrs.se2.womm.model.Roles;
import de.hbrs.se2.womm.repositories.NutzerRepository;
import de.hbrs.se2.womm.repositories.StudentRepository;
import de.hbrs.se2.womm.repositories.UnternehmenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserDetailsManagerImpl userDetailsManager;
    @Autowired
    private NutzerRepository nutzerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UnternehmenRepository unternehmenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public void registerStudent(StudentRegistrationRequest request) throws UsernameAlreadyTakenException {
        String username = request.getUsername();
        createUser(request, username, Roles.STUDENT.toString());
        // speichert Studenten mit FK zur Nutzer-Tabelle
        Nutzer user = nutzerRepository.findNutzerByNutzerName(username);
        studentRepository.save(Student.builder()
                    .studentVorname(request.getFirstname())
                    .studentName(request.getLastname())
                    .studentGeburtstag(request.getDob())
                    .studentBenachrichtigung(false)
                    .nutzer(user)
                .build());
    }

    public void registerCompany(CompanyRegistrationRequest request) throws UsernameAlreadyTakenException {
        String username = request.getUsername();
        createUser(request, username, Roles.UNTERNEHMEN.toString());
        // speichert Unternehmen mit FK zur Nutzer-Tabelle
        Nutzer user = nutzerRepository.findNutzerByNutzerName(username);
        unternehmenRepository.save(Unternehmen.builder()
                    .nutzer(user)
                    .unternehmenName(request.getName())
                .build());
    }

    public Authentication loginUser(LoginRequest request) throws AuthenticationException {
        Nutzer user = nutzerRepository.findNutzerByNutzerName(request.getUsername());
        if (user == null) throw new AuthenticationException("Invalid username");
        try {
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            throw new AuthenticationException("Invalid password");
        }
    }

    /**
     * speichert einen Nutzer für Student- oder Unternehmensanfrage
     */
    private void createUser(RegistrationRequest request, String username, String role) throws UsernameAlreadyTakenException {
        if (nutzerRepository.existsNutzerByNutzerName(username))
            throw new UsernameAlreadyTakenException("Username " + username + " is already taken!");
        userDetailsManager.createUser(Nutzer.builder()
                    .nutzerName(request.getUsername())
                    .nutzerMail(request.getEmail())
                    .nutzerPasswort(passwordEncoder.encode(request.getPassword()))
                    .nutzerOrt(request.getLocation())
                    .rolle(role)
                    .nutzerAktiv(true)
                .build());
    }
}
