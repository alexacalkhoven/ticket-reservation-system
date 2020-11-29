package main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.controller.EmailController;
import main.controller.MovieController;
import main.controller.PaymentController;
import main.controller.SeatController;
import main.controller.ShowtimeController;
import main.model.Email;
import main.model.Movie;
import main.model.Payment;
import main.model.Seat;
import main.model.Showtime;
import main.model.Ticket;
import resources.Constants;
import main.controller.TicketController;
import main.controller.UserController;


public class GUIController {
    private MainFrame mainFrame;
    private UserLoginFrame loginFrame;
    private HomePageFrame homeFrame;
    private String theatre = "-----SCREEN-----" + '\n' + "       1  2  3  4  5" + '\n' + "    1  •  •  •  •  •" + '\n' + "    2  •  •  •  •  •"
                            + '\n' + "    3  •  •  •  •  •" + '\n' + "    4  •  •  •  •  •";
    private String type;
    private String username;
    private UserController uc;

    public GUIController (MainFrame f){
        mainFrame = f;
        mainFrame.addActionListeners(new LoginGuestListener(), new LoginRUListener(), new LoginOUListener());
    }

    public boolean validateUsername (String u){
        uc = new UserController();
        if(!uc.isValidUser(u)) {
        	JOptionPane.showMessageDialog(mainFrame, "Invalid Username... Try again"); //should pop up an error window
        	return false;
        }
        return true;
    }

    public class LoginGuestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            username = displayInputDialog("Username: ");
            type = "G";
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginOUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            username = displayInputDialog("Username: ");
            boolean valid = validateUsername(username);
            if(!valid) return;
            type = "O";
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginRUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            username = displayInputDialog("Username: ");
            boolean valid = validateUsername(username);
            if(!valid) return;
            type = "R";
            loginFrame = new UserLoginFrame("Ticket Reservation System");
            loginFrame.addActionListeners(new LoginListener());
            mainFrame.dispose();
        }
    }

    public class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            homeFrame = new HomePageFrame("Ticket Reservation System", username, type);
            homeFrame.addActionListeners(new ViewMoviesListener(), new PurchaseTicketListener(), new ViewTicketsListener(), 
                                        new CancelTicketListener(), new ViewEmailListener(), new PaySubscriptionListener(),
                                        new QuitListener(), new SearchMovieListener(), new RegisterListener());
            loginFrame.dispose();
        }
    }

    public class ViewMoviesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
        	viewMovies();
        }
    }
    
    private void viewMovies() {
    	String message = "-----Movies-----\n";
    	MovieController mc = new MovieController();
    	ArrayList<Movie> movieList = mc.getMovies();
    	for(int i = 0; i < movieList.size(); i++) {
    		message += (movieList.get(i).toString() + "\n");
    	}
        homeFrame.printToTextArea(message);
    }

    /**
     * Allows user to purchase a ticket.
     */
    public class PurchaseTicketListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
        	viewMovies();
            String movie = displayInputDialog("Enter the name of the movie you would like to book a ticket for: ");
            if(movie == null) return;
            Movie m = searchMovie(movie);
            if(m == null) return;
            String showtime = displayInputDialog("Enter the id of the showtime you would like to book a ticket for: ");
            if(showtime == null) return;
            int showtimeId; 
            try {
            	showtimeId = Integer.parseInt(showtime); 
            } catch (NumberFormatException n) {
            	homeFrame.printToTextArea("Invalid showtime id entered.");
                return;
            }
            ShowtimeController stc = new ShowtimeController();
            Showtime selectedShowtime = stc.getShowtime(showtimeId);
            if(selectedShowtime == null || selectedShowtime.getMovieId() != m.getMovieId()) {
            	homeFrame.printToTextArea("Invalid showtime selected.");
            	return;
            }
            SeatController sc = new SeatController();
            Seat [][] seats = sc.getSeats(showtimeId);
            String seatChart = "{id} = Seat reserved for Registered Users.\n";
            seatChart += "[id] = Seat unavailable.\n";
            seatChart += "(id) = Seat available.\n";
            seatChart += "-----Screen-----\n";
            for (int i = 0; i < Constants.NUM_ROWS; i++) {
    			for (int j = 0; j < Constants.NUM_COLS; j++) {
    				Seat current = seats[i][j];
    				int seatId = current.getSeatId();
    				// {01} (02) (03) [04] [05]
    				// curly brackets: reserved for RUs
    				// round brackets: available
    				// square brackets: unavailable
    				String seatLabel = "";
    				if(seatId < 10) seatLabel += "0";
    				seatLabel += String.valueOf(seatId);
    				if(current.isTaken()) seatLabel = "[" + seatLabel + "]";
    				else if(current.getType() == 1) seatLabel = "{" + seatLabel + "}";
    				else seatLabel = "(" + seatLabel + ")";
    				seatChart += (seatLabel + " ");
    			}
    			seatChart += "\n";
    		}
            homeFrame.printToTextArea(seatChart);
            String seat = displayInputDialog("Enter the seat id you would like to book: ");
            if(seat == null) return;
            int seatId; 
            try {
            	seatId = Integer.parseInt(seat); 
            } catch (NumberFormatException n) {
            	homeFrame.printToTextArea("Invalid seat id entered.");
                return;
            }
            // check if valid seat entered here... (is it an actual seat for the selected show time..?)
            if(sc.isValidSeat(username, seatId)) {
            	// go through with purchase
            	homeFrame.printToTextArea("Selected ticket is $9.99. Please enter your payment information.");
            	String cardNum = paymentProcess();
            	int card = Integer.parseInt(cardNum);
            	PaymentController pc = new PaymentController();
            	Payment p = pc.addPayment(9.99, card);
            	TicketController tc = new TicketController();
            	Ticket t = tc.addTicket(seatId, showtimeId, p.getPaymentId());
            	tc.assignTicketToUser(username, t.getTicketId());
            	t.makePurchaseReceipt(username);
            	sc.markSeatAsTaken(seatId);
            	homeFrame.printToTextArea("Your receipt and ticket have been sent to your email!");
            } else {
            	homeFrame.printToTextArea("This seat is not available for purchase.\n");
            	return;
            }
        }
    }

    public class ViewTicketsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String message = "-----My Tickets-----\n";
            TicketController tc = new TicketController();
            ArrayList<Ticket> ticketList = tc.getTickets(username);
            for(int i = 0; i < ticketList.size(); i++) {
            	message += ticketList.get(i).toString();
            }
            homeFrame.printToTextArea(message);
        }
    }

    // TODO Trevor
    public class ViewTicketsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String message = "-----My Tickets-----\n";
            TicketController tc = new TicketController();
            ArrayList<Ticket> ticketList = tc.getTickets(loginFrame.usernameAnswer);
            for(int i = 0; i < ticketList.size(); i++) {
            	message += ticketList.get(i).toString();
            }
            homeFrame.printToTextArea(message);
        }
    }

    // TODO Trevor
    public class CancelTicketListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
        	
        	// is there a way to call the view tickets function without pressing the button? <-- make into a function
        	//could reuse the view tickets listener to fill the homeframe test area. 
        	 String message = "-----My Tickets-----\n";
             TicketController tc = new TicketController();
             ArrayList<Ticket> ticketList = tc.getTickets(loginFrame.usernameAnswer);
             for(int i = 0; i < ticketList.size(); i++) {
             	message += ticketList.get(i).toString();
             }
             
             homeFrame.printToTextArea(message);
        	
            
           //get user inputted ticket ID value from the input dialog box.
             int ticketId = Integer.parseInt(displayInputDialog("Enter the ticketId you would like to cancel: "));
          
             Ticket ticket = null; //temp ticket object set to null for error checking.
             
             //check the ticket list to see if the ids match. 
             for(Ticket t : ticketList) {
            	 if(t.getTicketId() == ticketId) {
            		 ticket = t;
            		 break;
            	 }
             }
             
            if(ticket == null) {
            	
            	//display error pane
            	JOptionPane.showMessageDialog(new JFrame(), "Error! Ticket not found.", "ERROR",
            	        JOptionPane.ERROR_MESSAGE);
            	return; //to avoid errors 
            }
         
            
            boolean isCancellable = ticket.validCancel(); //check if we can cancel 
            
            if(isCancellable == true) {
            	ticket.cancelTicket(loginFrame.usernameAnswer);
            	homeFrame.printToTextArea("Ticket " + ticketId + " successfully cancelled!");
            } else {
            	JOptionPane.showMessageDialog(new JFrame(), "Error. You may not cancel your ticket less than 72 hours before the movie.", "ERROR",
            	        JOptionPane.ERROR_MESSAGE);
            	
            	return; //unsure about return but following Noah logic with the return in other spots. 
            }
            
   
        }
    }

    public class ViewEmailListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String message = "-----My Emails-----\n";
            EmailController ec = new EmailController();
        	ArrayList<Email> emailList = ec.getEmails(username);
        	for(int i = 0; i < emailList.size(); i++) {
        		message += (emailList.get(i).getMessage() + "\n");
        	}
            homeFrame.printToTextArea(message);
        }
    }

    // TODO Madee
    public class PaySubscriptionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String payment = "$20.00";
            homeFrame.printToTextArea("Your outstanding payment is: " + payment);
            String confirmation = displayInputDialog("Enter 'Confirm' to purchase your membership: ");
            if(confirmation == null) return; // to prevent crash on cancel selection
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

    // TODO Noah
    public class RegisterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String selectedType = displayInputDialog("Enter 'RU' to become a Registered User or 'OU' to become an Ordinary User");
            if(selectedType == null) return;
            if(selectedType == "RU"){
                
                homeFrame.printToTextArea("You are now a Registered User. Logout and login to see the changes.");
            }
            else if(selectedType == "OU"){
                
                homeFrame.printToTextArea("You are now a Ordinary User. Logout and login to see the changes.");
            }
            else
                homeFrame.printToTextArea("Invalid entry... Try again!");
            
        }
    }

    public class SearchMovieListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
        	// make into a function (have to use in the purchase ticket)
        	String movie = displayInputDialog("Enter the name of a movie you would like to search for: ");
        	searchMovie(movie);
        }
    }
    
    private Movie searchMovie(String movie) {
    	MovieController mc = new MovieController();
        Movie m = mc.searchMovie(movie);
        String message = "-----Movie-----\n";
        if(m == null) {
        	message += "Sorry, movie entered is not available.";
        	homeFrame.printToTextArea(message);
        	return null;
        }
        else {
        	message += (movie.toString() + "\n");
        	message += "-----Showtimes-----\n";
        	ShowtimeController sc = new ShowtimeController();
        	ArrayList<Showtime> sList = sc.getShowtimesForMovie(m.getMovieId());
        	for(int i = 0; i < sList.size(); i++) {
        		message += (sList.get(i).toString() + "\n");
        	}
        }
        homeFrame.printToTextArea(message);
        return m;
    }

    public String displayInputDialog(String s) {
        return JOptionPane.showInputDialog(s);
    }

}
