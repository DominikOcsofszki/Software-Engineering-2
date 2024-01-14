package de.hbrs.se2.womm.dtos;
import de.hbrs.se2.womm.entities.NutzerLogin;
import lombok.Data;
import java.util.Date;
@Data
public class BenachrichtigungDTO implements AbstractDTO {
    private Long id;
    private String nachricht;
    private boolean gelesen;
    private Date date;
    private NutzerDTO nutzerDTO;
}
