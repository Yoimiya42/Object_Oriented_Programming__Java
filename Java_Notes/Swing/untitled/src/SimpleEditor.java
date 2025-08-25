import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleEditor extends JFrame {

	private JPanel editorPanel;
	private JPanel buttonPanel;
	private JPanel topPanel;

	private JScrollPane scroller;

	private JTextArea editor;

	private JButton loadButton;
	private JButton saveButton;
	private JButton cutButton;
	private JButton copyButton;
	private JButton pasteButton;

	public SimpleEditor()
	{
		createGUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createGUI()
	{
		setTitle("Editor --By Yoimiya");
		createEditorPanel();
		createButtonPanel();
		createTopPanel();

	}
	private void createTopPanel()
	{
		topPanel = new JPanel(new BorderLayout());
		topPanel.add(buttonPanel, BorderLayout.WEST);
		topPanel.add(editorPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.CENTER);
	}

	private void createEditorPanel()
	{
		editor = new JTextArea();
		editor.setColumns(40);
		editor.setText("Type here...");

		scroller = new JScrollPane(editor);

		editorPanel = new JPanel(new BorderLayout());
		editorPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		editorPanel.add(scroller, BorderLayout.CENTER);
	}

	private void createButtonPanel()
	{
		buttonPanel = new JPanel(new GridLayout(5,1,10,3));
		buttonPanel.setBorder(BorderFactory.createEtchedBorder());
		createLoadButton();
		createSaveButton();
		createCutButton();
		createPasteButton();
		createCopyButton();
		buttonPanel.add(loadButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(cutButton);
		buttonPanel.add(copyButton);
		buttonPanel.add(pasteButton);

	}

	private void createLoadButton()
	{
		loadButton = new JButton("Load...");
		loadButton.addActionListener((ActionEvent e) -> loadFile());
	}

	private void createSaveButton()
	{
		saveButton = new JButton("Save...");
		saveButton.addActionListener((ActionEvent e) -> saveFile());
	}

	private void createCutButton()
	{
		cutButton = new JButton("Cut");
		cutButton.addActionListener((ActionEvent e) -> cut());
	}

	private void createCopyButton()
	{
		copyButton = new JButton("Copy");
		copyButton.addActionListener((ActionEvent e) -> copy());
	}

	private void createPasteButton()
	{
		pasteButton = new JButton("Paste");
		pasteButton.addActionListener((ActionEvent e) -> paste());
	}


	private void loadFile()
	{
		JFileChooser fc = new JFileChooser(".");
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			try{
				editor.read(new FileReader(file), null);
			}catch (IOException exp) {
				JOptionPane.showMessageDialog(this, "Unable to load the file", "File Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void saveFile()
	{
		JFileChooser fc = new JFileChooser(".");
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			try
			{
				editor.write(new FileWriter(file));
			}catch (IOException e)
			{
				JOptionPane.showMessageDialog(this, "Unable to save the file", "File Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void cut()
	{
		editor.cut();
		editor.requestFocus();
	}

	private void copy()
	{
		editor.copy();
		editor.requestFocus();
	}

	private void paste()
	{
		editor.paste();
		editor.requestFocus();
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(SimpleEditor::new);
	}
}

