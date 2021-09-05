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

public class AjouterProduit {

	public JFrame frame;
	public JTextField codeProuit;
	public JTextField Designation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterProduit window = new AjouterProduit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Connection connection;
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public AjouterProduit() throws SQLException, ClassNotFoundException {
		
	
			  	Class.forName("com.mysql.jdbc.Driver");  
			  	connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-commerciales","root","");
			  	initialize();
		ShowFournisseur();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	public String[] ShowFournisseur() throws SQLException {
		int i=0;
		String[] fortable = new String[1000];

			Statement stmt=(Statement)connection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM fournisseur");
			while(rs.next()) {
				String CodeFor=rs.getString("codefournissuer");
				fortable[i]=CodeFor;
				i++;
		}
			return fortable;
	}
	
	

	
	
	public String[] ShowFamilleProduit() throws SQLException {
		int i=0;
		String[] fortable = new String[1000];

			Statement stmt=(Statement)connection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM familleproduit");
			while(rs.next()) {
				String CodeFor=rs.getString("copdefp");
			fortable[i]=CodeFor;
			i++;
			
		}
			return fortable;
	}
	
	
	
	
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Ajouter Produit - Fredj Med Amine ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1094, 691);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code Produit : ");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(346, 57, 108, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Code Produit Existe D\u00E9j\u00E0 ou Champ Vide!!!");
		lblNewLabel_9.setFont(new Font("Baskerville Old Face", lblNewLabel_9.getFont().getStyle() | Font.BOLD, 12));
		lblNewLabel_9.setForeground(new Color(255, 51, 51));
		lblNewLabel_9.setBounds(739, 59, 235, 39);
		frame.getContentPane().add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);;
		codeProuit = new JTextField();
		codeProuit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Statement stmt = (Statement)connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM produit");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("reference"));
					}
					if(test.contains(codeProuit.getText()) || codeProuit.getText().isEmpty()) {
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
		codeProuit.setBackground(new Color(255, 255, 255));
		codeProuit.setFont(new Font("Berlin Sans FB Demi", codeProuit.getFont().getStyle(), codeProuit.getFont().getSize()));
		codeProuit.setBounds(479, 60, 250, 36);
		frame.getContentPane().add(codeProuit);
		codeProuit.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9signation :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1.setBounds(346, 106, 108, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		Designation = new JTextField();
		Designation.setBackground(new Color(255, 255, 255));
		Designation.setBounds(479, 106, 250, 38);
		frame.getContentPane().add(Designation);
		Designation.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Unit\u00E9 de Mesure :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_2.setBounds(346, 155, 123, 39);
		frame.getContentPane().add(lblNewLabel_2);
		/* ***********************************************COMBOBOX FOURNISSEUR ************************************************ */
	
	  
	    String comboBox[]={"DOLLAR","TND","POUND","EURO","YEN"}; 
	    JComboBox Fornisseur=new JComboBox(this.ShowFournisseur());  
	    Fornisseur.setFont(new Font("Berlin Sans FB Demi", Fornisseur.getFont().getStyle() | Font.BOLD, 10));
	    Fornisseur.setBackground(new Color(255, 255, 255));
		//cb.setToolTipText("");
		Fornisseur.setBounds(479, 207, 250, 39);
		frame.getContentPane().add(Fornisseur);
		 JComboBox UniteMesure = new JComboBox(comboBox);
		 UniteMesure.setFont(new Font("Berlin Sans FB Demi", UniteMesure.getFont().getStyle() | Font.BOLD, 10));
		 UniteMesure.setBackground(new Color(255, 255, 255));
			//cb.setToolTipText("");
		    UniteMesure.setBounds(479, 207, 250, 39);
			frame.getContentPane().add(UniteMesure);
			UniteMesure.setBounds(479, 154, 250, 43);
			frame.getContentPane().add(UniteMesure);
		JLabel lblNewLabel_3 = new JLabel("Fournisseur :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_3.setBounds(346, 207, 108, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		/* ***********************************************COMBOBOX FAMILLEPRODUITS************************************************ */
		  
		JComboBox familleProduit = new JComboBox(ShowFamilleProduit());
		familleProduit.setFont(new Font("Berlin Sans FB Demi", familleProduit.getFont().getStyle() | Font.BOLD, 10));
		familleProduit.setBackground(new Color(255, 255, 255));
		familleProduit.setBounds(479, 256, 250, 42);
		frame.getContentPane().add(familleProduit);
		
	
		
		JLabel lblNewLabel_4 = new JLabel("Famille Produit : ");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4.setBounds(346, 253, 123, 42);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Stock Disponible : ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5.setBounds(346, 308, 108, 39);
		frame.getContentPane().add(lblNewLabel_5);
		
		JSpinner stock = new JSpinner();
		stock.setBackground(new Color(255, 255, 255));
		stock.setForeground(new Color(255, 245, 238));
		stock.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		stock.setBounds(479, 308, 250, 42);
		frame.getContentPane().add(stock);
		
		JLabel lblNewLabel_6 = new JLabel("Stock Minimale : ");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_6.setBounds(346, 358, 135, 42);
		frame.getContentPane().add(lblNewLabel_6);
		
		JSpinner stockMinimal = new JSpinner();
		stockMinimal.setBackground(new Color(255, 255, 255));
		stockMinimal.setForeground(new Color(255, 245, 238));
		stockMinimal.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		stockMinimal.setBounds(479, 360, 250, 42);
		frame.getContentPane().add(stockMinimal);
		
		JLabel lblNewLabel_7 = new JLabel("Prix Hors Taxe : ");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_7.setBounds(346, 410, 123, 43);
		frame.getContentPane().add(lblNewLabel_7);
		
		JSpinner prixHorsTaxe = new JSpinner();
		prixHorsTaxe.setBackground(new Color(255, 255, 255));
		prixHorsTaxe.setForeground(new Color(255, 245, 238));
		prixHorsTaxe.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		prixHorsTaxe.setBounds(479, 412, 250, 42);
		frame.getContentPane().add(prixHorsTaxe);
		
		JLabel lblNewLabel_8 = new JLabel("Taxe :");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_8.setBounds(346, 464, 108, 39);
		frame.getContentPane().add(lblNewLabel_8);
		
		JSpinner taxe = new JSpinner();
		taxe.setBackground(new Color(255, 255, 255));
		taxe.setForeground(new Color(255, 245, 238));
		taxe.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		taxe.setBounds(479, 464, 250, 42);
		frame.getContentPane().add(taxe);
		
		JLabel lblAjouterProduit = new JLabel("AJOUTER PRODUIT");
		lblAjouterProduit.setFont(new Font("OCR A Extended", lblAjouterProduit.getFont().getStyle() | Font.BOLD, 45));
		lblAjouterProduit.setForeground(new Color(255, 255, 204));
		lblAjouterProduit.setBounds(349, -4, 464, 54);
		frame.getContentPane().add(lblAjouterProduit);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				frame.dispose();
				m.frame.setVisible(true);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_3.setBounds(519, 594, 48, 39);
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
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(1018, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produits p;
				try {
					p = new Produits();
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
		btnNewButton_5.setBounds(48, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Statement stmt=(Statement)connection.createStatement();
					stmt.executeUpdate("INSERT INTO `produit`(`reference`, `designation`, `unitedemesure`, `codefournisseur`, `codefamilleprodit`, `stock`, `stockminimale`, `prixhorstaxe`, `taxe`) VALUES ('"+codeProuit.getText()+"','"+Designation.getText()+"','"+UniteMesure.getSelectedItem().toString()+"','"+Fornisseur.getSelectedItem().toString()+"','"+familleProduit.getSelectedItem().toString()+"',"+stock.getValue()+","+stockMinimal.getValue()+","+prixHorsTaxe.getValue()+","+taxe.getValue()+") ");
					JOptionPane.showInternalMessageDialog(null, "Done!!!!");
					Produits p;
					try {
						p = new Produits();
						frame.dispose();
						p.frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton.setBounds(664, 520, 65, 43);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_10.setBounds(0, -4, 1090, 667);
		frame.getContentPane().add(lblNewLabel_10);
		
		
		
		
		
		
		/* ***********************************************COMBOBOX UNITE DE MESURE ************************************************ */
	             
	   
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
