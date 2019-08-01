package com.stream.tutorial;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLinesFilterPrint {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Path path = Paths.get("C:/Goutam/data.txt");
		Stream<String> dataStream = Files.lines(path);
		dataStream.map(x->x.split(",")).filter(x->x.length==4).forEach(x->System.out.println(x[0]+x[1]+x[2]+x[3]));
		dataStream.close();
	}
}
