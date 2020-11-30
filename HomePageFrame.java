package main.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Page used as homepage for all users. This is the page with most GUI functionality
 */
public class HomePageFrame extends JFrame{
	private JPanel mainPanel, buttonPanel, buttonPanel2;
	private JButton registerGuest =new JButton("Register now!");
	private JButton viewMovies  = new JButton("View all movies");
	private JButton searchMovies = new JButton("Search movie");
	private JButton purchaseTicket  = new JButton("Purchase ticket");
	private JButton viewTickets = new JButton("View my tickets");
	private JButton cancelTicket= new JButton("Cancel ticket");
	private JButton viewEmail= new JButton("View my emails");
	private JButton paySubscription = new JButton("Pay subscription");
	private JButton logoutButton = new JButton("Logout");
	private JLabel welcome;
	//JFrame frame;
	private JLabel message = new JLabel("Please choose an option below:       ");
	private JScrollPane scrollArea;
	private JTextArea displayArea;
	private String username;
	private BorderLayout layout;
	private String userType;

	/*
	 * Constructor
	 * @param s Frame name
	 * @param u username of user
	 * @param type type of user
	 */
	public HomePageFrame (String s, String u, String type){
		super(s);
		username = u;
		userType = type;

		String temp = "Welcome to your Homepage " + username + "!       ";
		welcome = new JLabel(temp);
		welcome.setAlignmentX(CENTER_ALIGNMENT);

		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(welcome);


		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		message.setAlignmentX(CENTER_ALIGNMENT);
		if(userType == "G"){
			registerGuest.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		searchMovies.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewMovies.setAlignmentX(Component.CENTER_ALIGNMENT);
		purchaseTicket.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelTicket.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewTickets.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
		paySubscription.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		buttonPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		buttonPanel.add(message);
		if(userType == "G"){
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			buttonPanel.add(registerGuest);
		}

		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(searchMovies);
		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(viewMovies);
		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(purchaseTicket);
		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(cancelTicket);
		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(viewTickets);
		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(viewEmail);
		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(paySubscription);
		buttonPanel.add(Box.createRigidArea(new Dimension(20, 10)));
		buttonPanel.add(logoutButton);

		//mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		//        buttonPanel2= new JPanel();
		//        buttonPanel2.add(Box.createRigidArea(new Dimension(300, 30)));
		//        buttonPanel2.add(logoutButton);
		//        
		displayArea = new JTextArea(10,80);
		scrollArea = new JScrollPane(displayArea);
		scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		displayArea.setEditable(false);
		// displayArea.setVisible(true);
		scrollArea.setVisible(true);

		//addComponents();
//		frame=new JFrame();
//		frame.add(scrollArea);
//		frame.setVisible(true);

		add(mainPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
//		 add(frame, BorderLayout.CENTER);
		// add(buttonPanel2, BorderLayout.PAGE_END);
		//add(displayArea, BorderLayout.CENTER);
		add(scrollArea, BorderLayout.EAST);

		//setContentPane(mainPanel);
		pack();
		setVisible(true);

		// setDefaultLookAndFeelDecorated(true);
	}


	/*
	 * Once buttons are created, their actionListeners are linked
	 * @param movies view movies listener
	 * @param ticket purchase ticket listener
	 * @param tickets user tickets listener
	 * @param cancel cancel button listener
	 * @param emails email button listener
	 * @param pay pay subscription button listener
	 * @param quit logout button listener
	 * @param searchM search movie listener
	 * @param register register user for guest - button listener
	 */
	public void addActionListeners(GUIController.ViewMoviesListener movies, GUIController.PurchaseTicketListener ticket, 
			GUIController.ViewTicketsListener tickets, GUIController.CancelTicketListener cancel,
			GUIController.ViewEmailListener emails, GUIController.PaySubscriptionListener pay,
			GUIController.QuitListener quit, GUIController.SearchMovieListener searchM,
			GUIController.RegisterListener register){
		if(userType == "G")
			registerGuest.addActionListener(register);

		searchMovies.addActionListener(searchM);
		viewMovies.addActionListener(movies);
		purchaseTicket.addActionListener(ticket);
		viewTickets.addActionListener(tickets);
		cancelTicket.addActionListener(cancel);
		viewEmail.addActionListener(emails);
		paySubscription.addActionListener(pay);
		logoutButton.addActionListener(quit);
	}

	/*
	 * Prints argument to text area in GUI
	 * @param s message to print
	 */
	public void printToTextArea(String s){
		//frame.repaint();
//		if(s==null)
//			displayArea.setText(null);
//		else {
			displayArea = new JTextArea(s);
			scrollArea = new JScrollPane(displayArea);
//		}
		//displayArea.setText(null);
		// displayArea.setText(s);
	}
}
