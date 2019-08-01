package com.hacker.rank.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinMaxRiddleSolution {

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
    	
    	int len = arr.length;    
    	long[] a = new long[len];    	
		for (int t = 0; t < len; t++) {
			long max = 0;
			for (int i = 0; i < len; i++) {				
				long min = 0;
				System.out.println();
				for (int j = 0; j <= i; j++) {
					if (min == 0) {
						min = arr[j];
					} else {
						if (min < arr[j]) {
							min = arr[j];
						}
					}
					System.out.print(min + " " );
				}
				if (max == 0) {
					max = min;
				} else {
					if (min > max) {
						max = min;
					}
				}
				a[t] = max;				
			}
		}    	
    	return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);
        System.out.println(res);
        for (int i = 0; i < res.length; i++) {
            //bufferedWriter.write(String.valueOf(res[i]));

            System.out.print(res[i]+" ");
        }

        //bufferedWriter.newLine();
        //bufferedWriter.close();

        scanner.close();
    }
}
