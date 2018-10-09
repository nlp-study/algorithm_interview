package com.nlp.algorithm.stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class MaxSubMatrix {
	public static int getMaxSubMatrix(int[][]A)
	{
		int rowSize = A.length;
		int colSize = A[0].length;
		int[] hieght = new int[colSize];
		int maxArea = 0;
		for(int i=0;i<rowSize;i++)
		{
			Stack<Integer> stacks = new Stack<Integer>();
			for(int j=0;j<colSize;++j)
			{
				hieght[j] = A[i][j]<1?0:hieght[j]+1;
			}
			
			System.out.println("hieght:" + Arrays.toString(hieght));
			
			
			for(int j=0;j<colSize;++j)
			{
				while((!stacks.empty())&&hieght[j]<=hieght[stacks.peek()])
				{
					int index = stacks.pop();
					int dis = 0;
					if(!stacks.empty())
					{
						dis = j - 1 - stacks.peek();
					}
					else
					{
						dis = j - 1 ;
					}
//					int dis = j-1-stacks.peek();
					int tempArea = dis * hieght[index];
					if(tempArea>maxArea)
					{
						maxArea = tempArea;
					}
					if(stacks.empty())
					{
						break;
					}
				}
				if(stacks.empty() ||hieght[j]>hieght[stacks.peek()] )
				{
					stacks.push(j);
					continue;
				}
			}
			while(!stacks.empty())
			{
				int index = stacks.pop();
				int dis = 0;
				if(!stacks.empty())
				{
					dis = colSize -1 - stacks.peek();
				}
				else
				{
					dis = colSize ;
				}
				 
				int tempArea = dis * hieght[index];
				if(tempArea>maxArea)
				{
					maxArea = tempArea;
				}
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args)
	{
		int[][] A = new int[3][3];
		A[0][0] = 0;
		A[0][1] = 1;
		A[0][2] = 1;
		A[1][0] = 0;
		A[1][1] = 1;
		A[1][2] = 1;
		A[2][0] = 0;
		A[2][1] = 1;
		A[2][2] = 1;
		
		MaxSubMatrix maxSubMatrix = new MaxSubMatrix();
		int area = maxSubMatrix.getMaxSubMatrix(A);
		System.out.println("area:"+area);
	}

}
