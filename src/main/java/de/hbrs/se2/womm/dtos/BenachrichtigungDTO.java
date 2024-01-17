package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BenachrichtigungDTO implements AbstractDTO {
    private Long id;
    private String nachricht;
    private boolean gelesen;
    private Date date;
    private NutzerDTO nutzer;
}
