package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GestionFFL {

	public JFrame frame;
	private JTextField search;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionFFL window = new GestionFFL();
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
	public GestionFFL() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
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
			ResultSet result=stmt.executeQuery("SELECT * FROM factureflibre ");
			table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT * FROM factureflibre "+ref+"");
				table.setModel(DbUtils.resultSetToTableModel(result));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void affichertableauligne(String term) throws SQLException 
	{
		Statement stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where codeffl='"+term+"'";
				ResultSet result=stmt.executeQuery("SELECT `referenceproduit`, `quantite`,`thorstax`, `tavect`, `tt` FROM `ffldetail` "+ref+"");
				table_1.setModel(DbUtils.resultSetToTableModel(result));		
	}
	private void affichertableaudet(String term) throws SQLException 
	{
		Statement stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where reference='"+term+"'";
				ResultSet result=stmt.executeQuery("SELECT * FROM `produit` "+ref+"");
				table_2.setModel(DbUtils.resultSetToTableModel(result));		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Gestion Facture Fournisseur Libre - Fredj Med Amine ");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		search = new JTextField();
		search.setForeground(Color.BLACK);
		search.setColumns(10);
		search.setBackground(Color.WHITE);
		search.setBounds(31, 88, 569, 49);
		frame.getContentPane().add(search);
		
		String[] mode = {"codeffl  ","codefournisseur","modepay"};
		JComboBox comboBox = new JComboBox(mode);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichertableau(search.getText(),comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\footprint.png"));
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(775, 88, 74, 49);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_1 = new JButton("Ajouter une Facture");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				AjouterFFL a = new AjouterFFL();
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
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(876, 354, 180, 68);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer Une Facture");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String codeffl=table.getValueAt(rowindex, 0).toString();
					Statement stmt;
					try {
						stmt = (Statement) DataBaseConnection.connection.createStatement();
						if(JOptionPane.showInternalConfirmDialog(null, "Etes Vous Sur de Supprimer Cette Ligne ?")==0) {
							stmt.executeUpdate("DELETE FROM `factureflibre` WHERE codeffl='"+codeffl+"'");
							stmt.executeUpdate("DELETE FROM `ffldetail` WHERE codeffl='"+codeffl+"'");
							frame.dispose();
							try {
								GestionFFL g =new GestionFFL();
								g.frame.setVisible(true);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
								}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(876, 454, 180, 68);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnAfficherLesProduits_1 = new JButton("Afficher Les Produits");
		btnAfficherLesProduits_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int RowIndexSelected=table.getSelectedRow();
				 String codeffl=table.getValueAt(RowIndexSelected, 0).toString();
				 try {
					affichertableauligne(codeffl);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAfficherLesProduits_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnAfficherLesProduits_1.setForeground(Color.BLACK);
		btnAfficherLesProduits_1.setBackground(Color.WHITE);
		btnAfficherLesProduits_1.setBounds(876, 166, 180, 68);
		frame.getContentPane().add(btnAfficherLesProduits_1);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quittez ?")==0) {
					frame.dispose(); 
					}	
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(1008, 565, 48, 39);
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
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(500, 565, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m= new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\reply.png"));
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(31, 565, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblGestionFactureFournisseur = new JLabel("GESTION FACTURE FOURNISSEUR L");
		lblGestionFactureFournisseur.setFont(new Font("OCR A Extended", lblGestionFactureFournisseur.getFont().getStyle() | Font.BOLD, 45));
		lblGestionFactureFournisseur.setForeground(new Color(255, 255, 204));
		lblGestionFactureFournisseur.setBackground(Color.WHITE);
		lblGestionFactureFournisseur.setBounds(127, 0, 887, 78);
		frame.getContentPane().add(lblGestionFactureFournisseur);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 147, 438, 342);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(479, 147, 370, 342);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(31, 499, 818, 39);
		frame.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnAfficherLesProduits_1_1 = new JButton("Afficher D\u00E9tailles Produits");
		btnAfficherLesProduits_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int RowIndexSelected=table_1.getSelectedRow();
				 String ref=table_1.getValueAt(RowIndexSelected, 0).toString();
				 try {
					affichertableaudet(ref);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAfficherLesProduits_1_1.setFont(new Font("Berlin Sans FB Demi", btnAfficherLesProduits_1_1.getFont().getStyle() | Font.BOLD, 12));
		btnAfficherLesProduits_1_1.setForeground(Color.BLACK);
		btnAfficherLesProduits_1_1.setBackground(Color.WHITE);
		btnAfficherLesProduits_1_1.setBounds(876, 261, 180, 68);
		frame.getContentPane().add(btnAfficherLesProduits_1_1);
		
		

		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Berlin Sans FB Demi", comboBox.getFont().getStyle(), 12));
		comboBox.setBounds(610, 88, 155, 49);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
