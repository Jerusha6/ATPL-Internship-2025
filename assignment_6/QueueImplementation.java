package com.aaslin.java.assignments.assignment_6;

class QueueDemo{
	private int front;
	private int rear;
	private int maxSize;
	private int[] array;
	public QueueDemo(int size) {
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
	public boolean isEmpty() {
		if(front==-1 && rear == -1) {
			return true;
		}
		else return false;
	}
}

public class QueueImplementation{
	public static void main(String[] args) {
		QueueDemo queue = new QueueDemo(5);
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
		queue.isEmpty();
		System.out.println("Peek element: "+queue.peek());
		
	}
}
