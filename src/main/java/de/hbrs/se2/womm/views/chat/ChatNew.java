package de.hbrs.se2.womm.views.chat;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "chat_new")
public class ChatNew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "primarykey")
    private Long primarykey;

    @Column(name = "nutzerid1")
    private Long nutzerid1;

    @Column(name = "nutzerid2")
    private Long nutzerid2;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "msg")
    private String msg;


}
