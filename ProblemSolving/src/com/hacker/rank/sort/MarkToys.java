package com.hacker.rank.sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MarkToys {
	static int maximumToys(int[] prices, int k) {
		
		Queue<Integer> queue = new PriorityQueue<>();
		Arrays.stream(prices).sorted().forEach(x->queue.add(x));

		Iterator<Integer> it = queue.iterator();
		int sum = 0;
		int noOfToys = 0;
		while(it.hasNext()) {
			sum = sum + it.next();
			if(sum<k) {
				noOfToys++;
			}else {
				break;
			}
		}
		return noOfToys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();

        scanner.close();
    }
}
