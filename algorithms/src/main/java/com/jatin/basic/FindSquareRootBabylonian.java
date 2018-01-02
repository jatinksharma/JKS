package com.jatin.basic;

public class FindSquareRootBabylonian {

	public static void main(String[] args) {
		sqrt(48d);
	}

	/*
	 * Wow! That converges pretty fast. In fact, this method converges
	 * quadratically�the number of correct decimal places approximately doubles
	 * with every step!
	 * 
	 * So, why does this work? Well, first of all, note that if (that is, if R
	 * is a fixed point of this operation), then
	 * 
	 * 2R = R+N/R
	 * R = N/R
	 * RSq = N
	 * R = sqRoot(N)
	 */
	static double sqrt(double N) {
		double R = 2;
		double RR = 0;

		for (int i = 0; i < 100; i++) {
			RR = (R + N / R) / 2;
			R = RR;
		}

		System.out.println(R);

		System.out.println(RR);

		return 0d;

	}

}
