import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private JPanel mainPanel, buttonPanel;
    private JButton loginAsGuest, loginAsRegisteredUser, loginAsOrdinaryUser;
    private JLabel initialMessage;
    
    public MainFrame (String s){
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
        initialMessage = new JLabel("       Welcome to Ticket Registration System");
        initialMessage.setBounds(300, 300, 300, 300);
        mainPanel.add(initialMessage);

        loginAsGuest = new JButton("Login as Guest");
        loginAsGuest.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(loginAsGuest);

        loginAsRegisteredUser = new JButton("Login as Registered User");
        loginAsRegisteredUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(loginAsRegisteredUser);

        loginAsOrdinaryUser = new JButton("Login as Ordinary User");
        loginAsOrdinaryUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(loginAsOrdinaryUser);
    }

    public void addActionListeners(GUIController.LoginGuestListener loginGuest, GUIController.LoginRUListener loginRU, GUIController.LoginOUListener loginOU){
        loginAsGuest.addActionListener(loginGuest);
        loginAsRegisteredUser.addActionListener(loginRU);
        loginAsOrdinaryUser.addActionListener(loginOU);
    }
}
