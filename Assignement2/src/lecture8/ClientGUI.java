package lecture8;
import javax.swing.*;

public class ClientGUI {
    public static void main(String[] args) {
        JFrame clientFrame = new JFrame("GUI Client");

        clientFrame.setContentPane(new ClientPane());
        //clientFrame.setSize(400, 300);
        clientFrame.pack();
        clientFrame.setLocationRelativeTo(null);
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.setVisible(true);

    }
}