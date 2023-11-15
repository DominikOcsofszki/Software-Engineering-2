package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abo_tag",schema = "test")
@Getter
@Setter
@NoArgsConstructor
public class AboTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "abo_id")
    private Integer aboId;

    @Column(name = "abo_benachrichtigung")
    private Boolean aboBenachrichtigung;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

}

