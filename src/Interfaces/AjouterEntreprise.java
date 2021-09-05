package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class AjouterEntreprise {

	public JFrame frame;
	private JTextField matriculefiscale;
	private JTextField nom;
	private JTextField mail;
	private JTextField siteweb;
	private JTextField lrue1;
	private JTextField nville;
	private JTextField gouv;
	private JTextField pays;
	private JTextField banque;
	private JTextField agence;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterEntreprise window = new AjouterEntreprise();
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
	 * @wbp.parser.entryPoint
	 */
	public AjouterEntreprise() throws ClassNotFoundException, SQLException {
	  	DataBase.DataBaseConnection.connecter();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Ajouter Entreprise - Fredj Med Amine ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1094, 691);
		frame.getContentPane().setLayout(null);
		
		
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt;
				try {
					stmt = (Statement)DataBaseConnection.connection.createStatement();
					stmt.executeUpdate("INSERT INTO `entreprise`(`matriculefiscale`, `raisonsociale`, `description`, `telfixe`, `telmobile`, `fax`, `email`, `siteweb`, `etatfiscale`) VALUES ("
							+ "'"+matriculefiscale.getText()+"',"
							+ "'"+type.getSelectedItem().toString()+"',"
							+ "'"+nom.getText()+"',"
							+ ""+telfixe.getValue()+","
							+ ""+telm.getValue()+","
							+ ""+fax.getValue()+","
							+ "'"+mail.getText()+"',"
							+ "'"+siteweb.getText()+"',"
							+ "'"+etat.getSelectedItem().toString()+ "')");
					
					stmt.executeUpdate("INSERT INTO `adresse`(`numrue`, `libellerue`, `nomville`, `codepostale`, `gouvernerat`, `pays`, `mfentreprise`) VALUES ("
							+ ""+numr.getValue()+","
							+ "'"+lrue1.getText()+"',"
							+ "'"+nville.getText()+"',"
							+ ""+cp.getValue()+","
							+ "'"+gouv.getText()+"',"
							+ "'"+pays.getText()+"',"
							+ "'"+matriculefiscale.getText()+ "')");
					
					stmt.executeUpdate("INSERT INTO `cartebancaire`(`banque`, `agence`, `rib`, `mfentreprise`) VALUES ("
							+ "'"+banque.getText()+"',"
							+ "'"+agence.getText()+"',"
							+ ""+rib.getValue()+","
							+ "'"+matriculefiscale.getText()+"')");
							
							
							
					JOptionPane.showInternalMessageDialog(null, "Done!!!!");
					try {
						GestionEntreprise ge = new GestionEntreprise();
						frame.dispose();
						ge.frame.setVisible(true);
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
		
		JLabel lblNewLabel = new JLabel("Code Produit Existe D\u00E9j\u00E0 ou Champ Vide !!");
		lblNewLabel.setVisible(false);
		
		matriculefiscale = new JTextField();
		matriculefiscale.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Statement stmt;
				try {
					stmt = (Statement)DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM entreprise");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("matriculefiscale").toUpperCase());
						
					}
					if(test.contains(matriculefiscale.getText().toUpperCase()) || matriculefiscale.getText().isEmpty()) {
						lblNewLabel.setVisible(true);
						btnNewButton.setEnabled(false);;
						
					} else {
						lblNewLabel.setVisible(false);
						btnNewButton.setEnabled(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		matriculefiscale.setColumns(10);
		matriculefiscale.setBackground(new Color(255, 255, 255));
		matriculefiscale.setBounds(172, 105, 264, 38);
		frame.getContentPane().add(matriculefiscale);
		
		JLabel lblNewLabel_1 = new JLabel("Marticule Fiscale :");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1.setBounds(32, 103, 118, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		type.setBounds(314, 158, 122, 29);
		frame.getContentPane().add(type);
		
		JLabel lblNewLabel_3 = new JLabel("Type :");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(262, 157, 62, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		

		etat.setBounds(172, 158, 81, 30);
		frame.getContentPane().add(etat);
		
		JLabel lblNewLabel_5_4 = new JLabel("Etat Fiscale :");
		lblNewLabel_5_4.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_4.setBounds(32, 153, 123, 39);
		frame.getContentPane().add(lblNewLabel_5_4);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBackground(new Color(255, 255, 255));
		nom.setBounds(172, 199, 264, 38);
		frame.getContentPane().add(nom);
		
		JLabel lblNewLabel_1_1 = new JLabel("Description :");
		lblNewLabel_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1.setBounds(32, 197, 118, 38);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		
		telm.setForeground(new Color(255, 245, 238));
		telm.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		telm.setBackground(new Color(255, 255, 255));
		telm.setBounds(172, 248, 264, 42);
		frame.getContentPane().add(telm);
		
		JLabel lblNewLabel_5_1 = new JLabel("N\u00B0Mobile : ");
		lblNewLabel_5_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_1.setBounds(32, 249, 108, 39);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("N\u00B0Fixe : ");
		lblNewLabel_5_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_2.setBounds(32, 301, 108, 39);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		
		telfixe.setForeground(new Color(255, 245, 238));
		telfixe.setBackground(new Color(255, 255, 255));
		telfixe.setBounds(172, 300, 264, 42);
		frame.getContentPane().add(telfixe);
		
		JLabel lblNewLabel_5_3 = new JLabel("N\u00B0Fax :");
		lblNewLabel_5_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5_3.setBounds(32, 353, 108, 39);
		frame.getContentPane().add(lblNewLabel_5_3);
		
		
		fax.setForeground(new Color(255, 245, 238));
		fax.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		fax.setBackground(new Color(255, 255, 255));
		fax.setBounds(172, 352, 264, 42);
		frame.getContentPane().add(fax);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBackground(new Color(255, 255, 255));
		mail.setBounds(172, 403, 264, 38);
		frame.getContentPane().add(mail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Addresse Mail :");
		lblNewLabel_1_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1.setBounds(32, 402, 123, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		siteweb = new JTextField();
		siteweb.setColumns(10);
		siteweb.setBackground(new Color(255, 255, 255));
		siteweb.setBounds(172, 451, 264, 39);
		frame.getContentPane().add(siteweb);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Site Web :");
		lblNewLabel_1_1_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_1.setBounds(32, 451, 81, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		
		numr.setForeground(new Color(255, 245, 238));
		numr.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		numr.setBackground(new Color(255, 255, 255));
		numr.setBounds(778, 103, 88, 38);
		frame.getContentPane().add(numr);
		
		JLabel lblNumrue = new JLabel("N\u00B0Rue : ");
		lblNumrue.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNumrue.setForeground(new Color(255, 255, 255));
		lblNumrue.setBounds(699, 101, 69, 39);
		frame.getContentPane().add(lblNumrue);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Code Postale :");
		lblNewLabel_1_1_1_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_2.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_2.setBounds(876, 101, 102, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);
		
		
		cp.setForeground(new Color(255, 245, 238));
		cp.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		cp.setBackground(new Color(255, 255, 255));
		cp.setBounds(977, 105, 89, 36);
		frame.getContentPane().add(cp);
		
		lrue1 = new JTextField();
		lrue1.setColumns(10);
		lrue1.setBackground(new Color(255, 255, 255));
		lrue1.setBounds(778, 152, 288, 38);
		frame.getContentPane().add(lrue1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Libell\u00E9 Rue :");
		lblNewLabel_1_4.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_4.setBounds(687, 150, 108, 38);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Nom Ville :");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_2_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_2_1.setBounds(687, 195, 81, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_2_1);
		
		nville = new JTextField();
		nville.setColumns(10);
		nville.setBackground(new Color(255, 255, 255));
		nville.setBounds(778, 198, 288, 36);
		frame.getContentPane().add(nville);
		
		gouv = new JTextField();
		gouv.setColumns(10);
		gouv.setBackground(new Color(255, 255, 255));
		gouv.setBounds(778, 244, 288, 42);
		frame.getContentPane().add(gouv);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Gouvernerat :");
		lblNewLabel_1_1_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_2.setBounds(687, 244, 108, 38);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Pays :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_1_1_1.setBounds(687, 299, 62, 38);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		pays = new JTextField();
		pays.setColumns(10);
		pays.setBackground(new Color(255, 255, 255));
		pays.setBounds(778, 299, 288, 42);
		frame.getContentPane().add(pays);
		
		banque = new JTextField();
		banque.setColumns(10);
		banque.setBackground(new Color(255, 255, 255));
		banque.setBounds(778, 351, 288, 42);
		frame.getContentPane().add(banque);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Banque :");
		lblNewLabel_1_1_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_3.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_1_3.setBounds(687, 351, 81, 38);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Agence :");
		lblNewLabel_1_2_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_2_1.setBounds(687, 399, 81, 38);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		agence = new JTextField();
		agence.setColumns(10);
		agence.setBackground(new Color(255, 255, 255));
		agence.setBounds(778, 399, 288, 42);
		frame.getContentPane().add(agence);
		
	
		rib.setForeground(new Color(255, 245, 238));
		rib.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		rib.setBackground(new Color(255, 255, 255));
		rib.setBounds(778, 451, 288, 39);
		frame.getContentPane().add(rib);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("RIB :");
		lblNewLabel_1_3_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1_3_1.setBounds(687, 448, 81, 38);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblAjouterEntreprise = new JLabel("AJOUTER ENTREPRISE");
		lblAjouterEntreprise.setFont(new Font("OCR A Extended", lblAjouterEntreprise.getFont().getStyle() | Font.BOLD, 45));
		lblAjouterEntreprise.setForeground(new Color(255, 255, 204));
		lblAjouterEntreprise.setBounds(359, 10, 591, 54);
		frame.getContentPane().add(lblAjouterEntreprise);
		
		
		lblNewLabel.setFont(new Font("Baskerville Old Face", lblNewLabel.getFont().getStyle(), 12));
		lblNewLabel.setForeground(new Color(255, 51, 102));
		lblNewLabel.setBounds(446, 106, 243, 37);
		frame.getContentPane().add(lblNewLabel);
		
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(1000, 500, 65, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quitter ?")==0) {
					frame.dispose();
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(1018, 579, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(536, 579, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEntreprise p;
				try {
					p = new GestionEntreprise();
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
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(48, 579, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
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
