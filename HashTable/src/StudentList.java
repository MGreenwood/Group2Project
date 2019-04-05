/*
 * Create a Student linked list class for Student class to avoid collisions
 */
public class StudentList {
	private Node h;
	//Student List constructor
	public StudentList() {
		h = new Node();
		h.next = null;
		h.data = null;
	}
	//Insert function
	public boolean insertStudent(Student student) {
		Node n = new Node();
		n.data = student;
		n.next = h.next;
		h.next = n;
		return true;
	}
	//function to check against existing students
	public boolean existingStudentId(String rollno) {
		Node a = h.next;
		boolean exists = false;
		while(a != null) {
			if(rollno.equals(a.data.getStudentId())) {
				exists = true;
			}
			a = a.next;
		}
		return exists;
	}
	//function to fetch a particular student
	public Student fetchData(String studentid) {
		Student data = null;
		Node p = h.next;
		while(p != null) {
			if(p.data.getStudentId().equals(studentid)) {
				data=p.data;
				break;
			}
			p=p.next;
		}
		return data;
	}
	//function to delete student
	public void deleteStudent(String studentid) {
		Node p = h;
		Node q = h.next;
		while(q != null && !(q.data.getStudentId().equals(studentid))) {
			p = q;
			q = q.next;
		}
		if(q != null){
			p.next = q.next;
		}
		else {
			// no data found
		}
	}
	//function to display all data
	public void showAll() {
		Node x = h.next;
		while(x != null) {
			System.out.println(x.data);
			x = x.next;
		}
	}
	//Nested class with two main properties
	class Node{
		private Student data;
		private Node next;
	}
}
