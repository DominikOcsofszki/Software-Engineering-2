package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chat", schema = "test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chat_id")
    private Integer chatId;

    @Lob
    @Column(name = "chat_verlauf", columnDefinition = "bytea")
    private byte[] chatVerlauf;

    @ManyToOne
    @JoinColumn(name = "unternehmen_id")
    private Unternehmen unternehmen;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}

