package main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePageFrame extends JFrame{
    private JPanel mainPanel, buttonPanel;
    private JButton viewMovies, purchaseTicket, viewTickets, cancelTicket, viewEmail, paySubscription, quitButton;
    private JLabel message1, message2;
    private JScrollPane scrollArea;
    private JTextArea displayArea;
    private String username;
    private BorderLayout layout;
    private String userType; 

    public HomePageFrame (String s, String u){
        super(s);
        username = u;

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        addComponents();

        setSize(1500, 1000);
        setContentPane(mainPanel);
        pack();
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
        buttonPanel.add(viewMovies);

        purchaseTicket = new JButton("Purchase ticket");
        purchaseTicket.setBounds(8,120, 100, 20);
        buttonPanel.add(purchaseTicket);

        cancelTicket = new JButton("Cancel ticket");
        cancelTicket.setBounds(8, 150, 100, 20);
        buttonPanel.add(cancelTicket);

        viewTickets = new JButton("View my tickets");
        viewTickets.setBounds(8, 150, 120, 20);
        buttonPanel.add(viewTickets);

        viewEmail = new JButton("View my emails");
        viewEmail.setBounds(8, 180, 150, 20);
        buttonPanel.add(viewEmail);

        paySubscription = new JButton("Pay subscription");
        paySubscription.setBounds(8, 180, 120, 20);
        buttonPanel.add(paySubscription);

        quitButton = new JButton("Quit");
        quitButton.setBounds(8, 210, 120, 20);
        buttonPanel.add(quitButton);

        displayArea = new JTextArea(25,75);
        displayArea.setEditable(false);
        displayArea.setVisible(true);
        scrollArea = new JScrollPane(displayArea);
        scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scrollArea, BorderLayout.EAST);

    }



    public void addActionListeners(GUIController.ViewMoviesListener movies, GUIController.PurchaseTicketListener ticket, 
                                    GUIController.ViewTicketsListener tickets, GUIController.CancelTicketListener cancel,
                                    GUIController.ViewEmailListener emails, GUIController.PaySubscriptionListener pay,
                                    GUIController.QuitListener quit){
        viewMovies.addActionListener(movies);
        purchaseTicket.addActionListener(ticket);
        viewTickets.addActionListener(tickets);
        cancelTicket.addActionListener(cancel);
        viewEmail.addActionListener(emails);
        paySubscription.addActionListener(pay);
        quitButton.addActionListener(quit);
    }

    public void printToTextArea(String s){
        displayArea.setText(null);
        displayArea.setText(s);
    }
}
