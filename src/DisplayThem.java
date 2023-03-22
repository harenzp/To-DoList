import java.awt.*;
import java.awt.event.*;

public class DisplayThem extends Frame {
    private Calculator calculator;
    private ToDoListApp toDoListApp;

    public DisplayThem() {
        setTitle("Calculator and To-Do List");
        setLayout(new GridLayout(2, 1));

        toDoListApp = new ToDoListApp();
        add(toDoListApp);

        calculator = new Calculator();
        add(calculator);

        setSize(300, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new DisplayThem();
    }
}
