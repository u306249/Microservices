package com.stream.tutorial;

import java.util.stream.IntStream;

public class IntStreamSum {
	public static void main(String[] args) {
		int result = IntStream.range(1, 5).sum();
		System.out.println(result);
	}
}
