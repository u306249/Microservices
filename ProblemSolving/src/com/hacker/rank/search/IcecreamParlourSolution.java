package com.hacker.rank.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IcecreamParlourSolution {

    // Complete the whatFlavors function below.
	static void whatFlavors(int[] cost, int money) {
		
		int complementarr[] = Arrays.stream(cost).map(x -> money - x).toArray();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < cost.length; i++) {
			map.put(cost[i], i);
		}
		for (int i = 0; i < cost.length; i++) {

			Integer x = map.get(complementarr[i]);

			if (x != null && x != i) {
				System.out.println((i + 1) + " " + (x + 1));
				break;
			}
		}
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}

