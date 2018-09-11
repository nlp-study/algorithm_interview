package com.nlp.algorithm.stack_queue;

import java.util.Stack;

public class HanoiTowersStack {
	
	Stack<Integer> leftStack = new Stack<Integer>();
	Stack<Integer> midStack = new Stack<Integer>();
	Stack<Integer> rightStack = new Stack<Integer>();
	enum TransType {leftMid,midRight,rightMid,mid2left}
	int size;
	
	
	
	public  int  process()
	{
		
		TransType transType = moveLeft2Mid();
		while((!leftStack.empty())||(!this.midStack.empty()))
		{
			
			 
			   
			 switch(transType)
			 {
			 case midRight:
				 transType =  moveMid2Right();
				 break;
			 case mid2left:
				 transType =  moveMid2Left();
				 break;
			 case rightMid:
				 transType =  this.moveRight2Mid();
				 break;
			 case leftMid:
				 transType =  this.moveLeft2Mid();
				 break;
				 
				 
			 }
			   
		}
		
		return size;
	}
	
	private TransType  moveLeft2Mid()
	{
		int num = leftStack.pop();
		 this.midStack.push(num);
		 size ++;
		 System.out.println("move " + num + " from left to mid" );
		 if(this.rightStack.empty() )
		 {
			 return TransType.midRight;
		 }
		 else if(this.midStack.empty())
		 {
			 return TransType.rightMid;
		 }
		 else if( this.midStack.peek()<this.rightStack.peek())
		 {
			 return TransType.midRight;
		 }
		 return TransType.rightMid;
	}
	
	
	private TransType moveMid2Right()
	{
		int num = this.midStack.pop();
		 this.rightStack.push(num);
		 size ++;
		 System.out.println("move " + num + " from mid to right" );
		 if(this.leftStack.empty()  )
		 {
			 return TransType.mid2left;
		 }else if(this.midStack.empty())
		 {
			 return TransType.leftMid;
		 }
		 else if(this.midStack.peek()<this.leftStack.peek())
		 {
			 return TransType.mid2left;
		 }
		 return TransType.leftMid;
	}
	
	
	private TransType moveRight2Mid()
	{
		int num = this.rightStack.pop();
		 this.midStack.push(num);
		 size ++;
		 System.out.println("move " + num + " from right to mid" );
		 if(this.leftStack.empty() )
		 {
			 return TransType.mid2left;
		 }
		 else if(this.midStack.empty())
		 {
			 return TransType.leftMid;
		 }
		 else if(this.midStack.peek() < this.leftStack.peek())
		 {
			 return TransType.mid2left;
		 }
		 return TransType.leftMid;
	}
	
	
	private TransType moveMid2Left()
	{
		int num = this.midStack.pop();
		 this.leftStack.push(num);
		 size ++;
		 System.out.println("move " + num + " from mid to left" );
		 if(this.rightStack.empty())
		 {
			 return TransType.midRight;
		 }
		 else if(this.midStack.empty())
		 {
			 return TransType.rightMid;
		 }
		 else if( this.midStack.peek()<this.rightStack.peek())
		 {
			 return TransType.midRight;
		 }
		 return TransType.rightMid;
	}
	
	
	
	
	public static void main(String[] args)
	{
		HanoiTowersStack hanoiTowersStack = new HanoiTowersStack();
		
		for(int i=5;i>0;--i)
		{
			hanoiTowersStack.leftStack.push(i);
		}
		int size = hanoiTowersStack.process();
		System.out.println("size:"+size);
	}
}
