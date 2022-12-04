package tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class MainScreen {

	private JFrame frame;
	private JLabel txtProductivityTracker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	 void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 556, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnNewButton = new JButton("Set Time Table ");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetTimetTable s= new SetTimetTable();
				s.main(null);
				frame.setVisible(false);
				//directed to time table 
			}
		});
		btnNewButton.setBounds(0, 40, 114, 28);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(200, 88, 165, 30);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(textArea);
		textArea.setText("QUOTE OF THE DAY!");
		
		JButton btnNewButton_1 = new JButton("Schedule");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//directed to schedule
				AddTests schedule = new AddTests();

			}
		});
		btnNewButton_1.setBounds(0, 108, 114, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Expected Grade");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] subject =  Subjects.subjects.keySet().toArray();
				Object[] units =  	Subjects.subjects.values().toArray();
				for(int i=0;i<subject.length;i++) {
					if(!subject[i].equals("")) {
						ExpectedGrade.main(subject[i],units[i]);						
					}
				}
				//expected grade 
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_2.setBounds(0, 176, 114, 28);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View TimeTable");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeTable.main();
				frame.setVisible(false);
				//yearly map
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setBounds(0, 244, 114, 28);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("GradeSheet");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GradeSheet gs = new GradeSheet();
				gs.main();
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_4.setBounds(0, 312, 114, 28);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("View all notes");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BITSNoteTakingApp note = new BITSNoteTakingApp();
				//view all notes 
			}
		});
		btnNewButton_5.setBounds(211, 203, 139, 21);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Collaboration");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						CollaborativeNotesServer.main(null);
						CollaborativeNotesGUI.main(null);
					}
				});
				thread.start();
				
				//Collaboration
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_6.setBounds(428, 40, 114, 28);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Productivity ");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BITSProductiveTimeTracker.main(null);
				//productivity 
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_7.setBounds(428, 108, 114, 28);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Log Out");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frame.setVisible(false);
				
				//log out 
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_8.setBounds(428, 175, 114, 28);
		frame.getContentPane().add(btnNewButton_8);
		
		txtProductivityTracker = new JLabel();
		txtProductivityTracker.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		txtProductivityTracker.setText("Productivity Tracker ");
		txtProductivityTracker.setBounds(212, 10, 125, 19);
		frame.getContentPane().add(txtProductivityTracker);
	}
}
