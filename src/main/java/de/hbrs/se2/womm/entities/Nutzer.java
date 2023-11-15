package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nutzer",schema = "se")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nutzer {

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
}

