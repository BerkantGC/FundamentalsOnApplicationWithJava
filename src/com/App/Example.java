package com.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Example extends JFrame{
    private JPanel Start;
    private JPanel Top;
    private JTextField textUsername;
    private JPasswordField passwordField1;
    private JButton button_Log;

    public Example() throws IOException {
        add(Start);
        setSize(600,300);
        setTitle("App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width)/2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height)/2;
        setLocation(x,y);
        setResizable(false);
        setVisible(true);

        Files log = new Files("USERS.txt");
        log.createFile();

        button_Log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textUsername.getText().length() == 0)
                    JOptionPane.showMessageDialog(null, "Enter a valid username!", "Log in failed!", JOptionPane.INFORMATION_MESSAGE);
                else if(passwordField1.getText().length() == 0)
                    JOptionPane.showMessageDialog(null, "Enter a valid password!", "Log in failed!", JOptionPane.INFORMATION_MESSAGE);

                else
                {
                    try {
                        log.writeToFile("Username: " + textUsername.getText() + "\n");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                    try {
                        log.writeToFile("Password: " + passwordField1.getText() + "\n");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Logged In!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }
}
