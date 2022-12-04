package tracker;

import tracker.Subjects;
import tracker.TimeTable;
import tracker.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class SetTimetTable {

	private JFrame frame;
	private JTextField textField_40;
	private JTextField textField_00;
	private JTextField textField_10;
	private JTextField textField_20;
	private JTextField textField_30;
	private JTextField textField_41;
	private JTextField textField_01;
	private JTextField textField_11;
	private JTextField textField_21;
	private JTextField textField_31;
	private JTextField textField_42;
	private JTextField textField_02;
	private JTextField textField_12;
	private JTextField textField_22;
	private JTextField textField_32;
	private JTextField textField_03;
	private JTextField textField_13;
	private JTextField textField_23;
	private JTextField textField_33;
	private JTextField textField_43;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_04;
	private JTextField textField_14;
	private JTextField textField_24;
	private JTextField textField_34;
	private JTextField textField_44;
	private JTextField textField_54;
	private JTextField textField_64;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetTimetTable window = new SetTimetTable();
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
	public SetTimetTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField_40 = new JTextField();
		textField_40.setBounds(10, 178, 86, 20);
		frame.getContentPane().add(textField_40);
		textField_40.setColumns(10);

		textField_00 = new JTextField();
		textField_00.setBounds(10, 54, 86, 20);
		frame.getContentPane().add(textField_00);
		textField_00.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(10, 85, 86, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		textField_20 = new JTextField();
		textField_20.setBounds(10, 116, 86, 20);
		frame.getContentPane().add(textField_20);
		textField_20.setColumns(10);

		textField_30 = new JTextField();
		textField_30.setBounds(10, 147, 86, 20);
		frame.getContentPane().add(textField_30);
		textField_30.setColumns(10);

		textField_41 = new JTextField();
		textField_41.setBounds(106, 178, 86, 20);
		frame.getContentPane().add(textField_41);
		textField_41.setColumns(10);

		textField_01 = new JTextField();
		textField_01.setBounds(106, 54, 86, 20);
		frame.getContentPane().add(textField_01);
		textField_01.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(106, 85, 86, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setBounds(106, 116, 86, 20);
		frame.getContentPane().add(textField_21);
		textField_21.setColumns(10);

		textField_31 = new JTextField();
		textField_31.setBounds(106, 147, 86, 20);
		frame.getContentPane().add(textField_31);
		textField_31.setColumns(10);

		textField_42 = new JTextField();
		textField_42.setBounds(202, 178, 86, 20);
		frame.getContentPane().add(textField_42);
		textField_42.setColumns(10);

		textField_02 = new JTextField();
		textField_02.setBounds(202, 54, 86, 20);
		frame.getContentPane().add(textField_02);
		textField_02.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(202, 85, 86, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);

		textField_22 = new JTextField();
		textField_22.setBounds(202, 116, 86, 20);
		frame.getContentPane().add(textField_22);
		textField_22.setColumns(10);

		textField_32 = new JTextField();
		textField_32.setBounds(202, 147, 86, 20);
		frame.getContentPane().add(textField_32);
		textField_32.setColumns(10);

		textField_03 = new JTextField();
		textField_03.setBounds(301, 54, 86, 20);
		frame.getContentPane().add(textField_03);
		textField_03.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(301, 85, 86, 20);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);

		textField_23 = new JTextField();
		textField_23.setBounds(301, 116, 86, 20);
		frame.getContentPane().add(textField_23);
		textField_23.setColumns(10);

		textField_33 = new JTextField();
		textField_33.setBounds(301, 147, 86, 20);
		frame.getContentPane().add(textField_33);
		textField_33.setColumns(10);

		textField_43 = new JTextField();
		textField_43.setBounds(301, 178, 86, 20);
		frame.getContentPane().add(textField_43);
		textField_43.setColumns(10);

		textField_50 = new JTextField();
		textField_50.setColumns(10);
		textField_50.setBounds(10, 209, 86, 20);
		frame.getContentPane().add(textField_50);

		textField_51 = new JTextField();
		textField_51.setColumns(10);
		textField_51.setBounds(106, 209, 86, 20);
		frame.getContentPane().add(textField_51);

		textField_52 = new JTextField();
		textField_52.setColumns(10);
		textField_52.setBounds(202, 209, 86, 20);
		frame.getContentPane().add(textField_52);

		textField_53 = new JTextField();
		textField_53.setColumns(10);
		textField_53.setBounds(301, 209, 86, 20);
		frame.getContentPane().add(textField_53);

		textField_60 = new JTextField();
		textField_60.setColumns(10);
		textField_60.setBounds(10, 240, 86, 20);
		frame.getContentPane().add(textField_60);

		textField_61 = new JTextField();
		textField_61.setColumns(10);
		textField_61.setBounds(106, 240, 86, 20);
		frame.getContentPane().add(textField_61);

		textField_62 = new JTextField();
		textField_62.setColumns(10);
		textField_62.setBounds(202, 240, 86, 20);
		frame.getContentPane().add(textField_62);

		textField_63 = new JTextField();
		textField_63.setColumns(10);
		textField_63.setBounds(301, 240, 86, 20);
		frame.getContentPane().add(textField_63);

		textField_04 = new JTextField();
		textField_04.setColumns(10);
		textField_04.setBounds(401, 54, 86, 20);
		frame.getContentPane().add(textField_04);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(401, 85, 86, 20);
		frame.getContentPane().add(textField_14);

		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(401, 116, 86, 20);
		frame.getContentPane().add(textField_24);

		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(401, 147, 86, 20);
		frame.getContentPane().add(textField_34);

		textField_44 = new JTextField();
		textField_44.setColumns(10);
		textField_44.setBounds(401, 178, 86, 20);
		frame.getContentPane().add(textField_44);

		textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(401, 209, 86, 20);
		frame.getContentPane().add(textField_54);

		textField_64 = new JTextField();
		textField_64.setColumns(10);
		textField_64.setBounds(401, 240, 86, 20);
		frame.getContentPane().add(textField_64);

		JLabel lblNewLabel = new JLabel("Monday");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(29, 29, 51, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTuesday.setBounds(121, 29, 51, 14);
		frame.getContentPane().add(lblTuesday);

		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWednesday.setBounds(212, 29, 71, 14);
		frame.getContentPane().add(lblWednesday);

		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThursday.setBounds(316, 30, 71, 14);
		frame.getContentPane().add(lblThursday);

		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFriday.setBounds(422, 29, 51, 14);
		frame.getContentPane().add(lblFriday);

		JButton btnNewButton = new JButton("Complete!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] demo = {
						{ textField_00.getText(), textField_01.getText(), textField_02.getText(),
								textField_03.getText(), textField_04.getText() },
						{ textField_10.getText(), textField_11.getText(), textField_12.getText(),
								textField_13.getText(), textField_14.getText() },
						{ textField_20.getText(), textField_21.getText(), textField_22.getText(),
								textField_23.getText(), textField_24.getText() },
						{ textField_30.getText(), textField_31.getText(), textField_32.getText(),
								textField_33.getText(), textField_34.getText() },
						{ textField_40.getText(), textField_41.getText(), textField_42.getText(),
								textField_43.getText(), textField_44.getText() },
						{ textField_50.getText(), textField_51.getText(), textField_52.getText(),
								textField_53.getText(), textField_54.getText() },
						{ textField_60.getText(), textField_61.getText(), textField_62.getText(),
								textField_63.getText(), textField_64.getText() } };
				// Student s= new Student();
				// HashMap<String,Integer> subject=new HashMap<String,Integer>();
				for (int i = 0; i < demo.length; i++) {
					for (int j = 0; j < demo[i].length; j++) {
//						if (demo[i][j].isEmpty()) {
//							JOptionPane.showMessageDialog(null, "Please Enter all fields!");
//							return;
//						}
						Integer k = Subjects.subjects.get(demo[i][j]);
						Subjects.subjects.put(demo[i][j], (k == null) ? 1 : k + 1);
					}
				}
				// System.out.println(subject);
				User.user.setTimetable(demo);
				// System.out.println(s.showTimetable());
				 TimeTable t= new TimeTable();
				 TimeTable.main();
				 frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(202, 273, 112, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
