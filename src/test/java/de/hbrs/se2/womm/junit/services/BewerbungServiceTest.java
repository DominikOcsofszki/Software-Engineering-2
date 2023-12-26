package de.hbrs.se2.womm.junit.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.entities.Bewerbung;
import de.hbrs.se2.womm.repositories.BewerbungRepository;
import de.hbrs.se2.womm.services.BewerbungService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BewerbungServiceTest {

    private BewerbungService bewerbungService;
    private BewerbungRepository bewerbungRepositoryMock;
    Bewerbung be;
    @BeforeEach
    void setUp() {
        bewerbungRepositoryMock = mock(BewerbungRepository.class);
        bewerbungService = new BewerbungService(bewerbungRepositoryMock);
        be = Bewerbung.builder()
                .bewerbungId(18)
                .bewerbungPdf(null)
                .bewerbungText("text")
                .stelle(null)
                .student(null)
                .bewerbungStatus("angenommen")
                .build();
        //bewerbungRepositoryMock.save(be);
    }

    @Test
    void testGetAll() {
        // Mocking the behavior of bewerbungRepository
        when(bewerbungRepositoryMock.findAll()).thenReturn(Arrays.asList(be));
        // Calling the method to be tested
        List<BewerbungDTO> bewerbungDTOList = bewerbungService.getAll();
        // Assertions
        assertNotNull(bewerbungDTOList);
        assertEquals(1,bewerbungDTOList.size());
    }

    @Test
    void testGetById() {
        Long bewerbungId = 1L;
        // Mocking the behavior of bewerbungRepository
        when(bewerbungRepositoryMock.findById(bewerbungId)).thenReturn(Optional.of(be));

        // Calling the method to be tested
        Optional<BewerbungDTO> bewerbungDTO = bewerbungService.getById(bewerbungId);

        // Assertions
        assertTrue(bewerbungDTO.isPresent());
        // Add more assertions based on your specific use case
    }

    @Test
    void testGetByNutzerId() {
        Long nutzerId = 1L;
        // Mocking the behavior of bewerbungRepository
        when(bewerbungRepositoryMock.findBewerbungByStudent_Nutzer_NutzerId(nutzerId))
                .thenReturn(Arrays.asList(be));

        // Calling the method to be tested
        List<BewerbungDTO> bewerbungDTOList = bewerbungService.getByNutzerId(nutzerId);

        // Assertions
        assertNotNull(bewerbungDTOList);
        // Add more assertions based on your specific use case
    }
}