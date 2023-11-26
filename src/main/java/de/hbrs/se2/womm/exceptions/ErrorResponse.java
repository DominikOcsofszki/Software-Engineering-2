package de.hbrs.se2.womm.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {
    private int code;
    private String message;
}
