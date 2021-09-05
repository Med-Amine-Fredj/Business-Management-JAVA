package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

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

public class AjouterFournisseur {

	public JFrame frame;
	public JTextField codefournissuer;
	public JTextField matriculefiscale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterFournisseur window = new AjouterFournisseur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Connection connection;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mail;
	private JTextField siteweb;
	private JTextField lrue1;
	private JTextField gouv;
	private JTextField pays;
	private JTextField nville;
	private JTextField banque;
	private JTextField agence;
	private JSpinner telm;
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public AjouterFournisseur() throws SQLException, ClassNotFoundException {
		
	
			  	Class.forName("com.mysql.jdbc.Driver");  
			  	connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-commerciales","root","");
			  	initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Ajouter Fournisseur - Fredj Med Amine ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1094, 691);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code Fournissuer : ");
		lblNewLabel.setBounds(25, 76, 144, 39);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Code Produit Existe D\u00E9j\u00E0 ou Champ Vide!!!");
		
		lblNewLabel_9.setBounds(439, 79, 238, 36);
		lblNewLabel_9.setFont(new Font("Baskerville Old Face", lblNewLabel_9.getFont().getStyle() | Font.BOLD, 12));
		lblNewLabel_9.setForeground(new Color(255, 51, 51));
		frame.getContentPane().add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(992, 527, 65, 48);
		btnNewButton.setEnabled(false);
		codefournissuer = new JTextField();
		codefournissuer.setBounds(165, 78, 264, 36);
		codefournissuer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Statement stmt = (Statement)connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM fournisseur");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("codefournissuer").toUpperCase());
						
					}
					if(test.contains(codefournissuer.getText().toUpperCase()) || codefournissuer.getText().isEmpty()) {
						lblNewLabel_9.setVisible(true);
						btnNewButton.setEnabled(false);;
						
					} else {
						lblNewLabel_9.setVisible(false);
						btnNewButton.setEnabled(true);
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		codefournissuer.setBackground(new Color(255, 255, 255));
		codefournissuer.setFont(new Font("Berlin Sans FB Demi", codefournissuer.getFont().getStyle(), codefournissuer.getFont().getSize()));
		frame.getContentPane().add(codefournissuer);
		codefournissuer.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Marticule Fiscale :");
		lblNewLabel_1.setBounds(25, 123, 118, 38);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_1);
		
		matriculefiscale = new JTextField();
		matriculefiscale.setBounds(165, 125, 264, 38);
		matriculefiscale.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(matriculefiscale);
		matriculefiscale.setColumns(10);
		
		JSpinner cin;
		telm = new JSpinner();
		telm.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		telm.setBounds(165, 322, 264, 42);
		telm.setBackground(new Color(255, 245, 238));
		telm.setForeground(new Color(255, 245, 238));
		telm.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		frame.getContentPane().add(telm);
		
		JLabel lblAjouterProduit = new JLabel("AJOUTER FOURNISSEUR");
		lblAjouterProduit.setBounds(361, 10, 479, 54);
		lblAjouterProduit.setFont(new Font("OCR A Extended", lblAjouterProduit.getFont().getStyle() | Font.BOLD, 40));
		lblAjouterProduit.setForeground(new Color(255, 255, 204));
		frame.getContentPane().add(lblAjouterProduit);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(527, 601, 48, 39);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				frame.dispose();
				m.frame.setVisible(true);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(1009, 601, 48, 39);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quitter ?")==0) {
					frame.dispose();
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(39, 601, 48, 39);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionFournisseur p;
				try {
					p = new GestionFournisseur();
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
		frame.getContentPane().add(btnNewButton_5);
		
		String type1[]={"Etat Physique","Etat Morale"};
		JComboBox type = new JComboBox(type1);
		type.setBounds(327, 478, 102, 29);
		frame.getContentPane().add(type);
		
		JSpinner fax = new JSpinner();
		fax.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		fax.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		fax.setForeground(new Color(255, 245, 238));
		fax.setBackground(new Color(255, 245, 238));
		fax.setBounds(165, 426, 264, 42);
		frame.getContentPane().add(fax);
		
		JSpinner telfixe = new JSpinner();
		telfixe.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		telfixe.setForeground(new Color(255, 245, 238));
		telfixe.setBackground(new Color(255, 245, 238));
		telfixe.setBounds(165, 374, 264, 42);
		frame.getContentPane().add(telfixe);
		
		 String comboBox1[]={"ASSUJITI","TVA"};
		JComboBox etat = new JComboBox(comboBox1);
		etat.setBounds(165, 478, 81, 30);
		frame.getContentPane().add(etat);
		
		
		JSpinner cin1 = new JSpinner();
		cin1.setToolTipText("");
		cin1.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		cin1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cin1.setForeground(new Color(255, 0, 51));
		cin1.setBackground(new Color(204, 51, 51));
		cin1.setBounds(165, 270, 264, 42);
		frame.getContentPane().add(cin1);
		
		JSpinner numr = new JSpinner();
		numr.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numr.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		numr.setForeground(new Color(255, 245, 238));
		numr.setBackground(new Color(255, 245, 238));
		numr.setBounds(769, 123, 88, 38);
		frame.getContentPane().add(numr);
		
		JSpinner cp = new JSpinner();
		cp.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cp.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		cp.setForeground(new Color(255, 245, 238));
		cp.setBackground(new Color(255, 245, 238));
		cp.setBounds(968, 123, 89, 38);
		frame.getContentPane().add(cp);
		

		nville = new JTextField();
		nville.setColumns(10);
		nville.setBackground(new Color(255, 255, 255));
		nville.setBounds(769, 222, 288, 36);
		frame.getContentPane().add(nville);
		
		gouv = new JTextField();
		gouv.setColumns(10);
		gouv.setBackground(new Color(255, 255, 255));
		gouv.setBounds(769, 270, 288, 42);
		frame.getContentPane().add(gouv);
		
		pays = new JTextField();
		pays.setColumns(10);
		pays.setBackground(new Color(255, 255, 255));
		pays.setBounds(769, 322, 288, 42);
		frame.getContentPane().add(pays);

		banque = new JTextField();
		banque.setColumns(10);
		banque.setBackground(new Color(255, 255, 255));
		banque.setBounds(769, 374, 288, 42);
		frame.getContentPane().add(banque);
		
		agence = new JTextField();
		agence.setColumns(10);
		agence.setBackground(new Color(255, 255, 255));
		agence.setBounds(769, 426, 288, 42);
		frame.getContentPane().add(agence);
		
		JSpinner rib = new JSpinner();
		rib.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		rib.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		rib.setForeground(new Color(255, 245, 238));
		rib.setBackground(new Color(255, 245, 238));
		rib.setBounds(769, 478, 288, 39);
		frame.getContentPane().add(rib);
		
		JLabel lblNewLabel_3 = new JLabel("Type :");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(255, 477, 62, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		lrue1 = new JTextField();
		lrue1.setColumns(10);
		lrue1.setBackground(new Color(255, 255, 255));
		lrue1.setBounds(769, 171, 288, 38);
		frame.getContentPane().add(lrue1);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt;
				try {
					stmt = (Statement)connection.createStatement();
					try {
						stmt.executeUpdate("INSERT INTO `fournisseur`(`codefournissuer`, `matriculefiscale`, `nom`, `prenom`, `cin`, `type`, `telmobile`, `telfixe`, `fax`, `email`, `siteweb`, `etatfiscale`) VALUES ("
								+ "'"+codefournissuer.getText()+"',"
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
						
						stmt.executeUpdate("INSERT INTO `adresse`(`numrue`, `libellerue`, `nomville`, `codepostale`, `gouvernerat`, `pays`, `codefournisseur`) VALUES ("
								+ ""+numr.getValue()+","
								+ "'"+lrue1.getText()+"',"
								+ "'"+nville.getText()+"',"
								+ ""+cp.getValue()+","
								+ "'"+gouv.getText()+"',"
								+ "'"+pays.getText()+"',"
								+ "'"+codefournissuer.getText()+ "')");
						
						stmt.executeUpdate("INSERT INTO `cartebancaire`(`banque`, `agence`, `rib`, `codefournisseur`) VALUES ("
								+ "'"+banque.getText()+"',"
								+ "'"+agence.getText()+"',"
								+ ""+rib.getValue()+","
								+ "'"+codefournissuer.getText()+"')");
								
								
								
						JOptionPane.showInternalMessageDialog(null, "Done!!!!");
						GestionFournisseur p;
						try {
							p = new GestionFournisseur();
							frame.dispose();
							p.frame.setVisible(true);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}		
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		frame.getContentPane().add(btnNewButton);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBackground(new Color(255, 255, 255));
		nom.setBounds(165, 173, 264, 38);
		frame.getContentPane().add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBackground(new Color(255, 255, 255));
		prenom.setBounds(165, 222, 264, 38);
		frame.getContentPane().add(prenom);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pr\u00E9nom Fournisseur :");
		lblNewLabel_1_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_2.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_2.setBounds(25, 220, 138, 38);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("N\u00B0CIN :");
		lblNewLabel_1_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_3.setBounds(25, 273, 130, 38);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBackground(new Color(255, 255, 255));
		mail.setBounds(165, 517, 264, 38);
		frame.getContentPane().add(mail);
		
		
		JLabel lblNewLabel_5_1 = new JLabel("N\u00B0Mobile : ");
		lblNewLabel_5_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_5_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_1.setBounds(25, 323, 108, 39);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("N\u00B0Fixe : ");
		lblNewLabel_5_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_5_2.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_2.setBounds(25, 375, 108, 39);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("N\u00B0Fax :");
		lblNewLabel_5_3.setFont(lblNewLabel_5_3.getFont().deriveFont(lblNewLabel_5_3.getFont().getStyle() | Font.BOLD, 14f));
		lblNewLabel_5_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_3.setBounds(25, 427, 108, 39);
		frame.getContentPane().add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Etat Fiscale :");
		lblNewLabel_5_4.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_5_4.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_4.setBounds(25, 473, 123, 39);
		frame.getContentPane().add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Addresse Mail :");
		lblNewLabel_1_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1.setBounds(25, 516, 123, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom Fournisseur :");
		lblNewLabel_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1.setBounds(25, 171, 118, 38);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		siteweb = new JTextField();
		siteweb.setColumns(10);
		siteweb.setBackground(new Color(255, 255, 255));
		siteweb.setBounds(769, 76, 288, 39);
		frame.getContentPane().add(siteweb);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Site Web :");
		lblNewLabel_1_1_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_1.setBounds(678, 77, 81, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Code Postale :");
		lblNewLabel_1_1_1_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1_1_2.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_2.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_2.setBounds(867, 123, 102, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Pays :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1_1_1_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_1_1.setBounds(678, 322, 62, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNumrue = new JLabel("N\u00B0Rue : ");
		lblNumrue.setFont(new Font("Berlin Sans FB Demi", lblNumrue.getFont().getStyle() | Font.BOLD, 14));
		lblNumrue.setForeground(new Color(255, 255, 255));
		lblNumrue.setBounds(688, 123, 123, 39);
		frame.getContentPane().add(lblNumrue);
		

		
		JLabel lblNewLabel_1_4 = new JLabel("Libell\u00E9 Rue :");
		lblNewLabel_1_4.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_4.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_4.setBounds(678, 172, 108, 38);
		frame.getContentPane().add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_1_2 = new JLabel("Gouvernerat :");
		lblNewLabel_1_1_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1_2.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_2.setBounds(678, 272, 96, 38);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Nom Ville :");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1_1_2_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_2_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_2_1.setBounds(678, 220, 81, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Banque :");
		lblNewLabel_1_1_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_1_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_3.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_3.setBounds(678, 373, 108, 38);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Agence :");
		lblNewLabel_1_2_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_2_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_2_1.setBounds(678, 426, 108, 38);
		frame.getContentPane().add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("RIB :");
		lblNewLabel_1_3_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1_3_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_3_1.setBounds(678, 472, 62, 38);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel_2);
		


		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
