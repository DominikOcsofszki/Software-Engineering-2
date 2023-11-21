package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.repositories.NutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsManagerImpl implements UserDetailsManager {

    @Autowired
    private NutzerRepository nutzerRepository;

    @Override
    public void createUser(UserDetails user) {
        nutzerRepository.save((Nutzer) user);
    }

    @Override
    public void updateUser(UserDetails user) {
        nutzerRepository.save((Nutzer) user);
    }

    @Override
    public void deleteUser(String username) throws UsernameNotFoundException {
        Nutzer user = nutzerRepository.findNutzerByNutzerName(username);
        if (user == null) throw new UsernameNotFoundException("No User found for username: " + username);
    }

    /**
     * This method assumes that both oldPassword and the newPassword params
     * are encoded with configured passwordEncoder
     *
     * @param oldPassword the old password of the user
     * @param newPassword the new password of the user
     */
    @Override
    @Transactional
    public void changePassword(String oldPassword, String newPassword) {
        Nutzer userDetails = nutzerRepository.findNutzerByNutzerPasswort(oldPassword);
        if (userDetails == null) throw new UsernameNotFoundException("Invalid password");
        userDetails.setNutzerPasswort(newPassword);
        nutzerRepository.save(userDetails);
    }

    @Override
    public boolean userExists(String username) {
        return nutzerRepository.existsNutzerByNutzerName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nutzer user = nutzerRepository.findNutzerByNutzerName(username);
        if (user == null) throw new UsernameNotFoundException("No User found for username: " + username);
        return user;
    }
}
