package com.stream.tutorial;

import java.util.Arrays;

public class SteamFilter {

	public static void main(String[] args) {		
		
		String[] array = {"Goutam","Parama","Aditi","Maitreyee","Keisna","Padmaja","Soumi","Bhaskar","Snatosh"};
		Arrays.stream(array).filter(x->x.startsWith("P")).sorted().forEach(System.out::println);
	}

}
