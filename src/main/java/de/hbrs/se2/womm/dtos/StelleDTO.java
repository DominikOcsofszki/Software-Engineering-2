package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Unternehmen;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@Getter
public class StelleDTO extends AbstractDTO{
    private Long stelleId;
    private String stelleTitel;
    private String stelleOrt;
    private String stelleBeschreibung;
    private String stelleWebsite;
    private Unternehmen stelleUnternehmen;
}
