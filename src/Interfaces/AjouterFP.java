package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;

public class AjouterFP {

	public JFrame frame;
	public JTextField codeProuit;
	public JTextField Designation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterFP window = new AjouterFP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Connection connection;
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @wbp.parser.entryPoint
	 */
	
	public AjouterFP() throws SQLException, ClassNotFoundException {
		
	
			  	Class.forName("com.mysql.jdbc.Driver");  
			  	connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-commerciales","root","");
			  	initialize();
			  	
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Ajouter Famille Produit - Fredj Med Amine ");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1094, 691);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code FamilleProduit : ");
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", lblNewLabel.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(260, 170, 153, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Code Produit Existe D\u00E9j\u00E0 ou Champ Vide!!!");
		lblNewLabel_9.setFont(new Font("Baskerville Old Face", lblNewLabel_9.getFont().getStyle() | Font.BOLD, 12));
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(501, 218, 235, 39);
		frame.getContentPane().add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);;
		codeProuit = new JTextField();
		codeProuit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Statement stmt = (Statement)connection.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * FROM familleproduit");
					ArrayList<String> test= new ArrayList<String>();

					while(rs.next()) {
						test.add(rs.getString("copdefp"));
					}
					if(test.contains(codeProuit.getText()) || codeProuit.getText().isEmpty()) {
						lblNewLabel_9.setVisible(true);
						btnNewButton.setEnabled(false);;
						
					} else {
						lblNewLabel_9.setVisible(false);
						btnNewButton.setEnabled(true);
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		codeProuit.setBackground(new Color(255, 255, 255));
		codeProuit.setFont(new Font("Berlin Sans FB Demi", codeProuit.getFont().getStyle(), codeProuit.getFont().getSize()));
		codeProuit.setBounds(444, 172, 362, 36);
		frame.getContentPane().add(codeProuit);
		codeProuit.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9signation :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 14));
		lblNewLabel_1.setBounds(260, 265, 153, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		Designation = new JTextField();
		Designation.setBackground(new Color(255, 255, 255));
		Designation.setBounds(444, 267, 362, 38);
		frame.getContentPane().add(Designation);
		Designation.setColumns(10);
		/* ***********************************************COMBOBOX FOURNISSEUR ************************************************ */
	
	  
	    
		
		JLabel lblAjouterProduit = new JLabel("AJOUTER FAMILLE PRODUIT");
		lblAjouterProduit.setFont(new Font("OCR A Extended", lblAjouterProduit.getFont().getStyle() | Font.BOLD, 45));
		lblAjouterProduit.setForeground(new Color(255, 255, 204));
		lblAjouterProduit.setBounds(242, 29, 655, 54);
		frame.getContentPane().add(lblAjouterProduit);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				frame.dispose();
				m.frame.setVisible(true);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\house.png"));
		btnNewButton_3.setBounds(529, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Voulez Vous Quitter ?")==0) {
					frame.dispose();
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(980, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionFP p;
				try {
					p = new GestionFP();
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
		btnNewButton_5.setBounds(80, 585, 48, 39);
		frame.getContentPane().add(btnNewButton_5);
		
		
		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Statement stmt=(Statement)connection.createStatement();
					stmt.executeUpdate("INSERT INTO `familleproduit`(`id`, `copdefp`, `designation`) VALUES ("+null+",'"+codeProuit.getText()+"','"+Designation.getText()+"') ");
					JOptionPane.showInternalMessageDialog(null, "Famille Produit Ajouter !");
					GestionFP p;
					try {
						p = new GestionFP();
						frame.dispose();
						p.frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\label (1).png"));
		btnNewButton.setBounds(741, 370, 65, 41);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\test.jpg"));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(0, -4, 1090, 663);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		
		
		
		
		
		/* ***********************************************COMBOBOX UNITE DE MESURE ************************************************ */
	             
	   
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
