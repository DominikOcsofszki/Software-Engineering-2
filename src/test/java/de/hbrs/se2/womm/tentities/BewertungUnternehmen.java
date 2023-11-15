package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bewertung_unternehmen",schema = "test")
@Getter
@Setter
@NoArgsConstructor
public class BewertungUnternehmen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bewertung_unternehmen_id")
    private Integer bewertungUnternehmenId;

    @Column(name = "bewertung_unternehmen_wertung")
    private Integer bewertungUnternehmenWertung;

    @Column(name = "bewertung_unternehmen_text", columnDefinition = "text")
    private String bewertungUnternehmenText;

    @ManyToOne
    @JoinColumn(name = "unternehmen_id")
    private Unternehmen unternehmen;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}

