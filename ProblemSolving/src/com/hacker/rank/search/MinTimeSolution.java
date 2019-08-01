package com.hacker.rank.search;

import java.io.IOException;
import java.util.Scanner;

public class MinTimeSolution {

    // Complete the minTime function below.
    static long minTime(long[] machineCapaciy, long numberOfItemsToProduce) {
    	
        long noOfDays = 0;
        long low = 1;
        long high = (long) Math.pow((long)10, (long)18);
       
        while(high>=low) {
        	long mid = (high + low)/2;
        	noOfDays = Math.max(high, low);
        	long sum = 0;
        	
        	for(int i = 0; i<machineCapaciy.length; i++) {
        		sum = sum + (mid/(machineCapaciy[i]));
        		if(sum>numberOfItemsToProduce) {
        			break;
        		}
        	}
        	if(sum >= numberOfItemsToProduce) {
        		high = mid -1 ;
        	}else {
        		low = mid + 1;
        	}
        }
        return noOfDays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
		long[] machineCapaciy = { 4, 5, 6 };
		long numberOfItemsToProduce = 12;
		long noOfDays = minTime(machineCapaciy, numberOfItemsToProduce);
		System.out.println("Number Of Days Taken >> " + noOfDays);
	}
}

