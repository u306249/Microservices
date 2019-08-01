package com.hacker.rank.array;

import java.io.IOException;
import java.util.Scanner;

public class GlassHourSolution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int tmp = 0;
		int sum = 0;
		int offset = 2;
		for (int i = 0; i < arr.length; i++) {
			int col = 0;
			while (i + offset <= 5 && col + offset <= 5) {
				sum = arr[i][col] + arr[i][col + 1] + arr[i][col + 2] + arr[i + 1][col + 1] + arr[i + 2][col]
						+ arr[i + 2][col + 1] + arr[i + 2][col + 2];
				if (tmp < sum) {
					tmp = sum;
				}
				col++;
			}
		}
		return tmp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		System.out.println("Result = " + result);

		scanner.close();
	}
}
