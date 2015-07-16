package com.COP2805C.AddressBook.UserInterface;

import javax.swing.*;

/**
 * Created by EpiphX on 6/8/2015.
 */
public class LoginWindow {

    public static String[] loginPrompt() {

        //Username
        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameJTextField = new JTextField();
        JPanel usernameJPanel = new JPanel();
        usernameJPanel.setLayout(new BoxLayout(usernameJPanel, BoxLayout.X_AXIS));
        usernameJPanel.add(usernameLabel);
        usernameJPanel.add(usernameJTextField);


        //Password
        JLabel passwordLabel = new JLabel("Password ");
        JPasswordField passwordJTextField = new JPasswordField();
        JPanel passwordJpanel = new JPanel();
        passwordJpanel.setLayout(new BoxLayout(passwordJpanel, BoxLayout.X_AXIS));
        passwordJpanel.add(passwordLabel);
        passwordJpanel.add(passwordJTextField);


        //Main JPanel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(usernameJPanel);
        jPanel.add(passwordJpanel);


        //JOptionPane
        String[] buttons = {"Login", "Create Account"};
        int login = JOptionPane.showOptionDialog(
                null,
                jPanel,
                "Login",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons, buttons[0]);


        System.out.println(usernameJTextField.getText() + passwordJTextField.getText());
        System.out.println(login);

        //Login
        if (login == 0) {
            //Return string array with username and password

            //TODO TEST re enable this and disable the next line!
            return new String[]{usernameJTextField.getText(), passwordJTextField.getText()};
            //return new String[]{"Chris_12456", "121212"};


        } else {
            //if return null if create account
            return null;
        }
    }
}
