package de.hbrs.se2.womm.tentities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chat", schema = "test")
@Getter
@Setter
@Builder
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Chat() {

    }
}

