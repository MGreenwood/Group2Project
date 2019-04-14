/*
 * Create a student class along with properties for name, student id and GPA
 */
 class Student {
	 private String name;
	 private String studentid;
	 private double gpa;
	//Student constructor
	 public Student(String name, String studentid, double gpa) {
		 this.name=name;
		 this.studentid=studentid;
		 this.gpa=gpa;
	 }
	 //Setter for student name
	 public void setName(String name) {
		 this.name = name;
	 }
	 //Getter for student name
	 public String getName() {
		 return name;
	 }
	 //Setter for student id
	 public void setStudentId(String studentid) {
		 this.studentid=studentid;
	 }
	 //Getter for student id
	 public String getStudentId() {
		 return studentid;
	 }
	 //Setter for GPA
	 public void setGPA(double gpa) {
		 this.gpa=gpa;
	 }
	 //Getter for GPA
	 public double getGPA() {
		 return gpa;
	 }
	 //Convert to String for Main class
	 public String toString() {
		 return "Name: " + name + " Student ID: "+ studentid +" GPA: "+ gpa;
	 }
}
