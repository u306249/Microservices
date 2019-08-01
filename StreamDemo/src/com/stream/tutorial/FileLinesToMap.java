package com.stream.tutorial;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLinesToMap {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Path path = Paths.get("C:/Goutam/data.txt");
		Stream<String> dataStream = Files.lines(path);
		Map<String,String> map = dataStream.map(x->x.split(",")).filter(x->x.length==4)
		.collect(Collectors.toMap(x->x[0], x->x[1]+x[2]+x[3]));
		dataStream.close();
		System.out.println(map);
	}
}
