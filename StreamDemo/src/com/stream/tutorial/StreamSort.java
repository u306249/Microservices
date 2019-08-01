package com.stream.tutorial;

import java.util.stream.Stream;

import com.test.MyInterface;

public class StreamSort implements MyInterface{
	public static void main(String[] args) {
		Stream.of("Ava","Aneri","Alberto").sorted().findFirst().ifPresent(x->System.out.println(x));
	}
	
   @Override	
   public void method() {
		
	}
	
	
}
