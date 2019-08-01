package com.hacker.rank.strng;

import java.io.IOException;
import java.util.Scanner;

public class SpecialSpringSolution {

	// Complete the substrCount function below.
	static long substrCount(String s) {

		int strLen = s.length();
		int count = 0;

		for (int i = 0; i < strLen; i++) {
			char c = s.charAt(i);
			int sublen = 1;
			// String str = c + "";
			for (int j = i + 1; j < strLen; j++) {
				char c1 = s.charAt(j);
				// str = str + c1;
				if (c == c1) {
					sublen++;
					count++;
					// System.out.print(str + " ");
				} else {
					if (j + sublen < strLen) {
						int k = 0;
						for (; k < sublen; k++) {
							if (c != s.charAt(j + k + 1)) {
								// str = "";
								break;
							} else {
								// str = str + c;
							}
						}
						if (k == sublen) {
							count = count + 1;
							// System.out.print(str + " ");
						}
					}
					break;
				}
			}
		}
		return (count + strLen);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();
		System.out.println(substrCount(s));
		scanner.close();
	}
}
