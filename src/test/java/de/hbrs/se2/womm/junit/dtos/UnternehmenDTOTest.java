package de.hbrs.se2.womm.junit.dtos;
import com.vaadin.flow.component.html.Image;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.views.extra.ASSETS;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UnternehmenDTOTest {
    @Test
    void placeholderOrImage() {
        UnternehmenDTO unternehmen = UnternehmenDTO.builder().build();
        Image expect = ASSETS.buildPlaceholder(50);
        Image actual = unternehmen.PlaceholderOrImage();
        assertEquals(expect.getSrc(),actual.getSrc());
        assertEquals(expect.getAlt(),actual.getAlt());
    }
}
