package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.ChatNew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatNewRepository extends JpaRepository<ChatNew, Long> {
    List<ChatNew> findChatNewByNutzerid1AndNutzerid2(Long nutzerid1, Long nutzerid2);
}