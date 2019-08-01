package com.hacker.rank.dictionary;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramSolution {
	static int sherlockAndAnagrams(String s) {

		Map<String, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String tmp = s.substring(i, j);

				char[] chars = tmp.toCharArray();
				Arrays.sort(chars);
				tmp = String.valueOf(chars);
				// System.out.println(tmp);

				if (map.keySet().contains(tmp)) {
					map.put(tmp, map.get(tmp) + 1);
				} else {
					map.put(tmp, 1);
				}
			}
		}
		// System.out.println(map);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				int n = entry.getValue();
				count = count + n * (n - 1) / 2;
			}
		}
		return count;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }
        //bufferedWriter.close()
        scanner.close();
    }
}
