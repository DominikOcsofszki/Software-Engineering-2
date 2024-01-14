package de.hbrs.se2.womm.junit.dtos;
import com.vaadin.flow.component.html.Image;
import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.junit.services.ImageServiceTest;
import de.hbrs.se2.womm.views.extra.ASSETS;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class StudentDTOTest {
    StudentDTO student;
    @BeforeEach
    void setup() {
        student = StudentDTO.builder()
                .studentId(100L)
                .studentBio("bio")
                .studentGeburtstag("1997-10-12")
                .studentName("Name")
                .studentSemester(18)
                .studentSpezialisierung("spezial")
                .studentVorname("Vorname")
                .studentBenachrichtigung(false)
                .build();
    }
    @AfterEach
    void teardown() {
        student = null;
    }
    @Test
    void TestPlaceholderOrImage_NutzerNull() {
        student.setNutzer(null);
        Image expect = ASSETS.buildPlaceholder(50,50);
        Image actual = student.PlaceholderOrImage();
        assertEquals(expect.getSrc(),actual.getSrc());
        assertEquals(expect.getAlt(),actual.getAlt());
    }
    @Test
    void TestPlaceholderOrImage_NutzerProfilePictureIsNull() {
        student.setNutzer(
                NutzerDTO.builder().nutzerProfilbild(null).build()
        );
        Image expect = ASSETS.buildPlaceholder(50,50);
        Image actual = student.PlaceholderOrImage();
        assertEquals(expect.getSrc(),actual.getSrc());
        assertEquals(expect.getAlt(),actual.getAlt());
    }
    @Test
    void TestPlaceholderOrImage_NutzerWithRandomPicture(){
        byte[] image = ImageServiceTest.getRandomByteArray();
        student.setNutzer(
                NutzerDTO.builder().nutzerProfilbild(image).build()
        );
        Image expect = new Image("data:image/png;base64," + new String(image), "getImage");
        Image actual = student.PlaceholderOrImage();
        assertEquals(expect.getSrc(),actual.getSrc());
        assertEquals(expect.getAlt(),actual.getAlt());
    }
}
