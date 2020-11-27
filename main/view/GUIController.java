package main.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    private MainFrame mainFrame;
    private GuestFrame guestFrame;
    private UserLoginFrame loginFrame;
    private HomePageFrame homeFrame;

    public GUIController (MainFrame f){
        mainFrame = f;
        mainFrame.addActionListeners(new LoginGuestListener(), new LoginRUListener(), new LoginOUListener());
    }

    private void initialLogin(){

    }

    public class LoginGuestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            homeFrame = new HomePageFrame("Ticket Reservation System", "Guest user");
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
            homeFrame = new HomePageFrame("Ticket Reservation System", loginFrame.usernameAnswer);
            loginFrame.dispose();
        }
    }

    public class ViewMoviesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    public class PurchaseTicketListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

}
