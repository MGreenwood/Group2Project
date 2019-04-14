/*
 * Create the Hash Table class along with properties for a Student List array
 * size and total number of students
 */
public class Hashtable {
	private StudentList[] arr;
	private int size;
	private int totalstudents;
	//Hash Table constructor
	public Hashtable() {
		size = 1000;
		arr = new StudentList[size];
	}
	//function to convert student id into hash code
	public int toHashCode(String studentid) {
		int addhash = 0;
		int codevalue = 0;
		for(int i = 0; i < studentid.length(); i++) {
			addhash = addhash + (int)studentid.charAt(i);
		}
		codevalue = addhash %arr.length;
		return codevalue;
	}
	//function to insert student object into index
	public boolean insert(int key, Student data) {
		if(arr[key] == null) {
			arr[key] = new StudentList();
		}
		arr[key].insertStudent(data);
		totalstudents++;
		return true;
	}
	//function to return total number of students
	public int getTotal() {
		return totalstudents;
	}
	//function to check if a student exists within the array
	public Student fetchStudentInfo(String studentid) {
		int key = toHashCode(studentid);
		if(arr[key] == null) {
			return null;
		}
		else {
			Student query = arr[key].fetchData(studentid);
			if(query != null) {
				return query;
			}
			else {
				return null;
			}
		}
	}
	//function to delete student from array
	public boolean deleteStudent(String studentid) {
		boolean exists = arr[toHashCode(studentid)].existingStudentId(studentid);
		if(exists) {
			int key = toHashCode(studentid);	
			arr[key].deleteStudent(studentid);
			totalstudents--;
			return true;
		}
		return false;
	}
	//prints all data
	public void printAll() {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {
					arr[i].showAll();
			}
		}
	}
}
