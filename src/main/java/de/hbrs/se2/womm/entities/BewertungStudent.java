package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bewertung_student",schema = "se")
@Getter
@Setter
@Builder
public class BewertungStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bewertung_student_id")
    private Integer bewertungStudentId;

    @Column(name = "bewertung_student_wertung")
    private Integer bewertungStudentWertung;

    @Column(name = "bewertung_student_text", columnDefinition = "text")
    private String bewertungStudentText;

    @ManyToOne
    @JoinColumn(name = "unternehmen_id")
    private Unternehmen unternehmen;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public BewertungStudent() {

    }
}

