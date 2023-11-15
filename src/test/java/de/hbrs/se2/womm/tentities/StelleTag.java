package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stelle_tag",schema = "test")
@Getter
@Setter
@Builder
public class StelleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stelle_tag_id")
    private Integer stelleTagId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "stelle_id")
    private Stelle stelle;

    public StelleTag() {

    }
}

