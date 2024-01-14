package de.hbrs.se2.womm.junit.services;
import de.hbrs.se2.womm.dtos.CompanyRegistrationRequest;
import de.hbrs.se2.womm.dtos.LoginRequest;
import de.hbrs.se2.womm.dtos.StudentRegistrationRequest;
import de.hbrs.se2.womm.entities.NutzerLogin;
import de.hbrs.se2.womm.exceptions.AuthenticationException;
import de.hbrs.se2.womm.exceptions.UsernameAlreadyTakenException;
import de.hbrs.se2.womm.repositories.NutzerLoginRepository;
import de.hbrs.se2.womm.repositories.NutzerRepository;
import de.hbrs.se2.womm.repositories.StudentRepository;
import de.hbrs.se2.womm.repositories.UnternehmenRepository;
import de.hbrs.se2.womm.services.AuthenticationService;
import de.hbrs.se2.womm.services.UserDetailsManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {
    @Mock
    private NutzerLoginRepository nutzerLoginRepository;
    @Mock
    private NutzerRepository nutzerRepository;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private UnternehmenRepository unternehmenRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserDetailsManagerImpl userDetailsManager;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthenticationService authenticationService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); // intialisiert Mock-objekte
    }
    @Test
    void testRegisterStudent() throws UsernameAlreadyTakenException {

        StudentRegistrationRequest request = mock(StudentRegistrationRequest.class);
        when(request.getUsername()).thenReturn("testuser");
        when(request.getEmail()).thenReturn("test@example.com");
        when(request.getFirstname()).thenReturn("John");
        when(request.getLastname()).thenReturn("Doe");
        when(request.getDob()).thenReturn("2000-01-01");


        when(passwordEncoder.encode(any(CharSequence.class))).thenReturn("hashedPassword");// ausgabe dummy-passwort
        doNothing().when(userDetailsManager).createUser(any());
        when(nutzerRepository.findNutzerByNutzerMail(anyString())).thenReturn(null);


        authenticationService.registerStudent(request);


        verify(studentRepository, times(1)).save(any());
        verify(nutzerRepository, times(1)).save(any());
    }

    @Test
    void testRegisterCompany() throws UsernameAlreadyTakenException {

        CompanyRegistrationRequest request = mock(CompanyRegistrationRequest.class);
        when(request.getUsername()).thenReturn("testcompany");
        when(request.getEmail()).thenReturn("company@example.com");
        when(request.getName()).thenReturn("ABC Company");


        when(passwordEncoder.encode(any(CharSequence.class))).thenReturn("hashedPassword");
        doNothing().when(userDetailsManager).createUser(any());
        when(nutzerRepository.findNutzerByNutzerMail(anyString())).thenReturn(null);


        authenticationService.registerCompany(request);


        verify(unternehmenRepository, times(1)).save(any());
        verify(nutzerRepository, times(1)).save(any());
    }
    @Test
    void testLoginUser() throws AuthenticationException {
        String username = "testUser";
        String password = "testPassword";
        LoginRequest request = LoginRequest.builder().username(username).password(password).build();
        NutzerLogin user = new NutzerLogin();
        when(nutzerLoginRepository.findNutzerByNutzerName(any())).thenReturn(user);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(mock(Authentication.class));

        Authentication authentication = authenticationService.loginUser(request);


        verify(nutzerLoginRepository, times(1)).findNutzerByNutzerName(username);
        verify(authenticationManager, times(1))
                .authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(authenticationManager, times(1))
                .authenticate(any(UsernamePasswordAuthenticationToken.class));
    }
    @Test
    void testRegisterStudent_UsernameAlreadyTakenException() {

        StudentRegistrationRequest request = mock(StudentRegistrationRequest.class);
        when(request.getUsername()).thenReturn("existingUsername"); // Existing username in the repository


        when(nutzerRepository.findNutzerByNutzerMail(anyString())).thenReturn(null);
        when(nutzerLoginRepository.existsNutzerByNutzerName("existingUsername")).thenReturn(true);


        assertThrows(UsernameAlreadyTakenException.class, () -> authenticationService.registerStudent(request));
    }

    @Test
    void testRegisterCompany_UsernameAlreadyTakenException() {

        CompanyRegistrationRequest request = mock(CompanyRegistrationRequest.class);
        when(request.getUsername()).thenReturn("existingUsername"); // Existing username in the repository


        when(nutzerRepository.findNutzerByNutzerMail(anyString())).thenReturn(null);
        when(nutzerLoginRepository.existsNutzerByNutzerName("existingUsername")).thenReturn(true);


        assertThrows(UsernameAlreadyTakenException.class, () -> authenticationService.registerCompany(request));
    }

    @Test
    void testLoginUser_InvalidUsername() {

        LoginRequest request = LoginRequest.builder().username("nonExistingUser").password("testPassword").build();


        when(nutzerLoginRepository.findNutzerByNutzerName("nonExistingUser")).thenReturn(null);


        assertThrows(AuthenticationException.class, () -> authenticationService.loginUser(request));
    }

    @Test
    void testLoginUser_InvalidPassword() {

        LoginRequest request = LoginRequest.builder().username("existingUser").password("incorrectPassword").build();


        NutzerLogin user = new NutzerLogin();
        when(nutzerLoginRepository.findNutzerByNutzerName("existingUser")).thenReturn(user);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new RuntimeException("Invalid password"));


        assertThrows(AuthenticationException.class, () -> authenticationService.loginUser(request));
    }
}
