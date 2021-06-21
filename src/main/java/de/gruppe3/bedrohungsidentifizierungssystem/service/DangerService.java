package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
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


    public List<Danger> findAllDangers() {

        return dangerRepository.findAll();
    }

}
