package DataHouseProject;

import java.util.Arrays;

public class people {
	
	// attributes that describe people
	String fName; 
	double EQ; 
	double IQ; 
	double compat; 
	
	// template to make person
	people (String fName, double EQ, double IQ){
		this.fName = fName; 
		this.EQ = EQ; 
		this.IQ = IQ; 
	}
	
	// template to make person w/ compatibility score 
	people (String fName, double EQ, double IQ, double compat){
		this.fName = fName; 
		this.EQ = EQ; 
		this.IQ = IQ; 
		this.compat = compat; 
	}
	
	// getters
	public String getName() {
		return fName; 
	}
	
	public double getEQ() {
		return EQ; 
	}
	
	public double getIQ() {
		return IQ; 
	}
	
	public double getCompat() {
		return compat; 
	}
	
	// setters
	public void setCompat (double newCompat) {
		this.compat = newCompat; 
		
	}
	
	//----METHODS----
	
	// PRINT
	public String toString1 () {
		return fName  + ", " + EQ ;
	}
		
	public String toString2 () {
		return fName+ ", " + compat + " (percentage)" ;
		
	}
	
	
	// FIND AVERAGE EQ
		// input: array of persons
		// output: average team value of all people within array
		public static double getAverageEQ(people[] persons) { 
			
			double sum = 0; 
			
			for (int j = 0; j < persons.length; j++) {
				sum = sum + persons[j].getEQ(); 
			}
			
			double average = sum / persons.length; 
			return average; 
		}
	
	// FIND AVERAGE IQ
		// input: array of persons
		// output: average team value of all people within array
		public static double getAverageIQ(people[] persons) { 
			
			double sum = 0; 
			
			for (int j = 0; j < persons.length; j++) {
				sum = sum + persons[j].getIQ(); 
			}
			
			double average = sum / persons.length; 
			return average; 
		}
	
	
	// RANK COMPATIBILITY OF EQ
		// input: array of people (potential hires), array of people (current employees)
		// output: compatibility score by EQ
	public static double rankArrByEQ(people[] arrayOfPeople, int k, people[] arrayOfEmp) {

		if (arrayOfPeople[k].getEQ() > getAverageEQ(arrayOfEmp))// if above, not as compatible
			return .1;

		else if (arrayOfPeople[k].getEQ() == getAverageEQ(arrayOfEmp))// if equal, compatible
			return .5;

		else if (arrayOfPeople[k].getEQ() < getAverageEQ(arrayOfEmp))
			return 0;

		return 0;
	}
	
	// RANK COMPATIBILITY OF IQ
			// input: array of people (potential hires), array of people (current employees)
			// output: compatibility score by IQ
	public static double rankArrByIQ(people[] arrayOfPeople, int k, people[] arrayOfEmp) {

		if (arrayOfPeople[k].getIQ() > getAverageIQ(arrayOfEmp))// if above, not as compatible
			return .1;

		else if (arrayOfPeople[k].getIQ() == getAverageIQ(arrayOfEmp))// if equal, compatible
			return .5;

		else if (arrayOfPeople[k].getIQ() < getAverageIQ(arrayOfEmp))
			return 0;

		return 0;
	}
	
	
	// SORT POTENTIAL HIRES BY COMPATIBLITY
		// input: array of people (hires) 
		// output: ordered array
		public static void insertionSortPeople(people[] arr) {
	        for (int i = 1; i < arr.length; i++) {
	            people key;
	            key = arr[i];
	            int j = i - 1;
	            while (j >= 0 && arr[j].getCompat() > key.getCompat()) {
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j + 1] = key;
	        }
		}
	
	//----------------------------------------------------------------------------------------------------MAIN
	
	public static void main (String [] args) {
		
		// potential hires
		people h1 = new people ("jenna", 9, 9); 
		people h2 = new people ("amelia", 7, 9); 
		people h3 = new people ("james", 2, 8);
		
		// potential hires now in array
		people[] arrayHires = {h1, h2, h3}; 
		
		// print potential hires
		System.out.println("\nPotential Hires"); 
		for (int i = 0; i < arrayHires.length; i++) {
			System.out.println(arrayHires[i].toString1());
		}
		
		// current employees
		people e1 = new people ("zoe", 9, 10); 
		people e2 = new people ("lia", 9, 9); 
		people e3 = new people ("eloise", 9, 5); 
		
		// current employees now in array 
		people[] arrayOfEmp = {e1, e2, e3}; 
		
		// print current employees
		System.out.println("\nCurrent Employees"); 
		for (int i = 0; i < arrayOfEmp.length; i++) {
			System.out.println(arrayOfEmp[i].toString1());
		}
		
		
		// get and print average EQ and IQ
		System.out.println("\nAverage Employee EQ"); 
		System.out.println(getAverageEQ(arrayOfEmp));
		
		System.out.println("\nAverage Employee IQ"); 
		System.out.println(getAverageIQ(arrayOfEmp));
		
		
		// print compatibility scores
		System.out.println("\nCompatability Scores of Potential Hires by EQ: "); 
		for (int i = 0; i <arrayHires.length; i++) {
			System.out.println( 
					arrayHires[i].getName() + " --- " +
					rankArrByEQ(arrayHires, i, arrayOfEmp) 
					);	
		}
		
		System.out.println("\nCompatability Scores of Potential Hires by IQ: "); 
		for (int i = 0; i <arrayHires.length; i++) {
			System.out.println( 
					arrayHires[i].getName() + " --- " +
					rankArrByIQ(arrayHires, i, arrayOfEmp) 
					);	
		}
		
		
		// set compatibility scores (EQ compatibility + IQ compatibility
		for (int i = 0; i < arrayHires.length; i++)
		arrayHires[i].setCompat(
				rankArrByEQ(arrayHires, i, arrayOfEmp) +
				rankArrByIQ(arrayHires, i, arrayOfEmp)
				);
		
		
		// sort by compatibility
		insertionSortPeople(arrayHires); 
		
		
		// print in order
		System.out.println("\nPotential Hires \nby order of least to most compatible"); 
		
			people[] newArray = Arrays.copyOf(arrayHires, arrayHires.length);
			for (int i = 0; i < newArray.length; i++) {
				System.out.println(newArray[i].toString2());
			}
		
			
		} 
}
	


