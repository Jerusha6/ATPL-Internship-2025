package com.aaslin.java.assignments.assignment6;

class Queue{
	private int front;
	private int rear;
	private int maxSize;
	private int[] array;
	public Queue(int size) {
		front=-1;
		rear=-1;
		maxSize=size;
		array=new int[size];
	}
	
	public void enqueue(int element) {
		if(front==-1) {
			front++;
		}
		if(rear==maxSize-1) {
			System.out.println("\nQueue is full");
		}
		else {
			rear++;
			array[rear]=element;
		}		
	}
	public void dequeue() {
		if(front==-1) {
			System.out.println("\nQueue is empty");
		}
		else {
			front++;
		}
	}
	public void showQueue() {
		if(front==-1) {
			System.out.println("\nQueue is empty");
		}
		else {
			for(int iterator=front;iterator<=rear;iterator++) {
				System.out.print(array[iterator]+" ");
			}
			System.out.println();
		}	
	}
	public int peek() {
		return array[front];
	}
	public void isFull() {
		if(rear==maxSize-1) {
			System.out.println("\nQueue is full");
		}
		else {
			System.out.println("\nQueue still has "+((maxSize-1)-rear)+" capacity");
		}
	}
}

public class QueueImplementation{
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.showQueue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.showQueue();
		queue.isFull();
		System.out.println("Peek element: "+queue.peek());
		
	}
}
