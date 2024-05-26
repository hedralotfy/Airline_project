import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		menuBar.setBounds(0, 0, 209, 24);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Flights");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.setFont(new Font("Arial Black", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem AddFlight = new JMenuItem("Add flight");
		mnNewMenu.add(AddFlight);
		
		JMenu mnNewMenu_1 = new JMenu("Contact us");
		mnNewMenu_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("About us");
		mnNewMenu_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hide();
				Main login = new Main();
				login.setVisible(true);
			}
		});
		btnNewButton.setBounds(439, 0, 89, 24);
		contentPane.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 24, 661, 337);
		contentPane.add(desktopPane);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddCostumer add = new AddCostumer();
				AddCostumer.main(null);  //Like this we're calling main method
				
			}
		});
		btnNewButton_1.setBounds(538, 0, 89, 24);
		contentPane.add(btnNewButton_1);
		
	}
}
