package assignement2_alternativlosning;

import javax.swing.JOptionPane;

// Can make a guess and all data of a round is stored here
public class Hangman {

	private Game game;
	private int guesses;
	private String word;
	private String misses;
	private StringBuilder status;

	public Hangman(Game g, String w) {
		game = g;
		misses = "";
		guesses = game.difficulty;

		// add spaces after every letter
		word = w.replaceAll("(.)", "$1 ");

		// change every letter into an underscore
		status = new StringBuilder(w.replaceAll("(.)", "_ "));

		// reset the interface
		game.gui.guessLabel.setText("" + guesses);
		game.gui.statusField.setText("" + status);
		game.gui.missesField.setText("");
		game.gui.inputField.setText("");
		game.gui.inputField.setEditable(true);

	}

	public void guess(char letter) {
		char space = ' ';

		game.gui.inputField.setText("");

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
		game.gui.statusField.setText(status + "");

		if (word.equals(status + ""))
			gameOver(true);
	}

	public boolean alreadyUsed(char letter) {
		if (misses.indexOf(letter) == -1 && status.indexOf(letter + "") == -1)
			return false;

		game.gui.inputField.setText("");

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

		game.gui.guessLabel.setText(guesses + "");
		;
		game.gui.missesField.setText(misses);

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
		game.gui.inputField.setEditable(false);

	}
}
