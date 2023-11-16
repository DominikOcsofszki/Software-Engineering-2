package de.hbrs.se2.womm.entities;

import de.hbrs.se2.womm.config.CONFIG;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nutzer_tag",schema = CONFIG.DB.USING)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NutzerTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nutzer_tag_id")
    private Integer nutzerTagId;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "nutzer_id")
    private Nutzer nutzer;

}

