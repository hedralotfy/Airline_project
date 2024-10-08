import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordText;
	Connection con;
	PreparedStatement pst;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public Main() {
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 359, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(60, 34, 91, 27);
		contentPane.add(lblNewLabel);
		
		usernameText = new JTextField();
		usernameText.setColumns(10);
		usernameText.setBounds(143, 38, 138, 20);
		contentPane.add(usernameText);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(60, 72, 91, 27);
		contentPane.add(lblPassword);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(143, 76, 138, 20);
		contentPane.add(passwordText);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				String password = passwordText.getText();
				
				if(username.isEmpty() || username.matches("[A-Z][a-z]+([A-Z][a-z]+)*") == false) {
					JOptionPane.showMessageDialog(null,"Please enter a valid username");
				    return;
				}
				if(username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Username or password is blank.");
					
				    return;
				} else {
					

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
						pst = con.prepareStatement("SELECT * FROM `sign up` WHERE username = ? and password = ?");
						pst.setString(1, username);
						pst.setString(2, password);
						
						ResultSet rs;
						
						rs = pst.executeQuery();
						if(rs.next()) {
							
							if(username.equals("HeroFoty")&& rs.getString("username").equals(username)&&
									password.equals("sektum")&&rs.getString("password").equals(password)){
								
								hide();
								AdminPage adminPage = new AdminPage();
								adminPage.setVisible(true);
							} else if(!rs.next()){
								JOptionPane.showMessageDialog(null,"Username or password do not match.");
								usernameText.setText("");
								passwordText.setText("");
								usernameText.requestFocus();
							}
							
							
						} else {
							JOptionPane.showMessageDialog(null,"Username or password do not match.");
							usernameText.setText("");
							passwordText.setText("");
							usernameText.requestFocus();
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(60, 121, 221, 27);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(60, 173, 221, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Not registered yet?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(60, 204, 114, 22);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(185, 203, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
