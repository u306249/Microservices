package com.hacker.rank.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomeSolution {

	// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

    	Map<String,Integer> magMap = new HashMap<>();
    	Map<String,Integer> noteMap = new HashMap<>();
    	
    	boolean allWordFound = true;
    	
    	for(String s1 : magazine) {
    		if(magMap.containsKey(s1)) {
    			Integer count = magMap.get(s1);
    			magMap.put(s1, count+1);
    		}else {
    			magMap.put(s1, 1);
    		}
    	}
    	for(String s2 : note) {
    		if(noteMap.containsKey(s2)) {
    			Integer count = noteMap.get(s2);
    			noteMap.put(s2, count+1);
    		}else {
    			noteMap.put(s2, 1);
    		}
    	}
    	for(Map.Entry<String, Integer> entry : noteMap.entrySet()) {
    		if(magMap.containsKey(entry.getKey())) {
    			int magcount = magMap.get(entry.getKey());
    			int notecount = entry.getValue();
    			
    			if(notecount>magcount) {
    				allWordFound = false;
    			}
    		}else {
    			allWordFound = false;
    		}
    	}
    	if(allWordFound) {
    		System.out.println("Yes");
    	}else {
    		System.out.println("No");
    	}
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];
        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);
        scanner.close();
    }
}
