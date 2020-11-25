import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController {
    private MainFrame frame;
    private DataCommunicator communicator;

    public GUIController (MainFrame f){
        frame = f;

        initialLogin();
    }

    private void initialLogin(){

    }

    public class LoginGuestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    public class LoginOUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    public class LoginRUListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
}
