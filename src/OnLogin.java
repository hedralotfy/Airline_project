import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OnLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnLogin frame = new OnLogin();
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
	public OnLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 56, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tickets");
		menuBar.add(mnNewMenu);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 21, 700, 400);
		contentPane.add(desktopPane);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Book Ticket");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketBooking tb = new TicketBooking();
				desktopPane.add(tb);
				tb.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
	}
}
