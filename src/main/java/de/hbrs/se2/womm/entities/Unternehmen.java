package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "unternehmen",schema = "se")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "unternehmen_id_seq", sequenceName = "unternehmen_id_seq", allocationSize = 1)
public class Unternehmen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "unternehmen_id", columnDefinition = "serial")
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

