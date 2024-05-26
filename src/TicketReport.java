import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TicketReport extends JInternalFrame {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketReport frame = new TicketReport();
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
	public TicketReport() {
		
		setBounds(100, 100, 551, 358);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 38, 434, 244);
		getContentPane().add(scrollPane);
		
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
