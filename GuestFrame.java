import javax.swing.*;
import java.awt.*;

// Currently not in use

public class GuestFrame extends JFrame{
    
    private JPanel guestPanel, buttonPanel;
    private JButton loginAsGuest, loginAsRegisteredUser, loginAsOrdinaryUser;
    private JLabel initialMessage;
    //private JScrollPane
    //private JTextArea
    
    public GuestFrame (String s){
        super(s);

        guestPanel = new JPanel();
        guestPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        guestPanel.add(buttonPanel, BorderLayout.SOUTH);

        addComponents();

        setSize(300, 300);
        setContentPane(guestPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

    }

    private void addComponents(){
        initialMessage = new JLabel("What would you like to do?");
        initialMessage.setBounds(0,0,0,0);
        guestPanel.add(initialMessage);
    }

    public void addActionListeners(GUIController.LoginGuestListener loginGuest, GUIController.LoginRUListener loginRU, GUIController.LoginOUListener loginOU){
        loginAsGuest.addActionListener(loginGuest);
        loginAsRegisteredUser.addActionListener(loginRU);
        loginAsOrdinaryUser.addActionListener(loginOU);
    }
}

