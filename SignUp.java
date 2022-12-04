package tracker;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(101, 49, 175, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Create Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(124, 11, 117, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreatePassword.setBounds(124, 80, 117, 27);
		frame.getContentPane().add(lblCreatePassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 118, 175, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(124, 149, 117, 27);
		frame.getContentPane().add(lblConfirmPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 187, 175, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Sign up!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals(textField_1.getText())) {
					Students.add(textField.getText(),textField_1.getText());
					JOptionPane.showMessageDialog(null,"You are successfully signed up");
				}
			}
		});
		btnNewButton.setBounds(139, 218, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
