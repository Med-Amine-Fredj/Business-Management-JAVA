package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DataBase.DataBaseConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Produits {
	public JFrame frame;
	public JTable table;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produits window = new Produits();
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
	
	public Produits() throws ClassNotFoundException, SQLException {
		initialize();
		DataBaseConnection.connecter();
		affichertableau(null,null);
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
			ResultSet result=stmt.executeQuery("SELECT * FROM produit ");
			table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT * FROM produit "+ref+"");
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
		frame.setTitle("Gestion Commerciales - Gestion Produits - Fredj Med Amine ");
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 137, 815, 454);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("AJouter Produit");
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", btnNewButton.getFont().getStyle() | Font.BOLD, 10));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterProduit a;
				try {
					a = new AjouterProduit();
					frame.dispose();
					a.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(888, 231, 179, 73);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editer Produit");
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 10));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int RowIndexSelected=table.getSelectedRow();
				String Refernce=table.getValueAt(RowIndexSelected, 0).toString();
				String Designation=table.getValueAt(RowIndexSelected, 1).toString();
				String Unite=table.getValueAt(RowIndexSelected, 2).toString();
				String codefornisseur=table.getValueAt(RowIndexSelected, 3).toString();
				String codefamileproduit=table.getValueAt(RowIndexSelected, 4).toString();
				String stock=table.getValueAt(RowIndexSelected, 5).toString();
				String stockmin=table.getValueAt(RowIndexSelected, 6).toString();
				String prixhorstaxe=table.getValueAt(RowIndexSelected, 7).toString();
				String taxe=table.getValueAt(RowIndexSelected, 8).toString();
				

				String OpRefernce=JOptionPane.showInputDialog(null,"Entrez la nouvelle référence:",Refernce);
				String OpDesignation=JOptionPane.showInputDialog(null,"Entrez la nouvelle désignation:",Designation);
				////////////////////////////////////////////////////////////////////////////////////
				String[] stringg={"DOLAR","POUND","EURO","TND","YEN"};
				JComboBox j=new JComboBox(stringg);
				 JScrollPane jscrollpane=new JScrollPane();
		          jscrollpane.setViewportView(j);
		          JOptionPane.showMessageDialog(null, jscrollpane, "Entrez la nouvelle unité:", JOptionPane.PLAIN_MESSAGE);
		          String OpUnite= (String) j.getSelectedItem();
		          ///////////////////////////////////////////////////////////////////////////
		          
					AjouterProduit codefamileproduittable=new AjouterProduit();
					JComboBox codefamileproduitJCombo=new JComboBox(codefamileproduittable.ShowFamilleProduit());
					 JScrollPane codefamileproduitjscrollpane=new JScrollPane();
					 codefamileproduitjscrollpane.setViewportView(codefamileproduitJCombo);
			          JOptionPane.showMessageDialog(null, codefamileproduitjscrollpane, "Entrez le CodeFamille:", JOptionPane.PLAIN_MESSAGE);
			          String Newcodefamileproduit= (String) codefamileproduitJCombo.getSelectedItem();
			          ///////////////////////////////////////////////////////////////////////////
			          AjouterProduit codefornisseurtable=new AjouterProduit();
						JComboBox codefornisseurJCombo=new JComboBox(codefornisseurtable.ShowFournisseur());
						 JScrollPane codefornisseurjscrollpane=new JScrollPane();
						 codefornisseurjscrollpane.setViewportView(codefornisseurJCombo);
				          JOptionPane.showMessageDialog(null, codefornisseurjscrollpane, "Entrez le CodeFournisseur:", JOptionPane.PLAIN_MESSAGE);
				          String Newcodefornisseur= (String) codefornisseurJCombo.getSelectedItem();
				
			          //////////////////////////////////////////////////////////////////////////
				String Opstock=JOptionPane.showInputDialog(null,"Entrez le nouveau stock:",stock);
				String Opstockmin=JOptionPane.showInputDialog(null,"Entrez le nouveau stock minimale:",stockmin);
				String Opprixhorstaxe=JOptionPane.showInputDialog(null,"Entrez le nouveau prix hors taxe:",prixhorstaxe);
				String Optaxe=JOptionPane.showInputDialog(null,"Entrez la nouvelle Taxe:",taxe);
				
				
					table.setValueAt(OpRefernce, RowIndexSelected, 0);
					table.setValueAt(OpDesignation, RowIndexSelected, 1);
					table.setValueAt(OpUnite, RowIndexSelected, 2);
					table.setValueAt(Integer.parseInt(Opstock), RowIndexSelected, 5);
					table.setValueAt(Integer.parseInt(Opstockmin), RowIndexSelected, 6);
					table.setValueAt(Double.parseDouble(Opprixhorstaxe), RowIndexSelected, 7);
					table.setValueAt(Double.parseDouble(Optaxe), RowIndexSelected, 8);
					
					String NewRef=table.getValueAt(RowIndexSelected, 0).toString();
					String NewDesignation=table.getValueAt(RowIndexSelected, 1).toString();
					String NewUnite=table.getValueAt(RowIndexSelected, 2).toString();
					String Newstock=table.getValueAt(RowIndexSelected, 5).toString();
					String Newstockmin=table.getValueAt(RowIndexSelected, 6).toString();
					String Newprixhorstaxe=table.getValueAt(RowIndexSelected, 7).toString();
					String Newtaxe=table.getValueAt(RowIndexSelected, 7).toString();

					
					
					
					int newstock=Integer.parseInt(Newstock);
					int newstockmin=Integer.parseInt(Newstockmin);
					Double newprixhorstaxe=Double.parseDouble(Newprixhorstaxe);
					Double newtaxe=Double.parseDouble(Newtaxe);
					
				
					
					
						Statement stmt=(Statement) DataBaseConnection.connection.createStatement();
						stmt.executeUpdate("UPDATE `produit` SET `reference`='"+NewRef+"',`designation`='"+NewDesignation+"',`unitedemesure`='"+NewUnite+"',`codefournisseur`='"+Newcodefornisseur+"',`codefamilleprodit`='"+Newcodefamileproduit+"',`stock`="+newstock+",`stockminimale`="+newstockmin+",`prixhorstaxe`="+newprixhorstaxe+",`taxe`="+newtaxe+" WHERE reference='"+Refernce+"'");
					JOptionPane.showInternalMessageDialog(null, "Update Succes");
					
						frame.dispose();
						Produits p=new Produits();
						p.frame.setVisible(true);
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					 catch (SQLException e1) {
					
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_1.setBounds(888, 341, 179, 73);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer Produit");
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 10));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int rowindex=table.getSelectedRow();
					String tableRef=table.getValueAt(rowindex, 0).toString();
					try {
						Statement stmt =(Statement) DataBaseConnection.connection.createStatement();
						if(JOptionPane.showInternalConfirmDialog(null, "R u sure ???")==0) {
						stmt.executeUpdate("DELETE FROM `produit` WHERE reference='"+tableRef+"'");
						try {
							frame.dispose();

							Produits p=new Produits();
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
		btnNewButton_2.setBounds(888, 467, 179, 73);
		frame.getContentPane().add(btnNewButton_2);
		
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
		btnNewButton_4.setBounds(1005, 601, 48, 39);
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
		btnNewButton_3.setBounds(506, 601, 48, 39);
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
		btnNewButton_5.setBounds(35, 601, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		search = new JTextField();
		search.setBounds(35, 86, 591, 41);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		String[] mode = {"reference ","designation","codefournisseur","codefamilleprodit","stock"};
		JComboBox comboBox = new JComboBox(mode);
		comboBox.setFont(new Font("Berlin Sans FB Demi", comboBox.getFont().getStyle() | Font.BOLD, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				affichertableau(search.getText(),comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\footprint.png"));
		btnNewButton_6.setBounds(780, 86, 70, 41);
		frame.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("GESTION PRODUITS");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("OCR A Extended", lblNewLabel.getFont().getStyle() | Font.BOLD, 45));
		lblNewLabel.setBounds(338, 0, 513, 66);
		frame.getContentPane().add(lblNewLabel);

		JButton btnFamilleProduit = new JButton("Famille Produit");
		btnFamilleProduit.setFont(new Font("Berlin Sans FB Demi", btnFamilleProduit.getFont().getStyle() | Font.BOLD, 10));
		btnFamilleProduit.setBackground(new Color(255, 255, 255));
		btnFamilleProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionFP fp;
				try {
					fp = new GestionFP();
					frame.dispose();
					fp.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		btnFamilleProduit.setBounds(888, 118, 179, 73);
		frame.getContentPane().add(btnFamilleProduit);
		
		

		comboBox.setBounds(636, 86, 134, 41);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
