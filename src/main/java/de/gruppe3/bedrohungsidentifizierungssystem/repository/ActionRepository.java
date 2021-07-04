package de.gruppe3.bedrohungsidentifizierungssystem.repository;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Action;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    Action findByActionId(Integer actionId);
}


