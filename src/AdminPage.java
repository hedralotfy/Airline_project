import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNameTxt;
	private JTextField lastNameTxt;
	private JTextField phoneTxt;
	private JTextField nicTxt;
	private JTextField ageTxt;
	private JTextField usernameTxt;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField flightnameTxt;
	private JTextField dpTimeTxt;
	private JTextField arrTimeTxt;
	private JTextField flightChargeTxt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 563, 328);
		contentPane.add(tabbedPane);
		
		JPanel Flights = new JPanel();
		tabbedPane.addTab("Add filghts", null, Flights, null);
		Flights.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(56, 30, 437, 247);
		Flights.add(panel_2);
		
		JLabel flightIDTxt = new JLabel("Flight ID");
		flightIDTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		flightIDTxt.setBounds(20, 30, 65, 14);
		panel_2.add(flightIDTxt);
		
		JLabel flightIdTxt = new JLabel("New label");
		flightIdTxt.setForeground(Color.YELLOW);
		flightIdTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		flightIdTxt.setBounds(105, 30, 86, 14);
		panel_2.add(flightIdTxt);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("SELECT MAX(id) FROM `flight`");
			r.next();
			r.getString("MAX(id)");
			if(r.getString("MAX(id)") == null) {
				flightIdTxt.setText("FO001");
			} else {
				
				long id = Long.parseLong(r.getString("MAX(id)").substring(2, r.getString("MAX(id)").length()));
				id++;
				flightIdTxt.setText("FO" + String.format("%03d",id));
			}
			
			
			}catch(ClassNotFoundException ex){
				System.out.println("Error: Unable to load driver class!");
		        ex.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		JLabel lblNewLabel_1_3 = new JLabel("Flight name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(20, 69, 75, 14);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Source");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(20, 103, 65, 14);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departure");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2_1.setBounds(20, 138, 65, 14);
		panel_2.add(lblNewLabel_1_2_1);
		
		flightnameTxt = new JTextField();
		flightnameTxt.setColumns(10);
		flightnameTxt.setBounds(105, 66, 86, 20);
		panel_2.add(flightnameTxt);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(220, 30, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JDateChooser dateTxt = new JDateChooser();
		dateTxt.setBounds(298, 24, 99, 20);
		panel_2.add(dateTxt);
		
		JLabel lblNewLabel_3_1 = new JLabel("DP time");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setBounds(220, 69, 46, 14);
		panel_2.add(lblNewLabel_3_1);
		
		dpTimeTxt = new JTextField();
		dpTimeTxt.setColumns(10);
		dpTimeTxt.setBounds(298, 66, 86, 20);
		panel_2.add(dpTimeTxt);
		
		arrTimeTxt = new JTextField();
		arrTimeTxt.setColumns(10);
		arrTimeTxt.setBounds(298, 100, 86, 20);
		panel_2.add(arrTimeTxt);
		
		JLabel lblNewLabel_4_1 = new JLabel("ARR time");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(220, 103, 68, 14);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("Flight charge");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(220, 138, 75, 14);
		panel_2.add(lblNewLabel_5);
		
		flightChargeTxt = new JTextField();
		flightChargeTxt.setColumns(10);
		flightChargeTxt.setBounds(298, 135, 86, 20);
		panel_2.add(flightChargeTxt);
		
		JComboBox srcTxt = new JComboBox();
		srcTxt.setModel(new DefaultComboBoxModel(new String[] {"Egypt", "Germany", "Japan"}));
		srcTxt.setBounds(105, 99, 86, 22);
		panel_2.add(srcTxt);
		
		JComboBox depTxt = new JComboBox();
		depTxt.setModel(new DefaultComboBoxModel(new String[] {"Germany", "Egypt", "Japan"}));
		depTxt.setBounds(105, 134, 86, 22);
		panel_2.add(depTxt);
		
		JButton addFlightBtn = new JButton("Add flight");
		addFlightBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = flightIdTxt.getText();
				String flightName = flightnameTxt.getText();
				String source = srcTxt.getSelectedItem().toString().trim();
				String depart = depTxt.getSelectedItem().toString().trim();
				String departTime = dpTimeTxt.getText();
				String arrTime = arrTimeTxt.getText();
				
				DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
				String date = da.format(dateTxt.getDate());
				
				String flightCharge = flightChargeTxt.getText();
				
				
				if(flightName.isEmpty())
				{
				    JOptionPane.showMessageDialog(null,"Please enter your first name");
				    return;
				}
				
				if(arrTime.isEmpty())
				{
				    JOptionPane.showMessageDialog(null,"Please enter your phone");
				    return;
				}
				//step F3: check the passwords
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
					pst = con.prepareStatement("insert into `flight`(id,flightName,source,depart,date,"
							+ "depTime,arrTime,flightCharge) values (?,?,?,?,?,?,?,?)");
//					
					pst.setString(1, id);
					pst.setString(2, flightName);
					pst.setString(3, source);
					pst.setString(4, depart);
					pst.setString(5, date);
					pst.setString(6, departTime);
					pst.setString(7, arrTime);
					pst.setString(8, flightCharge);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Flight created");
					
					
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
		addFlightBtn.setBounds(105, 188, 89, 23);
		panel_2.add(addFlightBtn);
		
		JButton cancelBtn = new JButton("Cancel flight");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * String flightName = flightnameTxt.getText();
				String source = SrcTxt.getText();
				String depart = depTxt.getText();
				String departTime = dpTimeTxt.getText();
				String arrTime = arrTimeTxt.getText();
				 */
				flightnameTxt.setText("");
//				SrcTxt.setText("");
//				depTxt.setText("");
		        dpTimeTxt.setText("");
		        arrTimeTxt.setText("");
		        flightChargeTxt.setText("");
				
			}
		});
		cancelBtn.setBounds(220, 188, 111, 23);
		panel_2.add(cancelBtn);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search Costumer", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(77, 0, 328, 264);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Credentials", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(56, 63, 262, 213);
		contentPane_1.add(panel);
		
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
		lblNewLabel_1_2.setBounds(10, 87, 68, 14);
		panel.add(lblNewLabel_1_2);
		
		firstNameTxt = new JTextField();
		firstNameTxt.setColumns(10);
		firstNameTxt.setBounds(114, 22, 122, 20);
		panel.add(firstNameTxt);
		
		lastNameTxt = new JTextField();
		lastNameTxt.setColumns(10);
		lastNameTxt.setBounds(114, 53, 122, 20);
		panel.add(lastNameTxt);
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(114, 84, 122, 20);
		panel.add(phoneTxt);
		
		JLabel lblNewLabel_4 = new JLabel("NiC No");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 120, 68, 14);
		panel.add(lblNewLabel_4);
		
		nicTxt = new JTextField();
		nicTxt.setColumns(10);
		nicTxt.setBounds(114, 117, 122, 20);
		panel.add(nicTxt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 148, 68, 14);
		panel.add(lblNewLabel_1_1);
		
		ageTxt = new JTextField();
		ageTxt.setColumns(10);
		ageTxt.setBounds(114, 148, 122, 20);
		panel.add(ageTxt);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 180, 46, 14);
		panel.add(lblNewLabel_3);
		
		JRadioButton maleBtn = new JRadioButton("Male");
		maleBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		maleBtn.setBackground(new Color(0, 128, 255));
		maleBtn.setBounds(114, 175, 52, 23);
		panel.add(maleBtn);
		
		JRadioButton femaleBtn = new JRadioButton("Female");
		femaleBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		femaleBtn.setBackground(new Color(0, 128, 255));
		femaleBtn.setBounds(162, 175, 68, 23);
		panel.add(femaleBtn);
		
		JLabel costumerUsername = new JLabel("Username");
		costumerUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		costumerUsername.setBounds(56, 23, 89, 23);
		contentPane_1.add(costumerUsername);
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(127, 25, 86, 20);
		contentPane_1.add(usernameTxt);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameTxt.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
					pst = con.prepareStatement("SELECT * FROM `sign up` WHERE username = ?");
					pst.setString(1, username);
					rs = pst.executeQuery();
					
					if(rs.next() == false) {
						JOptionPane.showMessageDialog(null, "Record not found");
					} else {
						String fname = rs.getString("fName");
						String lname = rs.getString("lName");
						String phone = rs.getString("phone");
						String nicNo = rs.getString("nic");
						String gender = rs.getString("gender");
						int age = rs.getInt("age");
						
						if(gender.equals("male")) {
							maleBtn.setSelected(true);
							femaleBtn.setSelected(false);
						} else {
							maleBtn.setSelected(false);
							femaleBtn.setSelected(true);
						}
						
						firstNameTxt.setText(fname.trim());
						lastNameTxt.setText(lname.trim());
						phoneTxt.setText(phone.trim());
						nicTxt.setText(nicNo.trim());
						ageTxt.setText(String.valueOf(age).trim());
						
					}
					
				}catch(ClassNotFoundException ex){
					System.out.println("Error: Unable to load driver class!");
			        ex.printStackTrace();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(223, 24, 89, 23);
		contentPane_1.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Tickets", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 25, 483, 217);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TicketId", "FlightId", "Seats", "Price", "Class", "Cust Id", "Date"
			}
		));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
			pst = con.prepareStatement("SELECT * FROM ticket");
			 /*
			  * When costumer selects any item from source or depart, the sql code searches for
			  * the country whether it's in the source or the depart
			  */
			
			
			ResultSet r = pst.executeQuery();
			
			//This is for displaying the record at the Jtable
			ResultSetMetaData rm = r.getMetaData();
			
			int c;
			c= rm.getColumnCount();
			
			DefaultTableModel df = (DefaultTableModel)table.getModel();
			df.setRowCount(0);
			
			while(r.next()) {
				Vector v1 = new Vector();
				
				for(int i = 1; i<c;i++) {
					v1.add(r.getString("id"));
					v1.add(r.getString("flightid"));
					v1.add(r.getString("custid"));
					v1.add(r.getString("class"));
					v1.add(r.getString("price"));
					v1.add(r.getString("seats"));
					v1.add(r.getString("date"));
					
				}
				
				df.addRow(v1);
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
