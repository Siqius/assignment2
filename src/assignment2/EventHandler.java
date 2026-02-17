package assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
    private final GUI gui;
    private final int taskID;
    public void actionPerformed(ActionEvent event) {
        switch(event.getActionCommand()) {
            case "addHomeTask" -> {
                gui.createTask("home task");
            }
            case "addStudyTask" -> {
                gui.createTask("study task");
            }
            case "addExerciseTask" -> {
                gui.displayError("hello exercise!");
            }
            default -> {
                gui.displayError("Event not bound to an action.");
            }
        };
    }

    EventHandler(GUI gui) {
        this.gui = gui;
        this.taskID = -1;
    }
    EventHandler(GUI gui, int taskID) {
        this.gui = gui;
        this.taskID = taskID;
    }
}
