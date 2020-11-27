import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    private MainFrame mainFrame;
    //private GuestFrame guestFrame;
    private UserLoginFrame loginFrame;
    private HomePageFrame homeFrame;
    private String theatre = "---------SCREEN---------" + '\n' + "   A  B  C  D  E  F  G  H  I  J  K  L" + '\n' + "1  •  •  •  •  •  •  •  •  •  •  •  •" 
                            + '\n' + "2  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "3  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "4  •  •  •  •  •  •  •  •  •  •  •  •" 
                            + '\n' + "5  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "6  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "7  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "8  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "9  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "10  •  •  •  •  •  •  •  •  •  •  •  •" 
                            + '\n' + "11  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "12  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "13  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' + "14  •  •  •  •  •  •  •  •  •  •  •  •" + '\n' 
                            + "15  •  •  •  •  •  •  •  •  •  •  •  •";

    public GUIController (MainFrame f){
        mainFrame = f;
        mainFrame.addActionListeners(new LoginGuestListener(), new LoginRUListener(), new LoginOUListener());
    }

    public class LoginGuestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
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
            homeFrame.addActionListeners(new ViewMoviesListener(), new PurchaseTicketListener(), new ViewTicketsListener(), 
                                        new CancelTicketListener(), new ViewEmailListener(), new PaySubscriptionListener(),
                                        new QuitListener());
            loginFrame.dispose();
        }
    }

    public class ViewMoviesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            homeFrame.printToTextArea("This is all movies");
        }
    }

    public class PurchaseTicketListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String movie = displayInputDialog("Enter the name of the movie you would like to book ticket(s) for: ");
            homeFrame.printToTextArea(theatre);
            String seats = displayInputDialog("Enter the seats you would like to book separated by spaces (ex: A11 A12 B11): ");
            String [] seats_parsed = seats.split(" ");
        }
    }

    public class ViewTicketsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            homeFrame.printToTextArea("My tickets: ");
        }
    }

    public class CancelTicketListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            homeFrame.printToTextArea("My tickets: ");
            String ticket = displayInputDialog("Enter the ticketId you would like to cancel: ");
            homeFrame.printToTextArea("Ticket cancelled!");
        }
    }

    public class ViewEmailListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            homeFrame.printToTextArea("My emails: ");
        }
    }

    public class PaySubscriptionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String confirmation = displayInputDialog("Enter 'Confirm' to purchase your membership: ");
            homeFrame.printToTextArea("Payment confirmed!");
        }
    }

    public class QuitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            mainFrame.dispose();
            loginFrame.dispose();
            homeFrame.dispose();
            System.exit(1);
        }
    }

    public String displayInputDialog(String s) {
        return JOptionPane.showInputDialog(s);
    }

}
