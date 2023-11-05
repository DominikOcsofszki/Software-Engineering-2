package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "unternehmen")
@Getter
@Setter
@NoArgsConstructor
public class Unternehmen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unternehmen_id")
    private Integer unternehmenId;

    @Column(name = "unternehmen_name", nullable = false)
    private String unternehmenName;

    @Column(name = "unternehmen_beschreibung")
    private String unternehmenBeschreibung;

    @Column(name = "unternehmen_gruendung")
    private Date unternehmenGruendung;

    @OneToOne
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

}

