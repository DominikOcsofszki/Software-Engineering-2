package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.dtos.AbstractDTO;

import java.util.List;

public interface IgetAllService {
    List<? extends AbstractDTO> getAllService();
}
