package tracker;

import java.io.*;

public class Student implements Serializable{
	private String password="";
	private String name="";
	private String ID="";
	private float CGPA=0;
	private String[][] timetable = new String[5][7];
//	static String[][] test = { { "A1", "B1", "C1", "J1", "K1" }, { "D1", "E1", "F1", "L1", "M1" },
//			{ "G1", "H1", "I1", "N1", "O1" }, };

	public Student(String text, String text1,String text2) {
		setName(text);
		setID(text1);
		setPassword(text2);
	}

	public Student() {
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public float getCGPA() {
		return CGPA;
	}

	public void setCGPA(float cGPA) {
		CGPA = cGPA;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[][] getTimetable() {
		return timetable;
	}

	public String showTimetable() {
//		String[][] test= {
//				{"A1","B1","C1"},
//				{"D1","E1","F1"},
//				{"G1","H1","I1"},
//		};
		String txt = "";
		for (int i = 0; i < this.timetable.length; i++) {
			for (int j = 0; j < this.timetable[i].length; j++) {
				txt = txt + timetable[i][j] + " ";
				// System.out.print(timetable[i][j]);
			}
			txt = txt + "\n";
			// System.out.println();
		}
		return txt;
	}

	public void setTimetable(String[][] timetable) {
		this.timetable = timetable;
	}
}
