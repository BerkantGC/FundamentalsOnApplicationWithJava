package com.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame{
    private JPanel Start;
    private JPanel Top;
    private JTextField textUsername;
    private JPasswordField passwordField1;
    private JButton button_Log;

    public Example()
    {
        add(Start);
        setSize(600,300);
        setTitle("App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width)/2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height)/2;
        setLocation(x,y);
        setResizable(false);
        setVisible(true);

        button_Log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textUsername.getText().length() == 0)
                        JOptionPane.showMessageDialog(null, "Enter a valid username!", "Log in failed!", JOptionPane.INFORMATION_MESSAGE);
                else if(passwordField1.getText().length() == 0)
                        JOptionPane.showMessageDialog(null, "Enter a valid password!", "Log in failed!", JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(null, "Logged In!", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }
}
