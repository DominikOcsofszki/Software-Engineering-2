package de.hbrs.se2.womm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "nutzerid1")
    private Long nutzerid1;

    @Column(name = "nutzerid2")
    private Long nutzerid2;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "msg")
    private String msg;

    public Long getNutzerid1() {
        return this.nutzerid1;
    }

    public void setNutzerid1(Long nutzerid1) {
        this.nutzerid1 = nutzerid1;
    }

    public Long getNutzerid2() {
        return this.nutzerid2;
    }

    public void setNutzerid2(Long nutzerid2) {
        this.nutzerid2 = nutzerid2;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
