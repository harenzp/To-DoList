import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends Panel {

    // Declare GUI components
    private Label titleLabel;
    private TextField taskTextField;
    private Button addButton;
    private Button removeButton;
    private List taskList;

    // Constructor
    public ToDoListApp() {
        // Set window properties
        setSize(250, 400);
        setLayout(null);

        // Create and add components
        titleLabel = new Label("To-Do List App with Calculator");
        titleLabel.setBounds(60, 50, 200, 20);
        add(titleLabel);

        taskTextField = new TextField();
        taskTextField.setBounds(50, 100, 200, 20);
        add(taskTextField);

        addButton = new Button("Add Task");
        addButton.setBounds(100, 130, 100, 20);
        addButton.addActionListener(new AddTaskActionListener());
        add(addButton);

        removeButton = new Button("Remove Task");
        removeButton.setBounds(100, 320, 100, 20);
        removeButton.addActionListener(new RemoveTaskActionListener());
        add(removeButton);

        taskList = new List();
        taskList.setBounds(50, 180, 200, 120);
        add(taskList);

        // Show the window
        setVisible(true);
    }

    // Add Task Action Listener
    class AddTaskActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String task = taskTextField.getText();
            taskList.add(task);
            taskTextField.setText("");
        }
    }

    // Remove Task Action Listener
    class RemoveTaskActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskList.remove(selectedIndex);
            }
        }
    }

}
