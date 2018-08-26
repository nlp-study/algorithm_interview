package com.nlp.algorithm.stack_queue;

import java.util.Stack;

public class ReversedStack {
	public static int getAndRemoveLastElement(Stack<Integer> stack)
	{
		int result = stack.pop();
		if(stack.isEmpty())
		{
			return result;
		}
		else
		{
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static void reverse(Stack<Integer> stack)
	{
		if(stack.isEmpty())
		{
			return;
		}
		int i= getAndRemoveLastElement( stack) ;
		reverse(stack);
		stack.push(i);
	}
	
	
	public static void main(String[] args)
	{
		int[] datas = {1,2,-5,4,3};
		Stack<Integer> stack = new Stack<Integer>();
		for(int data:datas )
		{
			stack.push(data);
//			System.out.println("peek:"+twoStackQueue.peek());
		}
		
//		reverse( stack);
		getAndRemoveLastElement(stack);
		
		
		while(!stack.empty())
		{
			System.out.println("stack:"+stack.pop());
		}
	}

}
