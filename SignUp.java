package tracker;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(100, 122, 175, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter your ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(123, 84, 117, 27);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreatePassword.setBounds(123, 153, 117, 27);
		frame.getContentPane().add(lblCreatePassword);

		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 191, 175, 20);
		frame.getContentPane().add(textField_1);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(123, 222, 117, 27);
		frame.getContentPane().add(lblConfirmPassword);

		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 260, 175, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 53, 175, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblEnterYourName = new JLabel("Enter your Name");
		lblEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterYourName.setBounds(123, 15, 117, 27);
		frame.getContentPane().add(lblEnterYourName);

		JButton btnNewButton = new JButton("Sign up!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Student s : Students.students) {
					if (textField.getText().equals(s.getID())) {
						JOptionPane.showMessageDialog(null, "Your ID is already registered");
						return;
					}
				}
				if (textField_2.getText().equals(textField_1.getText())) {
					Students.add(textField_3.getText(), textField.getText(),textField_1.getText());
					try {
						FileHandling.write(textField_3.getText(),textField.getText() ,textField_1.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "You are successfully signed up");
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Password entered");
				}
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(138, 291, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
