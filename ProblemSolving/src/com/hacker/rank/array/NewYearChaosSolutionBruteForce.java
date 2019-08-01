package com.hacker.rank.array;

import java.util.Scanner;

public class NewYearChaosSolutionBruteForce {

	static void minimumBribes(int[] q) {
		int totalBribes = 0;
		int arLength = q.length;
		for (int i = 0; i < arLength-1; i++) {
			int indvBribe = 0;
			for (int j = i + 1; j < arLength; j++) {
				if (q[i] > q[j]) {
					++indvBribe;
					if (indvBribe > 2) {
						System.out.println("Too chaotic");
						return;
					}
				}
			}
			totalBribes = totalBribes + indvBribe;
		}
		System.out.println(totalBribes);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
