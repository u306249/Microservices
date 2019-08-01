package com.hacker.rank.warmup;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class CountValleySolution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

    	Stack<String> stack = new Stack<String>();
    	char[] steps = s.toCharArray();
    	int noOfValleys = 0;
    	for(int i=0;i<n;i++) {
    		
    		if(stack.isEmpty()) {
    			stack.add(steps[i]+"");
    		}else {
    			String top = stack.peek();
    			if(top.equals("D")&&(steps[i]+"").equals("U")) {
    				stack.pop();
    				if(stack.isEmpty()) {
    	    			noOfValleys++;
    	    		}
    			}else if(top.equals("U")&&(steps[i]+"").equals("D")) {
    				stack.pop();
    			}else {
    				stack.push(steps[i]+"");
    			}
    		}
    	}
    	return noOfValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
