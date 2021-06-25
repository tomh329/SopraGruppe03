package de.gruppe3.bedrohungsidentifizierungssystem.service;

import de.gruppe3.bedrohungsidentifizierungssystem.entity.Component;
import de.gruppe3.bedrohungsidentifizierungssystem.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepository componentRepository;

    public Component saveComponent(Component component) {

        return componentRepository.save(component);
    }

    public List<Component> findAllComponents() {

        return componentRepository.findAll();
    }

    public Component createComponent(String componentName, int priority, String lastAttack, int occurrence) {

        Component component = new Component(componentName, priority, lastAttack, occurrence);
        return componentRepository.save(component);
    }

    public void deleteComponent(Component component) {

        componentRepository.delete(component);
    }
}
