package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.CompanyRegistrationRequest;
import de.hbrs.se2.womm.dtos.RegistrationRequest;
import de.hbrs.se2.womm.dtos.StudentRegistrationRequest;
import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.entities.Student;
import de.hbrs.se2.womm.entities.Unternehmen;
import de.hbrs.se2.womm.exceptions.UsernameAlreadyTakenException;
import de.hbrs.se2.womm.repositories.NutzerRepository;
import de.hbrs.se2.womm.repositories.StudentRepository;
import de.hbrs.se2.womm.repositories.UnternehmenRepository;
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
    private StudentRepository studentRepository;
    @Autowired
    private UnternehmenRepository unternehmenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerStudent(StudentRegistrationRequest request) throws UsernameAlreadyTakenException {
        String username = request.getUsername();
        createUser(request, username);
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
        createUser(request, username);
        // speichert Unternehmen mit FK zur Nutzer-Tabelle
        Nutzer user = nutzerRepository.findNutzerByNutzerName(username);
        unternehmenRepository.save(Unternehmen.builder()
                    .nutzer(user)
                    .unternehmenName(request.getName())
                .build());
    }

    /**
     * speichert einen Nutzer für Student- oder Unternehmensanfrage
     */
    private void createUser(RegistrationRequest request, String username) throws UsernameAlreadyTakenException {
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
