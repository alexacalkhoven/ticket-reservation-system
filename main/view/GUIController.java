package Client.ClientController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.ClientView.*;


/**
 * The controller for GUI 
 * @author 
 *
 */
public class GUIController {
	private MainMenuFrame menuFrame;
	//private ClientModel;
	private SearchFrame searchFrame;
	private ProfileFrame profileFrame;
	private AddCourseFrame addFrame;
	private RemoveCourseFrame removeFrame;
	private CatalogueFrame cataFrame;
	private ClientController control;
	private LogInFrame loginFrame;
	private MessageFrame messageFrame;
	
	public GUIController(MainMenuFrame menuFrame,SearchFrame searchFrame,
			ProfileFrame profileFrame,AddCourseFrame addFrame,
			RemoveCourseFrame removeFrame,CatalogueFrame cataFrame, ClientController control, 
			LogInFrame login,MessageFrame message) {
		//setting main frame and listeners
		setMenuFrame(menuFrame);
		getMenuFrame().addQuitListener(new MainListener(getMenuFrame()));
		getMenuFrame().addViewListener(new MainListener(getMenuFrame()));
		getMenuFrame().addEnrollListener(new MainListener(getMenuFrame()));
		getMenuFrame().addRemoveListener(new MainListener(getMenuFrame()));
		getMenuFrame().addProfileListener(new MainListener(getMenuFrame()));
		getMenuFrame().addSearchListener(new MainListener(getMenuFrame()));
		getMenuFrame().addLogoutListener(new MainListener(getMenuFrame()));
		
		//setting search frame and listeners
		setSearchFrame(searchFrame);
		getSearchFrame().addBackListener(new SearchListener(getSearchFrame()));
		getSearchFrame().addFindListener(new SearchListener(getSearchFrame()));
		
		//setting add frame and listeners
		setAddFrame(addFrame);
		getAddFrame().addBackListener(new AddListener(getAddFrame()));
		getAddFrame().addEnrollListener(new AddListener(getAddFrame()));
		
		//setting remove and listeners
		setRemoveFrame(removeFrame);
		getRemoveFrame().addBackListener(new WithdrawListener(getRemoveFrame()));
		getRemoveFrame().addWithdrawListener(new WithdrawListener(getRemoveFrame()));
		
		//setting profile and listeners
		setProfileFrame(profileFrame);
		getProfileFrame().addBackListener(new ProfileListener(getProfileFrame()));
		
		//setting catalogue view and listeners
		setCataFrame(cataFrame);
		getCataFrame().addDoneListener(new CatalogueListener(getCataFrame()));
		
		//setting log-in view and listeners
		setLoginFrame(login);
		getLoginFrame().addQuitListener(new LoginListener(getLoginFrame()));
		getLoginFrame().addLoginListener(new LoginListener(getLoginFrame()));
		
		setMessageFrame(message);
		getMessageFrame().addDoneListener(new MessageListener(getMessageFrame()));
		
		setControl(control);
	}
	
	class LoginListener implements ActionListener {
		private LogInFrame login;
		
		public LoginListener(LogInFrame adsf) {
			login = adsf;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == login.getQuit()) {
				getLoginFrame().resetText();
				getLoginFrame().dispose();
			}
			else if(e.getSource() == login.getLogin()) {
				getControl().setDataFromGUI("login" + getLoginFrame().infoToString());
				String result = "";
				while(result.equals("")) {
					System.out.println(result + "bbbb");
					result = getControl().getToSend();
				}
				System.out.println(result);
				String [] info = result.replaceAll("[^0-9a-zA-Z ]", " ").split("\\s+");
				getProfileFrame().setInfo(info[0],info[1]+" "+info[2],info[3],info[4]);
				getMenuFrame().setGreeting(info[1]+" "+info[2]);
				getMenuFrame().setVisible(true);
				getLoginFrame().resetPass();
				getLoginFrame().dispose();
			}
			getControl().resetSend();
			
		}
		
	}
	
	class ProfileListener implements ActionListener {
		private ProfileFrame profile;
		
		public ProfileListener(ProfileFrame c) {
			profile = c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == profile.getBack()) {
				System.out.println("Profile done");
				profile.resetDisplay();
				profile.dispose();
			}
		}
	}
	
	class CatalogueListener implements ActionListener{
		private CatalogueFrame cata;
		
		public CatalogueListener(CatalogueFrame c) {
			cata = c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== cata.getDone()) {
				System.out.println("Cata done");
				getCataFrame().resetDisplay();
				getCataFrame().dispose();
			}
		}
	}
	
	class WithdrawListener implements ActionListener{
		private RemoveCourseFrame remove;
		
		public WithdrawListener(RemoveCourseFrame r) {
			remove = r;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== remove.getBack()) {
				System.out.println("remove back");
				getRemoveFrame().resetText();
				getRemoveFrame().dispose();
			}
			else if(e.getSource() == remove.getWithdraw()) {
				System.out.println("remove withdraw");
				getControl().setDataFromGUI("removeC" + getRemoveFrame().infoToString());
				String result ="";
				while(result.equals("")) {
					System.out.println(result + "cccc");
					result = getControl().getToSend();
				}
				if(result.equals("done" + "\n"))
					getRemoveFrame().displaySuccessMessage();
				else if(result.equals("noEnroll" + "\n"))
					getRemoveFrame().displayDNEMessage();
				else if(result.equals("DNE" + "\n"))
					getRemoveFrame().displayNotEnrolledMessage();
				else if(result.equals("invalidInput"+"\n")) 
					getRemoveFrame().displayInvalidInputMessage();
				
				getControl().resetSend();
			}
		}
	}
	
	class AddListener implements ActionListener{
		private AddCourseFrame add;
		
		public AddListener(AddCourseFrame a) {
			add = a;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==add.getBack()) {
				System.out.println("add back");
				getAddFrame().resetText();
				getAddFrame().dispose();
			}
			else if(e.getSource() == add.getEnroll()) {
				System.out.println("add enroll");
				getControl().setDataFromGUI("addC" + getAddFrame().infoToString());
				String result ="";
				while(result.equals("")) {
					System.out.println(result + "dddd");
					result = getControl().getToSend();
				}
				System.out.println(result + "aaa");
				if(result.equals("done" + "\n"))
					getAddFrame().displaySuccessMessage();
				else if(result.equals("6" + "\n"))
					getAddFrame().displayErrorMaxMessage();
				else if(result.equals("DNE" + "\n"))
					getAddFrame().displayDNEMessage();
				else if(result.equals("waitlist" + "\n"))
					getAddFrame().displayWaitlistMessage();
				else if(result.equals("invalidInput"+"\n")) 
					getAddFrame().displayInvalidInputMessage();
				else if(result.equals("added"+"\n")) 
					getAddFrame().displayAddedMessage();
				getControl().resetSend();
			}
		}
	}
	
	class MessageListener implements ActionListener{
		private MessageFrame m;
		
		public MessageListener(MessageFrame fr) {
			m = fr;
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			if(ae.getSource() == m.getDone()) {
				getMessageFrame().dispose();
				getMessageFrame().resetDisplay();
			}
		}
		
	}
	
	class SearchListener implements ActionListener{
		private SearchFrame search;
		
		public SearchListener(SearchFrame s) {
			search = s;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==search.getBack()) {
				System.out.println("search back");
				getSearchFrame().resetText();
				getSearchFrame().dispose();
			}
			else if(e.getSource() == search.getFind()) {
				System.out.println("search find");
				getControl().setDataFromGUI("cata" + getSearchFrame().infoToString());
				String result ="";
				while(!result.contains("\0"))
					result = getControl().getToSend();
				if(result.equals("DNE" + "\n"))
					getSearchFrame().displayDNEMessage();
				else if(result.equals("invalidInput"+"\n")) 
					getSearchFrame().displayInvalidInputMessage();
				
				else {
					getMessageFrame().printCourses(result);
					getMessageFrame().setVisible(true);
				}
				getControl().resetSend();
			}
		}
	}
	
	class MainListener implements ActionListener {
		private MainMenuFrame main;
		
		public MainListener(MainMenuFrame m) {
			main = m;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==main.getQuit()) {
				System.out.println("main quit");
				getControl().setDataFromGUI("quit");
				main.dispose();
			}
			else if(e.getSource() == main.getView()) {
				System.out.println("main view");
				getControl().setDataFromGUI("printCat");
				String result ="";
				while(!result.contains("\0"))
					result = getControl().getToSend();
				/*
				for(int i = 0; i < 1000; i++) {
					i++;
				}
				*/
				getCataFrame().setVisible(true);
				getCataFrame().printCourses(getControl().getToSend());
				getControl().resetSend();
			}
			else if(e.getSource() == main.getEnroll()) {
				System.out.println("main enroll");
				getAddFrame().setVisible(true);
			}
			else if(e.getSource() == main.getSearch()) {
				System.out.println("main search");
				getSearchFrame().setVisible(true);
			}
			else if(e.getSource() == main.getRemove()) {
				System.out.println("main remove");
				getRemoveFrame().setVisible(true);
			}
			else if(e.getSource() == main.getProfile()) {
				System.out.println("main profile");
				getControl().setDataFromGUI("printStud");
				String result = "";
				while(!result.contains("\0"))
					result = getControl().getToSend();
				getProfileFrame().setVisible(true);
				getProfileFrame().printCourses(getControl().getToSend());
				getControl().resetSend();
				
			}
			else if(e.getSource() == main.getLogout()) {
				getMenuFrame().dispose();
				getLoginFrame().setVisible(true);
				
			}
		}
		
	}
	
	public MainMenuFrame getMenuFrame() {
		return menuFrame;
	}
	public void setMenuFrame(MainMenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	public SearchFrame getSearchFrame() {
		return searchFrame;
	}
	public void setSearchFrame(SearchFrame searchFrame) {
		this.searchFrame = searchFrame;
	}
	public ProfileFrame getProfileFrame() {
		return profileFrame;
	}
	public void setProfileFrame(ProfileFrame profileFrame) {
		this.profileFrame = profileFrame;
	}
	public RemoveCourseFrame getRemoveFrame() {
		return removeFrame;
	}
	public void setRemoveFrame(RemoveCourseFrame removeFrame) {
		this.removeFrame = removeFrame;
	}
	public AddCourseFrame getAddFrame() {
		return addFrame;
	}
	public void setAddFrame(AddCourseFrame addFrame) {
		this.addFrame = addFrame;
	}
	public CatalogueFrame getCataFrame() {
		return cataFrame;
	}
	public void setCataFrame(CatalogueFrame cataFrame) {
		this.cataFrame = cataFrame;
	}

	public ClientController getControl() {
		return control;
	}

	public void setControl(ClientController control) {
		this.control = control;
	}
	public LogInFrame getLoginFrame() {
		return loginFrame;
	}
	public void setLoginFrame(LogInFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public MessageFrame getMessageFrame() {
		return messageFrame;
	}
	public void setMessageFrame(MessageFrame messageFrame) {
		this.messageFrame = messageFrame;
	}

}
