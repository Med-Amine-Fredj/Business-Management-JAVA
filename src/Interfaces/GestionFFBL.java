package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;

public class GestionFFBL {

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
					GestionFFBL window = new GestionFFBL();
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
	public GestionFFBL() throws ClassNotFoundException, SQLException {
		DataBaseConnection.connecter();
		initialize();
		affichertableau(null,null);
		affichertableauligne(null);
		affichertableaudetail(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void affichertableau(String term,String col) 
	{
		Statement stmt;
		try {
			stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where "+col+" ='"+term+"'";
			if(search.getText().isBlank()) {
			ResultSet result=stmt.executeQuery("SELECT `codeffbl`, `codefournisseur`, `datefacture`, `modepay`, `totohtva`, `tototva`, `toto` FROM facturefbl ");
			table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT `codeffbl`, `codefournisseur`, `datefacture`, `modepay`, `totohtva`, `tototva`, `toto` FROM facturefbl "+ref+"");
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
			String ref="where codeffbl='"+term+"'";
				ResultSet result=stmt.executeQuery("SELECT `codebr` FROM `ffbldetail` "+ref+"");
				table_1.setModel(DbUtils.resultSetToTableModel(result));		
	}
	private void affichertableaudetail(String term) throws SQLException 
	{
		Statement stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where codebr='"+term+"'";
				ResultSet result=stmt.executeQuery("SELECT `referenceproduit`, `quantite`,`totaleht`, `totalet`, `prixtotale` FROM `lignesbons` "+ref+"");
				table_2.setModel(DbUtils.resultSetToTableModel(result));		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Gestion Facture Fournisseur BL - Fredj Med Amine ");
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		search = new JTextField();
		search.setForeground(Color.BLACK);
		search.setColumns(10);
		search.setBackground(Color.WHITE);
		search.setBounds(30, 95, 579, 49);
		frame.getContentPane().add(search);
		
		String[] mode = {"codeffbl  ","codefournisseur","modepay"};
		JComboBox comboBox = new JComboBox(mode);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Berlin Sans FB Demi", comboBox.getFont().getStyle() | Font.BOLD, 12));
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 affichertableau(search.getText(),comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\footprint.png"));
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(762, 95, 74, 49);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnAfficherLesBons = new JButton("Afficher Les Bons De Receptions");
		btnAfficherLesBons.setFont(new Font("Berlin Sans FB Demi", btnAfficherLesBons.getFont().getStyle() | Font.BOLD, 12));
		btnAfficherLesBons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int RowIndexSelected=table.getSelectedRow();
				 String codeffbl=table.getValueAt(RowIndexSelected, 0).toString();
				 try {
					affichertableauligne(codeffbl);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAfficherLesBons.setToolTipText("");
		btnAfficherLesBons.setForeground(Color.BLACK);
		btnAfficherLesBons.setBackground(Color.WHITE);
		btnAfficherLesBons.setBounds(858, 179, 195, 68);
		frame.getContentPane().add(btnAfficherLesBons);
		
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
		btnNewButton_4.setBounds(1018, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m =new Main();
				frame.dispose();
				m.frame.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(499, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m =new Main();
				frame.dispose();
				m.frame.setVisible(true);
				}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\reply.png"));
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(30, 594, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnAfficherLesProduits = new JButton("Afficher Les Lignes de Bons");
		btnAfficherLesProduits.setFont(new Font("Berlin Sans FB Demi", btnAfficherLesProduits.getFont().getStyle() | Font.BOLD, 12));
		btnAfficherLesProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int RowIndexSelected=table_1.getSelectedRow();
				 String codebr=table_1.getValueAt(RowIndexSelected, 0).toString();
					try {
						affichertableaudetail(codebr);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnAfficherLesProduits.setForeground(Color.BLACK);
		btnAfficherLesProduits.setBackground(Color.WHITE);
		btnAfficherLesProduits.setBounds(858, 281, 195, 68);
		frame.getContentPane().add(btnAfficherLesProduits);
		
		JButton btnNewButton_1 = new JButton("Ajouter une Facture");
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterFFBL ff;
				try {
					ff = new AjouterFFBL();
					frame.dispose();
					ff.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(858, 378, 195, 68);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer Une Facture");
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String codeffbl=table.getValueAt(rowindex, 0).toString();
				Statement stmt;
				try {
					stmt = (Statement) DataBaseConnection.connection.createStatement();
					if(JOptionPane.showInternalConfirmDialog(null, "Etes Vous Sur de Supprimer Cette Ligne ?")==0) {
						stmt.executeUpdate("DELETE FROM `facturefbl` WHERE codeffbl='"+codeffbl+"'");
						stmt.executeUpdate("DELETE FROM `ffbldetail` WHERE codeffbl='"+codeffbl+"'");
						frame.dispose();
							GestionFFBL bb;
							try {
								bb = new GestionFFBL();
								bb.frame.setVisible(true);
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
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(858, 477, 195, 68);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblGestionFournisseur = new JLabel("GESTION FACTURE FOURNISSEUR BL");
		lblGestionFournisseur.setFont(new Font("OCR A Extended", lblGestionFournisseur.getFont().getStyle() | Font.BOLD, 45));
		lblGestionFournisseur.setForeground(new Color(255, 255, 204));
		lblGestionFournisseur.setBackground(Color.WHITE);
		lblGestionFournisseur.setBounds(128, 0, 887, 85);
		frame.getContentPane().add(lblGestionFournisseur);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 154, 437, 416);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(477, 154, 359, 210);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(477, 374, 359, 196);
		frame.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		

		comboBox.setBounds(619, 95, 133, 49);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
