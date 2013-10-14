package lecture8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.net.*;
import java.io.*;

public class ClientPane extends JPanel {
    
    JTextField hostField, portField, commandField;
    JLabel statusLabel;
    Socket socket;
    PrintStream socketOutput;

    public ClientPane() {
        super(); // not really necessary

        setLayout(new GridLayout(3, 1, 10, 10));

        JPanel hostPortPanel = new JPanel();

        JLabel hostLabel = new JLabel("Hostname:");
        hostPortPanel.add(hostLabel);

        hostField = new JTextField(15);
        hostPortPanel.add(hostField);

        JLabel portLabel = new JLabel("Port:");
        hostPortPanel.add(portLabel);

        portField = new JTextField(5);
        hostPortPanel.add(portField);

        add(hostPortPanel);

        /* ---------------------------- */

        JPanel connectionPanel = new JPanel();

        statusLabel = new JLabel("Status: Not connected");
        connectionPanel.add(statusLabel);

        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new Connect());

        connectionPanel.add(connectButton);

        connectionPanel.setBorder(BorderFactory.createEtchedBorder());

        add(connectionPanel);

        /* ---------------------------- */

        JPanel commandPanel = new JPanel();

        JLabel commandLabel = new JLabel("Command:");
        commandPanel.add(commandLabel);

        commandField = new JTextField(15);
        commandField.addActionListener(new Command());
        commandPanel.add(commandField);

        add(commandPanel);
        
    }

    private class Connect implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            try {
                String hostname = hostField.getText();
                int port = Integer.parseInt(portField.getText());
                socket = new Socket(hostname, port);
                socketOutput = new PrintStream(socket.getOutputStream());
                statusLabel.setText("Status: Connected");
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    private class Command implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String commandString = commandField.getText();
            commandField.setText("");
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
    }
}


