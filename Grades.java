package tracker;

public enum Grades {
	A1(10), A2(9), B1(8), B2(7), C1(6), C2(5), D(4), E(3);

	final float marks;

	Grades(float marks) {
		this.marks = marks;
	}
}
