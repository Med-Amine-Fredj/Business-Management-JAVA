package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class GestionBonReception {

	public JFrame frame;
	private JTextField codebr;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionBonReception window = new GestionBonReception();
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
	public GestionBonReception() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
		ShowProduit();
		ShowFournisseur();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public String[] ShowFournisseur() throws SQLException {
		int i=0;
		String[] fortable = new String[1000];

			Statement stmt=(Statement) DataBaseConnection.connection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM fournisseur");
			while(rs.next()) {
				String CodeFor=rs.getString("codefournissuer");
				fortable[i]=CodeFor;
				i++;
		}
			return fortable;
	}
	
	public String[] ShowProduit() throws SQLException {
		int i=0;
		String[] fortable = new String[1000];

			Statement stmt=(Statement) DataBaseConnection.connection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM produit");
			while(rs.next()) {
				String CodeFor=rs.getString("reference");
			fortable[i]=CodeFor;
			i++;
			
		}
			return fortable;
	}
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Ajouter Bon de Réception - Fredj Med Amine ");
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code : ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel.setBounds(20, 97, 121, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		
		JLabel erreur = new JLabel("Code Bon Invalide ! ");
		erreur.setFont(new Font("Baskerville Old Face", erreur.getFont().getStyle(), 12));
		erreur.setForeground(new Color(255, 51, 51));
		erreur.setVisible(false);
		
		codebr = new JTextField();
		codebr.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Statement stmt;
				try {
					stmt = (Statement)DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM bonreception");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("codebr"));
					}
					if(test.contains(codebr.getText()) || codebr.getText().isEmpty()) {
						erreur.setVisible(true);
					} else {
						erreur.setVisible(false);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		codebr.setBounds(151, 98, 145, 31);
		frame.getContentPane().add(codebr);
		codebr.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Fournisseur :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 325, 121, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(ShowFournisseur());
		comboBox.setBounds(151, 326, 145, 31);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("Date Du Bon : ");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_8.setBounds(20, 211, 121, 31);
		frame.getContentPane().add(lblNewLabel_8);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1611183600000L), new Date(1611183600000L), null, Calendar.MONTH));
		spinner.setBounds(151, 212, 145, 31);
		frame.getContentPane().add(spinner);
		
		JButton button = new JButton("New button");
		button.setBounds(29, 268, 45, -124);
		frame.getContentPane().add(button);
		
		JComboBox comboBox_1 = new JComboBox(ShowProduit());
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		JTextArea textArea_2 = new JTextArea();
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial Narrow", Font.BOLD, 14));

		textArea.setEditable(false);
		
		JSpinner spinner_2 = new JSpinner();
		
		JLabel lblNewLabel_2 = new JLabel("Code Comande Invalide !");
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", lblNewLabel_2.getFont().getStyle(), 12));
		lblNewLabel_2.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Statement stmt;
				try {
					stmt = (Statement)DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM bonreception");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("codecommande"));
					}
					if(test.contains(textField_1.getText()) || textField_1.getText().isEmpty()) {
						lblNewLabel_2.setVisible(true);
						btnNewButton.setEnabled(false);;
						
					} else {
						lblNewLabel_2.setVisible(false);
						btnNewButton.setEnabled(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setEnabled(false);
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////Récupération Addresse ////////////////
				

					Statement stmt;
					try {
						stmt = (Statement) DataBaseConnection.connection.createStatement();
						ResultSet rs=stmt.executeQuery("SELECT * FROM adresse WHERE codefournisseur = '"+comboBox.getSelectedItem().toString()+"'");
						while(rs.next()) {
							String numrue=rs.getString("numrue");
							String librue=rs.getString("libellerue");
							String nomville=rs.getString("nomville");
							String codepos=rs.getString("codepostale");
							String gouver=rs.getString("gouvernerat");
							String pay=rs.getString("pays");								
											
						textArea.setText("Code: "+codebr.getText()+"\n"
										+ "Code Commande: "+textField_1.getText()+"\n"
											+ "Date du bon: "+spinner.getValue()+"\n"
											+ "Date de réception: "+spinner_2.getValue()+"\n"
											+ "Code Fournisseur : "+comboBox.getSelectedItem().toString()+"\n"
											+ "N°Rue: "+numrue+"\n"
											+ "Libélle Rue: "+librue+"\n"
											+ "Nom Ville: "+nomville+"\n"
											+ "Code Postale: "+codepos+"\n"
											+ "Gouvernerat: "+gouver+"\n"
											+ "Pays: "+pay+"\n"
										);
						}
						stmt.executeUpdate("INSERT INTO `bonreception`(`codebr`, `codef`, `datebon`, `datereception`, `codecommande`, `totalepayer`) VALUES ('"+codebr.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+spinner.getValue()+"','"+spinner_2.getValue()+"','"+textField_1.getText()+"','"+0+"')");
						btnNewButton_2.setEnabled(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
////////////////////////////////////////////////////////////////////////////////////////////				
				codebr.setEditable(false);
				comboBox.setEnabled(false);
				spinner.setEnabled(false);
				spinner_2.setEnabled(false);
				textField_1.setEditable(false);
				btnNewButton.setEnabled(false);
				
			}
			

		});
		btnNewButton.setBounds(200, 367, 96, 41);
		frame.getContentPane().add(btnNewButton);
		
	
		comboBox_1.setBounds(151, 432, 145, 31);
		frame.getContentPane().add(comboBox_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_1.setBounds(151, 473, 145, 31);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_9 = new JLabel("R\u00E9ference :");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_9.setBounds(20, 431, 116, 31);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Quantite");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_10.setBounds(20, 472, 121, 31);
		frame.getContentPane().add(lblNewLabel_10);
		
		JTextArea totale = new JTextArea();
		totale.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		totale.setEditable(false);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_2.setText(
				textArea.getText()+
				"\n----------------------------------------------------------------------------------------- \n"
				+textArea_1.getText()+
				"\n----------------------------------------------------------------------------------------- \n"
				+totale.getText()
				);
				try {
					textArea_2.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\printer.png"));
		btnNewButton_1.setBounds(864, 514, 85, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(321, 79, 309, 425);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		textArea.setBounds(10, 10, 289, 244);
		panel.add(textArea);
		textArea.setLineWrap(true);
		textArea.setRows(20);
		
		
		totale.setBounds(10, 264, 289, 151);
		panel.add(totale);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(640, 79, 429, 425);
		frame.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 409, 405);
		panel_1.add(scrollPane);
		
		scrollPane.setViewportView(textArea_1);
		
		textArea_1.setRows(20);
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(596, 653, 421, 425);
		frame.getContentPane().add(panel_2);
		panel_2.setVisible(false);
		
		textArea_2.setRows(20);
		textArea_2.setLineWrap(true);
		textArea_2.setEditable(false);
		textArea_2.setBounds(22, 20, 378, 383);
		panel_2.add(textArea_2);
		

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/////////////////////récuperation des donnée de produit//////////////////////////:
				Statement stmt;
				Double ptht=0.000,ptt = 0.000,st=0.000;
				int stockfi=0,qu=0;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM produit WHERE reference = '"+comboBox_1.getSelectedItem().toString()+"'");
					while(rs.next()) {
						String des=rs.getString("designation");
						String um=rs.getString("unitedemesure");
						Double pht=Double.parseDouble(rs.getString("prixhorstaxe"));
						Double tva=Double.parseDouble(rs.getString("taxe"));	
						
						String fredj =textArea_1.getText();
						ptht = Double.parseDouble(spinner_1.getValue().toString())*pht ;
						ptt =Double.parseDouble(spinner_1.getValue().toString())*tva ;
						st = ptt+ptht;
						qu = Integer.parseInt(spinner_1.getValue().toString());
						
						textArea_1.setText("Reference Produit: "+comboBox_1.getSelectedItem().toString()+"\n"
								+ "Désignation Produit: "+des+"\n"
								+ "Unité de Mesure: "+um+"\n"
								+ "Quantité Produits : "+spinner_1.getValue()+"\n"
								+ "Prix Hors TVA: "+pht+" "+um+"\n"
								+ "TVA: "+tva+" "+um+"\n"
								+ "La Somme Totale Hors TVA: "+ptht+" "+um+"\n"
								+ "La Somme Totale TVA: "+ptt+" "+um+"\n"
								+ "La Somme Totale A Payer: "+st+" "+um+"\n"
										);
						textArea_1.setText(fredj+"\n----------------------------------------------------------------------------------------- \n"+textArea_1.getText());			
					}
					stmt.executeUpdate("INSERT INTO `lignesbons`(`codebr`, `referenceproduit`, `quantite`, `totaleht`, `totalet`, `prixtotale`) VALUES ('"+codebr.getText()+"','"+comboBox_1.getSelectedItem().toString()+"',"+qu+","+ptht+","+ptt+","+st+")");
					ResultSet stock=stmt.executeQuery("SELECT * FROM produit WHERE reference = '"+comboBox_1.getSelectedItem().toString()+"'");
					while(stock.next()) {
						int stockin=Integer.parseInt(stock.getString("stock"));
						stockfi = stockin+Integer.parseInt(spinner_1.getValue().toString());
					}				
					stmt.executeUpdate("UPDATE `produit` SET `stock`="+stockfi+" WHERE `reference`='"+comboBox_1.getSelectedItem().toString()+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
				
				
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton_2.setBounds(200, 514, 96, 41);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LesBonReception br = new LesBonReception();
					frame.dispose();
					br.frame.setVisible(true);
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
		btnNewButton_5.setBounds(51, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m= new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(539, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quittez ?")==0) {
					frame.dispose(); 
					}				
			
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(1021, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
		
		spinner_2.setModel(new SpinnerDateModel(new Date(1611183600000L), new Date(1611183600000L), null, Calendar.DAY_OF_YEAR));
		spinner_2.setBounds(151, 267, 145, 31);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_8_1 = new JLabel("Date De Reception :");
		lblNewLabel_8_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_8_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(15, 267, 145, 31);
		frame.getContentPane().add(lblNewLabel_8_1);
		
		textField_1.setColumns(10);
		textField_1.setBounds(151, 156, 145, 31);
		frame.getContentPane().add(textField_1);
		
		JLabel lblCodeCommande = new JLabel("Code Commande ");
		lblCodeCommande.setForeground(new Color(255, 255, 255));
		lblCodeCommande.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblCodeCommande.setBounds(20, 155, 116, 31);
		frame.getContentPane().add(lblCodeCommande);
		
	
		erreur.setBounds(163, 132, 128, 25);
		frame.getContentPane().add(erreur);
		
		
		lblNewLabel_2.setForeground(new Color(255, 51, 51));
		lblNewLabel_2.setBounds(161, 185, 135, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_6 = new JButton("Afficher Totale");
		btnNewButton_6.setFont(new Font("Berlin Sans FB Demi", btnNewButton_6.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt;
				Double tht=0.000,tt=0.000,tp=0.000;
				String tnd = null,um=null;
				try {
					tht=0.000;
					tt=0.000;
					tp=0.000;
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM lignesbons WHERE codebr = '"+codebr.getText()+"'");
					while(rs.next()) {
						um = rs.getString("referenceproduit");
						Double pht=Double.parseDouble(rs.getString("totaleht"));
						Double ptt=Double.parseDouble(rs.getString("totalet"));
						Double pt=Double.parseDouble(rs.getString("prixtotale"));
						tht = tht +pht;
						tt = ptt+tt;
						tp = tp+pt;
					}
					ResultSet ff=stmt.executeQuery("SELECT * FROM produit WHERE  reference= '"+um+"'");
							while(ff.next())
									{
									tnd=ff.getString("unitedemesure");
									}	
					totale.setText("                Les Prix Totales : \n"
							+ "\nPrix Du Bon Hors TVA:**"+tht+" "+tnd+"\n"
							+"Prix Du Bon avec Tva:**"+tt+" "+tnd+"\n"
							+"Prix Finale à Payer:**"+tp+" "+tnd+"\n"
							);
					stmt.executeUpdate("UPDATE `bonreception` SET `totalepayer`="+tp+",`totalehtva`="+tht+",`totaletva`="+tt+" WHERE `codebr`='"+codebr.getText()+"'");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_6.setBounds(511, 514, 157, 41);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Finaliser le bon ");
		btnNewButton_7.setFont(new Font("Berlin Sans FB Demi", btnNewButton_7.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Finaliser Le Bon ?")==0) {
					JOptionPane.showInternalMessageDialog(null, "Bon Créer Avec Succès !");
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(false);
					btnNewButton_6.setEnabled(false);
					btnNewButton_7.setEnabled(false);
					btnNewButton_1.setEnabled(true);
					}
				
			
	
			}
		});
		btnNewButton_7.setBounds(688, 514, 157, 41);
		frame.getContentPane().add(btnNewButton_7);
		
		JLabel lblNewLabel_3 = new JLabel("AJOUTER UN BON DE RECEPTION");
		lblNewLabel_3.setFont(new Font("OCR A Extended", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 45));
		lblNewLabel_3.setForeground(new Color(255, 255, 204));
		lblNewLabel_3.setBounds(206, 5, 811, 64);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		
		

		
		
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
