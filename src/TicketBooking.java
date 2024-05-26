import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import com.toedter.calendar.JDateChooser;

public class TicketBooking extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField custIdTxt;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField chargeTxt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketBooking frame = new TicketBooking();
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
	public TicketBooking() {
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Select Country", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(387, 114, 281, 124);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Source");
		lblNewLabel.setBounds(47, 27, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Destination");
		lblNewLabel_1.setBounds(187, 27, 59, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox srcTxt = new JComboBox();
		srcTxt.setModel(new DefaultComboBoxModel(new String[] {"Egypt", "Germany", "Japan"}));
		srcTxt.setBounds(25, 52, 79, 22);
		panel.add(srcTxt);
		
		JComboBox depTxt = new JComboBox();
		depTxt.setModel(new DefaultComboBoxModel(new String[] {"Germany", "Egypt", "Japan"}));
		depTxt.setBounds(177, 52, 79, 22);
		panel.add(depTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 255, 658, 104);
		getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 351, 211);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Costumer ID");
		lblNewLabel_4.setBounds(10, 22, 73, 14);
		panel_1.add(lblNewLabel_4);
		
		custIdTxt = new JTextField();
		custIdTxt.setBounds(86, 19, 73, 20);
		panel_1.add(custIdTxt);
		custIdTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("First name");
		lblNewLabel_5.setBounds(10, 86, 66, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Last name");
		lblNewLabel_6.setBounds(175, 86, 66, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel firstNameTxt = new JLabel("New label");
		firstNameTxt.setForeground(new Color(255, 0, 0));
		firstNameTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstNameTxt.setBounds(86, 86, 73, 14);
		panel_1.add(firstNameTxt);
		
		JLabel lastNameTxt = new JLabel("New label");
		lastNameTxt.setForeground(new Color(255, 0, 0));
		lastNameTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lastNameTxt.setBounds(251, 86, 73, 14);
		panel_1.add(lastNameTxt);
		
		JLabel lblNewLabel_9 = new JLabel("Nic");
		lblNewLabel_9.setBounds(10, 50, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel nicTxt = new JLabel("New label");
		nicTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		nicTxt.setForeground(new Color(255, 0, 0));
		nicTxt.setBounds(86, 50, 73, 14);
		panel_1.add(nicTxt);
		
		JLabel lblNewLabel_11 = new JLabel("Flight ID");
		lblNewLabel_11.setBounds(10, 122, 46, 14);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Flight name");
		lblNewLabel_12.setBounds(10, 158, 66, 14);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("Depart time");
		lblNewLabel_12_1.setBounds(10, 192, 66, 14);
		panel_1.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_12_2 = new JLabel("Class");
		lblNewLabel_12_2.setBounds(175, 122, 46, 14);
		panel_1.add(lblNewLabel_12_2);
		
		JLabel lblNewLabel_12_3 = new JLabel("Seats");
		lblNewLabel_12_3.setBounds(175, 158, 46, 14);
		panel_1.add(lblNewLabel_12_3);
		
		JLabel lblNewLabel_12_4 = new JLabel("Charge");
		lblNewLabel_12_4.setBounds(175, 192, 46, 14);
		panel_1.add(lblNewLabel_12_4);
		
		JLabel flightId = new JLabel("New label");
		flightId.setFont(new Font("Tahoma", Font.BOLD, 11));
		flightId.setForeground(new Color(255, 0, 0));
		flightId.setBounds(86, 122, 59, 14);
		panel_1.add(flightId);
		
		JLabel flightName = new JLabel("New label");
		flightName.setFont(new Font("Tahoma", Font.BOLD, 11));
		flightName.setForeground(new Color(255, 0, 0));
		flightName.setBounds(86, 158, 59, 14);
		panel_1.add(flightName);
		
		JLabel deptTxt = new JLabel("New label");
		deptTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
		deptTxt.setForeground(new Color(255, 0, 0));
		deptTxt.setBounds(86, 192, 59, 14);
		panel_1.add(deptTxt);
		
		JComboBox classTxt = new JComboBox();
		classTxt.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Business"}));
		classTxt.setBounds(251, 118, 90, 22);
		panel_1.add(classTxt);
		
		JLabel lblNewLabel_3 = new JLabel("Total Charge");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(387, 46, 85, 23);
		getContentPane().add(lblNewLabel_3);
		
		JLabel totalTxt = new JLabel("New label");
		totalTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalTxt.setBounds(493, 50, 75, 19);
		getContentPane().add(totalTxt);
		
		JSpinner seatsTxt = new JSpinner();
		seatsTxt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int charge = Integer.parseInt(chargeTxt.getText());
				int qty = Integer.parseInt(seatsTxt.getValue().toString());
				
				int tot = charge * qty;
				
				totalTxt.setText(String.valueOf(tot));
			}
		});
		seatsTxt.setBounds(251, 155, 46, 20);
		panel_1.add(seatsTxt);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				//getValueAt(int row, int column) takes the indexOf the row and the column and returns the value in them.
				flightId.setText(df.getValueAt(selectIndex, 0).toString());
				flightName.setText(df.getValueAt(selectIndex, 1).toString());
				deptTxt.setText(df.getValueAt(selectIndex, 5).toString());
				chargeTxt.setText(df.getValueAt(selectIndex, 7).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Flight ID", "Flight Name", "Source", "Departure","Date", "Dep time", "Arr time", "Charge"
			}
		));
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String source = srcTxt.getSelectedItem().toString().trim();
				String depart = depTxt.getSelectedItem().toString().trim();
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
					pst = con.prepareStatement("SELECT * FROM flight WHERE source = ? and depart = ?");
					 /*
					  * When costumer selects any item from source or depart, the sql code searches for
					  * the country whether it's in the source or the depart
					  */
					pst.setString(1, source);
					pst.setString(2, depart);
					
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
							v1.add(r.getString("flightName"));
							v1.add(r.getString("source"));
							v1.add(r.getString("depart"));
							v1.add(r.getString("date"));
							v1.add(r.getString("depTime"));
							v1.add(r.getString("arrTime"));
							v1.add(r.getString("flightCharge"));
							
						}
						
						df.addRow(v1);
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton_2.setBounds(96, 85, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search ID");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = custIdTxt.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
					pst = con.prepareStatement("SELECT * FROM `sign up` WHERE cid = ?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					
					if(rs.next() == false) {
						JOptionPane.showMessageDialog(null, "Record not found");
					} else {
						String fname = rs.getString("fName");
						String lname = rs.getString("lName");
						String nicNo = rs.getString("nic");
						
						
						firstNameTxt.setText(fname.trim());
						lastNameTxt.setText(lname.trim());
						nicTxt.setText(nicNo.trim());
						
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
		btnNewButton_3.setBounds(251, 18, 89, 23);
		panel_1.add(btnNewButton_3);
		
		chargeTxt = new JTextField();
		chargeTxt.setBounds(251, 189, 86, 20);
		panel_1.add(chargeTxt);
		chargeTxt.setColumns(10);
		
		JDateChooser dateTxt = new JDateChooser();
		dateTxt.setBounds(251, 50, 74, 20);
		panel_1.add(dateTxt);
		
		JLabel Date = new JLabel("Date");
		Date.setBounds(175, 50, 46, 14);
		panel_1.add(Date);
		
		JLabel lblNewLabel_2 = new JLabel("Ticket number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(387, 11, 96, 24);
		getContentPane().add(lblNewLabel_2);
		
		JLabel ticketTxt = new JLabel("New label");
		ticketTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		ticketTxt.setBounds(493, 16, 75, 14);
		getContentPane().add(ticketTxt);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("SELECT MAX(id) FROM `ticket`");
			r.next();
			r.getString("MAX(id)");
			if(r.getString("MAX(id)") == null) {
				ticketTxt.setText("TO001");
			} else {
				
				long id = Long.parseLong(r.getString("MAX(id)").substring(2, r.getString("MAX(id)").length()));
				id++;
				ticketTxt.setText("TO" + String.format("%03d",id));
			}
			
			
			}catch(ClassNotFoundException ex){
				System.out.println("Error: Unable to load driver class!");
		        ex.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		JButton btnNewButton = new JButton("Book Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ticketId = ticketTxt.getText();
				String id = flightId.getText();
				String custId = custIdTxt.getText();
				String flightClass = classTxt.getSelectedItem().toString().trim();
				String charge = totalTxt.getText();
				String seats = seatsTxt.getValue().toString();
				
				DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
				String date = da.format(dateTxt.getDate());
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/airlinedb","root","");
					pst = con.prepareStatement("insert into `ticket`(id,flightid,custid,class,price,"
							+ "seats,date) values (?,?,?,?,?,?,?)");
//					
					pst.setString(1, ticketId);
					pst.setString(2, id);
					pst.setString(3, custId);
					pst.setString(4, flightClass);
					pst.setString(5, charge);
					pst.setString(6, seats);
					pst.setString(7, date);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Ticket booked");
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error");
					e1.printStackTrace();
				}
			}	
		});
		btnNewButton.setBounds(387, 80, 104, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel booking");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nicTxt.setText("New label");
				firstNameTxt.setText("New label");
				lastNameTxt.setText("New label");
				ticketTxt.setText("New label");
				flightId.setText("New label");
				custIdTxt.setText("");
				flightName.setText("New label");
				deptTxt.setText("New label");
				totalTxt.setText("New label");
				seatsTxt.setValue(0);
				ticketTxt.setText("New label");
				if(dateTxt != null) {
					dateTxt.setCalendar(null);
				}
				
				chargeTxt.setText("");
			}
		});
		btnNewButton_1.setBounds(501, 80, 130, 23);
		getContentPane().add(btnNewButton_1);
		
		

	}
}
