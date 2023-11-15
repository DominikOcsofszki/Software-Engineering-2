package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nutzer_tag",schema = "test")
@Getter
@Setter
@NoArgsConstructor
public class NutzerTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nutzer_tag_id")
    private Integer nutzerTagId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

}

