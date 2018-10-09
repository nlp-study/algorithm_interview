package com.nlp.algorithm.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxTree1 {
	public void buildMaxTree()
	{
		
	}
	
	public static Node  processMaxTree(int[]A)
	{
		Node[] nodes = new Node[A.length];
		for(int i=0;i<A.length;++i)
		{
			nodes[i] = new Node(A[i]);
		}
		
		Stack<Node> leftMaxStack = new Stack<Node>();
		Stack<Node> rightMaxStack = new Stack<Node>();
		
		Map<Node,Node> leftMax = new HashMap<Node,Node>();
		Map<Node,Node> rightMax = new HashMap<Node,Node>();
		
		for(int i=0;i<A.length;++i)
		{
			while((!leftMaxStack.empty()) && leftMaxStack.peek().value < A[i] )
			{
				leftMaxStack.pop();
			}
			if(leftMaxStack.empty())
			{
				leftMaxStack.push(nodes[i]);
				leftMax.put(nodes[i], null);
				continue;
			}
			else
			{
				leftMax.put(nodes[i], leftMaxStack.peek());
				leftMaxStack.push(nodes[i]);
			}
			
		}

		for(int i=A.length-1;i>-1;--i)
		{
			while((!rightMaxStack.empty()) && rightMaxStack.peek().value < A[i] )
			{
				rightMaxStack.pop();
			}
			
			
			if(rightMaxStack.empty())
			{
				rightMaxStack.push(nodes[i]);
				rightMax.put(nodes[i], null);
				continue;
			}
			else
			{
				rightMax.put(nodes[i], rightMaxStack.peek());
				rightMaxStack.push(nodes[i]);
			}
		}
		
		Node root = null;
		for(int i=0;i<A.length;++i)
		{
			Node currentNode = nodes[i];
			Node leftMaxNode = leftMax.get(currentNode);
			Node rightMaxNode = rightMax.get(currentNode);
			Node fathreNode = null;
			if(leftMaxNode == null && rightMaxNode == null)
			{
				root = currentNode;
				continue;
			}
			
			
			
			else if(leftMaxNode == null && rightMaxNode != null)
			{
				fathreNode = rightMaxNode;
			}
			else if(leftMaxNode != null && rightMaxNode == null)
			{
				fathreNode = leftMaxNode;
			}
			else
			{
				fathreNode = leftMaxNode.value > rightMaxNode.value?rightMaxNode:leftMaxNode;
			}
			
			if(fathreNode.left == null)
			{
				fathreNode.left = currentNode;
			}
			else
			{
				fathreNode.right = currentNode;
			}
		}
		
		return root;
	}
	
	public static void main(String[] args)
	{
		int[] datas = {1,2,-5,4,3};
		
		
		Node root = MaxTree1.processMaxTree(datas);
		
		Stack<Node> nodes = new Stack<Node>();
		nodes.push(root);
		while(!nodes.empty())
		{
			Node node = nodes.pop();
			System.out.println("father node:"+node.value);
			
			if(node.left!=null)
			{
				nodes.push(node.left);
				System.out.println("left child node:"+node.left.value);
			}
			if(node.right!=null)
			{
				nodes.push(node.right);
				System.out.println("right child node:" + node.right.value);
			}
			
			System.out.println("                         ");
		}
		
		
		
		
	}
	
	

}
