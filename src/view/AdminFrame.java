package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.InsertTodb;
import controller.DbConnection;


public class AdminFrame extends JFrame {


	private static final long serialVersionUID = 1L;

	InsertTodb ins = new InsertTodb();
	DbConnection db = new DbConnection();

	JLabel welcome = new JLabel();
	JLabel systemDate = new JLabel();

	//*****************************************************************
	JButton statistics = new JButton("Στατιστικά Στοιχεία");
	JButton manageUsers = new JButton("Διαχείριση Χρηστών");
	//*****************************************************************

	JPanel panel = new JPanel();
	Border blackline = BorderFactory.createLineBorder(Color.black);


	public AdminFrame(String username){
		super("Πίνακας Ελέγχου Διαχειριστή");
		setSize(420,420);
		setLocation(500,280);
		panel.setLayout (null);

		welcome.setBounds(0,0,150,40);
		welcome.setText("Χρήστης: "+username);
		panel.add(welcome);

		Calendar cal = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		systemDate.setText("Ημερομηνία: "+formatter.format(cal.getTime()).toString());
		systemDate.setBounds(160,0,150,40);
		panel.add(systemDate);

		//*******************************************************
		/*
		 * Ενέργειες
		 */
		statistics.setBounds(10, 320, 170, 20);
		panel.add(statistics);
		manageUsers.setBounds(190, 320, 170, 20);
		panel.add(manageUsers);

		statistics.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				JOptionPane.showMessageDialog(AdminFrame.this,
								"Γίνεται εκτύπωση στατιστικών",
								"Ενημέρωση",
								JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		manageUsers.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				JOptionPane.showMessageDialog(AdminFrame.this,
								"’νοιγμα φόρμας διαχείρισης χρηστών εφαρμογής",
								"Ενημέρωση",
								JOptionPane.INFORMATION_MESSAGE);
			}
		});
		//*******************************************************
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
