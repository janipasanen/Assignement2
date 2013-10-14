package assignement2;
import javax.swing.*;

public class main {
    public static void main(String[] args) {
		JFrame clientFrame = new JFrame("Hangman");

		clientFrame.setContentPane(new HangManPane());
		clientFrame.setSize(400, 300);
		// clientFrame.pack();
        clientFrame.setLocationRelativeTo(null);
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.setVisible(true);

    }
}