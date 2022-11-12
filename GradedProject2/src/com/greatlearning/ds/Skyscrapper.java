package com.greatlearning.ds;

import java.util.Scanner;
import java.util.Stack;

public class Skyscrapper {

	public static class Queue {
		private int maxSize;
		int front;
		int rear;
		int arr[];

		public Queue(int sizeOfQueue) {
			this.maxSize = sizeOfQueue;
			front = -1;
			rear = -1;
			arr = new int[maxSize];
		}

		public boolean isFull() {
			if (rear == maxSize - 1) {
				return true;
			}
			return false;
		}

		public boolean isEmpty() {
			if (front == -1) {
				return true;
			}
			return false;
		}

		public void enQueue(int data) {
			if (!isFull()) {
				rear++;
				arr[rear] = data;
				if (front == -1)
					front = 0;
			} else {
				System.out.println("Queue overflow");
			}
		}

		public int deQueue() {
			if (isEmpty()) {
				System.out.println("queue underflow");
				return 0;
			} else {
				return arr[front];
			}

		}

		public void updatePointers() {
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front++;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> stk = new Stack<>();
		// total floors
		System.out.println("Enter the total no of floors in the building: ");
		int size = sc.nextInt();
		Queue q = new Queue(size);

		// floor manufactured on each construction day
		for (int i = 0; i < size; i++) {
			System.out.println("Enter the floor size given on day " + (i + 1) + ": ");
			q.enQueue(sc.nextInt());
		}

		System.out.println("\nThe order of construction is as follows: \n");
		int key = 0, j = 1, max = size;
		// creating an object of Stack class

		// pushing elements into stack
		for (int i = 0; i < size; i++) {
			key = q.deQueue();
			q.updatePointers();
			stk.push(key);
			if (key == max) {
				System.out.println("Day " + j + ": ");
				while (stk.peek() == max) {
					System.out.print(" " + stk.pop());
					max--;
					if (stk.empty())
						break;
				}
				j++;
				System.out.println();
			} else {
				System.out.println("Day " + j + ": ");
				j++;
			}
		}
		sc.close();
	}
}
