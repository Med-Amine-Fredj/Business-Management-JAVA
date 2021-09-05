package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class AjouterFFL {

	public JFrame frame;
	private JTextField codeffl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterFFL window = new AjouterFFL();
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
	public AjouterFFL() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
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
		frame.setTitle("Gestion Commerciales - Ajouter Facture Fournisseur Libre - Fredj Med Amine ");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAjouterUneFacture = new JLabel("Ajouter Une Facture Fournissuer Libre");
		lblAjouterUneFacture.setFont(new Font("OCR A Extended", lblAjouterUneFacture.getFont().getStyle() | Font.BOLD, 45));
		lblAjouterUneFacture.setForeground(new Color(255, 255, 204));
		lblAjouterUneFacture.setBounds(10, 10, 1080, 53);
		frame.getContentPane().add(lblAjouterUneFacture);
		
		JLabel lblNewLabel = new JLabel("Code FFL :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel.setBounds(10, 89, 81, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel erreur = new JLabel("Code Invalide !");
		erreur.setVisible(false);
		
		codeffl = new JTextField();
		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		
		codeffl.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Statement stmt;
				try {
					stmt = (Statement)DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM factureflibre");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("codeffl"));
						
					}
					if(test.contains(codeffl.getText()) || codeffl.getText().isEmpty()) {
						erreur.setVisible(true);
						btnNewButton.setEnabled(false);
					} else {
						erreur.setVisible(false);
						btnNewButton.setEnabled(true);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		codeffl.setBounds(135, 89, 136, 30);
		frame.getContentPane().add(codeffl);
		codeffl.setColumns(10);
		
		
		erreur.setForeground(new Color(255, 51, 51));
		erreur.setFont(new Font("Baskerville Old Face", erreur.getFont().getStyle() | Font.BOLD, 12));
		erreur.setBounds(145, 122, 115, 28);
		frame.getContentPane().add(erreur);
		
		JLabel lblNewLabel_2 = new JLabel("Fournisseur : ");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_2.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 152, 115, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox(ShowFournisseur());
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(135, 152, 136, 33);
		frame.getContentPane().add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1611356400000L), new Date(1611356400000L), null, Calendar.DAY_OF_YEAR));
		spinner.setBackground(Color.WHITE);
		spinner.setBounds(135, 204, 136, 33);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("Date Facture :");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_3.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 204, 115, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		String[] mode = {"Chèque","Virement","Espèce"};
		JComboBox comboBox_1 = new JComboBox(mode);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(135, 260, 136, 33);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Mode Payement :");
		lblNewLabel_4.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_4.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 259, 115, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		
		JTextArea textArea_1 = new JTextArea();
		
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_1.setEnabled(false);
		
		JComboBox comboBox_1_1 = new JComboBox(ShowProduit());
		comboBox_1_1.setEnabled(false);
		
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stmt;
				Double ptht=0.000,ptt = 0.000,st=0.000;
				int stockfi=0,qu=0;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM produit WHERE reference = '"+comboBox_1_1.getSelectedItem().toString()+"'");
					while(rs.next()) {
						String des=rs.getString("designation");
						String um=rs.getString("unitedemesure");
						Double pht=Double.parseDouble(rs.getString("prixhorstaxe"));
						Double tva=Double.parseDouble(rs.getString("taxe"));	
						
						String fredj =textArea_1.getText();
						ptht = Double.parseDouble(spinner_1.getValue().toString())*pht ;
						ptt = Double.parseDouble(spinner_1.getValue().toString())*tva ;
						st = ptt+ptht;
						qu = Integer.parseInt(spinner_1.getValue().toString());
						
						textArea_1.setText("Reference Produit: "+comboBox_1_1.getSelectedItem().toString()+"\n"
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
					stmt.executeUpdate("INSERT INTO `ffldetail`(`codeffl`, `referenceproduit`, `quantite`, `thorstax`, `tavect`, `tt`) VALUES ('"+codeffl.getText()+"','"+comboBox_1_1.getSelectedItem().toString()+"',"+qu+","+ptht+","+ptt+","+st+")");
//					stmt.executeUpdate("UPDATE `factureflibre` SET "
//							+ "`referenceproduit`="+comboBox_1_1.getSelectedItem().toString()+","
//							+ " `quantite`="+qu+","
//							+ " `thorstax`="+ptht+","
//							+ " `tavect`="+ptt+","
//							+ " `tt`="+st+""
//							+ " WHERE `codeffl`='"+codeffl.getText()+"'");
					ResultSet stock=stmt.executeQuery("SELECT * FROM produit WHERE reference = '"+comboBox_1_1.getSelectedItem().toString()+"'");
					while(stock.next()) {
						int stockin=Integer.parseInt(stock.getString("stock"));
						stockfi = stockin+Integer.parseInt(spinner_1.getValue().toString());
					}				
					stmt.executeUpdate("UPDATE `produit` SET `stock`="+stockfi+" WHERE `reference`='"+comboBox_1_1.getSelectedItem().toString()+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_2.setEnabled(false);
		


		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("\n \t Détailles Facture FL \n \n \n"
						+"Code FFBL: "+codeffl.getText()+"\n \n"
						+ "Code Fournisseur: "+comboBox.getSelectedItem().toString()+"\n \n"
						+ "Date du Facture: "+spinner.getValue()+"\n \n"
						+ "Mode de Payement: "+comboBox_1.getSelectedItem().toString()+"\n"
					);
					Statement stmt;
					try {
						stmt = (Statement) DataBaseConnection.connection.createStatement();
						stmt.executeUpdate("INSERT INTO `factureflibre`(`codeffl`, `codefournisseur`, `datefacture`, `modepay`) VALUES ('"+codeffl.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+spinner.getValue().toString()+"','"+comboBox_1.getSelectedItem().toString()+"')");
						btnNewButton_2.setEnabled(true);
						codeffl.setEnabled(false);
						comboBox.setEnabled(false);
						spinner.setEnabled(false);
						comboBox_1.setEnabled(false);
						comboBox_1_1.setEnabled(true);
						spinner_1.setEnabled(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(186, 316, 85, 48);
		frame.getContentPane().add(btnNewButton);
		

		comboBox_1_1.setBounds(135, 392, 136, 31);
		frame.getContentPane().add(comboBox_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("R\u00E9ference :");
		lblNewLabel_9.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_9.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(10, 391, 116, 31);
		frame.getContentPane().add(lblNewLabel_9);
		

		spinner_1.setBounds(135, 444, 136, 33);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_10 = new JLabel("Quantit\u00E9 :");
		lblNewLabel_10.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_10.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(10, 444, 121, 31);
		frame.getContentPane().add(lblNewLabel_10);
		
	
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(186, 506, 85, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextArea totale = new JTextArea();
		
		JButton btnNewButton_6 = new JButton("Afficher Totale");
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
					ResultSet rs=stmt.executeQuery("SELECT * FROM ffldetail WHERE codeffl = '"+codeffl.getText()+"'");
					while(rs.next()) {
						um = rs.getString("referenceproduit");
						Double pht=Double.parseDouble(rs.getString("thorstax"));
						Double ptt=Double.parseDouble(rs.getString("tavect"));
						Double pt=Double.parseDouble(rs.getString("tt"));
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
							+ "\nPrix Facture Hors TVA:**"+tht+" "+tnd+"\n"
							+"Prix Facture avec Tva:**"+tt+" "+tnd+"\n"
							+"Prix Totale à Payer:**"+tp+" "+tnd+"\n"
							);
					stmt.executeUpdate("UPDATE `factureflibre` SET `tothtva`="+tht+",`tottva`="+tt+",`totpayer`="+tp+" WHERE `codeffl`='"+codeffl.getText()+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(460, 513, 157, 41);
		frame.getContentPane().add(btnNewButton_6);
		
		JTextArea textArea_2 = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("");
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
		
		JButton btnNewButton_7 = new JButton("Finaliser le bon ");
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
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(668, 513, 157, 41);
		frame.getContentPane().add(btnNewButton_7);
		
		
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\printer.png"));
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(888, 513, 85, 41);
		frame.getContentPane().add(btnNewButton_1);
		
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
		btnNewButton_4.setBounds(1015, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
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
		btnNewButton_3.setBounds(527, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionFFL f;
				try {
					f = new GestionFFL();
					frame.dispose();
					f.frame.setVisible(true);
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
		btnNewButton_5.setBounds(30, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(327, 71, 321, 425);
		frame.getContentPane().add(panel);
		
		
		textArea.setRows(20);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 301, 244);
		panel.add(textArea);
		
		
		totale.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		totale.setEditable(false);
		totale.setBounds(10, 264, 301, 151);
		panel.add(totale);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(658, 71, 417, 425);
		frame.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 393, 405);
		panel_1.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel_1);
		
		textArea_2.setRows(20);
		textArea_2.setLineWrap(true);
		textArea_2.setEditable(false);
		textArea_2.setBounds(22, 20, 378, 383);
		
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
