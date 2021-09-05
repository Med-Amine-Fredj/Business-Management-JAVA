package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DataBase.DataBaseConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.SpinnerNumberModel;

public class AjouterClient {

	public JFrame frame;
	private JTextField codeclient;
	private JTextField matriculefiscale;
	private JTextField nom;
	private JTextField prenom;
	private JTextField banque;
	private JTextField agence;
	private JTextField mail;
	private JTextField siteweb;
	private JTextField lrue1;
	private JTextField nville;
	private JTextField gouv;
	private JTextField pays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterClient window = new AjouterClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AjouterClient() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
	  	DataBaseConnection.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-commerciales","root","");
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Ajouter Client - Fredj Med Amine ");
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAjouterProduit = new JLabel("AJOUTER CLIENT");
		lblAjouterProduit.setFont(new Font("OCR A Extended", lblAjouterProduit.getFont().getStyle() | Font.BOLD, 45));
		lblAjouterProduit.setForeground(new Color(255, 255, 204));
		lblAjouterProduit.setBounds(415, 0, 414, 54);
		frame.getContentPane().add(lblAjouterProduit);
		
		JLabel lblNewLabel = new JLabel("Code Client :");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(33, 59, 103, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code Produit Existe D\u00E9j\u00E0 ou Champ Vide!!!");
		lblNewLabel_1.setVisible(false);
		
		JSpinner cin1 = new JSpinner();
		
		String type1[]={"Etat Physique","Etat Morale"};
		JComboBox type = new JComboBox(type1);
		
		JSpinner telm = new JSpinner();
		
		JSpinner telfixe = new JSpinner();
		
		JSpinner fax = new JSpinner();
		
		String comboBox1[]={"ASSUJITI","TVA"};
		JComboBox etat = new JComboBox(comboBox1);
		
		JSpinner numr = new JSpinner();
		numr.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		JSpinner cp = new JSpinner();
		cp.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		JSpinner rib = new JSpinner();
		rib.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					stmt.executeUpdate("INSERT INTO `client`(`codeclient`, `matriculefiscale`, `nom`, `prenom`, `cin`, `type`, `telmobile`, `telfixe`, `fax`, `email`, `siteweb`, `etatfiscale`) VALUES ("
							+ "'"+codeclient.getText()+"',"
							+ "'"+matriculefiscale.getText()+"',"
							+ "'"+nom.getText()+"',"
							+ "'"+prenom.getText()+"',"
							+ ""+cin1.getValue()+","
							+ "'"+type.getSelectedItem().toString()+"',"
							+ ""+telm.getValue()+","
							+ ""+telfixe.getValue()+","
							+ ""+fax.getValue()+","
							+ "'"+mail.getText()+"',"
							+ "'"+siteweb.getText()+"',"
							+ "'"+etat.getSelectedItem().toString()+ "')");
					
					stmt.executeUpdate("INSERT INTO `adresse`(`numrue`, `libellerue`, `nomville`, `codepostale`, `gouvernerat`, `pays`, `codeclient`) VALUES ("
							+ ""+numr.getValue()+","
							+ "'"+lrue1.getText()+"',"
							+ "'"+nville.getText()+"',"
							+ ""+cp.getValue()+","
							+ "'"+gouv.getText()+"',"
							+ "'"+pays.getText()+"',"
							+ "'"+codeclient.getText()+ "')");
					
					stmt.executeUpdate("INSERT INTO `cartebancaire`(`banque`, `agence`, `rib`, `codeclient`) VALUES ("
							+ "'"+banque.getText()+"',"
							+ "'"+agence.getText()+"',"
							+ ""+rib.getValue()+","
							+ "'"+codeclient.getText()+"')");
									
					JOptionPane.showInternalMessageDialog(null, "Done!!!!");
					
					try {
						GestionClients gc = new GestionClients();
						frame.dispose();
						gc.frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setEnabled(false);
		
		codeclient = new JTextField();
		codeclient.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Statement stmt;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM client");
					ArrayList<String> test= new ArrayList<String>();
					while(rs.next()) {
						test.add(rs.getString("codeclient").toUpperCase());
						
					}
					if(test.contains(codeclient.getText().toUpperCase()) || codeclient.getText().isEmpty()) {
						lblNewLabel_1.setVisible(true);
						btnNewButton.setEnabled(false);
						
					} else {
						lblNewLabel_1.setVisible(false);
						btnNewButton.setEnabled(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		codeclient.setBounds(156, 59, 260, 39);
		frame.getContentPane().add(codeclient);
		codeclient.setColumns(10);
		
		matriculefiscale = new JTextField();
		matriculefiscale.setColumns(10);
		matriculefiscale.setBounds(156, 108, 260, 39);
		frame.getContentPane().add(matriculefiscale);
		
		JLabel lblMatriculeFiscale = new JLabel("Matricule Fiscale :");
		lblMatriculeFiscale.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblMatriculeFiscale.setForeground(new Color(255, 255, 255));
		lblMatriculeFiscale.setBounds(33, 109, 118, 39);
		frame.getContentPane().add(lblMatriculeFiscale);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(156, 158, 260, 39);
		frame.getContentPane().add(nom);
		
		JLabel lblNom = new JLabel("Nom Client :");
		lblNom.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNom.setForeground(new Color(255, 255, 255));
		lblNom.setBounds(33, 158, 105, 39);
		frame.getContentPane().add(lblNom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(156, 207, 260, 39);
		frame.getContentPane().add(prenom);
		
		JLabel lblPrnomClient = new JLabel("Pr\u00E9nom Client :");
		lblPrnomClient.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblPrnomClient.setForeground(new Color(255, 255, 255));
		lblPrnomClient.setBounds(33, 207, 143, 39);
		frame.getContentPane().add(lblPrnomClient);
		
		banque = new JTextField();
		banque.setColumns(10);
		banque.setBounds(805, 355, 260, 39);
		frame.getContentPane().add(banque);
		
		JLabel lblNewLabel_4 = new JLabel("Banque :");
		lblNewLabel_4.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(682, 355, 143, 39);
		frame.getContentPane().add(lblNewLabel_4);
		
		agence = new JTextField();
		agence.setColumns(10);
		agence.setBounds(805, 404, 260, 39);
		frame.getContentPane().add(agence);
		
		JLabel lblNewLabel_5 = new JLabel("Agence :");
		lblNewLabel_5.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(682, 404, 113, 39);
		frame.getContentPane().add(lblNewLabel_5);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(156, 502, 260, 39);
		frame.getContentPane().add(mail);
		
		JLabel lblNewLabel_6 = new JLabel("Adresse Mail :");
		lblNewLabel_6.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(33, 503, 143, 39);
		frame.getContentPane().add(lblNewLabel_6);
		
		siteweb = new JTextField();
		siteweb.setColumns(10);
		siteweb.setBounds(805, 59, 260, 39);
		frame.getContentPane().add(siteweb);
		
		JLabel lblNewLabel_7 = new JLabel("Site Web :");
		lblNewLabel_7.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(682, 58, 125, 39);
		frame.getContentPane().add(lblNewLabel_7);
		
		lrue1 = new JTextField();
		lrue1.setColumns(10);
		lrue1.setBounds(805, 159, 260, 39);
		frame.getContentPane().add(lrue1);
		
		JLabel lblNewLabel_8 = new JLabel("Libell\u00E9 Rue :");
		lblNewLabel_8.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(682, 158, 118, 39);
		frame.getContentPane().add(lblNewLabel_8);
		
		nville = new JTextField();
		nville.setColumns(10);
		nville.setBounds(805, 207, 260, 39);
		frame.getContentPane().add(nville);
		
		JLabel lblNewLabel_9 = new JLabel("Nom Ville :");
		lblNewLabel_9.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(682, 207, 143, 39);
		frame.getContentPane().add(lblNewLabel_9);
		
		gouv = new JTextField();
		gouv.setColumns(10);
		gouv.setBounds(805, 255, 260, 39);
		frame.getContentPane().add(gouv);
		
		JLabel lblNewLabel_10 = new JLabel("Gouvernerat :");
		lblNewLabel_10.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(682, 255, 143, 39);
		frame.getContentPane().add(lblNewLabel_10);
		
		pays = new JTextField();
		pays.setColumns(10);
		pays.setBounds(805, 306, 260, 39);
		frame.getContentPane().add(pays);
		
		JLabel lblNewLabel_11 = new JLabel("Pays :");
		lblNewLabel_11.setFont(new Font("Berlin Sans FB Demi", lblMatriculeFiscale.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(682, 306, 143, 39);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_4_1 = new JLabel("N\u00B0CIN :");
		lblNewLabel_4_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_4_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setBounds(33, 255, 143, 39);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		
		cin1.setBounds(156, 256, 260, 39);
		frame.getContentPane().add(cin1);
		
		
		telm.setBounds(156, 306, 260, 39);
		frame.getContentPane().add(telm);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("N\u00B0Mobile :");
		lblNewLabel_4_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_4_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(33, 305, 143, 39);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		

		telfixe.setBounds(156, 355, 260, 39);
		frame.getContentPane().add(telfixe);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("N\u00B0Fixe :");
		lblNewLabel_4_1_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_4_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_2.setBounds(33, 355, 143, 39);
		frame.getContentPane().add(lblNewLabel_4_1_2);
		

		fax.setBounds(156, 404, 260, 39);
		frame.getContentPane().add(fax);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("N\u00B0Fax :");
		lblNewLabel_4_1_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_4_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4_1_3.setForeground(Color.WHITE);
		lblNewLabel_4_1_3.setBounds(33, 404, 143, 39);
		frame.getContentPane().add(lblNewLabel_4_1_3);
		
		JLabel lblNewLabel_6_1 = new JLabel("Etat Fiscale :");
		lblNewLabel_6_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_6_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1.setBounds(33, 455, 95, 39);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Type :");
		lblNewLabel_6_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_6_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_6_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1_1.setBounds(271, 453, 66, 39);
		frame.getContentPane().add(lblNewLabel_6_1_1);
		

		etat.setBounds(156, 453, 105, 39);
		frame.getContentPane().add(etat);
		
		
		
		type.setBounds(321, 453, 95, 39);
		frame.getContentPane().add(type);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionClients p;
				try {
					p = new GestionClients();
					frame.dispose();
					p.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\reply.png"));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(33, 592, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(521, 592, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quitter ?")==0) {
					frame.dispose();
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(1003, 592, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_1.setBounds(425, 60, 231, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("N\u00B0 Rue :");
		lblNewLabel_8_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_8_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_8_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_8_1.setBounds(682, 108, 143, 39);
		frame.getContentPane().add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Code Postale :");
		lblNewLabel_8_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_8_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_8_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_8_2.setBounds(890, 107, 95, 39);
		frame.getContentPane().add(lblNewLabel_8_2);
		
		
		numr.setBounds(805, 108, 77, 39);
		frame.getContentPane().add(numr);
		
		
		cp.setBounds(988, 108, 77, 39);
		frame.getContentPane().add(cp);
		
		JLabel lblNewLabel_5_1 = new JLabel("N\u00B0RIB :");
		lblNewLabel_5_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_5_1.getFont().getStyle(), 14));
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setBounds(682, 453, 113, 39);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		
		rib.setBounds(805, 453, 260, 39);
		frame.getContentPane().add(rib);
		
		

		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(980, 511, 85, 48);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
