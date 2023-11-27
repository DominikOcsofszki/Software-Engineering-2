package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nutzerLogin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NutzerLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nutzerLogin_id")
    private Integer nutzerId;

    @Column(name = "nutzerLogin_name", nullable = false)
    private String nutzerName;

    @Column(name = "nutzerLogin_passwort", nullable = false)
    private String nutzerPasswort;

    @OneToOne
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

}
