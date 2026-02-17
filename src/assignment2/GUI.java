package assignment2;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUI {
    private final JFrame window;
    private final JPanel headerPanel;
    private final JPanel addTaskPanel;
    private final JPanel taskPanel;
    private final EventHandler eventHandler;
    private final JPanel errorDisplay;
    private List<HomeTask> tasks;
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

        headerPanel = getHeaderPanel();

        addTaskPanel = getAddTaskPanel();

        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBackground(new Color(151, 76, 76));
        taskPanel.setVisible(true);

        errorDisplay = getErrorDisplayPanel();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.05;
        c.anchor = GridBagConstraints.NORTH;

        c.gridx = 0;
        c.gridy = 0;
        window.add(headerPanel, c);
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0.1;
        window.add(addTaskPanel, c);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.8;
        window.add(taskPanel, c);
        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0.05;
        window.add(errorDisplay, c);
        window.setVisible(true);

    }

    public void createTask(String taskType) {
        switch(taskType) {
            case("home task") -> {
                HomeTask homeTask = new HomeTask();
                taskPanel.add(homeTask, BorderLayout.NORTH);
                taskPanel.revalidate();
                taskPanel.repaint();
            }
            case("study task") -> {
                StudyTask studyTask = new StudyTask();
                taskPanel.add(studyTask, BorderLayout.NORTH);
                taskPanel.revalidate();
                taskPanel.repaint();
            }
            case("exercise task") -> {

            }
        }
    }

    private JPanel getErrorDisplayPanel() {
        JPanel errorDisplay = new JPanel();
        errorDisplay.setAlignmentY(Component.CENTER_ALIGNMENT);
        errorDisplay.setBackground(Color.RED);
        errorDisplay.setVisible(false);

        JLabel errorDisplayText = new JLabel("none", JLabel.CENTER);
        errorDisplayText.setFont(new Font("Arial", Font.PLAIN, 24));
        errorDisplayText.setForeground(Color.BLACK);

        errorDisplay.add(errorDisplayText);

        return errorDisplay;
    }

    private JPanel getAddTaskPanel() {
        JPanel addTaskPanel  = new JPanel();
        addTaskPanel.setLayout(new BoxLayout(addTaskPanel, BoxLayout.X_AXIS));

        JButton addHomeTask = new JButton();
        addHomeTask.setText("Add home task");
        addHomeTask.setBackground(new Color(255,255,255));
        addHomeTask.setActionCommand("addHomeTask");
        addHomeTask.addActionListener(eventHandler);

        JButton addStudyTask = new JButton();
        addStudyTask.setText("Add study task");
        addStudyTask.setBackground(new Color(255,255,255));
        addStudyTask.setActionCommand("addStudyTask");
        addStudyTask.addActionListener(eventHandler);

        JButton addExerciseTask = new  JButton();
        addExerciseTask.setText("Add exercise task");
        addExerciseTask.setBackground(new Color(255,255,255));
        addExerciseTask.setActionCommand("addExerciseTask");
        addExerciseTask.addActionListener(eventHandler);

        addTaskPanel.add(addHomeTask);
        addTaskPanel.add(addStudyTask);
        addTaskPanel.add(addExerciseTask);

        return addTaskPanel;
    }

    private JPanel getHeaderPanel() {
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
        return headerPanel;
    }

    public void hideError() {
        errorDisplay.setVisible(false);
    }

    public void displayError(String error) {
        System.out.println("Error: " + error);
        errorDisplay.setVisible(true);
        ((JLabel)errorDisplay.getComponents()[0]).setText(error); //Cast component to JLabel to change text
    }
}
