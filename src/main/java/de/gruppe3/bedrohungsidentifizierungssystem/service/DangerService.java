package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Severity;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.DangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class DangerService {

    @Autowired
    static Scanner sc = new Scanner(System.in);

    @Autowired
    private DangerRepository dangerRepository;


    public Danger saveDanger(Danger danger) {

        return dangerRepository.save(danger);
    }


    public Danger createDanger(String dangerName, Enum<Severity> dangerLevel) {
        Danger danger = new Danger(dangerName, dangerLevel);
        return dangerRepository.save(danger);
    }

    public void deleteDanger(Danger danger) {
        dangerRepository.delete(danger);
    }

    public List<Danger> findAllDangers() {
        return dangerRepository.findAll();
    }

}
