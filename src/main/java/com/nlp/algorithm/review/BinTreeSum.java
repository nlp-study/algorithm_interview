package com.nlp.algorithm.review;

class Pair {
	double sum;
	double temp;

	public Pair(double sum, double temp) {
		super();
		this.sum = sum;
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Pair [sum=" + sum + ", temp=" + temp + "]";
	}
}

public class BinTreeSum {

	public static Pair calculateBinTreeSum(double[] A, int i) {
		if (i * 2 > A.length - 1) {
			return new Pair(A[i], 10);
		} else if (i * 2 < A.length && i * 2 + 1 >= A.length) {
			Pair pair = calculateBinTreeSum(A, i * 2);
			double sum = pair.sum + A[i] * pair.temp;
			double temp = pair.temp * 10;
			Pair nextPair = new Pair(sum, temp);

			return nextPair;
		}

		Pair leftPair = calculateBinTreeSum(A, i * 2);
		Pair rightPair = calculateBinTreeSum(A, i * 2 + 1);
		double leftSum = leftPair.sum + A[i] * leftPair.temp;
		double rightSum = rightPair.sum + A[i] * rightPair.temp;

		double temp = leftPair.temp * 10 + rightPair.temp * 10;
		double sum = leftSum + rightSum;
		Pair nextPair = new Pair(sum, temp);

		return nextPair;
	}

	public static void main(String[] args) {
		// int[] A = {1,2,3,4,5,6,7,8,9,10,11};
		double[] A = { 0, 1, 2, 3, 4, 5,6,7,8 };
		Pair a = calculateBinTreeSum(A, 1);
		System.out.println("a:" + a);
	}

}
