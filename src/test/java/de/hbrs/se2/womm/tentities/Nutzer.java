package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nutzer",schema = "test")
@Getter
@Setter
@NoArgsConstructor
public class Nutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

