package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ChatDTO implements Serializable {
    private Integer chatId;

    private String[] chatVerlauf;

    private StudentDTO student;

    private UnternehmenDTO unternehmen;
}
