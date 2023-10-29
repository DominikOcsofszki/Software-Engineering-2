package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "se", name = "abo")
public class Abo {
    @Id
    @Column(name = "abo_id")
    private Integer aboId;

    @ManyToOne
    @JoinColumn(name = "nutzer_id_profil", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzerProfil;

    @ManyToOne
    @JoinColumn(name = "nutzer_id_abonnent", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzerAbonnent;

}
