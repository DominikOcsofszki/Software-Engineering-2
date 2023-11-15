package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stelle", schema = "test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stelle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

