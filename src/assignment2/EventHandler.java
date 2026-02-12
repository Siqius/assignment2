package assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
    private final GUI gui;
    public void actionPerformed(ActionEvent event) {
        switch(event.getActionCommand()) {
            case "addTask" -> {
                gui.displayError("hello");
            }
            default -> {
                gui.displayError("Event not bound to an action.");
            }
        };
    }

    EventHandler(GUI gui) {
        this.gui = gui;
    }
}
