package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bewerbung")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bewerbung {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bewerbung_id")
    private Integer bewerbungId;

    @Lob
    @Column(name = "bewerbung_pdf", columnDefinition = "bytea")
    private byte[] bewerbungPdf;

    @Column(name = "bewerbung_text", columnDefinition = "text")
    private String bewerbungText;

    @ManyToOne
    @JoinColumn(name = "stelle_id")
    private Stelle stelle;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
