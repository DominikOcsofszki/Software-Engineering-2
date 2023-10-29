package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "se", name = "bewertung")
public class Bewertung {
    @Id
    @Column(name = "bewertung_id")
    private Integer bewertungId;

    @Column(name = "bewertung_wert", nullable = false)
    private Integer bewertungWert;

    @Lob
    @Column(name = "bewertung_text")
    private String bewertungText;

    @ManyToOne
    @JoinColumn(name = "nutzer_id_profil", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzerProfil;

    @ManyToOne
    @JoinColumn(name = "nutzer_id_abonnent", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzerAbonnent;
}
