package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stelle")
public class Stelle {
    @Id
    @Column(name = "stelle_id")
    private Integer stelleId;

    @Column(name = "stelle_type", nullable = false, length = 1)
    private String stelleType;

    @Column(name = "stelle_name", nullable = false, length = 100)
    private String stelleName;

    @Column(name = "stelle_ort", nullable = false, length = 100)
    private String stelleOrt;

    @Lob
    @Column(name = "stelle_beschreibung")
    private String stelleBeschreibung;

    @Column(name = "stelle_website", length = 500)
    private String stelleWebsite;

    @ManyToOne
    @JoinColumn(name = "fachgebiet_id", referencedColumnName = "fachgebiet_id", nullable = false)
    private Fachgebiet fachgebiet;

    @ManyToOne
    @JoinColumn(name = "nutzer_id", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzer;
}

