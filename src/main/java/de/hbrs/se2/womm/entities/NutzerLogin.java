package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nutzer_login")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NutzerLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nutzer_login_id")
    private Integer nutzerId;

    @Column(name = "nutzer_login_name", nullable = false)
    private String nutzerName;

    @Column(name = "nutzer_login_passwort", nullable = false)
    private String nutzerPasswort;

    @OneToOne
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

}
