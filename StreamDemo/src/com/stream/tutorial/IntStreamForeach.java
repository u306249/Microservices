package com.stream.tutorial;

import java.util.stream.IntStream;

public class IntStreamForeach {
	public static void main(String[] args) {
		IntStream.range(1, 10).forEach(System.out::println);
	}
}
