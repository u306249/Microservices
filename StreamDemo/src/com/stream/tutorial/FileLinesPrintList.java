package com.stream.tutorial;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLinesPrintList {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Path path = Paths.get("C:/Goutam/bands.txt");
		Stream<String> bandNames = Files.lines(path);
		List<String> names = bandNames.collect(Collectors.toList());
		bandNames.close();
		names.forEach(System.out::println);
	}
}
