import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    private MainFrame mainFrame;
    private GuestFrame guestFrame;
    private UserLoginFrame loginFrame;

    public GUIController (MainFrame f){
        mainFrame = f;
        mainFrame.addActionListeners(new LoginGuestListener(), new LoginRUListener(), new LoginOUListener());
    }

    private void initialLogin(){

    }

    public class LoginGuestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            guestFrame = new GuestFrame("Ticket Reservation System");
            mainFrame.dispose();
        }
    }

    public class LoginOUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginRUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
}
