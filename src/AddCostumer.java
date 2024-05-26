import java.sql.*;
import java.util.regex.Matcher;
import java.util.logging.Logger;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
public class AddCostumer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fName;
	private JTextField lName;
	private JTextField ageTxt;
	private JTextField phoneTxt;
	private JTextField nicTxt;
	private JTextField userTxt;
	private JPasswordField userPassword;
	private JPasswordField confirmPass;
	private JTextField usernameTxt;
	private JPasswordField userPass;
	private JLabel idTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	Connection con;
	PreparedStatement pst;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCostumer frame = new AddCostumer();
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
	public AddCostumer() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Credentials", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(20, 51, 262, 214);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel idTxt = new JLabel("Generated ID");
		idTxt.setForeground(new Color(255, 0, 0));
		idTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		idTxt.setBounds(108, 11, 103, 23);
		contentPane.add(idTxt);
		
		//Generating ID
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("SELECT MAX(cid) FROM `sign up`");
			r.next();
			r.getString("MAX(cid)");
			if(r.getString("MAX(cid)") == null) {
				idTxt.setText("CS001");
			} else {
				
				long id = Long.parseLong(r.getString("MAX(cid)").substring(2, r.getString("MAX(cid)").length()));
				id++;
				idTxt.setText("CS" + String.format("%03d",id));
			}
			
			
			}catch(ClassNotFoundException ex){
				System.out.println("Error: Unable to load driver class!");
		        ex.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 25, 68, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 56, 68, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(10, 118, 68, 14);
		panel.add(lblNewLabel_1_2);
		
		fName = new JTextField();
		fName.setBounds(114, 22, 122, 20);
		panel.add(fName);
		fName.setColumns(10);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(114, 53, 122, 20);
		panel.add(lName);
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(114, 115, 122, 20);
		panel.add(phoneTxt);
		
		JLabel lblNewLabel_2 = new JLabel("username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 87, 68, 14);
		panel.add(lblNewLabel_2);
		
		userTxt = new JTextField();
		userTxt.setBounds(114, 84, 122, 20);
		panel.add(userTxt);
		userTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 149, 68, 14);
		panel.add(lblNewLabel_5);
		
		userPassword = new JPasswordField();
		userPassword.setBounds(114, 146, 122, 20);
		panel.add(userPassword);
		
		confirmPass = new JPasswordField();
		confirmPass.setBounds(114, 177, 122, 20);
		panel.add(confirmPass);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Password");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 180, 101, 14);
		panel.add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(292, 51, 214, 107);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("NiC No");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 21, 68, 14);
		panel_1.add(lblNewLabel_4);
		
		nicTxt = new JTextField();
		nicTxt.setBounds(88, 18, 111, 20);
		panel_1.add(nicTxt);
		nicTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 81, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JRadioButton maleBtn = new JRadioButton("Male");
		buttonGroup.add(maleBtn);
		maleBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		maleBtn.setBounds(88, 77, 52, 23);
		panel_1.add(maleBtn);
		maleBtn.setBackground(new Color(0, 128, 255));
		
		JRadioButton femaleBtn = new JRadioButton("Female");
		buttonGroup.add(femaleBtn);
		femaleBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		femaleBtn.setBounds(136, 77, 68, 23);
		panel_1.add(femaleBtn);
		femaleBtn.setBackground(new Color(0, 128, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 49, 68, 14);
		panel_1.add(lblNewLabel_1_1);
		
		ageTxt = new JTextField();
		ageTxt.setBounds(88, 46, 111, 20);
		panel_1.add(ageTxt);
		ageTxt.setColumns(10);

		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idTxt.getText();
				//fname is the variable name for the text field, how can I test it?
				String firstName = fName.getText();
				String lastName = lName.getText();
				String userName = userTxt.getText();
				String nic = nicTxt.getText();
				String phone = phoneTxt.getText();
				int age = Integer.valueOf(ageTxt.getText());
				maleBtn.setActionCommand("male");
				femaleBtn.setActionCommand("female");
				String gender = buttonGroup.getSelection().getActionCommand();
				
				String password = userPassword.getText();
				String passwordCheck = confirmPass.getText();
				
				//There should be cases added where user should enter a valid first name.
				//`|| firstName.matches("[A-Z][a-z]+") == false` is added after running the test
				if(firstName.isEmpty() || firstName.matches("[A-Z][a-z]+") == false)
				{
				    JOptionPane.showMessageDialog(null,"Please enter a valid first name");
				    return;
				}
				//There should be cases added where user should enter a valid last name.
				//`|| lastName.matches("[A-Z][a-z]+") == false` is added after running the test
				if(lastName.isEmpty() || lastName.matches("[A-Z][a-z]+") == false)
				{
				    JOptionPane.showMessageDialog(null,"Please enter a valid last name");
				    return;
				}
				//`|| userName.matches("[A-Z][a-z]+([A-Z][a-z]+)*") == false` is added after running the test
				//Parameters are modified from matches("[A-Z][a-z]+") to matches("[A-Z][a-z]+([A-Z][a-z]+)*") which is false as well
				//It was then modified to matches([A-Z][a-z]+([A-Z])*([a-z]+)*")
				if(userName.isEmpty() || userName.matches("[A-Z][a-z]+([A-Z][a-z]+)*") == false) {
					JOptionPane.showMessageDialog(null,"Please enter a valid username");
				    return;
				}
				//There should be added a case where the phone number string should be 11 numbers starting with zero
				//following it numbers starting from 1 to 9, the length of the phone number should be 11 characters.
				//`|| userName.matches("[A-Z][a-z]+") == false` is added after running the test
				if(phone.isEmpty() || phone.matches("0[1-9]{10}") == false)
				{
				    JOptionPane.showMessageDialog(null,"Please enter a valid phone");
				    return;
				}
				if(gender.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter your gender");
				    return;
				}
				if(password.isEmpty())
				{
				    JOptionPane.showMessageDialog(null,"Please enter your password");
				    return;
				}
				if(passwordCheck.isEmpty())
				{
				    JOptionPane.showMessageDialog(null,"Please enter your confirm password");
				    return;
				}

				//step F3: check the passwords
				if(!password.matches(passwordCheck))
				{
				   JOptionPane.showMessageDialog(null,"Your passwords don't match!");
				   return;
				}
				
				//if statement was added after running the tests.
				if(age <= 0) {
					JOptionPane.showMessageDialog(null,"Enter a valid age");
					return;
				}
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
					pst = con.prepareStatement("insert into `sign up`(cid,fName,lName,username,phone,password,"
							+ "nic,gender,age) values (?,?,?,?,?,?,?,?,?)");
					
					pst.setString(1, id);
					pst.setString(2, firstName);
					pst.setString(3, lastName);
					pst.setString(4, userName);
					pst.setString(5, phone);
					pst.setString(6, password);
					pst.setString(7, nic);
					pst.setString(8, gender);
					pst.setInt(9, age);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registration created");
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error");
					e1.printStackTrace();
				}
				finally {
					if(con != null){
						try {
							con.close();
							}catch(SQLException e2) 
						{}
					}
					if(pst != null) {
						try {
							pst.close();
							}catch(SQLException e2) {}
					}
				}
				
			}
		});
		addBtn.setBounds(291, 274, 89, 23);
		contentPane.add(addBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear all the text fields
		        fName.setText("");
		        lName.setText("");
		        userTxt.setText("");
		        nicTxt.setText("");
		        phoneTxt.setText("");
		        ageTxt.setText("");
		        userPassword.setText("");
		        confirmPass.setText("");
		        
		        // Clear the gender selection
		        buttonGroup.clearSelection();
			}
		});
		cancelBtn.setBounds(390, 274, 89, 23);
		contentPane.add(cancelBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(292, 168, 214, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 14, 73, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 39, 73, 14);
		panel_2.add(lblNewLabel_8);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(87, 11, 102, 20);
		panel_2.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		userPass = new JPasswordField();
		userPass.setBounds(87, 36, 102, 20);
		panel_2.add(userPass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTxt.getText();
				String password = userPass.getText();
				
				
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
							hide();
							OnLogin ol = new OnLogin();
							ol.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null,"Username or password do not match.");
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
		btnNewButton.setBounds(100, 61, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel costumerId = new JLabel("Costumer ID");
		costumerId.setFont(new Font("Tahoma", Font.BOLD, 12));
		costumerId.setBounds(20, 11, 89, 23);
		contentPane.add(costumerId);
			
	}
	
}
