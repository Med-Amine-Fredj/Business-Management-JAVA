package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class AjouterFFBL {

	public JFrame frame;
	private JTextField codeffbl;
	private JComboBox comboBox_3 ;
	private Double el1=0.000,el2=0.000,el3=0.000;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterFFBL window = new AjouterFFBL();
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
	public AjouterFFBL() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
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
	public String[] ShowBon(String term) throws SQLException {
		int i=0;
		String[] fortable = new String[1000];
			String ref="where codef='"+term+"'";
			Statement stmt=(Statement) DataBaseConnection.connection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM bonreception "+ref+"");
			while(rs.next()) {
				String CodeFor=rs.getString("codebr");
			fortable[i]=CodeFor;
			i++;			
		}
			return fortable;
	}
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Ajouter Facture Fournisseur BL - Fredj Med Amine ");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter Une Facture Fournissuer BL");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("OCR A Extended", lblNewLabel.getFont().getStyle(), 45));
		lblNewLabel.setBounds(89, 0, 991, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Code FFBL :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 98, 115, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel erreur = new JLabel("Code Invalide !");
		erreur.setVisible(false);
		
		JComboBox comboBox_2 = new JComboBox(ShowBon(null));
			comboBox_2.setBackground(new Color(255, 255, 255));
			comboBox_2.setBounds(135, 442, 136, 35);
			frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox = new JComboBox(ShowFournisseur());
	
		JSpinner spinner = new JSpinner();
		
		JTextArea textArea = new JTextArea();
		
		String[] mode = {"Chèque","Virement","Espèce"};
		JComboBox comboBox_1 = new JComboBox(mode);
		
		JTextArea textArea_1 = new JTextArea();
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Statement stmt = null;
			
			try {
				String codebr1=null;
				stmt = (Statement) DataBaseConnection.connection.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT * FROM  bonreception WHERE codebr = '"+comboBox_3.getSelectedItem().toString()+"'");
				while(rs.next()) {
					codebr1=rs.getString("codebr");
					Double ptht=Double.parseDouble(rs.getString("totalehtva"));
					Double ptt=Double.parseDouble(rs.getString("totaletva"));
					Double ptp=Double.parseDouble(rs.getString("totalepayer"));	
					


					String fredj =textArea_1.getText();
					
						textArea_1.setText("Code Bon De Réception: "+codebr1+"\n"
							+ "Somme Totale Hors TVA: "+ptht+"\n"
							+ "Somme Totale TVA : "+ptt+"\n"
								+ "Somme Totale à Payer: "+ptp+"\n"
								);
				textArea_1.setText(fredj+"\n----------------------------------------------------------------------------------------- \n"+textArea_1.getText());
				el1 = el1 + ptht;
				el2 = el2 + ptt;
				el3 = el3 + ptp;

				}
				stmt.executeUpdate("INSERT INTO `ffbldetail`(`codeffbl`, `codebr`) VALUES ('"+codeffbl.getText()+"','"+comboBox_3.getSelectedItem().toString()+"')");

				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			stmt.executeUpdate("UPDATE `facturefbl` SET `totohtva`="+el1+", `tototva`="+el2+", `toto`="+el3+" WHERE `codeffbl`='"+codeffbl.getText()+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			}
		});
		btnNewButton_1.setEnabled(false);
		
		JButton btnNewButton_2 = new JButton("Afficher Totale");
		btnNewButton_2.setEnabled(false);
	
		JButton btnNewButton = new JButton("");
		
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				textArea.setText("\n \t Détailles Facture FBL \n \n \n"
									+"Code FFBL: "+codeffbl.getText()+"\n \n"
									+ "Code Fournisseur: "+comboBox.getSelectedItem().toString()+"\n \n"
									+ "Date du Facture: "+spinner.getValue()+"\n \n"
									+ "Mode de Payement: "+comboBox_1.getSelectedItem().toString()+"\n"
								);
				Statement stmt;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					stmt.executeUpdate("INSERT INTO `facturefbl`(`codeffbl`, `codefournisseur`, `datefacture`, `modepay`) VALUES ('"+codeffbl.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+spinner.getValue().toString()+"','"+comboBox_1.getSelectedItem().toString()+"')");
					btnNewButton_1.setEnabled(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				comboBox_2.setVisible(false);
				try {
					comboBox_3 = new JComboBox(ShowBon(comboBox.getSelectedItem().toString()));
					comboBox_3.setBackground(new Color(255, 255, 255));
					comboBox_3.setBounds(135, 442, 136, 35);
					frame.getContentPane().add(comboBox_3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  
				codeffbl.setEditable(false);
				comboBox.setEnabled(false);
				spinner.setEnabled(false);
				comboBox_1.setEnabled(false);
				btnNewButton.setEnabled(false);
				btnNewButton_2.setEnabled(true);


			}
		});
		
		
		codeffbl = new JTextField();
		codeffbl.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Statement stmt;
				try {
					stmt = (Statement)DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM facturefbl");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("codeffbl"));
					}
					if(test.contains(codeffbl.getText()) || codeffbl.getText().isEmpty()) {
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
		codeffbl.setBackground(new Color(255, 255, 255));
		codeffbl.setBounds(135, 98, 136, 33);
		frame.getContentPane().add(codeffbl);
		codeffbl.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fournisseur : ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 173, 115, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
	
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(135, 173, 136, 33);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Date Facture :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 241, 115, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		spinner.setBackground(new Color(255, 255, 255));
		spinner.setModel(new SpinnerDateModel(new Date(1611270000000L), new Date(1611270000000L), null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(135, 241, 136, 33);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_4 = new JLabel("Mode Payement :");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 296, 115, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		

		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(135, 297, 136, 33);
		frame.getContentPane().add(comboBox_1);
		
		
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton.setBounds(186, 354, 85, 48);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Code BR :");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 441, 136, 33);
		frame.getContentPane().add(lblNewLabel_5);
		
		

		
		
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton_1.setBounds(186, 499, 85, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(291, 63, 309, 425);
		frame.getContentPane().add(panel);
		
		
		textArea.setRows(20);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 289, 244);
		panel.add(textArea);
		
		JTextArea totale = new JTextArea();
		totale.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		totale.setEditable(false);
		totale.setBounds(10, 264, 289, 151);
		panel.add(totale);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(610, 63, 429, 425);
		frame.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 409, 405);
		panel_1.add(scrollPane);
		
	
		scrollPane.setViewportView(textArea_1);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Statement stmt;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM facturefbl WHERE codeffbl = '"+codeffbl.getText()+"'");
					while(rs.next()) {
						Double pht=Double.parseDouble(rs.getString("totohtva"));
						Double ptt=Double.parseDouble(rs.getString("tototva"));
						Double pt=Double.parseDouble(rs.getString("toto"));
					totale.setText("                Les Prix Totales : \n"
							+ "\nPrix Totale Hors TVA:**"+pht+"\n"
							+"Prix Du Bon avec Tva:**"+ptt+"\n"
							+"Prix Finale à Payer:**"+pt+"\n"
							);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

					}
		});
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(464, 512, 165, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextArea textArea_2 = new JTextArea();	
		textArea_2.setRows(20);
		textArea_2.setLineWrap(true);
		textArea_2.setEditable(false);
		textArea_2.setBounds(22, 20, 378, 383);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnNewButton_4.setEnabled(false);
		
		
		JButton btnNewButton_3 = new JButton("Finaliser la facture");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Finaliser Le Bon ?")==0) {
					JOptionPane.showInternalMessageDialog(null, "Bon Créer Avec Succès !");
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(false);
					btnNewButton_1.setEnabled(false);
					btnNewButton_3.setEnabled(false);
					btnNewButton_4.setEnabled(true);
					}
				
			}
		});
		btnNewButton_3.setFont(new Font("Berlin Sans FB Demi", btnNewButton_3.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(652, 512, 165, 48);
		frame.getContentPane().add(btnNewButton_3);
		
		
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\printer.png"));
		btnNewButton_4.setBounds(844, 512, 85, 48);
		frame.getContentPane().add(btnNewButton_4);
		
		
		erreur.setForeground(new Color(255, 51, 51));
		erreur.setFont(new Font("Baskerville Old Face", erreur.getFont().getStyle() | Font.BOLD, 12));
		erreur.setBounds(156, 141, 115, 22);
		frame.getContentPane().add(erreur);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(0, 0, 1, 20);
		frame.getContentPane().add(verticalStrut);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quittez ?")==0) {
					frame.dispose(); 
					}				
			}
		});
		btnNewButton_4_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4_1.setBackground(Color.WHITE);
		btnNewButton_4_1.setBounds(1012, 601, 48, 39);
		frame.getContentPane().add(btnNewButton_4_1);
		
		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m= new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(530, 601, 48, 39);
		frame.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionFFBL p;
				try {
					p = new GestionFFBL();
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
		btnNewButton_5.setBounds(42, 601, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1090, 653);
		frame.getContentPane().add(lblNewLabel_6);
		
		
		
		
		
		
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
