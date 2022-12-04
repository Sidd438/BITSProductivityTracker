package tracker;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeSheet {

	private JFrame frame;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeSheet window = new GradeSheet();
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
	public GradeSheet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String[] column= {"Subject","Grade"};
		Object[] subject = Subjects.grade.keySet().toArray();
		Object[] grades = Subjects.grade.values().toArray();
		Object[] units = Subjects.subjects.values().toArray();
		Float SGPA=(float) 0;
		Float sum=(float) 0;
		String[][] gradeSheet = new String[subject.length][2];
		for (int i = 0; i < subject.length; i++) {
			gradeSheet[i][0] = (String) subject[i];
			gradeSheet[i][1] = (String) grades[i];
			for (Grades g : Grades.values()) {
				if (grades[i].equals(g.toString())&&subject[i]!="") {
					SGPA=SGPA+g.marks*Integer.parseInt(units[i].toString());
					sum=sum+Integer.parseInt(units[i].toString());
					System.out.println(subject[i]+" "+g.marks+" "+units[i].toString()+" "+SGPA+" "+sum);
					break;
				}
			}
		}
		SGPA/=sum;
		JLabel btnNewButton = new JLabel("Expected SGPA: "+SGPA);
		btnNewButton.setBounds(168, 203, 187, 23);
		frame.getContentPane().add(btnNewButton);
		
		table_1 = new JTable(gradeSheet, column);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table_1.setBounds(10, 11, 414, 129);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(scrollPane);

		// JButton Back = new JButton("Back to main screen");

	}
}
