package de.hbrs.se2.womm.controller;

import de.hbrs.se2.womm.dtos.AbstractDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AboController extends AbstractControllerWomm{
    @Override
    public ResponseEntity<List<? extends AbstractDTO>> getDTObyPrimaryKeyIfNegativeAll(long primaryKey) {
        return null;
    }
}
