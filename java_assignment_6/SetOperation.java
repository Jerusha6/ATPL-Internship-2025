package com.aaslin.java.assignments.assignment6;
import java.util.HashSet;
import java.util.Set;

public class SetOperation {

	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		//inserting set 1 elements using for loop from 1 to 10
		for(int setElement=1; setElement<=10; setElement++) {
			set1.add(setElement);
		}
		
		
		//inserting set 2 elements using for loop from 5 to 15
		for(int setElement=5; setElement<=15; setElement++) {
			set2.add(setElement);
		}
		
		//set1 = {1,2,3,...,10} and set2 = {5,6,7,...,15}
		
		//Creating unionSet to hold union elements
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		
		//Creating intersectionSet to hold common elements
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		
		
		//Creating intersectionSet to hold common elements
				Set<Integer> differenceSet = new HashSet<>(set1);
				differenceSet.removeAll(set2);
				
		System.out.println("Set 1 contains: "+set1);
		System.out.println("Set 2 contains: "+set2);
		System.out.println("Union Set contains: "+unionSet);
		System.out.println("Intersection Set contains: "+intersectionSet);
		System.out.println("Differnce Set contains: "+differenceSet);
	}

}
