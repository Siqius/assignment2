package assignment2;

import se.his.it401g.todo.Task;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private final JFrame window;
    private final JPanel taskPanel;
    private final JButton addTask;
    private EventHandler eventHandler;
    private JPanel errorDisplay;
    private Task[] tasks;
    public GUI() {
        eventHandler = new EventHandler(this);

        window = new JFrame("ToDo");
        window.setLayout(new BoxLayout(window, BoxLayout.PAGE_AXIS));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(800, 800));
        window.setLocation(500, 200);
        window.getContentPane().setBackground(new Color(40, 40, 40));
        window.setVisible(true);

        addTask = new JButton();
        addTask.setSize(200,20);
        addTask.setVisible(true);
        addTask.setText("Hello World!");
        addTask.setBackground(new Color(255,255,255));
        addTask.setActionCommand("addTask");
        addTask.addActionListener(eventHandler);

        taskPanel = new JPanel();
        taskPanel.setVisible(true);

        errorDisplay = new JPanel();
        errorDisplay.setSize(800, 300);
        errorDisplay.setBackground(Color.RED);
        errorDisplay.setVisible(false);

        JLabel errorDisplayText = new JLabel("none", JLabel.CENTER);
        errorDisplayText.setForeground(Color.BLACK);

        errorDisplay.add(errorDisplayText);



        window.add(addTask);
        window.add(taskPanel);
        window.add(errorDisplay);

        JPanel taskPanel = new JPanel(new FlowLayout());
    }


    public void displayError(String error) {
        errorDisplay.setVisible(true);
        ((JLabel)errorDisplay.getComponents()[0]).setText(error); //Cast component to JLabel to change text
    }
}
