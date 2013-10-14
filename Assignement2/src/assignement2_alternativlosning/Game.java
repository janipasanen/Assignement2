package assignement2_alternativlosning;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


public class Game implements Runnable {
	
	private ArrayList<String> words = new ArrayList<String>();
	private Random rand = new Random();
	protected Hangman man;
	protected Interface gui;
	protected Integer difficulty;
        
     public Game() throws Exception {
    	 Scanner scanner = new Scanner(Game.class.getResourceAsStream("words.txt"));
    	 while(scanner.hasNextLine()) { 
    		 words.add(scanner.nextLine());  
    		 }
        scanner.close();
        
     }


	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Game());
        }
        	
     public void run() {
     	difficulty = 7;
		gui = new Interface(this);
       	    	
       }
     
     public void start() {
		String word = words.get(rand.nextInt(words.size()));
		man = new Hangman(this, word);
	}

}
        	
 

// TODO 1. create gui *use lecture8 code to start ---> JPanel, JTextfield, JMenu
// TODO 2. get words from a file place them in array and randomly choose one
// ---> google: import txt file in JAVA
// TODO 3. chosen word to show up on current status field ---> setText
// TODO 4. word to show up as dashes ---> setText, getLength()
// TODO 5. *might be tricky* show user input in the guess field at the correct
// place if correct ---> getText, setText, addActionListener
// TODO 6. show user input in fail box if not correct --> getText, setText
// TODO 7. allow only one character as an input and capitalize it -->
// addKeyListener, getText, setText, regular expressions
// TODO 8. don't allow user to enter the same character twice --> use a
// character array just for storing previous user input, getText, setText
// TODO 9. implement guesses left
// TODO 10. implement levels --> addMouseListener
// TODO 11. implement start/quit --> addMouseListener, system.exit(0)
