package com.stream.tutorial;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLinesPrint {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Path path = Paths.get("C:/Goutam/bands.txt");
		Stream bandNames = Files.lines(path);
		bandNames.forEach(System.out::println);
		bandNames.close();
	}
}
