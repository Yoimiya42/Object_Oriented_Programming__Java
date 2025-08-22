import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchButton extends JFrame {
	private static final String FAREWELL = "Farewell";
	private static final String TWILIGHT = "Twilight";

	private String message = FAREWELL;

	private JPanel aPanel;
	private JButton aButton;
	private JLabel aLabel;

	public SwitchButton()
	{
		super("Click Button to Switch.");

		aPanel = new JPanel();
		aButton = new JButton("Click Me");
		aLabel = new JLabel(message, SwingConstants.CENTER);

		aPanel.setBorder(BorderFactory.createEmptyBorder(80,60,20,80));
		aPanel.setLayout(new BorderLayout());
		aPanel.add(aLabel, BorderLayout.CENTER);
		aPanel.add(aButton, BorderLayout.EAST);

		aButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				message = message.equals(FAREWELL)? TWILIGHT : FAREWELL;
				aLabel.setText(message);
			}
		}
		);

		add(aPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}


	public static void main(final String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				new SwitchButton();
			}
		}
		);
	}
}