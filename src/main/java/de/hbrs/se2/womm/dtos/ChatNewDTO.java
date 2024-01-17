package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ChatNewDTO {
    private Long nutzerid1;
    private Long nutzerid2;
    private LocalDate date;
    private String msg;

}
