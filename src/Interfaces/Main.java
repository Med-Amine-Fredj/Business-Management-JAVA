package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Main {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login window = new Login();
					window.frame.setVisible(true);
					
			         
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Fredj Med Amine ");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1094, 691);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fonctionnalit\u00E9s de Structure");
		lblNewLabel.setFont(new Font("OCR A Extended", lblNewLabel.getFont().getStyle(), 30));
		lblNewLabel.setForeground(new Color(255, 255, 204));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(223, 10, 646, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Produits");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", btnNewButton.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produits p;
				try {
					p = new Produits();
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
		btnNewButton.setBounds(72, 85, 175, 56);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Famille Produits");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionFP fp = new GestionFP();
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
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(268, 85, 175, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fournisseurs");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionFournisseur gf = new GestionFournisseur();
					frame.dispose();
					gf.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", btnNewButton_2.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(465, 84, 175, 56);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Clients");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionClients c = new GestionClients();
					frame.dispose();
					c.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Berlin Sans FB Demi", btnNewButton_3.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBounds(658, 85, 175, 57);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "r u sure")==0) {
					frame.dispose();
				}
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\logout (1).png"));
		btnNewButton_4.setBounds(1004, 589, 57, 45);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("Entreprises");
		btnNewButton_3_1.addActionListener(new ActionListener() {
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
		btnNewButton_3_1.setForeground(new Color(0, 0, 0));
		btnNewButton_3_1.setFont(new Font("Berlin Sans FB Demi", btnNewButton_3_1.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_3_1.setBackground(new Color(255, 255, 255));
		btnNewButton_3_1.setBounds(853, 85, 175, 56);
		frame.getContentPane().add(btnNewButton_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Fonctionnalit\u00E9s D'achats");
		lblNewLabel_1.setFont(new Font("OCR A Extended", lblNewLabel_1.getFont().getStyle(), 30));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_1.setBounds(268, 180, 565, 64);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_5 = new JButton("Bon De R\u00E9ception");
		btnNewButton_5.setFont(new Font("Berlin Sans FB Demi", btnNewButton_5.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LesBonReception b = new LesBonReception();
					frame.dispose();
					b.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_5.setBounds(265, 244, 175, 56);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Facture FournisseurBL");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionFFBL g;
				try {
					g = new GestionFFBL();
					frame.dispose();
					g.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_6.setFont(new Font("Berlin Sans FB Demi", btnNewButton_6.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(461, 244, 175, 56);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Facture FournisseurL");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionFFL f = new GestionFFL() ;
					frame.dispose();
					f.frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setFont(new Font("Berlin Sans FB Demi", btnNewButton_7.getFont().getStyle() | Font.BOLD, 12));
		btnNewButton_7.setBounds(658, 247, 175, 53);
		frame.getContentPane().add(btnNewButton_7);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}
