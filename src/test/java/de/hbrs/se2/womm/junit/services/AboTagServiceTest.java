package de.hbrs.se2.womm.junit.services;

import de.hbrs.se2.womm.dtos.AboTagDTO;
import de.hbrs.se2.womm.entities.AboTag;
import de.hbrs.se2.womm.entities.Student;
import de.hbrs.se2.womm.mapper.AboTagMapper;
import de.hbrs.se2.womm.repositories.AboTagRepository;
import de.hbrs.se2.womm.services.AboTagService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AboTagServiceTest {
    @Mock
    private AboTagRepository aboTagRepository;

    @Mock
    private AboTagMapper aboTagMapper;

    @InjectMocks
    private AboTagService aboTagService;

    private List<AboTag> aboTagEntityList;
    private AboTagDTO aboTagDTO;

    private AboTag aboTag;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        aboTagEntityList = new ArrayList<>();
        aboTagDTO = AboTagDTO.builder()
                .aboId(1)
                .aboBenachrichtigung(true)
                .student(Student.builder().build())
                .build();
    }

    @AfterEach
    void teardown() {
        aboTagRepository = null;
        aboTagMapper = null;
        aboTagService = null;
        aboTagEntityList = null;
        aboTagDTO = null;
        aboTag = null;
    }

    @Test
    void testGetById() {
        aboTag = new AboTag(); // Creating a new AboTag instance

        when(aboTagRepository.findById(any(Long.class))).thenReturn(Optional.of(aboTag));
        when(aboTagMapper.aboTagToDto(aboTag)).thenReturn(aboTagDTO);

        AboTagDTO result = aboTagService.getById(1L);

        assertNotNull(result);
    }

    @Test
    void testGetByNutzerId() {
        when(aboTagRepository.findAboTagByStudent_Nutzer_NutzerId(any(Long.class))).thenReturn(aboTagEntityList);
        when(aboTagMapper.aboTagToDto(aboTag)).thenReturn(aboTagDTO);

        List<AboTagDTO> result = aboTagService.getByNutzerId(1L);

        assertNotNull(result);

    }

    @Test
    void testSaveAboTag() {
        when(aboTagRepository.save(any(AboTag.class))).thenAnswer(
                invocation -> {
                    AboTag input = invocation.getArgument(0);
                    aboTagEntityList.add(input);
                    return input;
                }
        );

        assertEquals(0, aboTagEntityList.size());

        AboTagDTO aboTagDTO = AboTagDTO.builder().aboId(1).aboBenachrichtigung(true).build();

        aboTagService.saveAboTag(aboTagDTO);

        assertEquals(1, aboTagEntityList.size());
    }

}
