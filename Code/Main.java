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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Main
{
	static int toGenerate = 1000;
	static String nameFile = "RandomStudentNames.txt";

	public static void main(String[] args)
	{
		// create the structures that will be tested
		Hashtable ht = new Hashtable();
		ArrayList arrayList = new ArrayList();
		DoublyLinkedList dll = new DoublyLinkedList();

		// create a list of length "toGenerate" of Student classes
		// this will be used to populate the structures, and "randomly" seek and access records in the structures
		Student[] students = GenerateStudents();


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
					continue;
			}
		}
		catch (IOException e)
		{
			System.err.format("IOException: %s%n", e);
		}

		return students;
	}
}
