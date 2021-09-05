package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionFournisseur {

	public JFrame frame;
	public static JTable table;
	public static String id;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionFournisseur window = new GestionFournisseur();
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
	public GestionFournisseur() throws ClassNotFoundException, SQLException {
		initialize();
		DataBaseConnection.connecter();
		affichertableau(null,null);
		
	}
	static	public String showId() {
		 return id;
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void affichertableau(String term,String col) 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where "+col+"='"+term+"'";
			if(search.getText().isBlank()) {
			ResultSet result=stmt.executeQuery("SELECT * FROM fournisseur ");
			table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT * FROM fournisseur "+ref+"");
				table.setModel(DbUtils.resultSetToTableModel(result));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Gestion Fournisseur - Fredj Med Amine ");
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 163, 831, 389);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quittez ?")==0) {
					frame.dispose();
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(1010, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
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
		btnNewButton_3.setBounds(503, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\reply.png"));
		btnNewButton_5.setBounds(23, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("Supprimer Fournisseur");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String tableRef=table.getValueAt(rowindex, 0).toString();
				try {
					Statement stmt =(Statement) DataBaseConnection.connection.createStatement();
					if(JOptionPane.showInternalConfirmDialog(null, "Vous Etes Sur de Supprimer ?")==0) {
					stmt.executeUpdate("DELETE FROM `fournisseur` WHERE codefournissuer='"+tableRef+"'");
					try {
						frame.dispose();
						GestionFournisseur p=new GestionFournisseur();
						p.frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(875, 459, 183, 68);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Editer Fournisseur");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int RowIndexSelected=table.getSelectedRow();
				
				String Copdef=table.getValueAt(RowIndexSelected, 0).toString();
				String MartriculeF=table.getValueAt(RowIndexSelected, 1).toString();
				String Nom=table.getValueAt(RowIndexSelected, 2).toString();
				String Prenom=table.getValueAt(RowIndexSelected, 3).toString();
				String Cin=table.getValueAt(RowIndexSelected, 4).toString();
				String Type=table.getValueAt(RowIndexSelected, 5).toString();
				String TelM=table.getValueAt(RowIndexSelected, 6).toString();
				String TelFix=table.getValueAt(RowIndexSelected, 7).toString();
				String Fax=table.getValueAt(RowIndexSelected, 8).toString();
				String Email=table.getValueAt(RowIndexSelected, 9).toString();
				String SiteWeb=table.getValueAt(RowIndexSelected, 10).toString();
				String EtatF=table.getValueAt(RowIndexSelected, 11).toString();
				
				String OpCopdef=JOptionPane.showInputDialog(null,"Entrez le nouveau codeFournisseur:",Copdef);
				String OpMartriculeF=JOptionPane.showInputDialog(null,"Entrez la nouvelle Matricule Fiscale:",MartriculeF);	
				String OpNom=JOptionPane.showInputDialog(null,"Entrez le nouveau nom:",Nom);
				String OpPrenom=JOptionPane.showInputDialog(null,"Entrez le nouveau prenom:",Prenom);
				String OpCin=JOptionPane.showInputDialog(null,"Entrez la nouvelle carte CIN:",Cin);
				//String OpType=JOptionPane.showInputDialog(null,"Entrez le nouveau type: \n 0 => Etat Physique \n 1 => Etat Morale ",Type);
				////////////////////////////////////////////////////
				String[] stringg={"Etat Physique","Etat Morale"};
				JComboBox j=new JComboBox(stringg);
				 JScrollPane jscrollpane=new JScrollPane();
		          jscrollpane.setViewportView(j);
		          JOptionPane.showMessageDialog(null, jscrollpane, "Entrez le nouveau type:", JOptionPane.PLAIN_MESSAGE);
		          String  OpType= (String) j.getSelectedItem();
		          /////////////////////////////////////////
				String OpTelM=JOptionPane.showInputDialog(null,"Entrez le nouveau Tel.Mobile :",TelM);
				String OpTelFix=JOptionPane.showInputDialog(null,"Entrez le nouveau Tel.Fixe :",TelFix);
				String OpFax=JOptionPane.showInputDialog(null,"Entrez le nouveau Fax :",Fax);
				String OpEmail=JOptionPane.showInputDialog(null,"Entrez le nouveau Email :",Email);
				String OpSiteWeb=JOptionPane.showInputDialog(null,"Entrez le nouveau SiteWeb:",SiteWeb);
				//String OpEtatF=JOptionPane.showInputDialog(null,"Entrez le nouveau Etat Fiscale \n 0 => Etat Assujiti \n 1 => +TVA:",EtatF);
				////////////////////////////////////////////////////
				String[] stringf={"Assujiti","TVA"};
				JComboBox g=new JComboBox(stringf);
				JScrollPane jscrollpanef=new JScrollPane();
				jscrollpanef.setViewportView(g);
				JOptionPane.showMessageDialog(null, jscrollpanef, "Entrez le nouveau Etat Fiscale :", JOptionPane.PLAIN_MESSAGE);
				String  OpEtatF= (String) g.getSelectedItem();
				/////////////////////////////////////////
				
				
				table.setValueAt(OpCopdef, RowIndexSelected, 0);
				table.setValueAt(OpMartriculeF, RowIndexSelected, 1);
				table.setValueAt(OpNom, RowIndexSelected, 2);
				table.setValueAt(OpPrenom, RowIndexSelected, 3);
				table.setValueAt(OpCin, RowIndexSelected, 4);
				table.setValueAt(OpType, RowIndexSelected, 5);
				table.setValueAt(OpTelM, RowIndexSelected, 6);
				table.setValueAt(OpTelFix, RowIndexSelected, 7);
				table.setValueAt(OpFax, RowIndexSelected, 8);
				table.setValueAt(OpEmail, RowIndexSelected, 9);
				table.setValueAt(OpSiteWeb, RowIndexSelected, 10);
				table.setValueAt(OpEtatF, RowIndexSelected, 11);
				
					
				String NewCopdef=table.getValueAt(RowIndexSelected, 0).toString();
				String NewMartriculeF=table.getValueAt(RowIndexSelected, 1).toString();
				String NewNom=table.getValueAt(RowIndexSelected, 2).toString();
				String NewPrenom=table.getValueAt(RowIndexSelected, 3).toString();
				String NewCin=table.getValueAt(RowIndexSelected, 4).toString();
				String NewType=table.getValueAt(RowIndexSelected, 5).toString();
				String NewTelM=table.getValueAt(RowIndexSelected, 6).toString();
				String NewTelFix=table.getValueAt(RowIndexSelected, 7).toString();
				String NewFax=table.getValueAt(RowIndexSelected, 8).toString();
				String NewEmail=table.getValueAt(RowIndexSelected, 9).toString();
				String NewSiteWeb=table.getValueAt(RowIndexSelected, 10).toString();
				String NewEtatF=table.getValueAt(RowIndexSelected, 11).toString();																						
					
					try {
						Statement stmt=(Statement) DataBaseConnection.connection.createStatement();
						stmt.executeUpdate("UPDATE `fournisseur` SET "
								+ "`codefournissuer`='"+NewCopdef+"',"
								+ "`matriculefiscale`='"+NewMartriculeF+"',"
								+ "`nom`='"+NewNom+"',"
								+ "`prenom`='"+NewPrenom+"',"
								+ "`cin`="+Integer.parseInt(NewCin)+","
								+ "`type`='"+NewType+"',"
								+ "`telmobile`="+Integer.parseInt(NewTelM)+","
								+ "`telfixe`="+Integer.parseInt(NewTelFix)+","
								+ "`fax`="+Integer.parseInt(NewFax)+","
								+ "`email`='"+NewEmail+"',"
								+ "`siteweb`='"+NewSiteWeb+"',"
								+ "`etatfiscale`='"+NewEtatF+"'"
								+ " WHERE codefournissuer='"+Copdef+"'");
					JOptionPane.showInternalMessageDialog(null, "Update Succes");
					try {
						frame.dispose();
						GestionFournisseur p=new GestionFournisseur();
						p.frame.setVisible(true);
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
			}
		});
		JButton btnAfficherAddresseEt = new JButton("Afficher Addresse/Carte bancaire");
		btnAfficherAddresseEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 	int  cc=table.getSelectedRow();
				   String  idd=table.getValueAt(cc, 0).toString();
				   id=idd;
				try {
					AdresseCarteF af = new AdresseCarteF();
					af.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(875, 365, 183, 68);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnAjouterFournisseur = new JButton("Ajouter Fournisseur");
		btnAjouterFournisseur.setBackground(new Color(255, 255, 255));
		btnAjouterFournisseur.setFont(new Font("Berlin Sans FB Demi", btnAjouterFournisseur.getFont().getStyle() | Font.BOLD, 12));
		btnAjouterFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterFournisseur af = new AjouterFournisseur();
					frame.dispose();
					af.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAjouterFournisseur.setBounds(875, 273, 183, 68);
		frame.getContentPane().add(btnAjouterFournisseur);
		
		String[] mode = {"codefournissuer ","matriculefiscale","nom","prenom","cin"};
		JComboBox comboBox = new JComboBox(mode);
		comboBox.setFont(new Font("Berlin Sans FB Demi", comboBox.getFont().getStyle(), 12));
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\footprint.png"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichertableau(search.getText(),comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton_6.setBounds(785, 104, 69, 49);
		frame.getContentPane().add(btnNewButton_6);
		
		search = new JTextField();
		search.setColumns(10);
		search.setBounds(23, 104, 579, 49);
		frame.getContentPane().add(search);
		
		JLabel lblGestionFournisseur = new JLabel("GESTION FOURNISSEUR");
		lblGestionFournisseur.setBackground(new Color(255, 255, 204));
		lblGestionFournisseur.setFont(new Font("OCR A Extended", lblGestionFournisseur.getFont().getStyle() | Font.BOLD, 45));
		lblGestionFournisseur.setForeground(new Color(255, 255, 204));
		lblGestionFournisseur.setBounds(328, 10, 567, 39);
		frame.getContentPane().add(lblGestionFournisseur);
		

		btnAfficherAddresseEt.setBackground(new Color(255, 255, 255));
		btnAfficherAddresseEt.setFont(new Font("Berlin Sans FB Demi", btnAfficherAddresseEt.getFont().getStyle() | Font.BOLD, 12));
		btnAfficherAddresseEt.setToolTipText("");
		btnAfficherAddresseEt.setBounds(875, 179, 183, 68);
		frame.getContentPane().add(btnAfficherAddresseEt);

		comboBox.setBounds(612, 104, 163, 49);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
