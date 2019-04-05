
public class Main {

	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		Student student1 = new Student("Mike", "15-123", 3.7);
		Student student2 = new Student("Sue", "15-423", 3.1);
		Student student3 = new Student("Mikey", "15-223", 3.2);
		Student student4 = new Student("Xavier", "15-321", 3.0);
		
		int student1key = ht.toHashCode(student1.getStudentId());
		int student2key = ht.toHashCode(student2.getStudentId());
		int student3key = ht.toHashCode(student3.getStudentId());
		int student4key = ht.toHashCode(student4.getStudentId());
		
		ht.insert(student1key, student1);
		ht.insert(student2key, student2);
		ht.insert(student3key, student3);
		ht.insert(student4key, student4);
		
		ht.deleteStudent(student3.getStudentId());
		ht.printAll();	
		
		Student new_student2 = ht.fetchStudentInfo(student2.getStudentId());
		if(new_student2.getName().equals(student2.getName())){
			System.out.println("Equal");
		}
	}

}
