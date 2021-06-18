package de.gruppe3.bedrohungsidentifizierungssystem.repository;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
