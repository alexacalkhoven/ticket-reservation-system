package main.view;
import resources.SampleData;

class TicketApp {

    public static void main(String[] args){
    	SampleData.addSampleData();
        MainFrame frame = new MainFrame("Ticket Reservation System");
        GUIController guiController = new GUIController(frame);
    }

}