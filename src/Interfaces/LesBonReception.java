package Interfaces;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;

public class LesBonReception {

	public JFrame frame;
	private JTable table;
	private JTextField search;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LesBonReception window = new LesBonReception();
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
	public LesBonReception() throws ClassNotFoundException, SQLException {
		initialize();
		DataBase.DataBaseConnection.connecter();
		affichertableau(null,null);
		affichertableauligne(null);
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
			ResultSet result=stmt.executeQuery("SELECT * FROM bonreception ");
			table.setModel(DbUtils.resultSetToTableModel(result));

			}
			else{
				ResultSet result=stmt.executeQuery("SELECT * FROM bonreception "+ref+"");
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
			String ref="where codebr='"+term+"'";
				ResultSet result=stmt.executeQuery("SELECT `referenceproduit`, `quantite`,`totaleht`, `totalet`, `prixtotale` FROM `lignesbons` "+ref+"");
				table_1.setModel(DbUtils.resultSetToTableModel(result));		
	}
	private void affichertableaupr(String term) throws SQLException 
	{
		Statement stmt = (Statement) DataBaseConnection.connection.createStatement();
			String ref="where reference='"+term+"'";
				ResultSet result=stmt.executeQuery("SELECT * FROM produit "+ref+"");
				table_2.setModel(DbUtils.resultSetToTableModel(result));		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Gestion Des Bons De Réception - Fredj Med Amine ");
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 145, 441, 350);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		search = new JTextField();
		search.setBounds(37, 93, 536, 42);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		String[] mode = {"codebr ","codef","codecommande"};
		JComboBox comboBox = new JComboBox(mode);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Berlin Sans FB Demi", comboBox.getFont().getStyle(), 12));
		

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichertableau(search.getText(),comboBox.getSelectedItem().toString());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\footprint.png"));
		btnNewButton.setBounds(757, 93, 89, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afficher Les Lignes Du Bon");
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 int RowIndexSelected=table.getSelectedRow();
			 String codebr=table.getValueAt(RowIndexSelected, 0).toString();
			 try {
				affichertableauligne(codebr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			}
		});
		btnNewButton_1.setBounds(871, 168, 184, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ajouter Un Bon");
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionBonReception gbr = new GestionBonReception();
					frame.dispose();
					gbr.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(871, 355, 184, 63);
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
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(1007, 593, 48, 39);
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
		btnNewButton_3.setBounds(525, 593, 48, 39);
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
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(37, 593, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(496, 146, 350, 350);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("GESTION DES BONS DE RECEPTIONS");
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setFont(new Font("OCR A Extended", lblNewLabel.getFont().getStyle() | Font.BOLD, 45));
		lblNewLabel.setBounds(138, 0, 875, 83);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_6 = new JButton("Supprimer Le Bon");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String codebr=table.getValueAt(rowindex, 0).toString();
					Statement stmt;
					try {
						stmt = (Statement) DataBaseConnection.connection.createStatement();
						if(JOptionPane.showInternalConfirmDialog(null, "Etes Vous Sur de Supprimer Cette Ligne ?")==0) {
							stmt.executeUpdate("DELETE FROM `bonreception` WHERE codebr='"+codebr+"'");
							stmt.executeUpdate("DELETE FROM `lignesbons` WHERE codebr='"+codebr+"'");
							frame.dispose();
							try {
								LesBonReception bb = new LesBonReception();
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
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setFont(new Font("Berlin Sans FB Demi", btnNewButton_6.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_6.setBounds(871, 443, 184, 63);
		frame.getContentPane().add(btnNewButton_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(37, 505, 809, 42);
		frame.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton_7 = new JButton("Afficher D\u00E9tailles Produits");
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int RowIndexSelected=table_1.getSelectedRow();
				 String codebr=table_1.getValueAt(RowIndexSelected, 0).toString();
				try {
					affichertableaupr(codebr);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setFont(new Font("Berlin Sans FB Demi", btnNewButton_7.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_7.setBounds(871, 263, 184, 63);
		frame.getContentPane().add(btnNewButton_7);
		
		

		comboBox.setBounds(583, 93, 164, 42);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1090, 663);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(52, 32, 45, 13);
		frame.getContentPane().add(label);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
