package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Database.Crypto;
import com.COP2805C.AddressBook.Functions;

import javax.swing.*;
import java.util.Objects;

/**
 * Created by abirfaisal on 6/18/15.
 */
public class CreateAccountWindow {


    public static String[] createAccount() {

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

        //Confirm Password
        JLabel confirmPasswordLabel = new JLabel("Confirm   ");
        JPasswordField confirmPasswordJTextField = new JPasswordField();
        JPanel confirmPasswordJpanel = new JPanel();
        confirmPasswordJpanel.setLayout(new BoxLayout(confirmPasswordJpanel, BoxLayout.X_AXIS));
        confirmPasswordJpanel.add(confirmPasswordLabel);
        confirmPasswordJpanel.add(confirmPasswordJTextField);


        //Main JPanel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(usernameJPanel);
        jPanel.add(passwordJpanel);
        jPanel.add(confirmPasswordJpanel);


        do {
            //JOptionPane
            String[] buttons = {"Create Account"};
            int test = JOptionPane.showOptionDialog(
                    null,
                    jPanel,
                    "Create an account",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    buttons, buttons[0]);


            //Prompt user that passwords don't match
            if (!Objects.equals(passwordJTextField.getText(), confirmPasswordJTextField.getText())) {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
            }
        } while (!Objects.equals(passwordJTextField.getText(), confirmPasswordJTextField.getText()) ||
                !Functions.isPasswordStrong(usernameJTextField.getText(), passwordJTextField.getText()));

        //TODO I did this to temporarily fix the login problem, so that I can test database. Password on database needed to be SHA
        String encryptedPassword = passwordJTextField.getText();
        return new String[]{usernameJTextField.getText(), encryptedPassword};
    }

}
