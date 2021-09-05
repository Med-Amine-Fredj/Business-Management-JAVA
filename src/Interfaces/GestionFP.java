package Interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GestionFP {

	public JFrame frame;
	private JTable table;
	private JTextField search;
	private JButton btnNewButton_1;
	private JButton button;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JLabel lblGestionFamillleProduit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionFP window = new GestionFP();
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
	public GestionFP() throws ClassNotFoundException, SQLException {
		initialize();
		DataBaseConnection.connecter();
		affichertableau(null,null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void affichertableau(String term,String code) 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where "+code+"='"+term+"'";
			if(search.getText().isBlank()) {
			ResultSet result=stmt.executeQuery("SELECT `copdefp`, `designation` FROM familleproduit ");
			table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT `copdefp`, `designation` FROM familleproduit "+ref+"");
				table.setModel(DbUtils.resultSetToTableModel(result));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Gestion Facture Famille Produit - Fredj Med Amine ");
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 147, 708, 402);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		search = new JTextField();
		search.setBounds(64, 88, 474, 49);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		String[] mode = {"copdefp","designation"};
		JComboBox comboBox = new JComboBox(mode);
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"copdefp", "designation"}));
		comboBox.setFont(new Font("Berlin Sans FB Demi", comboBox.getFont().getStyle() | Font.BOLD, 11));
		comboBox.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichertableau(search.getText(),comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\footprint.png"));
		btnNewButton.setBounds(687, 88, 85, 49);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Les Produits");
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 10));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produits p = new Produits();
					frame.dispose();
					p.frame.setVisible(true);
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton_1.setBounds(815, 163, 212, 68);
		frame.getContentPane().add(btnNewButton_1);
		
		button = new JButton("New button");
		button.setBounds(909, 504, 75, -13);
		frame.getContentPane().add(button);
		
		btnNewButton_2 = new JButton("Supprimer Famille Produit");
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 10));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String tableRef=table.getValueAt(rowindex, 0).toString();
				try {
					Statement stmt =(Statement) DataBaseConnection.connection.createStatement();
					if(JOptionPane.showInternalConfirmDialog(null, "Vous Ete Sur ?")==0) {
					stmt.executeUpdate("DELETE FROM `familleproduit` WHERE copdefp='"+tableRef+"'");
					try {
						frame.dispose();

						GestionFP p=new GestionFP();
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
		btnNewButton_2.setBounds(815, 449, 212, 68);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Editer Famille Produit");
		btnNewButton_3.setFont(new Font("Berlin Sans FB Demi", btnNewButton_3.getFont().getStyle() | Font.BOLD, 10));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int RowIndexSelected=table.getSelectedRow();
		
				String Copdefp=table.getValueAt(RowIndexSelected, 0).toString();
				String Designation=table.getValueAt(RowIndexSelected, 1).toString();
				
				String OpCopdefp=JOptionPane.showInputDialog(null,"Entrez le nouveau code FP:",Copdefp);
				String OpDesignation=JOptionPane.showInputDialog(null,"Entrez la nouvelle désignatation",Designation);				
				
				table.setValueAt(OpCopdefp, RowIndexSelected, 0);
				table.setValueAt(OpDesignation, RowIndexSelected, 1);
					
				String NewCopdefp=table.getValueAt(RowIndexSelected, 0).toString();
				String NewDesignation=table.getValueAt(RowIndexSelected, 1).toString();																							
					
					try {
						Statement stmt=(Statement) DataBaseConnection.connection.createStatement();
						stmt.executeUpdate("UPDATE `familleproduit` SET `copdefp`='"+NewCopdefp+"',`designation`='"+NewDesignation+"'WHERE copdefp='"+Copdefp+"'");
					JOptionPane.showInternalMessageDialog(null, "Update Succes");
					try {
						frame.dispose();
						GestionFP p=new GestionFP();
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
		btnNewButton_3.setBounds(815, 356, 212, 68);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Ajouter Famille Produit");
		btnNewButton_4.setFont(new Font("Berlin Sans FB Demi", btnNewButton_4.getFont().getStyle() | Font.BOLD, 10));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterFP fp = new AjouterFP();
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
		btnNewButton_4.setBounds(815, 261, 212, 68);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produits p = new Produits();
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
		btnNewButton_5.setBounds(64, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m =new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_6.setBounds(548, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quittez ?")==0) {
					frame.dispose();
				}
			}
		});
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(979, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_7);
		
		lblGestionFamillleProduit = new JLabel("GESTION FAMILLLE PRODUIT");
		lblGestionFamillleProduit.setFont(new Font("OCR A Extended", lblGestionFamillleProduit.getFont().getStyle() | Font.BOLD, 45));
		lblGestionFamillleProduit.setForeground(new Color(255, 255, 204));
		lblGestionFamillleProduit.setBounds(206, 0, 728, 63);
		frame.getContentPane().add(lblGestionFamillleProduit);
		
		

		comboBox.setBounds(548, 88, 129, 49);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
