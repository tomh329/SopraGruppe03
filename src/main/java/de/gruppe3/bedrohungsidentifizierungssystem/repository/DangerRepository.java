package de.gruppe3.bedrohungsidentifizierungssystem.repository;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DangerRepository extends JpaRepository<Danger, Integer> {

    Danger findByDangerId(Integer dangerId);
}
