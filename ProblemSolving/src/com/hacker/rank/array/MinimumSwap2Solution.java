package com.hacker.rank.array;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwap2Solution {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		Map<StringBuffer, StringBuffer> data = new LinkedHashMap<>();
		for (int i = 0; i < arr.length; i++) {
			data.put(new StringBuffer(arr[i] + ""), new StringBuffer(i + 1 + ""));
		}
		int noOfSwap = 0;

		for (Map.Entry<StringBuffer, StringBuffer> entry : data.entrySet()) {
			if (!entry.getValue().toString().equals(entry.getKey().toString())) {
				for (Map.Entry<StringBuffer, StringBuffer> innerEntry : data.entrySet()) {
					if (entry.getKey().toString().equals(innerEntry.getValue().toString())) {
						String tmp = entry.getValue().toString();
						entry.getValue().replace(0, entry.getValue().length(), innerEntry.getValue().toString());
						innerEntry.getValue().replace(0, innerEntry.getValue().length(), tmp);
						noOfSwap = noOfSwap + 1;
					}
				}
			}
		}
		return noOfSwap;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		minimumSwaps(arr);
		scanner.close();
	}
}
