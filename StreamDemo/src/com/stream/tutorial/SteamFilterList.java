package com.stream.tutorial;

import java.util.Arrays;

public class SteamFilterList {

	public static void main(String[] args) {		
		
		String[] array = {"Goutam","Parama","Aditi","Maitreyee","Keisna","Padmaja","Soumi","Bhaskar","Snatosh"};
		Arrays.asList(array).stream().filter(x->x.startsWith("P")).sorted().forEach(System.out::println);
	}

}
