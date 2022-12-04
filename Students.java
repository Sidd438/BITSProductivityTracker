package tracker;

import tracker.FileHandling;

import java.io.*;
import java.util.ArrayList;

public class Students implements Serializable {
	static ArrayList<Student> students = new ArrayList<Student>();
	public static final String filepath = "D:\\Students\\Students.txt";

	
	public static void add(String text, String text2, String text3) {
		//FileHandling.WriteObjectToFile(filepath, new Student(text, text2, text3));
		students.add(new Student(text, text2, text3));
	}
	@SuppressWarnings("unchecked")
	public static void read() {
		try {
			FileHandling.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<FileHandling.ID.size();i++) {
			students.add(new Student(FileHandling.Name.get(i),FileHandling.ID.get(i),FileHandling.Password.get(i)));
		}
		//System.out.println(students);
	}
}
