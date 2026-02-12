package assignment2;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.TaskListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ExerciseTask extends JPanel implements Task {
    private JTextField name;
    private JTextArea description;
    private JTextField taskType;
    private JCheckBox completed;
    private Color color;
    private TaskListener taskListener;

    public ExerciseTask(String name) {
        super(new BorderLayout());
        //this.name = new JTextField("New task",20);
        //this.textLabel = new JLabel();
        //this.textLabel.setVisible(false);
        JPanel center = new JPanel();
        //center.add(text);
        //center.add(textLabel);
        add(center);

        //TaskInputListener inputListener = new TaskInputListener(this, text, textLabel);
        //this.text.addKeyListener(inputListener);
        //this.textLabel.addMouseListener(inputListener);

        JButton remove = new JButton("Remove");
        add(remove,BorderLayout.EAST);
        //remove.addActionListener(inputListener);

        add(completed,BorderLayout.WEST);
        //completed.addItemListener(inputListener);

        setMaximumSize(new Dimension(1000,50));
        setBorder(new TitledBorder(getTaskType()));
    }

    public String getText() {
        return "a";
    }

    public String getTaskType() {
        //return this.taskType;
        return "a";
    }

    /**
     * Sets the task listener on which this task reports various events.
     * @param t the listener to use.
     */
    public void setTaskListener(TaskListener t) {}

    /**
     * @return the task listener currently used.
     */
    public TaskListener getTaskListener() {
        return this.taskListener;
    }

    public boolean isComplete() {
        //return this.isCompleted;
        return true;
    }

    /**
     * @return the graphical user interface component representing this task.
     */
    public Component getGuiComponent() {
        return this;
    }
}
