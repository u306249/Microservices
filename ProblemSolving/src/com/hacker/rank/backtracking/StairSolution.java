package com.hacker.rank.backtracking;

import java.io.IOException;
import java.util.Scanner;

public class StairSolution {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
    	if(n<0) {
    		return 0;
    	}else if(n == 0) {
    		return 1;
    	}
    	return stepPerms(n-1)+stepPerms(n-2)+stepPerms(n-3);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);
            System.out.println(res);

            //bufferedWriter.write(String.valueOf(res));
            //bufferedWriter.newLine();
        }
        //bufferedWriter.close();

        scanner.close();
    }
}

