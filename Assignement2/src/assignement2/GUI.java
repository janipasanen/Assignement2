package assignement2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.border.*;


public class GUI extends JFrame {
	// implements ActionListener {

	private JMenuItem item1 = new JMenuItem("Start");
	private JMenuItem item2 = new JMenuItem("Quit");

	private JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("Easy");
	private JRadioButtonMenuItem item4 = new JRadioButtonMenuItem("Medium");
	private JRadioButtonMenuItem item5 = new JRadioButtonMenuItem("Hard");

	protected JLabel guessLabel = new JLabel();
	protected JTextField statusField = new JTextField("", 13);
	protected JTextField inputField = new GuessField();
	protected JTextField missesField = new JTextField("", 25);

	private ArrayList<String> words = new ArrayList<String>();
	private Random rand = new Random();
	
	private int guesses;
	private String word;
	private String misses;
	private StringBuilder status;

	int difficulty = 7;

	public GUI() {

		// Get the words from the file words.txt and enter into words
		Scanner scanner = new Scanner(
				GUI.class.getResourceAsStream("words.txt"));
		while (scanner.hasNextLine()) {
			words.add(scanner.nextLine());
		}
		scanner.close();
		

		ButtonGroup buttongroup = new ButtonGroup(); // Group all button into
														// Options menu
		buttongroup.add(item3);
		buttongroup.add(item4);
		buttongroup.add(item5);

		JFrame FrameName = new JFrame("Hangman");
		

		JPanel GuessesPanel = new JPanel(new GridLayout(2, 2, 2, 2));
		JPanel CurrentStatusPanel = new JPanel(new GridLayout(2, 2, 2, 2));
		JPanel GuessPanel = new JPanel();
		JPanel MissesPanel = new JPanel();

		FrameName.setLayout(new GridLayout(4, 2, 2, 2));

		GuessesPanel.add(new JLabel("Guesses left:", SwingConstants.LEFT));
		GuessesPanel.add(guessLabel);
		FrameName.add(GuessesPanel);

		/* ---------------------------- */

		CurrentStatusPanel.add(new JLabel("Current status:",
				SwingConstants.LEFT));
		CurrentStatusPanel.add(statusField);

		CurrentStatusPanel.add(new JLabel("Guess:", SwingConstants.CENTER));
		CurrentStatusPanel.add(inputField);

		FrameName.add(CurrentStatusPanel);

		/* ---------------------------- */

		// GuessPanel.add(new JLabel("Guess:", SwingConstants.CENTER));
		// GuessPanel.add(inputField);
		//
		// FrameName.add(GuessPanel);

		/* ---------------------------- */

		MissesPanel.add(new JLabel("Misses:", SwingConstants.LEFT));
		MissesPanel.add(missesField);
		FrameName.add(MissesPanel);

		/* ---------------------------- */
		

		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("Game");
		JMenu menu2 = new JMenu("Options");

		/*
		 * 
		 * Commented out the below addActionListeners below because I commented
		 * out implements ActionListener from public class GUI extends JFrame
		 * implements ActionListener. I commented out the implements
		 * ActionListener because I do not instruct the program to check actions
		 * performed and compare with if statements. I add the ActionsListeners
		 * below and do the actions performed check at the same time.
		 */

		// item1.addActionListener(this);
		// item2.addActionListener(this);
		//
		// item3.addActionListener(this);
		// item4.addActionListener(this);
		// item5.addActionListener(this);

		menu1.add(item1);
		menu1.add(item2);


		menu2.add(item3);
		menu2.add(item4);
		menu2.add(item5);

		menubar.add(menu1);
		menubar.add(menu2);


		FrameName.setJMenuBar(menubar);
		FrameName.setSize(350, 200); // Sets the size of the screen (Frame)
		FrameName.setLocationRelativeTo(null); // Center the screen in the
												// monitor
		FrameName.setVisible(true); // Make the screen visible
		// Terminate the program when the screen is closed
		FrameName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		/*
		 * 
		 * Add actions to the menu options and instruct the program to listen to
		 * changes made by user by selecting something from the menus.
		 */

		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				start();
			}
		});


		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		/*-----------------------------------------------*/
		// Add action listeners to the difficulty menu

		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				difficulty = 10;
				start();
			}
		});

		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				difficulty = 7;
				start();
			}
		});

		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				difficulty = 5;
				start();
			}
		});

		item4.setSelected(true);

		}

	// This is custom class for the textField the user types in
	private class GuessField extends JTextField {

		protected void processKeyEvent(KeyEvent ke) {

			/*
			 * Stop if the input is disabled or the key is not pressed
			 */
			if (!this.isEditable() || ke.getID() != KeyEvent.KEY_PRESSED)
				return;

			/*
			 * Only allow letters, make them upper-case
			 */
			if (Character.isLetter(ke.getKeyChar())) {
				this.setText(("" + ke.getKeyChar()).toUpperCase());
			}

			/*
			 * If enter key is pressed
			 */
			if (ke.getKeyCode() == 10) {
				String input = inputField.getText();

				/*
				 * If the input text is not empty and there is a Hangman ask
				 * Hangman to guess
				 */
				// if (word != null && !input.isEmpty())
				// guess(input.charAt(0));
			}
		}
	}

	public void start() {
		String word = words.get(rand.nextInt(words.size()));
		
		misses = "";
		guesses = difficulty;

		// change every letter into an underscore
		status = new StringBuilder(word.replaceAll("(.)", "_ "));

		// reset the interface
		guessLabel.setText("" + guesses);
		statusField.setText("" + status);
		missesField.setText("");
		inputField.setText("");
		inputField.setEditable(true);
		missesField.setEditable(false);

	}

	public void guess(char letter) {
		char space = ' ';

		inputField.setText("");

		if (alreadyUsed(letter))
			return;

		if (letterNotInWord(letter))
			return;

		/*
		 * Check if any letter in the word is equal to the letter typed change
		 * the underscore in "status" at that index to that letter
		 */
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter && word.charAt(i) != space) {
				status.setCharAt(i, letter);
			}
		}
		statusField.setText(status + "");

		if (word.equals(status + ""))
			gameOver(true);
	}

	public boolean alreadyUsed(char letter) {
		if (misses.indexOf(letter) == -1 && status.indexOf(letter + "") == -1)
			return false;

		inputField.setText("");

		JOptionPane.showMessageDialog(null, "Letter " + letter
				+ " is already used!");

		return true;

	}

	public boolean letterNotInWord(char letter) {
		if (word.indexOf(letter) != -1)
			return false;

		misses += letter + " ";
		guesses -= 1;

		/*
		 * update the guesses and misses text
		 */

		guessLabel.setText(guesses + "");
		;
		missesField.setText(misses);

		/*
		 * 
		 * if no more guesses are left, you lost!
		 */
		if (guesses == 0)
			gameOver(false);

		return true;
	}

	private void gameOver(Boolean youWon) {
		String message = youWon ? "You guessed the right word!"
				: "You guessed wrong. The word that could have saved him was\""
						+ word + "\"...";

		JOptionPane.showMessageDialog(null, message);
		inputField.setEditable(false);

	}
}
		


	