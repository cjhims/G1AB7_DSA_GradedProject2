package com.greatlearning.bst.model;

//Class of the node
public class Node {
	public int val;
	public Node left, right;

	// Helper function that allocates a new node
	// with the given data and NULL left and right
	// pointers.
	public Node(int item) {
		val = item;
		left = right = null;
	}
}
