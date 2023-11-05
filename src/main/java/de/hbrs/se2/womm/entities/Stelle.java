package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stelle")
@Getter
@Setter
@NoArgsConstructor
public class Stelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stelle_id")
    private Integer stelleId;

    @Column(name = "stelle_titel", nullable = false)
    private String stelleTitel;

    @Column(name = "stelle_ort", nullable = false)
    private String stelleOrt;

    @Column(name = "stelle_beschreibung", nullable = false)
    private String stelleBeschreibung;

    @Column(name = "stelle_website")
    private String stelleWebsite;

    @ManyToOne
    @JoinColumn(name = "unternehmen_id")
    private Unternehmen unternehmen;

}

