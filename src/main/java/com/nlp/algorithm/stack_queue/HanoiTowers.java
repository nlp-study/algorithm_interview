package com.nlp.algorithm.stack_queue;

public class HanoiTowers {
	public static int hanoiProblem1(int num,String right,String mid,String left)
	{
		if(num<1)
		{
			return 0;
		}
		return process1( num, right, mid, left, left, right);
	}
	
	public static int process1(int num,String right,String mid,String left,String from,String to)
	{
		if(num==1)
		{
			if(from.equals(mid) || to.equals(mid))
			{
				System.out.println("move " + num + " from "+ from + " to " + to);
				return 1;
			}
			else
			{
				System.out.println("move " + num + " from "+ from + " to " + mid);
				System.out.println("move " + num + " from "+  mid + " to " + to);
				return 2;
			}
		}
		
		
		if(from.equals(mid) || to.equals(mid))
		{
			String another = (from.equals(left)||to.equals(left))?right:left;
			int size1 = process1( num-1, right, mid, left, from, another);
			int size2 = 1;
			System.out.println("move " + num + " from "+from + " to " + to);
			int size3 = process1( num-1, right, mid, left, another, to);
			return size1 + size2 + size3 ;
		}else
		{
			int size1 = process1( num-1, right, mid, left, from, to);
			int size2 = 1;
			System.out.println("move " + num + " from "+from + " to " + mid);
			
			int size3 = process1( num-1, right, mid, left, to, from);
			int size4 = 1;
			
			System.out.println("move " + num + " from "+mid + " to " + to);
			
			int size5 = process1( num-1, right, mid, left, from, to);
			return size1 + size2 + size3 + size4 + size5;
		}
		
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		int num = 5;
		String right = "right";
		String mid = "mid";
		String left = "left";
		
		int size = HanoiTowers.hanoiProblem1(num, right, mid, left);
		System.out.println("size:"+size);
	}
}
