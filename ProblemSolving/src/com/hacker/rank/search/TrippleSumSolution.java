package com.hacker.rank.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TrippleSumSolution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	
    	a = Arrays.stream(a).distinct().toArray();
    	b = Arrays.stream(b).distinct().toArray();
    	c = Arrays.stream(c).distinct().toArray();
    	Arrays.sort(a);
    	Arrays.sort(c);
    	
    	long count = 0;
		for (int i = 0; i < b.length; i++) {	
			
			long index1 = 0;
			long index2 = 0;
			
			for(int j = 0;j<a.length;j++) {
				if(b[i]>=a[j]) {
					index1++;
				}else {
					break;
				}
			}
			for(int k = 0;k<c.length;k++) {
				if(b[i]>=c[k]) {
					index2++;
				}else {
					break;
				}
			}
			System.out.println("index1 = "+index1);
			System.out.println("index2 = "+index2);
			
			count = count + index1*index2;
			System.out.println("Sum = "+index1*index2);
		}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        System.out.println(ans);
        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}

