package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bewerbung")
public class Bewerbung {
    @Id
    @Column(name = "bewerbung_id")
    private Integer bewerbungId;

    @ManyToOne
    @JoinColumn(name = "nutzer_id", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzer;

    @ManyToOne
    @JoinColumn(name = "stelle_id", referencedColumnName = "stelle_id", nullable = false)
    private Stelle stelle;
}

