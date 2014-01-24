package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;

import controller.DoLogin;
 
public class LoginDialog extends JDialog {
 
    
	private static final long serialVersionUID = 1L;
	private JTextField username;
    private JPasswordField password;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
    
    DoLogin dl = new DoLogin();
 
    public LoginDialog(Frame parent) {
        super(parent, "Είσοδος στην εφαρμογή", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Όνομα Χρήστη: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        username = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(username, cs);
 
        lbPassword = new JLabel("Κωδικός Πρόσβασης: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        password = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(password, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnLogin = new JButton("Είσοδος");
 
        btnLogin.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                try {
					if (dl.authenticate(getUsername(), getPassword())) {
					    succeeded = true;
					    dispose();
					} else {
					    JOptionPane.showMessageDialog(LoginDialog.this,
					            "Λάθος Όνομα Χρήστη/Κωδικός Πρόσβασης",
					            "Σφάλμα",
					            JOptionPane.ERROR_MESSAGE);
					    // reset username and password
					    username.setText("");
					    password.setText("");
					    succeeded = false;
 
					}
				} catch (HeadlessException | ClassNotFoundException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btnCancel = new JButton("’κυρο");
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
 
    public String getUsername() {
        return username.getText().trim();
    }
 
    public String getPassword() {
        return new String(password.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
}