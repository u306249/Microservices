package com.hacker.rank.dictionary;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStringsSolution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	
    	char[] cs1 = s1.toCharArray();
    	char[] cs2 = s2.toCharArray();
    	Set<Character> s = new HashSet<>();
    	
    	for(int i = 0;i<s2.length();i++) {
    		s.add(s2.charAt(i));
    	}
    	boolean isFound = false;
    	for(char c : cs1) {
    		if(s.contains(c)) {
    			isFound = true;
    			break;
    		}
    	}
    	if(isFound) {
    		return "YES";
    	}else {
    		return "NO";
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}

