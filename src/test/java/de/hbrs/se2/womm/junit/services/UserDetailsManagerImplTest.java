package de.hbrs.se2.womm.junit.services;
import de.hbrs.se2.womm.entities.NutzerLogin;
import de.hbrs.se2.womm.repositories.NutzerLoginRepository;
import de.hbrs.se2.womm.services.UserDetailsManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class UserDetailsManagerImplTest {
    @Mock
    private NutzerLoginRepository nutzerLoginRepository;
    @InjectMocks
    private UserDetailsManagerImpl userDetailsManager;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testCreateUser() {
        UserDetails user = new NutzerLogin(); // Create a UserDetails object for testing
        userDetailsManager.createUser(user);
        verify(nutzerLoginRepository, times(1)).save((NutzerLogin) user);
    }
    @Test
    void testUpdateUser() {
        UserDetails user = new NutzerLogin(); // Create a UserDetails object for testing
        userDetailsManager.updateUser(user);
        verify(nutzerLoginRepository, times(1)).save((NutzerLogin) user);
    }
    @Test
    void testDeleteUser() {
        String username = "testUser";
        when(nutzerLoginRepository.findNutzerByNutzerName(username)).thenReturn(new NutzerLogin());
        assertDoesNotThrow(() -> userDetailsManager.deleteUser(username));
        verify(nutzerLoginRepository, times(1)).findNutzerByNutzerName(username);
    }
    @Test
    void testDeleteUser_UserNotFound() {
        String username = "nonexistentUser";
        when(nutzerLoginRepository.findNutzerByNutzerName(username)).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> userDetailsManager.deleteUser(username));
    }
    @Test
    void testChangePassword() {
        String oP = "oldPass";
        String nP = "newPass";
        NutzerLogin userDetails = new NutzerLogin();
        when(nutzerLoginRepository.findNutzerByNutzerPasswort(oP)).thenReturn(userDetails);
        assertDoesNotThrow(() -> userDetailsManager.changePassword(oP, nP));
        verify(nutzerLoginRepository, times(1)).findNutzerByNutzerPasswort(oP);
        verify(nutzerLoginRepository, times(1)).save(userDetails);
    }
    @Test
    void testChangePassword_InvalidPassword() {
        String oP = "invalidPass";
        String nP = "newPass";
        when(nutzerLoginRepository.findNutzerByNutzerPasswort(oP)).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> userDetailsManager.changePassword(oP, nP));
    }
    @Test
    void testUserExists() {
        String username = "existingUser";
        when(nutzerLoginRepository.existsNutzerByNutzerName(username)).thenReturn(true);
        assertTrue(userDetailsManager.userExists(username));
        verify(nutzerLoginRepository, times(1)).existsNutzerByNutzerName(username);
    }
    @Test
    void testUserNotExists() {
        String username = "nonexistentUser";
        when(nutzerLoginRepository.existsNutzerByNutzerName(username)).thenReturn(false);
        assertFalse(userDetailsManager.userExists(username));
        verify(nutzerLoginRepository, times(1)).existsNutzerByNutzerName(username);
    }
    @Test
    void testLoadUserByUsername() {
        String username = "testUser";
        NutzerLogin user = new NutzerLogin();
        when(nutzerLoginRepository.findNutzerByNutzerName(username)).thenReturn(user);
        UserDetails userDetails = userDetailsManager.loadUserByUsername(username);
        assertNotNull(userDetails);
        verify(nutzerLoginRepository, times(1)).findNutzerByNutzerName(username);
    }
    @Test
    void testLoadUserByUsername_UserNotFound() {
        String username = "nonexistentUser";
        when(nutzerLoginRepository.findNutzerByNutzerName(username)).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> userDetailsManager.loadUserByUsername(username));
    }
}
