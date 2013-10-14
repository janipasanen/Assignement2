package assignement2_alternativlosning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Interface extends JFrame {

	private Game game;
	protected JLabel guessLabel = new JLabel();
	protected JTextField statusField = new JTextField("", 13);
	protected JTextField missesField = new JTextField();
	protected JTextField inputField = new GuessField();

	public Interface(Game g) {
		super("Hangman");
		
		game = g;
		
		missesField.setEditable(false);
		statusField.setEditable(false);
		statusField.setFont(new Font("Verdana", Font.CENTER_BASELINE, 20));
		// statusField.setBorder(new EmptyBorder(5, 0, 5, 0));
		inputField.setHorizontalAlignment(JTextField.CENTER);
		
		JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
		
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(new JLabel("Guesses left:", SwingConstants.LEFT));
		panel.add(guessLabel);
		panel.add(new JLabel("Current status:", SwingConstants.LEFT));
		panel.add(statusField);
		panel.add(new JLabel("Guess:", SwingConstants.CENTER));
		panel.add(inputField);
		panel.add(new JLabel("Misses:", SwingConstants.LEFT));
		panel.add(missesField);

		add(panel);
		
		pack();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// panel.setSize(400, 300);
		setJMenuBar(createMenuBar());
		setVisible(true);

	}

	// This is custom class for the textField the user types in
	private class GuessField extends JTextField {

		protected void processKeyEvent(KeyEvent ke) {
			
			/*
			 * Stop if the input is disabled or the key is not pressed
			 */
			if(!this.isEditable() || ke.getID() != KeyEvent.KEY_PRESSED) return;
			
			/*
			 * Only allo letter, make them upper-case
			 */
			if(Character.isLetter(ke.getKeyChar())) {
				this.setText(("" + ke.getKeyChar()).toUpperCase());
			}
			
			/*
			 * If the key pressen is an enter
			 */
			if(ke.getKeyCode() == 10) {
				String input = inputField.getText();
				
				/*
				 * If the input text is not empty and there is a Hangman ask Hangman to gues
				 */
				if(game.man != null && !input.isEmpty()) game.man.guess(input.charAt(0));
			}
		}
	}



	private JMenuBar createMenuBar() {
		// Create the menu bar and listen if the menu items are clicked
		/*-----------------------------------------------*/
		// Create the Menu bar

		JMenuItem startItem = new JMenuItem("Start");
		JMenuItem quitItem = new JMenuItem("Quit");

		JRadioButtonMenuItem easyItem = new JRadioButtonMenuItem("Easy");
		JRadioButtonMenuItem mediumItem = new JRadioButtonMenuItem("Medium");
		JRadioButtonMenuItem hardItem = new JRadioButtonMenuItem("Hard");

		/*-----------------------------------------------
		 * Add action listeners to the start menu
		 * Listen to input from mouse by user selecting an option in the menu
		 * 
		 */

		startItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				game.start();
			}
		});
		
		quitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		
		
		/*-----------------------------------------------*/
		// Add action listeners to the difficulty menu
		
		easyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				game.difficulty = 10;
				game.start();
			}
		});
				
		mediumItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				game.difficulty = 7;
				game.start();
			}
		});

		hardItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				game.difficulty = 5;
				game.start();
			}
		});

		mediumItem.setSelected(true);

		/*-----------------------------------------------*/
		// Group all the menus and buttons

		ButtonGroup group = new ButtonGroup();

		JMenu gameMenu = new JMenu("Game");
		gameMenu.add(startItem);
		gameMenu.add(quitItem);

		group.add(easyItem);
		group.add(mediumItem);
		group.add(hardItem);

		JMenu optionsMenu = new JMenu("Options");
		optionsMenu.add(easyItem);
		optionsMenu.add(mediumItem);
		optionsMenu.add(hardItem);



		JMenuBar bar = new JMenuBar();
		bar.add(gameMenu);
		bar.add(optionsMenu);

		return bar;
	}

}
