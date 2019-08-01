package com.hacker.rank.sort;

import java.util.Scanner;
import java.util.stream.Stream;

public class BubbleSolution {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
    	int n = a.length;
    	int arraySortCount = 0;
    	for (int i = 0; i < n; i++) {   
    	    for (int j = 0; j < n - 1; j++) {
    	        // Swap adjacent elements if they are in decreasing order
    	        if (a[j] > a[j + 1]) {
    	        	int tmp = a[j];
    	            a[j] = a[j + 1];
    	            a[j+1] = tmp;
    	            arraySortCount++;
    	        }
    	    }
    	}
    	System.out.println("Array is sorted in "+arraySortCount+" swaps.");
    	System.out.println("First Element: "+a[0]);
    	System.out.println("Last Element: "+a[n-1]);
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}

