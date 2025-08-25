import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SimpleCalculator extends JFrame {

	private JPanel backPanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;

	private JTextField op1 = new JTextField();
	private JTextField op2 = new JTextField();

	private JLabel op1Label;
	private JLabel op2Label;
	private JLabel sumLabel;
	private JLabel resultLabel;

	private JButton addButton;
	private JButton subtractButton;
	private JButton clearButton;

	public SimpleCalculator()
	{
		super("Simple Calculator");
		createForm();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void createLabels()
	{
		op1Label = new JLabel("The value");
		op2Label = new JLabel("added to ");
		sumLabel = new JLabel("gives: ");
		resultLabel = new JLabel("");
	}

	private void createButtons()
	{
		addButton = new JButton("Add");
		addButton.addActionListener((ActionEvent e)-> computingButtonClicked(true));
		subtractButton = new JButton("Subtract");
		subtractButton.addActionListener((ActionEvent e) ->computingButtonClicked(false));
		clearButton = new JButton("Clear");
		clearButton.addActionListener((ActionEvent e) -> clearButtonClicked());
	}

	private void computingButtonClicked(boolean isAdded)
	{
		String resultMessage;
		try{
			double x = Double.parseDouble(op1.getText());
			double y = Double.parseDouble(op2.getText());
			if (isAdded)
				resultMessage = "" + (x + y);
			else
				resultMessage = "" + (x - y);
		}catch (NumberFormatException ex){
			resultMessage = "Invalid number";
		}

		resultLabel.setText(resultMessage);
	}

	private void clearButtonClicked()
	{
		op1.setText("");
		op2.setText("");
		resultLabel.setText("");
	}

	private void createInputPanel()
	{
		GridLayout panelLayout = new GridLayout(3, 2, 8, 8);
		inputPanel = new JPanel(panelLayout);

		createLabels();
		inputPanel.add(op1Label);
		inputPanel.add(op1);
		inputPanel.add(op2Label);
		inputPanel.add(op2);
		inputPanel.add(sumLabel);
		inputPanel.add(resultLabel);
	}

	private void createButtonPanel()
	{
		buttonPanel = new JPanel();

		createButtons();
		buttonPanel.add(addButton);
		buttonPanel.add(subtractButton);
		buttonPanel.add(clearButton);
	}

	private void createBackPanel()
	{
		backPanel = new JPanel(new BorderLayout());
		backPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		backPanel.add(inputPanel, BorderLayout.CENTER);
		backPanel.add(buttonPanel, BorderLayout.SOUTH);
	}

	private void createForm()
	{
		createButtonPanel();
		createInputPanel();
		createBackPanel();
		add(backPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(SimpleCalculator::new);
	}
}
