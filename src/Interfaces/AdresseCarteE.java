package Interfaces;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdresseCarteE {

		public JFrame frame;
		private JTable tablea;
		private JTable tablec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdresseCarteE window = new AdresseCarteE();
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
	public AdresseCarteE() throws ClassNotFoundException, SQLException {
		DataBase.DataBaseConnection.connecter();
		initialize();
		affichertableaua(null);
		affichertableauc(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void affichertableaua(String term) throws SQLException 
	{
		String codefournisseur=GestionEntreprise.id;
		Statement stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where mfentreprise='"+codefournisseur+"'";
				ResultSet result=stmt.executeQuery("SELECT numrue ,libellerue , nomville ,codepostale , gouvernerat ,pays FROM adresse "+ref+"");
				tablea.setModel(DbUtils.resultSetToTableModel(result));
			
	}
	private void affichertableauc(String term) throws SQLException 
	{
		String codefournisseur=GestionEntreprise.id;
		Statement stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where mfentreprise='"+codefournisseur+"'";
				ResultSet result=stmt.executeQuery("SELECT banque ,agence , rib FROM cartebancaire "+ref+"");
				tablec.setModel(DbUtils.resultSetToTableModel(result));		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - D�tailles Entreprise - Fredj Med Amine ");
		frame.setBounds(100, 100, 693, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADDRESSE & CARTE BANCAIRE ENTREPRISE");
		lblNewLabel.setFont(new Font("OCR A Extended", lblNewLabel.getFont().getStyle() | Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setBounds(11, 10, 653, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Addresse : ");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(23, 74, 85, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Carte Bancaire : ");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(23, 168, 110, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionEntreprise ge = new GestionEntreprise();
					frame.dispose();
					ge.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\reply.png"));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(23, 277, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(590, 277, 48, 39);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Editer");
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle(), 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mfentreprisec=GestionEntreprise.id;
				
				int RowIndexSelected=tablec.getSelectedRow();
				
				String Numrue=tablec.getValueAt(RowIndexSelected, 0).toString();
				String Libellerue=tablec.getValueAt(RowIndexSelected, 1).toString();
				String Nomville=tablec.getValueAt(RowIndexSelected, 2).toString();
				
				String OpNumrue=JOptionPane.showInputDialog(null,"Entrez la nouvelle banque:",Numrue);
				String OpLibellerue=JOptionPane.showInputDialog(null,"Entrez la nouvelle Agence:",Libellerue);	
				String OpNomville=JOptionPane.showInputDialog(null,"Entrez le nouveau N�RIB:",Nomville);

				
				
				tablec.setValueAt(OpNumrue, RowIndexSelected, 0);
				tablec.setValueAt(OpLibellerue, RowIndexSelected, 1);
				tablec.setValueAt(OpNomville, RowIndexSelected, 2);


				
				String NewNumrue=tablec.getValueAt(RowIndexSelected, 0).toString();
				String NewLibellerue=tablec.getValueAt(RowIndexSelected, 1).toString();
				String NewNomville=tablec.getValueAt(RowIndexSelected, 2).toString();

																						
				Statement stmt;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					stmt.executeUpdate("UPDATE `cartebancaire` SET "
							+ "`banque`='"+NewNumrue+"',"
							+ "`agence`='"+NewLibellerue+"',"
							+ "`rib`="+Integer.parseInt(NewNomville)+""
							+ " WHERE `mfentreprise`='"+mfentreprisec+"'");
					JOptionPane.showInternalMessageDialog(null, "Update Succes");
						frame.dispose();
						AdresseCarteE aee;
						try {
							aee = new AdresseCarteE();
							aee.frame.setVisible(true);
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
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(564, 200, 74, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Editer");
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle(), 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mfentreprisea=GestionEntreprise.id;
				
				int RowIndexSelected=tablea.getSelectedRow();
				
				String Numrue=tablea.getValueAt(RowIndexSelected, 0).toString();
				String Libellerue=tablea.getValueAt(RowIndexSelected, 1).toString();
				String Nomville=tablea.getValueAt(RowIndexSelected, 2).toString();
				String Codepostale=tablea.getValueAt(RowIndexSelected, 3).toString();
				String Gouv=tablea.getValueAt(RowIndexSelected, 4).toString();
				String Pays=tablea.getValueAt(RowIndexSelected, 5).toString();

				
				String OpNumrue=JOptionPane.showInputDialog(null,"Entrez le nouveau N�Rue:",Numrue);
				String OpLibellerue=JOptionPane.showInputDialog(null,"Entrez la nouvelle Libell� Rue:",Libellerue);	
				String OpNomville=JOptionPane.showInputDialog(null,"Entrez le nouveau Nom de ville:",Nomville);
				String OpCodepostale=JOptionPane.showInputDialog(null,"Entrez le nouveau Code postale:",Codepostale);
				String OpGouv=JOptionPane.showInputDialog(null,"Entrez la nouvelle Gouvernerat:",Gouv);
				String OpPays=JOptionPane.showInputDialog(null,"Entrez le nouveau Pays",Pays);

				
				
				tablea.setValueAt(OpNumrue, RowIndexSelected, 0);
				tablea.setValueAt(OpLibellerue, RowIndexSelected, 1);
				tablea.setValueAt(OpNomville, RowIndexSelected, 2);
				tablea.setValueAt(OpCodepostale, RowIndexSelected, 3);
				tablea.setValueAt(OpGouv, RowIndexSelected, 4);
				tablea.setValueAt(OpPays, RowIndexSelected, 5);

				
				String NewNumrue=tablea.getValueAt(RowIndexSelected, 0).toString();
				String NewLibellerue=tablea.getValueAt(RowIndexSelected, 1).toString();
				String NewNomville=tablea.getValueAt(RowIndexSelected, 2).toString();
				String NewCodepostale=tablea.getValueAt(RowIndexSelected, 3).toString();
				String NewGouv=tablea.getValueAt(RowIndexSelected, 4).toString();
				String NewPays=tablea.getValueAt(RowIndexSelected, 5).toString();
																						

					Statement stmt;
					try {
						stmt = (Statement) DataBaseConnection.connection.createStatement();
						stmt.executeUpdate("UPDATE `adresse` SET "
								+ "`numrue`="+Integer.parseInt(NewNumrue)+","
								+ "`libellerue`='"+NewLibellerue+"',"
								+ "`nomville`='"+NewNomville+"',"
								+ "`codepostale`="+Integer.parseInt(NewCodepostale)+","
								+ "`gouvernerat`='"+NewGouv+"',"
								+ "`pays`='"+NewPays+"'"
								+ " WHERE `mfentreprise`='"+mfentreprisea+"'");
					JOptionPane.showInternalMessageDialog(null, "Update Succes");
						frame.dispose();
						try {
							AdresseCarteE ae = new AdresseCarteE();
							ae.frame.setVisible(true);
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
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(564, 108, 74, 41);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 108, 531, 41);
		frame.getContentPane().add(scrollPane);
		
		tablea = new JTable();
		scrollPane.setViewportView(tablea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 202, 529, 39);
		frame.getContentPane().add(scrollPane_1);
		
		tablec = new JTable();
		scrollPane_1.setViewportView(tablec);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\tesetttt.jpg"));
		lblNewLabel_3.setBounds(0, 0, 689, 342);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

}
