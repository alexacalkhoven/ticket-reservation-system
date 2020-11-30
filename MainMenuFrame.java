package Client.ClientView;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * 
 * @author Madisson Carle
 * @author Minh Vo
 * @author Rubaiyet Meem
 * @since April 17, 2020
 * @version 2.0
 * What the user sees after they log into the program. 
 */
public class MainMenuFrame extends JFrame{
	//declaring buttons and label
	/**
	 * Greeting label.
	 */
	private JLabel greeting = new JLabel("Hello, ...");
	/**
	 * Exit program button.
	 */
	private JButton quit = new JButton("Quit");
	/**
	 * Search for course button.
	 */
	private JButton search = new JButton("Find A Course");
	/**
	 * Withdraw from course button.
	 */
	private JButton remove = new JButton("Withdraw From Course");
	/**
	 * View all courses button.
	 */
	private JButton view = new JButton("View All Courses");
	/**
	 * Enroll button.
	 */
	private JButton enroll = new JButton("Enroll In Course");
	/**
	 * Student profile button.
	 */
	private JButton profile = new JButton ("Your Courses");
	/**
	 * Lobout button.
	 */
	private JButton logout = new JButton("Log Out");
	
	/**
	 * BorderLayout frame that contains all main menu buttons.
	 */
	public MainMenuFrame() {
		//create GUI with title
		super("Registration");
		
		//set size and layout 
		setSize (400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//dividing the window into 3 panels
		//panel for greeting and profile 
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(greeting,BorderLayout.WEST);
		panel1.add(profile, BorderLayout.EAST);
		
		//panel to group buttons scroll-bar
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		
	    search.setAlignmentX(Component.CENTER_ALIGNMENT);
	    view.setAlignmentX(Component.CENTER_ALIGNMENT);
	    remove.setAlignmentX(Component.CENTER_ALIGNMENT);
	    enroll.setAlignmentX(Component.CENTER_ALIGNMENT);
	    panel2.add(Box.createRigidArea(new Dimension(300, 30)));
		panel2.add(search);
		panel2.add(Box.createRigidArea(new Dimension(300, 30)));
		panel2.add(remove);
		panel2.add(Box.createRigidArea(new Dimension(300, 30)));
		panel2.add(view);
		panel2.add(Box.createRigidArea(new Dimension(300, 30)));
		panel2.add(enroll);
		panel2.add(Box.createRigidArea(new Dimension(300, 30)));
		
		//panel to group buttons 
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.add(quit,BorderLayout.EAST);
		panel3.add(logout,BorderLayout.WEST);
		
		//adding panels to frame
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		pack();
		//setVisible(true);
	}
	
	/**
	 * Add an action listener for quit button
	 * @param a Action Listener
	 */
	public void addQuitListener(ActionListener a) {
		this.quit.addActionListener(a);
	}
	
	/**
	 * Add an action listener for enroll button.
	 * @param a Action Listener
	 */
	public void addEnrollListener(ActionListener a) {
		this.enroll.addActionListener(a);
	}
	
	/**
	 * Add an action listener for profile button
	 * @param a Action Listener
	 */
	public void addProfileListener(ActionListener a) {
		this.profile.addActionListener(a);
	}
	
	/**
	 * Add an action listener for view button.
	 * @param a
	 */
	public void addViewListener(ActionListener a) {
		this.view.addActionListener(a);
	}
	/**
	 * Add an action listener for remove button.
	 * @param a Action Listener
	 */
	public void addRemoveListener(ActionListener a) {
		this.remove.addActionListener(a);
	}
	
	/**
	 * Add an action listener for search button.
	 * @param a Action Listener
	 */
	public void addSearchListener(ActionListener a) {
		this.search.addActionListener(a);
	} 
	
	/**
	 * Add an action listener for search button.
	 * @param a Action Listener
	 */
	public void addLogoutListener(ActionListener a) {
		this.logout.addActionListener(a);
	} 	
	
	/**
	 * Set greetings to text.
	 * @param text The user name.
	 */
	public void setGreeting(String text) {
		greeting.setText("Hello, " + text + " !");;
	}

	/**
	 * Gets state of quit button.
	 * @return The state.
	 */
	public JButton getQuit() {
		return this.quit;
	}
	/**
	 * Gets state of search button.
	 * @return The state.
	 */
	public JButton getSearch() {
		return this.search;
	}
	/**
	 * Gets state of logout button.
	 * @return The state.
	 */
	public JButton getLogout() {
		return this.logout;
	}
	/**
	 * Gets state of remove button.
	 * @return The state.
	 */
	public JButton getRemove() {
		return this.remove;
	}
	/**
	 * Gets state of enroll button.
	 * @return The state.
	 */
	public JButton getEnroll() {
		return this.enroll;
	}
	/**
	 * Gets state of view button.
	 * @return The state.
	 */
	public JButton getView() {
		return this.view;
	}
	/**
	 * Gets state of profile button.
	 * @return The state.
	 */
	public JButton getProfile() {
		return this.profile;
	} 
	
}
