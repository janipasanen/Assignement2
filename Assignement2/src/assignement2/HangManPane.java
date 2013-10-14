package assignement2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.border.*;

public class HangManPane extends JPanel {
    
	JMenuBar menuBar;
	JMenuItem startItem, quitItem;

	JTextField guessesleftField, statusField, guessField, missesField;
    JLabel statusLabel;
    Socket socket;
    PrintStream socketOutput;

	// private Random rand = new Random();

    public HangManPane() {
        super(); // not really necessary

		setLayout(new GridLayout(5, 2, 10, 10));

		/*
		 * Create menu
		 * 
		 * ----------------------------
		 */


		JMenu gameMenu = new JMenu("Game");

		startItem = new JMenuItem("Start");
		// startItem.addActionListener(new ActionListener()) {
		//
		// };
		gameMenu.add(startItem);

		quitItem = new JMenuItem("Quit");
		// quitItem.addActionListener(listener);
		gameMenu.add(quitItem);

		menuBar = new JMenuBar();
		menuBar.add(startItem);
		menuBar.add(quitItem);
		
		clientFrame.setJMenuBar(gameMenu);

		
		// gameMenu.add(startItem);
		// gameMenu.add(quitItem);

		//
		// JMenu optionsMenu = new JMenu("Options");
		// optionsMenu.add(easyItem);
		// optionsMenu.add(mediumItem);
		// optionsMenu.add(hardItem);
		//
		//
		//
		//
		// JRadioButtonMenuItem easyItem = new JRadioButtonMenuItem("Easy");
		// JRadioButtonMenuItem mediumItem = new JRadioButtonMenuItem("Medium");
		// JRadioButtonMenuItem hardItem = new JRadioButtonMenuItem("Hard");
		//
		// ButtonGroup group = new ButtonGroup();
		//
		//
		//
		// group.add(easyItem);
		// group.add(mediumItem);
		// group.add(hardItem);
		//
		//
		//
		// JMenuBar bar = new JMenuBar();
		// bar.add(gameMenu);
		// bar.add(optionsMenu);

		/* ---------------------------- */

		JPanel guesseLeftPanel = new JPanel();

		JLabel guessesleftLabel = new JLabel("Guesses left:");
		guesseLeftPanel.add(guessesleftLabel);

		guessesleftField = new JTextField(1);
		guesseLeftPanel.add(guessesleftField);

		add(guesseLeftPanel);

		/* ---------------------------- */

		JPanel statusPanel = new JPanel();

		JLabel statusLabel = new JLabel("Current status:");
		statusPanel.add(statusLabel);

		statusField = new JTextField(15);
		statusPanel.add(statusField);

		add(statusPanel);

        /* ---------------------------- */

        JPanel guessPanel = new JPanel();

		JLabel guessLabel = new JLabel("Guess:");
		guessPanel.add(guessLabel);

		guessField = new JTextField(1);
		// guessField.addActionListener(new Command());
		guessPanel.add(guessField);

        add(guessPanel);
        
		/* ---------------------------- */

		JPanel missedLettersPanel = new JPanel();

		JLabel missedLettersLabel = new JLabel("Misses:");
		missedLettersPanel.add(missedLettersLabel);

		missesField = new JTextField(25);
		// missesField.addActionListener(new Command());
		missedLettersPanel.add(missesField);

		add(missedLettersPanel);
		
		


	}

	

    }



