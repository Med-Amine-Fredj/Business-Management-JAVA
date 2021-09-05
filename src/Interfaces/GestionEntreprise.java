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

public class GestionEntreprise {

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
					GestionEntreprise window = new GestionEntreprise();
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
	public GestionEntreprise() throws ClassNotFoundException, SQLException {
		initialize();
		DataBaseConnection.connecter();
		affichertableau(null);
		
	}
	 static	public String showId() {
		 return id;
		 	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void affichertableau(String term) 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where matriculefiscale='"+term+"'";
			if(search.getText().isBlank()) {
			ResultSet result=stmt.executeQuery("SELECT `matriculefiscale`, `raisonsociale`, `description`, `telfixe`, `telmobile`, `fax`, `email`, `siteweb`, `etatfiscale` FROM `entreprise`");
			table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT `matriculefiscale`, `raisonsociale`, `description`, `telfixe`, `telmobile`, `fax`, `email`, `siteweb`, `etatfiscale` FROM entreprise "+ref+"");
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
		frame.setTitle("Gestion Commerciales - Gestion Entreprise - Fredj Med Amine ");
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 138, 822, 414);
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
		btnNewButton_4.setBounds(1008, 585, 48, 39);
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
		btnNewButton_3.setBounds(507, 585, 48, 39);
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
		btnNewButton_5.setBounds(30, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("Supprimer Entreprise");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String tableRef=table.getValueAt(rowindex, 0).toString();
				try {
					Statement stmt =(Statement) DataBaseConnection.connection.createStatement();
					if(JOptionPane.showInternalConfirmDialog(null, "Vous Etes Sur de Supprimer ?")==0) {
					stmt.executeUpdate("DELETE FROM `entreprise` WHERE matriculefiscale='"+tableRef+"'");
					try {
						frame.dispose();
						GestionEntreprise p=new GestionEntreprise();
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
		btnNewButton_2.setBounds(875, 463, 181, 68);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Editer Entreprise");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int RowIndexSelected=table.getSelectedRow();
				
				String MartriculeF=table.getValueAt(RowIndexSelected, 0).toString();
				String Description=table.getValueAt(RowIndexSelected, 2).toString();
				String TelFix=table.getValueAt(RowIndexSelected, 3).toString();
				String TelM=table.getValueAt(RowIndexSelected, 4).toString();
				String Fax=table.getValueAt(RowIndexSelected, 5).toString();
				String Email=table.getValueAt(RowIndexSelected, 6).toString();
				String SiteWeb=table.getValueAt(RowIndexSelected, 7).toString();
				String EtatF=table.getValueAt(RowIndexSelected, 8).toString();
				
				String OpMartriculeF=JOptionPane.showInputDialog(null,"Entrez la nouvelle Matricule Fiscale:",MartriculeF);	
				String OpDescription=JOptionPane.showInputDialog(null,"Entrez le nouveau Description :",Description);
				////////////////////////////////////////////////////
				String[] stringg={"Etat Physique","Etat Morale"};
				JComboBox j=new JComboBox(stringg);
				 JScrollPane jscrollpane=new JScrollPane();
		          jscrollpane.setViewportView(j);
		          JOptionPane.showMessageDialog(null, jscrollpane, "Entrez le nouveau type:", JOptionPane.PLAIN_MESSAGE);
		          String  OpRaisonSociale= (String) j.getSelectedItem();
		          /////////////////////////////////////////		
					

				String OpTelM=JOptionPane.showInputDialog(null,"Entrez le nouveau Tel.Mobile :",TelFix);
				String OpTelFix=JOptionPane.showInputDialog(null,"Entrez le nouveau Tel.Fixe :",TelM);
				String OpFax=JOptionPane.showInputDialog(null,"Entrez le nouveau Fax :",Fax);
				String OpEmail=JOptionPane.showInputDialog(null,"Entrez le nouveau Email :",Email);
				String OpSiteWeb=JOptionPane.showInputDialog(null,"Entrez le nouveau SiteWeb:",SiteWeb);
		
				
				String[] stringf={"Assujiti","TVA"};
				JComboBox g=new JComboBox(stringf);
				JScrollPane jscrollpanef=new JScrollPane();
				jscrollpanef.setViewportView(g);
				JOptionPane.showMessageDialog(null, jscrollpanef, "Entrez le nouveau Etat Fiscale :", JOptionPane.PLAIN_MESSAGE);
				String  OpEtatF= (String) g.getSelectedItem();
				/////////////////////////////////////////
				
				
				table.setValueAt(OpMartriculeF, RowIndexSelected, 0);
				table.setValueAt(OpRaisonSociale, RowIndexSelected, 1);
				table.setValueAt(OpDescription, RowIndexSelected, 2);

				table.setValueAt(OpTelM, RowIndexSelected, 3);
				table.setValueAt(OpTelFix, RowIndexSelected, 4);
				table.setValueAt(OpFax, RowIndexSelected, 5);
				table.setValueAt(OpEmail, RowIndexSelected, 6);
				table.setValueAt(OpSiteWeb, RowIndexSelected, 7);
				table.setValueAt(OpEtatF, RowIndexSelected, 8);
				
				
					
				String NewMartriculeF=table.getValueAt(RowIndexSelected, 0).toString();
				String NewNom=table.getValueAt(RowIndexSelected, 1).toString();
				String NewPrenom=table.getValueAt(RowIndexSelected, 2).toString();
				String NewCin=table.getValueAt(RowIndexSelected, 3).toString();
				String NewType=table.getValueAt(RowIndexSelected, 4).toString();
				String NewTelM=table.getValueAt(RowIndexSelected, 5).toString();
				String NewTelFix=table.getValueAt(RowIndexSelected, 6).toString();
				String NewFax=table.getValueAt(RowIndexSelected, 7).toString();
				String Newf=table.getValueAt(RowIndexSelected, 8).toString();

					try {
						Statement stmt=(Statement) DataBaseConnection.connection.createStatement();
						stmt.executeUpdate("UPDATE `entreprise` SET "
								
								+ "`matriculefiscale`='"+NewMartriculeF+"',"
								+ "`raisonsociale`='"+NewNom+"',"
								+ "`description`='"+NewPrenom+"',"
								+ "`telfixe`="+Integer.parseInt(NewCin)+","
								+ "`telmobile`="+Integer.parseInt(NewType)+","
								+ "`fax`="+Integer.parseInt(NewTelM)+","
								+ "`email`='"+NewTelFix+"',"
								+ "`siteweb`='"+NewFax+"' ,"
								+ "`etatfiscale`='"+Newf+"' "

								+ " WHERE matriculefiscale='"+MartriculeF+"'");
					JOptionPane.showInternalMessageDialog(null, "Update Succes");
					try {
						frame.dispose();
						GestionEntreprise p=new GestionEntreprise();
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
		btnNewButton_1.setBounds(875, 358, 181, 68);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnAjouterFournisseur = new JButton("Ajouter Entreprise");
		btnAjouterFournisseur.setBackground(new Color(255, 255, 255));
		btnAjouterFournisseur.setFont(new Font("Berlin Sans FB Demi", btnAjouterFournisseur.getFont().getStyle() | Font.BOLD, 12));
		btnAjouterFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterEntreprise af = new AjouterEntreprise();
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
		btnAjouterFournisseur.setBounds(875, 256, 181, 68);
		frame.getContentPane().add(btnAjouterFournisseur);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\footprint.png"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichertableau(search.getText());
			}
		});
		btnNewButton_6.setBounds(783, 81, 69, 47);
		frame.getContentPane().add(btnNewButton_6);
		
		search = new JTextField();
		search.setColumns(10);
		search.setBounds(30, 81, 743, 47);
		frame.getContentPane().add(search);
		
		JLabel lblGestionFournisseur = new JLabel("GESTION ENTREPRISE");
		lblGestionFournisseur.setBackground(new Color(255, 255, 204));
		lblGestionFournisseur.setFont(new Font("OCR A Extended", lblGestionFournisseur.getFont().getStyle() | Font.BOLD, 45));
		lblGestionFournisseur.setForeground(new Color(255, 255, 204));
		lblGestionFournisseur.setBounds(330, 0, 567, 61);
		frame.getContentPane().add(lblGestionFournisseur);
		
		JButton btnAfficherAddresseEt = new JButton("Afficher Addresse/Carte bancaire");
		btnAfficherAddresseEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int  cc=table.getSelectedRow();
				   String  idd=table.getValueAt(cc, 0).toString();
				   id=idd;
				   try {
					AdresseCarteE ae = new AdresseCarteE();
					ae.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAfficherAddresseEt.setBackground(new Color(255, 255, 255));
		btnAfficherAddresseEt.setFont(new Font("Berlin Sans FB Demi", btnAfficherAddresseEt.getFont().getStyle() | Font.BOLD, 12));
		btnAfficherAddresseEt.setToolTipText("");
		btnAfficherAddresseEt.setBounds(875, 156, 181, 68);
		frame.getContentPane().add(btnAfficherAddresseEt);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		lblNewLabel_2.setBounds(-1, 0, 1105, 660);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
