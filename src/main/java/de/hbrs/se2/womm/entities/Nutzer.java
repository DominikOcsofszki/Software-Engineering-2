package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "se", name = "nutzer")
public class Nutzer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nutzer_id")
    private Integer nutzerId;

    @Column(name = "nutzer_name", nullable = false, length = 50)
    private String nutzerName;

    @Column(name = "nutzer_vorname", nullable = false, length = 50)
    private String nutzerVorname;

    @Column(name = "nutzer_kennung", nullable = false, length = 1)
    private String nutzerKennung;

    @Column(name = "nutzer_telefonnummer", length = 15)
    private String nutzerTelefonnummer;

    @Column(name = "nutzer_profilbild")
    private byte[] nutzerProfilbild;

    @Column(name = "nutzer_bio", columnDefinition = "TEXT")
    private String nutzerBio;

    @Column(name = "nutzer_ort", length = 150)
    private String nutzerOrt;

    @Column(name = "nutzer_aktiviert", nullable = false)
    private Boolean nutzerAktiviert;

    @Column(name = "nutzer_benachrichtigung", nullable = false)
    private Boolean nutzerBenachrichtigung;
}
