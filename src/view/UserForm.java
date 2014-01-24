package view;

import helper.Praxi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.InsertTodb;
import model.Selections;
import controller.DbConnection;


public class UserForm extends JFrame {


	private static final long serialVersionUID = 1L;

	InsertTodb ins = new InsertTodb();
	DbConnection db = new DbConnection();

	JLabel welcome = new JLabel();
	JLabel systemDate = new JLabel();
	JLabel fieldset1 = new JLabel();
	JLabel fieldset2 = new JLabel();
	JLabel fieldset3 = new JLabel();
	JLabel id = new JLabel("0");
	

	//*****************************************************************
	JLabel lbEponimo = new JLabel("Επώνυμο:",SwingConstants.RIGHT);
	JTextField eponimo =new JTextField(100);
	JLabel lbOnoma = new JLabel("Όνομα:",SwingConstants.RIGHT);
	JTextField onoma =new JTextField(100);
	JLabel lbPatronimo = new JLabel("Πατρώνυμο:",SwingConstants.RIGHT);
	JTextField patronimo =new JTextField(100);
	JLabel lbAddress = new JLabel("Διεύθυνση:",SwingConstants.RIGHT);
	JTextField address =new JTextField(200);
	JLabel lbAdt = new JLabel("ΑΔΤ:",SwingConstants.RIGHT);
	JTextField adt =new JTextField(100);
	JLabel lbEkdousa = new JLabel("Εκ. Αρχή:",SwingConstants.RIGHT);
	JTextField ekdousa =new JTextField(100);
	JLabel lbPhone = new JLabel("Τηλέφωνο:",SwingConstants.RIGHT);
	JTextField phone =new JTextField(100);
	//*****************************************************************

	//*****************************************************************
	JLabel lbArPraxis = new JLabel("Αρ. Πράξης:",SwingConstants.RIGHT);
	JTextField arPraxis =new JTextField(100);
	JLabel lbDatep = new JLabel("Ημ. Πράξης:",SwingConstants.RIGHT);
	JTextField datep =new JTextField(100);
	JLabel lbSymv = new JLabel("Στοιχεία Εκδ. Αρχής / Συμβολαιογράφου:",SwingConstants.LEFT);
	JTextField symv =new JTextField(100);
	//*****************************************************************

	//*****************************************************************
	JLabel lbKaek = new JLabel("",SwingConstants.RIGHT);
	JTextField kaek =new JTextField(40);
	//*****************************************************************

	//*****************************************************************
	JButton eisagogi = new JButton("Καταχώρηση");
	JButton anazitisi = new JButton("Αναζήτηση");
	JButton metavoli = new JButton("Μεταβολή");
	JButton istoriko = new JButton("Ιστορικό");
	JButton katharismos = new JButton("Καθάρισμα");
	

	//*****************************************************************
	JPanel panel = new JPanel();
	Border blackline = BorderFactory.createLineBorder(Color.black);



	public UserForm(final String username){
		super("Πίνακας Ελέγχου Χρήστη");
		setSize(800,420);
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

		TitledBorder title;
		title = BorderFactory.createTitledBorder("Στοιχεία Αιτούντος");
		fieldset1.setBorder(title);
		fieldset1.setBounds(9, 40, 770, 100);
		panel.add(fieldset1);

		title = BorderFactory.createTitledBorder("Στοιχεία Πράξης");
		fieldset2.setBorder(title);
		fieldset2.setBounds(9, 150, 770, 100);
		panel.add(fieldset2);

		title = BorderFactory.createTitledBorder("Στοιχεία KAEK");
		fieldset3.setBorder(title);
		fieldset3.setBounds(9, 250, 770, 50);
		panel.add(fieldset3);

		/*
		 * Στοιχεία αιτούντος.
		 */
		lbEponimo.setBounds(10,61,80,20);
		panel.add(lbEponimo);
		eponimo.setBounds(91,61,150,20);
		panel.add(eponimo);

		lbOnoma.setBounds(242,61,80,20);
		panel.add(lbOnoma);
		onoma.setBounds(323,61,150,20);
		panel.add(onoma);

		lbPatronimo.setBounds(474,61,80,20);
		panel.add(lbPatronimo);
		patronimo.setBounds(555,61,150,20);
		panel.add(patronimo);

		lbAddress.setBounds(10,85,80,20);
		panel.add(lbAddress);
		address.setBounds(91,85,614,20);
		panel.add(address);

		lbAdt.setBounds(10,109,80,20);
		panel.add(lbAdt);
		adt.setBounds(91,109,150,20);
		panel.add(adt);

		lbEkdousa.setBounds(242,109,80,20);
		panel.add(lbEkdousa);
		ekdousa.setBounds(323,109,150,20);
		panel.add(ekdousa);

		lbPhone.setBounds(474,109,80,20);
		panel.add(lbPhone);
		phone.setBounds(555,109,150,20);
		panel.add(phone);

		//*******************************************************

		/*
		 * Στοιχεία Πράξης.
		 */

		lbArPraxis.setBounds(10,170,80,20);
		panel.add(lbArPraxis);
		arPraxis.setBounds(91,170,150,20);
		arPraxis.setBackground(new Color(255,255,0));
		panel.add(arPraxis);

		lbDatep.setBounds(242,170,80,20);
		panel.add(lbDatep);
		datep.setBounds(323,170,150,20);
		panel.add(datep);

		lbSymv.setBounds(20,201,230,20);
		panel.add(lbSymv);
		symv.setBounds(251,201,400,20);
		panel.add(symv);

		//*******************************************************
		/*
		 * Στοιχεία KAEK.
		 */

		lbKaek.setBounds(10,270,80,20);
		lbKaek.setText("ΚΑΕΚ:");
		panel.add(lbKaek);
		kaek.setBounds(91,270,150,20);
		kaek.setBackground(new Color(255,255,0));
		panel.add(kaek);
		
		id.setVisible(false);
		panel.add(id);

		eisagogi.setBounds(260, 270, 120, 20);
		panel.add(eisagogi);
		katharismos.setBounds(400, 270, 120, 20);
		panel.add(katharismos);

		eisagogi.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (id.getText().equals("0")){
				if (!validateFields()){
					JOptionPane.showMessageDialog(UserForm.this,
							"Πρέπει να συμπληρώσετε όλα τα πεδία",
							"Σφάλμα",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Praxi px = new Praxi();
						px.setEponimo(eponimo.getText());
						px.setOnoma(onoma.getText());
						px.setPatronimo(patronimo.getText());
						px.setAddress(address.getText());
						px.setAdt(adt.getText());
						px.setEkdarxi(ekdousa.getText());
						px.setPhone(phone.getText());
						px.setArpraxis(arPraxis.getText());
						px.setHmerominia(datep.getText());
						px.setSymvolaiografos(symv.getText());
						px.setKaek(kaek.getText());

						ins.insertPraxi(px);
						JOptionPane.showMessageDialog(UserForm.this,
								"Επιτυχής καταχώρηση",
								"Ενημέρωση",
								JOptionPane.INFORMATION_MESSAGE);
						clearFields();

					}
					catch (Exception ex){
						ex.printStackTrace();
					}
				}
			}
				else {
					JOptionPane.showMessageDialog(UserForm.this,
							"Η εγγραφή υπάρχει. Για αλλαγή πατήστε Μεταβολή.",
							"Ενημέρωση",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}

		} );
		
		metavoli.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (!id.getText().equals("0")){
				if (!validateFields()){
					JOptionPane.showMessageDialog(UserForm.this,
							"Πρέπει να συμπληρώσετε όλα τα πεδία",
							"Σφάλμα",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Praxi px = new Praxi();
						px.setEponimo(eponimo.getText());
						px.setOnoma(onoma.getText());
						px.setPatronimo(patronimo.getText());
						px.setAddress(address.getText());
						px.setAdt(adt.getText());
						px.setEkdarxi(ekdousa.getText());
						px.setPhone(phone.getText());
						px.setArpraxis(arPraxis.getText());
						px.setHmerominia(datep.getText());
						px.setSymvolaiografos(symv.getText());
						px.setKaek(kaek.getText());
						px.setId(Integer.parseInt(id.getText()));
						ins.updatePraxi(px);
						JOptionPane.showMessageDialog(UserForm.this,
								"Επιτυχής ενημέρωση εγγραφής",
								"Ενημέρωση",
								JOptionPane.INFORMATION_MESSAGE);
						clearFields();

					}
					catch (Exception ex){
						ex.printStackTrace();
					}
				}
			}
				else {
					JOptionPane.showMessageDialog(UserForm.this,
							"Η εγγραφή δεν υπάρχει. Πατήστε καταχώρηση για την εισαγωγή.",
							"Ενημέρωση",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}

		} );

		anazitisi.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (!(kaek.getText()==null) && !(arPraxis.getText()==null) && !kaek.getText().equals("") && !arPraxis.getText().equals("")){

					try {
						loadResults();
					} catch (ClassNotFoundException | SQLException | ParseException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(UserForm.this,
							"Πρέπει να συμπληρώσετε ΚΑΕΚ και αριθμό πράξης!",
							"Σφάλμα",
							JOptionPane.ERROR_MESSAGE);
				}
			}


		});

		istoriko.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(istoriko);
				Searchframe sfrm = new Searchframe(username, topFrame);
				sfrm.setVisible(true);
				setVisible(false);
			}
		});
		
		katharismos.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});

		//*******************************************************

		//*******************************************************
		/*
		 * Ενέργειες
		 */
		anazitisi.setBounds(10, 320, 120, 20);
		panel.add(anazitisi);
		metavoli.setBounds(140, 320, 120, 20);
		panel.add(metavoli);
		istoriko.setBounds(270, 320, 120, 20);
		panel.add(istoriko);


		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public boolean validateFields(){

		if (eponimo.getText().equals("") || eponimo.getText()==null){
			return false;
		}
		if (onoma.getText().equals("") || onoma.getText()==null){
			return false;
		}
		if (patronimo.getText().equals("") || patronimo.getText()==null){
			return false;
		}
		if (address.getText().equals("") || address.getText()==null){
			return false;
		}
		if (adt.getText().equals("") || adt.getText()==null){
			return false;
		}
		if (ekdousa.getText().equals("") || ekdousa.getText()==null){
			return false;
		}
		if (phone.getText().equals("") || phone.getText()==null){
			return false;
		}
		if (arPraxis.getText().equals("") || arPraxis.getText()==null){
			return false;
		}
		if (datep.getText().equals("") || datep.getText()==null){
			return false;
		}
		if (symv.getText().equals("") || symv.getText()==null){
			return false;
		}
		if (kaek.getText().equals("") || kaek.getText()==null){
			return false;
		}

		return true;
	}

	public void loadResults() throws ClassNotFoundException, SQLException, ParseException{

		Selections sl = new Selections();
		String s1 = arPraxis.getText();
		String s2 = kaek.getText();
		Praxi rs = sl.selectPraxi(s1, s2);

		if (rs.getId()!=0){
			id.setText(""+rs.getId());
			eponimo.setText(rs.getEponimo());
			onoma.setText(rs.getOnoma());
			patronimo.setText(rs.getPatronimo());
			address.setText(rs.getAddress());
			adt.setText(rs.getAdt());
			ekdousa.setText(rs.getEkdarxi());
			DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd"); 
			Date pdate = formatter.parse(rs.getHmerominia());
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			datep.setText(formatter.format(pdate).toString());
			symv.setText(rs.getSymvolaiografos());
			phone.setText(rs.getPhone());
		}
	}
	
	public void clearFields(){

		
			id.setText("0");
			eponimo.setText("");
			onoma.setText("");
			patronimo.setText("");
			address.setText("");
			adt.setText("");
			ekdousa.setText("");
			datep.setText("");
			symv.setText("");
			phone.setText("");
			kaek.setText("");
			arPraxis.setText("");
	}

}
