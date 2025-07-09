
//Model a print queue system using Queue<String> where each string represents document.
//○ Add 5 documents.
//○ Process (remove) 2 documents.
//○ Display the remaining queue.

package com.aaslin.java.assignments.assignment6;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class PrintQueueSystem {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number documents you want to put into queue: ");
		int DocumentCount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Add "+DocumentCount+" Documents: ");
		for(int iterator=0;iterator<DocumentCount;iterator++) {
			queue.offer(scanner.nextLine());
		}
		System.out.println("Documents added to the queue");
		System.out.println("Enter number documents you want to process: ");
		int ProcessCount = scanner.nextInt();
		for(int iterator=0;iterator<ProcessCount;iterator++) {
			queue.poll();
		}
		System.out.println(ProcessCount+" documents processed.)");
		if(queue.size()!=0)
			System.out.println(" Here is the remaining documents to process"+queue);
		else
			System.out.println("No documents left to process");
	}
}