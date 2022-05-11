package edu.vassar.cmpu203.plannerapp.persistence;

import java.util.List;

import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Task;

public interface IPersistenceFacade {
    interface Listener {
        void writeToFile(String fileName, String content);
        String readFromFile(String fileName);
    }
}
