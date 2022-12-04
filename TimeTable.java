package tracker;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTable {

	private JFrame frame;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeTable window = new TimeTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TimeTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Main Screen");
		btnNewButton.setBounds(168, 203, 110, 23);
		frame.getContentPane().add(btnNewButton);

		String[] Days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
		// Reminder!!!!
		table_1 = new JTable(User.user.getTimetable(), Days);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table_1.setBounds(10, 11, 414, 129);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(scrollPane);

		// JButton Back = new JButton("Back to main screen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainScreen.main(null);
				// Back To Main Screen
			}
		});
	}
}
