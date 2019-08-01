package com.hacker.rank.backtracking;

import java.util.Scanner;

public class FiboSolution {

    public static int fibonacci(int n) {
    	
        if(n==1) {
        	return 1; 
        }else if(n <= 0){
        	return 0;
        }else {
        	int sum = 0;
            sum = sum + fibonacci(n-1)+fibonacci(n-2);
        	return sum;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}