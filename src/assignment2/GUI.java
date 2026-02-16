package assignment2;

import se.his.it401g.todo.Task;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUI {
    private final JFrame window;
    private final JPanel taskPanel;
    private final JButton addHomeTask;
    private final JButton addStudyTask;
    private final JButton addExerciseTask;
    private final EventHandler eventHandler;
    private final JPanel errorDisplay;
    private List<Task> tasks;
    public GUI() {
        eventHandler = new EventHandler(this);
        GridBagConstraints c = new GridBagConstraints();

        window = new JFrame("ToDo");
        window.setResizable(false);
        window.getContentPane().setLayout(new GridBagLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(800, 800));
        window.setLocation(500, 200);
        window.getContentPane().setBackground(new Color(40, 40, 40));

        JPanel headerPanel = new JPanel();
        headerPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        headerPanel.setBackground(new Color(40, 40, 40));
        headerPanel.setVisible(true);

        JComboBox<String> sortSelector = new JComboBox<String>();
        sortSelector.addItem("Alphabetical");
        sortSelector.addItem("Task type");
        sortSelector.addItem("Completed");

        sortSelector.setVisible(true);

        ButtonGroup sortOrder = new ButtonGroup();
        JRadioButton ascending = new JRadioButton("Ascending");
        JRadioButton descending = new JRadioButton("Descending");
        ascending.setVisible(true);
        descending.setVisible(true);
        ascending.setSelected(true);
        sortOrder.add(ascending);
        sortOrder.add(descending);

        headerPanel.add(sortSelector);
        headerPanel.add(ascending);
        headerPanel.add(descending);

        JPanel addTasksPanel  = new JPanel();
        addTasksPanel.setLayout(new BoxLayout(addTasksPanel, BoxLayout.X_AXIS));

        addHomeTask = new JButton();
        addHomeTask.setText("Add home task");
        addHomeTask.setBackground(new Color(255,255,255));
        addHomeTask.setActionCommand("addHomeTask");
        addHomeTask.addActionListener(eventHandler);

        addStudyTask = new JButton();
        addStudyTask.setText("Add study task");
        addStudyTask.setBackground(new Color(255,255,255));
        addStudyTask.setActionCommand("addStudyTask");
        addStudyTask.addActionListener(eventHandler);

        addExerciseTask = new  JButton();
        addExerciseTask.setText("Add exercise task");
        addExerciseTask.setBackground(new Color(255,255,255));
        addExerciseTask.setActionCommand("addExerciseTask");
        addExerciseTask.addActionListener(eventHandler);

        taskPanel = new JPanel();
        taskPanel.setBackground(new Color(151, 76, 76));
        taskPanel.setVisible(true);

        errorDisplay = new JPanel();
        errorDisplay.setAlignmentY(Component.CENTER_ALIGNMENT);
        errorDisplay.setBackground(Color.RED);
        errorDisplay.setVisible(false);

        JLabel errorDisplayText = new JLabel("none", JLabel.CENTER);
        errorDisplayText.setFont(new Font("Arial", Font.PLAIN, 24));
        errorDisplayText.setForeground(Color.BLACK);

        errorDisplay.add(errorDisplayText);

        JPanel taskPanel = new JPanel(new FlowLayout());

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.NORTH;

        c.gridx = 0;
        c.gridy = 0;
        window.add(headerPanel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.8;
        window.add(taskPanel, c);
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0.1;
        window.add(addTasksPanel, c);
        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0.05;
        window.add(errorDisplay, c);
        window.setVisible(true);

    }


    public void displayError(String error) {
        System.out.println("Error: " + error);
        errorDisplay.setVisible(true);
        ((JLabel)errorDisplay.getComponents()[0]).setText(error); //Cast component to JLabel to change text
    }
}
