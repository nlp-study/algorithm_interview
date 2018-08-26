package com.nlp.algorithm.stack_queue;

import java.util.Stack;

public class TwoStackQueue {
	Stack<Integer> pushStack = new Stack<Integer>();
	Stack<Integer> popStack = new Stack<Integer>();
	
	public void add(int value)
	{
		pushStack.push(value);
	}
	
	public Integer poll()
	{
		if(popStack.isEmpty())
		{
			if(pushStack.size() == 0)
			{
				return null;
			}
//			System.out.println("pushStack size:"+pushStack.size());
			
			while(!pushStack.empty())
			{
				int value = pushStack.pop();
				popStack.push(value);
			}
			
		}
		return popStack.pop();
	}
	
	public Integer peek()
	{
		if(popStack.isEmpty())
		{
			if(pushStack.size() == 0)
			{
				return null;
			}
			while(!pushStack.empty())
			{
				int value = pushStack.pop();
				popStack.push(value);
			}
			
		}
		return popStack.peek();
	}
	
	public static void main(String[] args)
	{
		TwoStackQueue twoStackQueue = new TwoStackQueue();
		int[] datas = {1,2,-5,4,3};
		for(int data:datas )
		{
			twoStackQueue.add(data);
//			System.out.println("peek:"+twoStackQueue.peek());
		}
		
		
		for(int i=0;i<2;++i)
		{
			int value = twoStackQueue.poll();
			System.out.println("2 min value:"+value);
		}
		
		for(int data:datas )
		{
			twoStackQueue.add(data);
			System.out.println("peek:"+twoStackQueue.peek());
		}
		
		for(int i=0;i<datas.length;++i)
		{
			int value = twoStackQueue.poll();
			System.out.println("2 min value:"+value);
		}
		
	}

}
