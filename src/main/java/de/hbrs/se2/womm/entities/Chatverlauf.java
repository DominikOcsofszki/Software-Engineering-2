package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "se", name = "chatverlauf")
public class Chatverlauf {
    @Id
    @Column(name = "chatverlauf_id")
    private Integer chatverlaufId;

    @Lob
    @Column(name = "chatverlauf_verlauf", nullable = false)
    private byte[] chatverlaufVerlauf;

    @Temporal(TemporalType.DATE)
    @Column(name = "chatverlauf_erstellungsdatum", nullable = false)
    private java.util.Date chatverlaufErstellungsdatum;

    @ManyToOne
    @JoinColumn(name = "nutzer_teilnehmer_eins", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzerTeilnehmerEins;

    @ManyToOne
    @JoinColumn(name = "nutzer_teilnehmer_zwei", referencedColumnName = "nutzer_id", nullable = false)
    private Nutzer nutzerTeilnehmerZwei;
}
