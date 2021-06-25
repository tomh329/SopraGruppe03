package de.gruppe3.bedrohungsidentifizierungssystem.repository;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {

    Component findByComponentId(Integer componentId);
}
