package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "interessen")
public class Interessen {
    @Id
    @Column(name = "interessen_id")
    private Integer interessenId;

    @ManyToOne
    @JoinColumn(name = "nutzer_id", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzer;

    @ManyToOne
    @JoinColumn(name = "fachgebiet_id", referencedColumnName = "fachgebiet_id", nullable = false)
    private Fachgebiet fachgebiet;
}

