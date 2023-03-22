import java.awt.*;
import java.awt.event.*;
public class Calculator extends Panel implements ActionListener {
    private Label resultLabel;
    private Button addButton, subtractButton, multiplyButton, divideButton, clearButton, computeButton;
    private Button[] digitButtons = new Button[10];
    private String currentNumber = "";
    private char currentOperation;
    private int previousValue;

    public Calculator() {
        setLayout(new BorderLayout());

        // Create components
        resultLabel = new Label("0", Label.RIGHT);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(resultLabel, BorderLayout.NORTH);

        Panel buttonPanel = new Panel(new GridLayout(4, 4));
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new Button("" + i);
            digitButtons[i].addActionListener(this);
            buttonPanel.add(digitButtons[i]);
        }
        addButton = new Button("+");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        subtractButton = new Button("-");
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);
        multiplyButton = new Button("*");
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton);
        divideButton = new Button("/");
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton);
        clearButton = new Button("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        computeButton = new Button("=");
        computeButton.addActionListener(this);
        buttonPanel.add(computeButton);

        add(buttonPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();

        if (buttonText.matches("[0-9]")) {
            currentNumber += buttonText;
            resultLabel.setText(currentNumber);
        } else if (buttonText.equals("+")) {
            currentOperation = '+';
            previousValue = Integer.parseInt(currentNumber);
            currentNumber = "";
        } else if (buttonText.equals("-")) {
            currentOperation = '-';
            previousValue = Integer.parseInt(currentNumber);
            currentNumber = "";
        } else if (buttonText.equals("*")) {
            currentOperation = '*';
            previousValue = Integer.parseInt(currentNumber);
            currentNumber = "";
        } else if (buttonText.equals("/")) {
            currentOperation = '/';
            previousValue = Integer.parseInt(currentNumber);
            currentNumber = "";
        } else if (buttonText.equals("C")) {
            currentNumber = "";
            resultLabel.setText("0");
        } else if (buttonText.equals("=")) {
            int currentValue = Integer.parseInt(currentNumber);
            int result = 0;

            switch (currentOperation) {
                case '+':
                    result = previousValue + currentValue;
                    break;
                case '-':
                    result = previousValue - currentValue;
                    break;
                case '*':
                    result = previousValue * currentValue;
                    break;
                case '/':
                    result = previousValue / currentValue;
                    break;
            }

            currentNumber = Integer.toString(result);
            resultLabel.setText(currentNumber);
        }
    }
}
