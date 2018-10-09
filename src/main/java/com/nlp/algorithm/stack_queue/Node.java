package com.nlp.algorithm.stack_queue;

public class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int data)
	{
		this.value = data;
	}

	@Override
	public String toString() {
		return "[value=" + value + ", left=" + left + ", right=" + right+"]";
				
	}

}
