package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import DataBase.DataBaseConnection;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
public class Login  {

	public JFrame frame;
	private JTextField username;
 private JPasswordField password;
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Login() throws ClassNotFoundException, SQLException {
		initialize();
		DataBaseConnection.connecter();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MSI GF63\\Downloads\\ecommerce.png"));
		frame.setTitle("Gestion Commerciales - Login - Fredj Med Amine ");
		frame.setBounds(100, 100, 511, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setBounds(181, 26, 139, 27);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(lblNewLabel);
		frame.setResizable(false);
		
		JLabel lblNewLabel_1 = new JLabel("  Utilisateur : ");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(83, 86, 118, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(224, 87, 139, 27);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", lblNewLabel_1_1.getFont().getStyle() | Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(93, 123, 121, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btn_connect = new JButton("Connecter");
		btn_connect.setFont(new Font("Berlin Sans FB Demi", btn_connect.getFont().getStyle() | Font.BOLD, 12));
		btn_connect.setBackground(new Color(255, 255, 255));
		btn_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt= (Statement) DataBase.DataBaseConnection.connection.createStatement();
					//Récupération des inputs
					String name = username.getText();
					String psw = password.getText();
					
					ResultSet result=stmt.executeQuery("SELECT * FROM login where username='"+name+"' AND mdp='"+psw+"' ");
						if(result.next())
						{
							Main m =new Main();
							m.frame.setVisible(true);
							frame.dispose();
						}else {
							JOptionPane.showMessageDialog(null,"Username or Paswword are incorrect ! ");
						}
					}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_connect.setBounds(263, 167, 100, 33);
		frame.getContentPane().add(btn_connect);
		
		password = new JPasswordField();
		password.setBounds(224, 124, 139, 33);
		frame.getContentPane().add(password);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\dddddddddddddddddddddd.jpg"));
		lblNewLabel_2.setBounds(0, 0, 507, 343);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\MSI GF63\\Downloads\\user.png"));
		lblNewLabel_3.setBounds(193, 86, 47, 27);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
