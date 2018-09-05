package com.nlp.algorithm.stack_queue;

import java.util.Stack;

public class StackSortOtherStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> help = new Stack<Integer>();

	public void push(int value) {
		stack.push(value);
	}

	public void sortStack() {
		while (!stack.isEmpty()) {
			int tempValue = stack.pop();
//			if (help.isEmpty()) {
//				help.push(tempValue);
//				continue;
//			}
//			int helpTopValue = help.peek();
//			if (tempValue >= helpTopValue) {
//				help.push(tempValue);
//				continue;
//			}

			System.out.println("help:" + help);
			while ((!help.isEmpty()) && (tempValue < help.peek())) {
				stack.push(help.pop());
			}
			help.push(tempValue);
		}

		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

	public void print() {
		System.out.println("stack:" + stack);
	}

	public static void main(String[] args) {
		StackSortOtherStack stackSortOtherStack = new StackSortOtherStack();

		int[] datas = { 1, 2, -5, 4, 3 };
		Stack<Integer> stack = new Stack<Integer>();
		for (int data : datas) {
			stackSortOtherStack.push(data);
			// System.out.println("peek:"+twoStackQueue.peek());
		}
		stackSortOtherStack.print();

		stackSortOtherStack.sortStack();
		stackSortOtherStack.print();

	}

}
