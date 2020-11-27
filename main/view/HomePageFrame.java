package main.view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HomePageFrame extends JFrame{
    private JPanel mainPanel, buttonPanel;
    private JButton viewMovies, purchaseTicket;
    private JLabel message1, message2;
    private String username;
    private BorderLayout layout;

    public HomePageFrame (String s, String u){
        super(s);
        username = u;

        mainPanel = new JPanel(null);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buttonPanel);

        addComponents();

        setSize(1500, 1000);
        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
    }

    private void addComponents(){
        String s = "Welcome to your Homepage " + username + "!";
        message1 = new JLabel(s);
        message1.setBounds(8,10,1000,20);
        mainPanel.add(message1);

        message2 = new JLabel("Please choose an option below:");
        message2.setBounds(8,50,1000,20);
        mainPanel.add(message2);

        viewMovies = new JButton("View movies");
        viewMovies.setBounds(8, 90, 100, 20);//setLocation(100, 100);
        mainPanel.add(viewMovies);

        purchaseTicket = new JButton("Purchase ticket");
        purchaseTicket.setBounds(8,120, 100, 20);
        mainPanel.add(purchaseTicket);
    }



    public void addActionListeners(GUIController.ViewMoviesListener movies, GUIController.PurchaseTicketListener ticket){
        viewMovies.addActionListener(movies);
        purchaseTicket.addActionListener(ticket);
    }
}
