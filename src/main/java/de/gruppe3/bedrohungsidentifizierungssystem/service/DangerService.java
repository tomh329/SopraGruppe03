package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Danger;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Requirement;
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


    public Danger createDanger(String dangerName, int dangerLevel){
        Danger danger = new Danger(dangerName, dangerLevel);
        return dangerRepository.save(danger);
    }

    public void updateDanger(int dangerId, String dangerName, int dangerLevel) {

        List<Danger> dangerList = findAllDangers();

        for(Danger danger : dangerList){
            if(dangerId == danger.getDangerId()){
                danger.setDangerName(dangerName);
                danger.setDangerLevel(dangerLevel);
                dangerRepository.save(danger);
            }
        }
    }

    public void deleteDanger(Danger danger){
        dangerRepository.delete(danger);
    }

    public boolean deleteDanger(int dangerId){

        List<Danger> dangerList = dangerRepository.findAll();

        for(Danger danger : dangerList){
            if(dangerId == danger.getDangerId()){
                dangerRepository.delete(danger);
                return true;
            }
        }
        return false;
    }


    public List<Danger> findAllDangers() {

        return dangerRepository.findAll();
    }


    public Danger findProcessWithId(Integer dangerId) {
        return dangerRepository.findByDangerId(dangerId);
    }

}
