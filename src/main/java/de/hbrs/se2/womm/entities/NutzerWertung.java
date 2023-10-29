package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "v_nutzer_wertung")
public class NutzerWertung {
    @Id
    @Column(name = "nutzer_id")
    private Integer nutzerId;

    @Column(name = "avg")
    private Double durchschnittlicheBewertung;
}

