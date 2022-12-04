package tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.*;
import java.util.*;

public class FileHandling {
	final static String filepath = "E:\\Login.txt";
	static List<String> ID = new ArrayList<String>();
	static List<String> Password = new ArrayList<String>();
	static List<String> Name = new ArrayList<String>();

	public static void write(String Name,String ID,String Password) throws Exception {
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath, true)));
		writer.append("\n"+Name+" "+ID+" "+Password);
		writer.close();

	}
	public static void read() throws Exception {
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		while ((line = reader.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(line);
			while (str.hasMoreTokens()) {
				Name.add(str.nextToken());
				ID.add(str.nextToken());
				Password.add(str.nextToken());
			}
		}
		reader.close();
	}

}