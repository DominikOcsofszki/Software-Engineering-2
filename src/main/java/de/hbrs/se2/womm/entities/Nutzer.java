package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "nutzer",schema = "se")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "nutzer_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
public class Nutzer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nutzer_id", columnDefinition = "serial")
    private Integer nutzerId;

    @Column(name = "nutzer_name", nullable = false)
    private String nutzerName;

    @Column(name = "nutzer_passwort", nullable = false)
    private String nutzerPasswort;

    @Column(name = "nutzer_mail", nullable = false)
    private String nutzerMail;

    @Column(name = "nutzer_aktiv", nullable = false)
    private Boolean nutzerAktiv;

    @Column(name = "nutzer_ort", nullable = false)
    private String nutzerOrt;

    @Column(name = "nutzer_profilbild", columnDefinition = "bytea")
    private byte[] nutzerProfilbild;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return nutzerPasswort;
    }

    @Override
    public String getUsername() {
        return nutzerName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

