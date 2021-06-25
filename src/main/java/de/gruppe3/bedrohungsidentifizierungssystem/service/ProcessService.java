package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Process;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ProcessService {

    @Autowired
    static Scanner sc = new Scanner(System.in);

    @Autowired
    private ProcessRepository processRepository;


    public Process saveProcess(Process process) {

        return processRepository.save(process);
    }

    public Process createProcess(String processName, int protectionLevel) {
        Process process = new Process(processName, protectionLevel);
        return processRepository.save(process);
    }

    public void deleteProcess(Process process) {

        processRepository.delete(process);
    }

    public List<Process> findAllProcesses() {

        return processRepository.findAll();
    }
}
