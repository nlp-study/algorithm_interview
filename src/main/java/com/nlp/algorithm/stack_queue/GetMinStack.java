package com.nlp.algorithm.stack_queue;

import java.util.Stack;



class MinStack1
{
	Stack<Integer> stackData = new Stack<Integer>();
	Stack<Integer> stackMin = new Stack<Integer>();
	
	public Integer pop()
	{
		if(stackData.size() > 0)
		{
			int value = stackData.pop();
			if(value==stackMin.peek())
			{
				stackMin.pop();
			}
			return stackData.pop();
		}
		return null;
	}
	
	public void push(int value)
	{
		if(stackMin.isEmpty())
		{
			stackMin.push(value);
		}
		else if(stackMin.peek()>value)
		{
			stackMin.push(value);
		}
		
		stackData.push(value);
	}
	
	public int getMin()
	{
		if(stackMin.empty())
		{
			throw new RuntimeException("your stack is empty!");
		}
		return stackMin.peek();
	}
}


class MinStack2
{
	Stack<Integer> stackData = new Stack<Integer>();
	Stack<Integer> stackMin = new Stack<Integer>();
	
	
	public Integer pop()
	{
		if(stackData.size() > 0)
		{
			int value = stackData.pop();
			stackMin.pop();
			return stackData.pop();
		}
		return null;
	}
	
	public void push(int value)
	{
		if(stackMin.isEmpty())
		{
			stackMin.push(value);
		}
		else if(stackMin.peek()>value)
		{
			stackMin.push(value);
			stackMin.push(stackMin.peek());
		}
		
		stackData.push(value);
	}
	
	public int getMin()
	{
		if(stackMin.isEmpty())
		{
			throw new RuntimeException("you stack is emtpy.");
		}
		return stackMin.peek();
	}
}


public class GetMinStack {
	
	
	public static void main(String[] args)
	{
		int[] datas = {1,2,1,-5,4,3};
		MinStack2 minStack = new MinStack2();
		for(int data:datas )
		{
			minStack.push(data);
			int value = minStack.getMin();
			System.out.println("1 min value:"+value);
		}
		
		
		for(int i=0;i<datas.length;++i)
		{
			int value = minStack.getMin();
			System.out.println("2 min value:"+value);
			minStack.pop();
		}
	}
	
	

}
