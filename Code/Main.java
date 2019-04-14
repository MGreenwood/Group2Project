/*
Author: Matt Greenwood
Date: 14 April 2019

Summary:
Our example would be a school looking to implement the best method of storing
and accessing student accounts for use in GPA calculations and general records
 management (e.g. information changes, student enrollment status, etc.). The
 school’s current system is aging and slow, so we’re tasked with improving the
 overall functionality with minimal resource usage and maximum performance enhancement.

Solutions

We will use three different data structures:

· Hash table

· Doubly linked list

· Array list

For our test cases in each data structure, we will calculate GPA’s and report it
to an output file. We will be calculating the average from quarterly grades stored
in our Student class object. We will be generating report metrics for each data
structure in varying list sizes: 50 students, 500 students, and 1,000 students. We’ll
also query each structure for the same three lists of users without output.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Main
{
	static int MAX_STUDENTS = 1000;
	static int toGenerate = 250; // CHANGE THIS NUMBER TO TEST VARYING SIZES
	static String nameFile = "RandomStudentNames.txt";
	static Hashtable ht;
	static ArrayList arrayList;
	static DoublyLinkedList dll;

	public static void main(String[] args)
	{
		if(toGenerate > MAX_STUDENTS)
			toGenerate = MAX_STUDENTS;

		// create the structures that will be tested
		ht = new Hashtable();
		arrayList = new ArrayList();
		dll = new DoublyLinkedList();

		// Create a list of length "toGenerate" of Student classes
		// this will be used to populate the structures and seek/access records in the structures
		Student[] students = GenerateStudents();

		// populate the structures using their built in functions
		for(int i =0; i < toGenerate; i++)
		{
			int key = ht.toHashCode(students[i].getStudentId());
			ht.insert(key, students[i]);
			arrayList.addLast(students[i]);
			dll.addTail(students[i]);
		}

		double first = 0d, second = 0d, third = 0d, start;
		// loop through students with equal distribution
		// Take time of access for each structure to compare
		for(int i=0;i<toGenerate;i++)
		{
			// query Hash
			start = System.nanoTime();
			QueryHash(students[i].getStudentId());
			first += System.nanoTime() - start;

			// query Array List
			start = System.nanoTime();
			QueryArrayList(students[i]);
			second += System.nanoTime() - start;

			// query Doubly linked list
			start = System.nanoTime();
			QueryDLL(students[i].getStudentId());
			third += System.nanoTime() - start;
		}

		// Print the results
		System.out.println("PROGRAM OUTPUT ---  TIMING CALCULATIONS ("+ toGenerate + " students)");
		System.out.println("------\t------\t------\t------\t------");
		System.out.println("Hashtable lookups took " + first / 1000000 + " milliseconds.");
		System.out.println("Array List lookups took " + second / 1000000 + " milliseconds.");
		System.out.println("Doubly Linked List lookups took " + third / 1000000 + " milliseconds.");
		System.out.println("------\t------\t------\t------\t------");
	}

	static void QueryHash(String id)
	{
		double gpa = ht.fetchStudentInfo(id).getGPA();
	}

	static void QueryArrayList(Student s)
	{
		double gpa = arrayList.get(s).getGPA();
	}

	static void QueryDLL(String id)
	{
		int key = ht.toHashCode(id);
		Student s = dll.Get(Integer.toString(key));
		double gpa;
		if(s != null)
			gpa = s.getGPA();
	}

	static Student[] GenerateStudents()
	{
		// This function will read in from a file of random names
		// With every name read, a student will be made

		String[] names = new String[1000];             // the list of names
		Student[] students = new Student[toGenerate]; // the students to return
		Random rand = new Random();                  // Random number to assign GPA

		try (BufferedReader br = Files.newBufferedReader(Paths.get(nameFile)))
		{
			// read line by line
			String line;
			int ct = 0;
			while ((line = br.readLine()) != null)
			{
				// GPA will be a random value between 2.0 and 4.0
				students[ct] = new Student(line,  Integer.toString(ct + 1), rand.nextFloat() * 2.0f + 2.0f);
				ct++;

				// max number of students created, move on
				if(ct >= toGenerate)
					break;
			}
		}
		catch (IOException e)
		{
			System.err.format("IOException: %s%n", e);
		}

		return students;
	}
}
