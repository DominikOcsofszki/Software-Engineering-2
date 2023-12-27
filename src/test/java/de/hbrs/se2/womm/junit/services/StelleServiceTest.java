package de.hbrs.se2.womm.junit.services;

import static com.helger.commons.functional.Predicates.notNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.helger.commons.traits.IPrimitiveConverterTo;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.repositories.StelleRepository;
import de.hbrs.se2.womm.services.StelleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StelleServiceTest {

    private StelleRepository repo;

    private StelleService service;

    private List<StelleDTO> listDTO;
    private List<Stelle> listEntity;

    private StelleDTO stelleDTO;

    private Stelle stelle;

    @BeforeEach
    void setup() {
        repo = mock(StelleRepository.class);
        service = new StelleService(repo);
        listDTO = new ArrayList<>();
        listEntity = new ArrayList<>();
        stelleDTO = StelleDTO.builder()
                .stelleId(100L)
                .stelleTitel("titel")
                .stelleOrt("ort")
                .stelleBeschreibung("beschreibung")
                .stelleWebsite("url")
                .stelleUnternehmen(null)
                .build();

        stelle = Stelle.builder()
                .stelleId(100)
                .stelleTitel("titel")
                .stelleOrt("ort")
                .stelleBeschreibung("beschreibung")
                .stelleWebsite("url")
                .unternehmen(null)
                .build();

        when(repo.findAll()).thenReturn(listEntity);
    }

    @AfterEach
    void teardown() {
        repo = null;
        service = null;
        listDTO = null;
        listEntity = null;
        stelleDTO = null;
        stelle = null;
    }

    @Test
    void testGetByUnternehmenId() {
        //TODO
    }

    @Test
    void testgetByNutzerId() {
        //TODO
    }

    @Test
    void testGetAll() {

        List<StelleDTO> actual = service.getAll();
        assertNotNull(actual);
        assertEquals(listDTO.size(), actual.size());

        listEntity.add(stelle);
        listDTO.add(stelleDTO);

        actual = service.getAll();
        assertNotNull(actual);
        assertEquals(listDTO.size(), actual.size());

        assertTrue(listDTO.get(0).equals(actual.get(0)));

    }

    @Test
    void testGetAllByFilter() {

    }

    @Test
    void testGetById() {
        when(repo.findById(any(Long.class)))
                .thenAnswer(
                        i -> {
                            List<Stelle> curr = listEntity
                                    .stream()
                                    .filter(p -> p.getStelleId().toString().equals(i.getArgument(0).toString()))
                                    .toList();
                            return curr.size() == 0 ? Optional.empty() : Optional.of(curr.get(0));
                        }
                );

        Optional<StelleDTO> actual = service.getById(100L);
        assertTrue(actual.isEmpty());

        listEntity.add(stelle);

        actual = service.getById(100L);
        assertFalse(actual.isEmpty());
        assertEquals(stelleDTO.getStelleId(), actual.get().getStelleId());

        Stelle stelle_2 = Stelle.builder()
                .stelleId(999)
                .stelleTitel("titel")
                .stelleOrt("ort")
                .stelleBeschreibung("beschreibung")
                .stelleWebsite("url")
                .unternehmen(null)
                .build();

        listEntity.add(stelle_2);

        actual = service.getById(999L);
        assertFalse(actual.isEmpty());
        assertEquals((long) stelle_2.getStelleId(), actual.get().getStelleId());
    }

    @Test
    void testSaveStelle() {
        when(repo.save(any(Stelle.class))).thenAnswer(i -> {
            Stelle input = (Stelle) i.getArgument(0);
            listEntity.add(input);
            return input;
        });

        assertEquals(0, listEntity.size());

        service.saveStelle(stelleDTO);
        assertEquals(1, listEntity.size());

        stelle = listEntity.get(0);
        assertEquals(stelleDTO.getStelleId(), (long) stelle.getStelleId());
        assertEquals(stelleDTO.getStelleTitel(), stelle.getStelleTitel());
        assertEquals(stelleDTO.getStelleUnternehmen(), stelle.getUnternehmen());
        assertEquals(stelleDTO.getStelleOrt(), stelle.getStelleOrt());
        assertEquals(stelleDTO.getStelleWebsite(), stelle.getStelleWebsite());
        assertEquals(stelleDTO.getStelleBeschreibung(), stelle.getStelleBeschreibung());

    }
}
