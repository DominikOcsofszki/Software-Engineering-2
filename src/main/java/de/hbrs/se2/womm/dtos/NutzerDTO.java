package de.hbrs.se2.womm.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NutzerDTO extends AbstractDTO {
    @JsonProperty("nutzerId")
    private Long nutzerId;

    @JsonProperty("nutzerName")
    private String benutzername;

    @JsonProperty("nutzerPasswort")
    private String passwort;

    @JsonProperty("nutzerMail")
    private String email;

    @JsonProperty("nutzerAktiv")
    private boolean aktiv;

    @JsonProperty("nutzerOrt")
    private String ort;

    @JsonProperty("nutzerProfilbild")
    private byte[] profilbild;

    @JsonProperty("rolle")
    private String rolle;
}
