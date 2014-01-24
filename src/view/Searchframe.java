package view;

import helper.Praxi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.InsertTodb;
import model.Selections;
import controller.DbConnection;


public class Searchframe extends JFrame {


	private static final long serialVersionUID = 1L;

	InsertTodb ins = new InsertTodb();
	DbConnection db = new DbConnection();

	JLabel welcome = new JLabel();
	JLabel systemDate = new JLabel();
	JLabel fieldset1 = new JLabel();
	JLabel fieldset2 = new JLabel();


	//*****************************************************************
	JLabel lbArPraxis = new JLabel("Αρ. Πράξης:",SwingConstants.RIGHT);
	JTextField arPraxis =new JTextField(100);
	JLabel lbSymv = new JLabel("Στοιχεία Εκδ. Αρχής / Συμβολαιογράφου:",SwingConstants.LEFT);
	JTextField symv =new JTextField(100);
	//*****************************************************************

	//*****************************************************************
	JLabel lbKaek = new JLabel("",SwingConstants.RIGHT);
	JTextField kaek =new JTextField(40);
	//*****************************************************************

	//*****************************************************************

	JButton anazitisi = new JButton("Αναζήτηση");
	JButton back = new JButton("Επιστροφή");


	//*****************************************************************
	JPanel panel = new JPanel();
	JTable table = new JTable();
	JScrollPane sPane = new JScrollPane();

	Border blackline = BorderFactory.createLineBorder(Color.black);



	public Searchframe(String username, final JFrame pFrame){
		super("Πίνακας Ελέγχου Χρήστη - Ιστορικό Μεταβολών");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,350);
		setLocation(500,280);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		panel1.setLayout (null);
		panel2.setLayout (null);

		panel1.setBounds(5,5,770,110);
		sPane.setBounds(5,120,770,120);
		panel2.setBounds(5, 250, 770, 40);

		panel.add(panel1);
		panel.add(sPane);
		panel.add(panel2);


		welcome.setBounds(0,0,150,20);
		welcome.setText("Χρήστης: "+username);
		panel1.add(welcome);

		Calendar cal = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		systemDate.setText("Ημερομηνία: "+formatter.format(cal.getTime()).toString());
		systemDate.setBounds(160,0,150,20);
		panel1.add(systemDate);

		TitledBorder title;
		title = BorderFactory.createTitledBorder("Στοιχεία Αναζήτησης");
		fieldset1.setBorder(title);
		fieldset1.setBounds(9, 20, 600, 90);
		panel1.add(fieldset1);


		//*******************************************************
		/*
		 * Στοιχεία Αναζήτησης.
		 */

		lbKaek.setBounds(10,61,80,20);
		lbKaek.setText("ΚΑΕΚ:");
		panel1.add(lbKaek);
		kaek.setBounds(91,61,150,20);
		kaek.setBackground(new Color(255,255,0));
		panel1.add(kaek);

		anazitisi.setBounds(340, 61, 120, 20);
		panel1.add(anazitisi);

		anazitisi.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (!(kaek.getText()==null) && !kaek.getText().equals("")){
					Selections sl = new Selections();
					try {
						List<Praxi> lista = sl.selectMetavoles(kaek.getText());
						if (!lista.isEmpty()){
							showResults(lista);
						}
						else {
							JOptionPane.showMessageDialog(Searchframe.this,
									"Δεν βρέθηκαν εγγραφές",
									"Ενημέρωση",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(Searchframe.this,
							"Πρέπει να συμπληρώσετε τον ΚΑΕΚ.",
							"Σφάλμα",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		//*******************************************************
		/*
		 * Ενέργειες
		 */
		back.setBounds(600, 10, 120, 20);
		panel2.add(back);

		back.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				pFrame.setVisible(true);
				setVisible(false);
			}


		});

		//*******************************************************

	}

	public void showResults(List<Praxi> lista){
		int i=1;
		
		Iterator<Praxi> it = lista.iterator();
		String header[] = new String[]{"Επώνυμο", "Όνομα", "Πατρώνυμο", "Αρ. Πράξης", "Ημερομηνία","Συμβολαιογράφος"};
		Object[][] data={{null,null,null,null,null,null}};
		DefaultTableModel mymodel = new DefaultTableModel(data,header);
		//mymodel.setColumnIdentifiers(header);
		table.setModel(mymodel);
		table.invalidate();
		while (it.hasNext()){
			Praxi px = new Praxi();
			px  = it.next();
			mymodel.insertRow(mymodel.getRowCount(), data);
			mymodel.setValueAt(px.getEponimo(),i,0);
			mymodel.setValueAt(px.getOnoma(),i,1);
			mymodel.setValueAt(px.getPatronimo(),i,2);
			mymodel.setValueAt(px.getArpraxis(),i,3);
			mymodel.setValueAt(px.getHmerominia(),i,4);
			mymodel.setValueAt(px.getSymvolaiografos(),i,5);
			i++;		
		}
		mymodel.fireTableDataChanged();
		sPane.setColumnHeaderView(table.getTableHeader());
	}


}
