package assignement2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;


public class GUI extends JFrame {
	// implements ActionListener {

	private Main main;
	private JMenuItem item1 = new JMenuItem("Start");
	private JMenuItem item2 = new JMenuItem("Quit");

	private JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("Easy");
	private JRadioButtonMenuItem item4 = new JRadioButtonMenuItem("Medium");
	private JRadioButtonMenuItem item5 = new JRadioButtonMenuItem("Hard");

	protected JLabel guessLabel = new JLabel();
	protected JTextField statusField = new JTextField("", 13);
	protected JTextField inputField = new JTextField("", 1);
	protected JTextField missesField = new JTextField("", 25);

	public GUI() {

		
		System.out.println("Hey dude I'm printed from the GUI class");

		ButtonGroup buttongroup = new ButtonGroup(); // Group all button into
														// Options menu
		buttongroup.add(item3);
		buttongroup.add(item4);
		buttongroup.add(item5);

		JFrame FrameName = new JFrame("Hangman");
		

		JPanel GuessesPanel = new JPanel();
		JPanel CurrentStatusPanel = new JPanel();
		JPanel GuessPanel = new JPanel();
		JPanel MissesPanel = new JPanel();

		FrameName.setLayout(new GridLayout(4, 2, 10, 10));

		GuessesPanel.add(new JLabel("Guesses left:", SwingConstants.LEFT));
		GuessesPanel.add(guessLabel);
		FrameName.add(GuessesPanel);

		/* ---------------------------- */

		CurrentStatusPanel.add(new JLabel("Current status:",
				SwingConstants.LEFT));
		CurrentStatusPanel.add(statusField);
		FrameName.add(CurrentStatusPanel);

		/* ---------------------------- */

		GuessPanel.add(new JLabel("Guess:", SwingConstants.CENTER));
		GuessPanel.add(inputField);
		GuessPanel.setSize(1, 1);
		FrameName.add(GuessPanel);

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
		 * performed and compare with if statesments. I add the ActionsListeners
		 * below and do the actions perfomed check at the same time.
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

//		public void actionPerformed(ActionEvent e) {
//			if (e.getSource() == item1) {
//				JFileChooser FrameName = new JFileChooser(".");
//				FrameName.showOpenDialog(null);
//
//			}
//
//			if (e.getSource() == item2) {
//				System.exit(0);
//			}

		/*
		 * 
		 * Add actions to the menu options and instruct the program to listen to
		 * changes made by user by selecting something from the menus.
		 */

		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// game.start();
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
//				game.difficulty = 10;
//				game.start();
			}
		});

		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
//				game.difficulty = 7;
//				game.start();
			}
		});

		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
//				game.difficulty = 5;
//				game.start();
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
				 * Hangman to gues
				 */
				// if (game.man != null && !input.isEmpty())
				// game.man.guess(input.charAt(0));
			}
		}
	}

	}
