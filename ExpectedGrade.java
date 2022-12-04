package tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExpectedGrade {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(Object subject, Object units) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpectedGrade window = new ExpectedGrade(subject, units);
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
	public ExpectedGrade(Object subject, Object units) {
		initialize(subject, units);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Object subject, Object units) {
		frame = new JFrame();
		frame.setBounds(100, 100, 336, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// String s="OOP";
		JLabel lblNewLabel = new JLabel("Subject: " + subject);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(36, 35, 328, 33);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Number of Units: " + units);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(36, 69, 328, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Expected Grade: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(36, 113, 328, 33);
		frame.getContentPane().add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setBounds(139, 113, 102, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					for (Grades g : Grades.values()) {
						if (textField.getText().equals(g.toString())) {
							Subjects.grade.put((String) subject, textField.getText());
							frame.setVisible(false);
							break;
						}
					}
			}
		});
		btnNewButton.setBounds(105, 160, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
