package tracker;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(114, 66, 211, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(114, 32, 70, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(114, 104, 70, 23);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 138, 211, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s1=textField.getText();
					@SuppressWarnings("deprecation")
					String s2=passwordField.getText();
					for(Student s:Students.students) {
						if(s.getUsername().equals(s1)&&s.getPassword().equals(s2)) {
							JOptionPane.showMessageDialog(null,"You are logged in!");
						}
					}
					//JOptionPane.showMessageDialog(null,"Username: "+s1+" Password: "+s2);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Please Enter Valid details");
				}
			}
		});
		btnNewButton.setBounds(176, 189, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New User?");
		lblNewLabel_1.setBounds(114, 247, 57, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setBounds(176, 247, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					SignUp second = new SignUp();
				 //second.setVisible(true);
				 second.setSize(360,450);
				 second.setLocationRelativeTo(null);
				 //second.setBounds(100, 100, 450, 300);
				  second.setVisible(true);
			}
		});
		
		
	}
}
