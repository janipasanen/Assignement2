package assignement2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class Main implements Runnable {

	private ArrayList<String> words = new ArrayList<String>();
	protected Integer difficulty;
	private Random rand = new Random();
	protected GUI gui;
	protected Game game;


	public Main() throws Exception {
		Scanner scanner = new Scanner(
				Game.class.getResourceAsStream("words.txt"));
		while (scanner.hasNextLine()) {
			words.add(scanner.nextLine());
		}
		scanner.close();

	}


	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Main());
	}

	public void run() {
		difficulty = 7;
		gui = new GUI(this);

	}

	public void start() {
		String word = words.get(rand.nextInt(words.size()));
		gui = new GUI(this, word);
	}

}