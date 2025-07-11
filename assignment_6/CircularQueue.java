package com.aaslin.java.assignments.assignment_6;

class QueueDemoClass{
	private int front;
	private int rear;
	private int maxSize;
	private int[] array;
	public QueueDemoClass(int size) {
		front=-1;
		rear=-1;
		maxSize=size;
		array=new int[size];
	}
	
	public void enqueue(int element) {
		
		if(isEmpty()) {
			front=0;
			rear=0;
			array[rear]=element;
			
			System.out.println(element+" inserted");
			
		}
		
		else {
				rear=(rear+1)%maxSize;
				if(rear==front) {
					System.out.println("Queue is full. Cannot perform enqueue operation!");
					rear=(rear-1+maxSize) % maxSize;
				}
				else {
					System.out.println(element+" inserted");
					array[rear]=element;
				}
				
		}			
	}
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("\nQueue is empty");
		}
		else {
			front=(front+1)%maxSize;
		}
	}
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("\nQueue is empty");
		}
		else {
			int current=front;
			for(int iterator=0;iterator<maxSize;iterator++) {
				System.out.print(array[current]+" ");
				current=(current+1)%maxSize;
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

public class CircularQueue{
	public static void main(String[] args) {
		QueueDemoClass queue = new QueueDemoClass(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		queue.showQueue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		queue.showQueue();	
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.showQueue();
		System.out.println("Peek element: "+queue.peek());
		
	}
}
