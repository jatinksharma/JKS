package com.jatin.basic;

public class RotateMatrix {
	static int rows = 4;
	static int cols = 4;

	static int[][] matrix;

	static int[][] rotatedMatrix;

	public static void main(String[] args) {
		createMatrices();
		displayMatrix(matrix);
		rotateMatrix();
		displayMatrix(rotatedMatrix);

	}

	public static void createMatrices() {
		matrix = new int[rows][cols];
		rotatedMatrix = new int[cols][rows];

		int num = 1;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = num;
				num++;
			}
		}
	}

	/**
	 * 1,2,3 4,5,6 7,8,9
	 * 
	 * 7,4,1 8,5,2 9,6,3
	 * 
	 * Take 1st row, create last col Take 2nd row, create n-1th col ...
	 */
	public static void rotateMatrix() {

		for (int i = 0, l = cols-1; i < rows; i++, l--) {
			for (int j = 0, k = 0; j < cols; j++, k++) {
			
				rotatedMatrix[k][l] = matrix[i][j];
				/*
				 * [0][2] = [0][0] ; [1][2] = [0][1] [2][2] = [0][2]
				 */
			}
		}
	}

	public static void displayMatrix(int[][] matrix) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

}
