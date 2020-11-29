package main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import main.controller.UserController;

public class UserLoginFrame extends JFrame{
    
    private JPanel mainPanel, buttonPanel;
    private JButton login;
    private JLabel message;
    private JTextField usernameInput;
    public String usernameAnswer;

    public UserLoginFrame (String s){
        super(s);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        addComponents();

        setSize(300, 300);
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
    }

    private void addComponents(){

        message = new JLabel("    Hello Theatre Member! Please click login.");
        message.setBounds(300, 300, 300, 300);
        mainPanel.add(message);
        
        UserController uc = new UserController();
        usernameAnswer = this.displayInputDialog("Username: ");
        //check username answer here
        /* Comment this out until we can differentiate between the types of users otherwise we can never log in
        if(!uc.isValidUser(usernameAnswer)) {
        	// ERROR DIAGLOG HERE
        	System.exit(1); // change this to a cancel/go back
        }
        
        */
        // how do we differentiate between logging in a RU/Guest/OU?

        login = new JButton("Login"); // what is the purpose of this extra login button?
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(login);

    }

    public void addActionListeners(GUIController.LoginListener loginButton){
        login.addActionListener(loginButton);
    }

    public String displayInputDialog(String s) {
        return JOptionPane.showInputDialog(s);
    }

}
