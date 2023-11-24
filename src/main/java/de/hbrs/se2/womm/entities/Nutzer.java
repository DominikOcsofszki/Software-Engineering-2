package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;

@Entity
@Table(name = "nutzer",schema = "se")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutzer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nutzer_id")
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

    @Lob
    @Column(name = "nutzer_profilbild", columnDefinition = "bytea")
    private byte[] nutzerProfilbild;

    @Column(name = "nutzer_rolle", nullable = false)
    private String rolle;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(rolle));
        return authorities;
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

