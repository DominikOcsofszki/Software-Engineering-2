package de.hbrs.se2.womm.entities;

import de.hbrs.se2.womm.config.CONFIG;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "unternehmen",schema = CONFIG.DB.USING)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Unternehmen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

