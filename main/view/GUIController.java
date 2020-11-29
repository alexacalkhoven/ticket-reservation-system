
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
package main.view;

public class GUIController {
    private MainFrame mainFrame;
    private UserLoginFrame loginFrame;
    private HomePageFrame homeFrame;
    private String theatre = "-----SCREEN-----" + '\n' + "       1  2  3  4  5" + '\n' + "    1  •  •  •  •  •" + '\n' + "    2  •  •  •  •  •"
                            + '\n' + "    3  •  •  •  •  •" + '\n' + "    4  •  •  •  •  •";
    private String type;

    public GUIController (MainFrame f){
        mainFrame = f;
        mainFrame.addActionListeners(new LoginGuestListener(), new LoginRUListener(), new LoginOUListener());
    }

    public class LoginGuestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            type = "G";
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginOUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //check username validity in UserLoginFrame.java -> addComponents()
            type = "O";
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginRUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //check username validity in UserLoginFrame.java -> addComponents()
            type = "R";
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            homeFrame = new HomePageFrame("Ticket Reservation System", loginFrame.usernameAnswer, type);
            homeFrame.addActionListeners(new ViewMoviesListener(), new PurchaseTicketListener(), new ViewTicketsListener(), 
                                        new CancelTicketListener(), new ViewEmailListener(), new PaySubscriptionListener(),
                                        new QuitListener(), new SearchMovieListener(), new RegisterListener());
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
            if(movie == null) return;
            homeFrame.printToTextArea(theatre);
            String seats = displayInputDialog("Enter the seats you would like to book (row/col) separated by spaces (ex: 11 12 13): ");
            if(seats == null) return;
            String [] seats_parsed = seats.split(" "); //list of seats ordered
            //if one or more seat in unavailable
            //homeFrame.printToTextArea("One or more seats that you have selected are unavailable, please try again");
            //else
            homeFrame.printToTextArea("Your receipt and ticket have been sent to your email!");
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
            if(ticket == null) return;
            //getticket()
            //check 72 hours here - set to boolean
            //if(before 72 hours)
                //assign 85% credit to their account if Ordinary else give 100% credit
                homeFrame.printToTextArea("Ticket cancelled!");
            //else
                //homeFrame.printToTextArea("You may not cancel your ticket less than 72 hours before the movie");
        }
    }

    public class ViewEmailListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String emails = "This is the list of all my emails!";
            homeFrame.printToTextArea("My emails: " + "\n\n" + emails);
        }
    }

    public class PaySubscriptionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String payment = "$20.00";
            homeFrame.printToTextArea("Your outstanding payment is: " + payment);
            String confirmation = displayInputDialog("Enter 'Confirm' to purchase your membership: ");
            if(confirmation == null) return;
            homeFrame.printToTextArea("Payment confirmed! Receipt sent to email");
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

    public class RegisterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String selectedType = displayInputDialog("Enter 'RU' to become a Registered User or 'OU' to become an Ordinary User");
            if(selectedType == "RU"){
                //register bs
                homeFrame.printToTextArea("You are now a Registered User");
            }
            else if(selectedType == "OU"){
                //register bs
                homeFrame.printToTextArea("You are now a Ordinary User");
            }
            else
                homeFrame.printToTextArea("Invalid entry... Try again!");
            
        }
    }

    public class SearchMovieListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String movie = displayInputDialog("Enter the name of a movie you would like to search for: ");
            //find movie
            //if movie doesnt exist
            //homeFrame.printToTextArea("Sorry, this movie does not exist!");
            //else
            homeFrame.printToTextArea("Movie info: ");// + movie.toString());
        }
    }

    public String displayInputDialog(String s) {
        return JOptionPane.showInputDialog(s);
    }

}
