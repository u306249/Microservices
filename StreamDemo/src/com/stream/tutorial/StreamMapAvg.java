package com.stream.tutorial;

import java.util.Arrays;

public class StreamMapAvg {
	public static void main(String[] args) {
		int arr[] = {2,3,8,6,5};
		
		Arrays.stream(arr).map(x->x*x).average().ifPresent(System.out::print);
	}
}
