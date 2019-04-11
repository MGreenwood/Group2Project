
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student phil = new Student("Phil", "99", 4.0);
		
		DoublyLinkedList pjm = new DoublyLinkedList();
		
		pjm.addTail(phil);
		
		pjm.print();
	}

}
