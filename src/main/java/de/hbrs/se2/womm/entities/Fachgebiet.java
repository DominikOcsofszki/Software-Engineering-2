package de.hbrs.se2.womm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "fachgebiet")
public class Fachgebiet {
    @Id
    @Column(name = "fachgebiet_id")
    private Integer fachgebietId;

    @Column(name = "fachgebiet_fachgebiet", nullable = false, length = 50)
    private String fachgebietName;
}

