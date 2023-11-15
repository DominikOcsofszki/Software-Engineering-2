package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stelle_tag",schema = "test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StelleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stelle_tag_id")
    private Integer stelleTagId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "stelle_id")
    private Stelle stelle;

}

