package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;
    @Autowired
    private ComponentRepository componentRepository;

    public Process saveProcess(Process process) {

        return processRepository.save(process);
    }



    public Process createProcess(String processName, int protectionLevel, int componentId){

        Process process = new Process(processName, protectionLevel);
        List<Component> compList = componentRepository.findAll();

        for(Component component : compList){

            if (componentId == component.getComponentId()) {

                process.addComponent(component);
            }
        }

        return processRepository.save(process);
    }


    public void deleteProcess(Process process){

        processRepository.delete(process);
    }


    public List<Process> findAllProcesses() {

        return processRepository.findAll();
    }
}
