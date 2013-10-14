package assignement2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class HangManPane extends JPanel {
    
	JTextField guessesleftField, statusField, guessField, missesField;
    JLabel statusLabel;
    Socket socket;
    PrintStream socketOutput;

	int difficulty = 7;

	// private Random rand = new Random();

    public HangManPane() {
        super(); // not really necessary

		setLayout(new GridLayout(5, 1, 10, 30));

	

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

		// JPanel connectionPanel = new JPanel();
		//
		// statusLabel = new JLabel("Status: Not connected");
		// connectionPanel.add(statusLabel);
		//
		// JButton connectButton = new JButton("Connect");
		// connectButton.addActionListener(new Connect());
		//
		// connectionPanel.add(connectButton);
		//
		// connectionPanel.setBorder(BorderFactory.createEtchedBorder());
		//
		// add(connectionPanel);

        /* ---------------------------- */

        JPanel guessPanel = new JPanel();

		JLabel guessLabel = new JLabel("Guess:");
		guessPanel.add(guessLabel);

		guessField = new JTextField(1);
		guessField.addActionListener(new Command());
		guessPanel.add(guessField);

        add(guessPanel);
        
		/* ---------------------------- */

		JPanel missedLettersPanel = new JPanel();

		JLabel missedLettersLabel = new JLabel("Misses:");
		missedLettersPanel.add(missedLettersLabel);

		missesField = new JTextField(25);
		missesField.addActionListener(new Command());
		missedLettersPanel.add(missesField);

		add(missedLettersPanel);

    }

	// private class Connect implements ActionListener {
	// public void actionPerformed(ActionEvent ae) {
	// try {
	// String hostname = hostField.getText();
	// int port = Integer.parseInt(portField.getText());
	// socket = new Socket(hostname, port);
	// socketOutput = new PrintStream(socket.getOutputStream());
	// statusLabel.setText("Status: Connected");
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	//
	// }
	// }

    private class Command implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
			String commandString = guessField.getText();
			guessField.setText("");
            try {
                socketOutput.println(commandString);
                if(commandString.equals("quit")) {
                    socket.close();
                    System.out.println("Good-bye!");
                    statusLabel.setText("Status: Not connected");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

		private class Miss implements ActionListener {
			public void actionPerformed(ActionEvent ae) {
				String commandString = missesField.getText();
				missesField.setText("");
				try {
					socketOutput.println(commandString);
					if (commandString.equals("quit")) {
						socket.close();
						System.out.println("Good-bye!");
						statusLabel.setText("Status: Not connected");
					}
				} catch (Exception e) {
					System.out.println(e);

				}
			}
    }
		Private class JMenu 
    
    }
}


