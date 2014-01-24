package view;

import javax.swing.*;
 
public class MainFrame extends JFrame{
   
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame();
                LoginDialog loginDlg = new LoginDialog(frame);
                loginDlg.setVisible(true);
                if(loginDlg.isSucceeded()){
                	if ("user".equals(loginDlg.getUsername())){
                		UserForm uFrm = new UserForm(loginDlg.getUsername());
                		uFrm.setVisible(true);
                	}
                	else {
                		AdminFrame aFrm = new AdminFrame(loginDlg.getUsername());
                		aFrm.setVisible(true);
                	}
                }
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
       
    }
}