package com.nlp.algorithm.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WindowsMaxValue {
	public static int[] findMaxValue(int[] A, int windowsWide) {
		int[] result = new int[A.length - windowsWide +1];
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < A.length; ++i) {
			if (deque.size() == 0) {
				deque.add(i);
				continue;
			}
			if(i > windowsWide-1)
			{
				result[i-windowsWide] = A[deque.peekFirst()];
			}
			if (i - deque.peek() >= windowsWide || deque.size()==windowsWide) {
				int max = deque.pollFirst();
			}

			while ((!deque.isEmpty()) && A[i] > A[deque.getLast()]) {
				deque.pollLast();
			}
			deque.add(i);
		}
		result[A.length - windowsWide] = A[deque.peekFirst()];
		return result;
	}

	public static void main(String[] args) {
		int[] A = {4,3,5,4,3,3,6,7}; 
		int windowsWide = 3;
		int[] result = WindowsMaxValue.findMaxValue(A, windowsWide);
		System.out.println( Arrays.toString(result));
	}
}
