package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "student", schema = "se")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_vorname", nullable = false)
    private String studentVorname;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_geburtstag", nullable = false)
    private Date studentGeburtstag;

    @Column(name = "student_benachrichtigung", nullable = false)
    private Boolean studentBenachrichtigung;

    @Column(name = "student_bio")
    private String studentBio;

    @Column(name = "student_spezialisierung")
    private String studentSpezialisierung;

    @Column(name = "student_semester")
    private Integer studentSemester;

    @OneToOne
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

}

