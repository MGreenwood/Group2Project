public class ArrayList {

	private int size = 10; // default size
	private int n = -1; // keeps track of array elements
	private  Student[] arr = new Student[10]; //default arr

	public Student getLast(){ // returns the end of the array
		if(n < 0)
			return null;
		return arr[n];
	}

	public Student getFirst(){ // returns the front of the array
		if(n < 0)
			return null;
		return arr[0];
	}
	
	public Student get(Student s){
		for(int i = 0; i < n + 1; i++){
			if(arr[i].equals(s)){
				return s;
			}
		}
		return null;
	}

	public int getSize(){ // returns the size of the array
		return n + 1;
	}

	private void resize(){ // resizes the array based on how many slots are occupied
		if(n == size - 1){ // doubles the array if full
			int i = 0;
			Student[] temp = new Student[size*2];
			for(Student s : arr){
				temp[i] = s;
				i++;
			}
			arr = temp;
		}
		if(n == size/4 && size > 10){ // halves the array its a quarter full
			int i = 0;
			Student[] temp = new Student[size/2];
			for(Student s : arr){
				temp[i] = s;
				i++;
			}
			arr = temp;
		}
	}

	public void addLast(Student s){ // appends an element to end of the array
		resize();
		arr[++n] = s;
	}

	public void addFirst(Student s){ // adds the element to the front of the array
		add(s, 0);
	}

	public void add(Student s, int index){ // adds an elment at any given index of the array
		resize();
		if(arr[index].equals(null)){ // tests for empty array
			arr[index] = s;
			n++;
		}
		else{
			int i = n;
			while(i > index+1){ // move elements over
				arr[i + 1] = arr[i];
				i--;
			}
			arr[index] = s;
			n++;
		}
	}

	public Student remove(Student s){ // removes a given element from the array
		resize();
		for(int i = 0; i < n + 1; i++){
			if(arr[i].equals(s)){
				while(i < n){ // moves elements inward
					arr[i] = arr[++i];
				}
				arr[n] = null;
				n--;	
				return s;
			}
		}
		return null;
	}

	public void print(){ // prints out the elements of the array
		String printOut = arr[0] + "";
		for(int i = 1; i < n + 1; i++){
			if(i % 3 == 0){
				printOut += ",\n" + arr[i];
				continue;
			}
			printOut += ", " + arr[i];
		}
		System.out.println(printOut);
	}

	public static void main(String[] args){

		ArrayList AA = new ArrayList();
		Student s = new Student("s", 1+"", 4);
		Student s1 = new Student("s1", 2+"", 4);
		Student s2 = new Student("s2", 3+"", 3.5);
		Student s3 = new Student("s3", 4+"", 3.2);
		Student s4 = new Student("s4", 5+"", 3);
		Student s5 = new Student("s5", 6+"", 2.8);
		Student s6 = new Student("s6", 7+"", 2.5);
		Student s7 = new Student("s7", 8+"", 2);
		Student s8 = new Student("s8", 9+"", 1.5);
		Student s9 = new Student("s9", 10+"", 1.2);
		Student s10 = new Student("s10", 11+"", 1.1);
		Student s11 = new Student("s11", 12+"", 1);

		AA.addLast(s);
		AA.addLast(s1); // adding an element that exists at the end
		AA.addLast(s2);
		AA.addLast(s3);
		AA.addLast(s4);
		AA.addLast(s5);
		AA.addLast(s6);
		AA.addLast(s7);
		AA.addLast(s8);
		AA.addLast(s9);
		AA.addLast(s10);
		AA.addLast(s11);
		AA.remove(s1); // rmeoving an element that exists
		AA.remove(s11);
		AA.remove(s10);
		AA.remove(s5);
		AA.remove(s5); // removing an element that does not exist in the array
		AA.add(s5, 0);

		AA.print(); 

		System.out.println("\nSize of AA: " + AA.getSize());
		System.out.println("\nFirst: " + AA.getFirst());
		System.out.println("\nLast: " + AA.getLast());

	}
}
