package tracker;

public class Student {
	private String username;
	private String password;
	private String name;
	private Integer ID;
	private float CGPA;
	private String Branch;
	
	public Student(String text, String text2) {
		setUsername(text);
		setPassword(text2);
		// TODO Auto-generated constructor stub
	}
	public void Student() {
		
	}
		
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
}
