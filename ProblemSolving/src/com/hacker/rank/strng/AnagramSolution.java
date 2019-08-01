package com.hacker.rank.strng;

import java.io.IOException;
import java.util.Scanner;

public class AnagramSolution {

	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {

		int strLength = s.length();
		char firstChar = 0;
		int noOfDeletions = 0;
		for (int i = 0; i < strLength; i++) {
			if (i == 0) {
				firstChar = s.charAt(i);
			} else {
				if (s.charAt(i) == firstChar) {
					++noOfDeletions;
				} else {
					firstChar = s.charAt(i);
				}
			}
		}
		return noOfDeletions;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = alternatingCharacters(s);
			System.out.println("Result = " + result);
			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
