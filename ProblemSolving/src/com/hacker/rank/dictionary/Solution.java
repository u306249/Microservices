package com.hacker.rank.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

	static long countTriplets(List<Long> arr, long r) {

		Map<Long, Integer> map = new HashMap<>();
		for (Long e : arr) {
			if (map.containsKey(e)) {
				map.put(e, map.get(e) + 1);
			} else {
				map.put(e, 1);
			}
		}
		Set<Long> set = new HashSet<>();
		set.addAll(arr);

		int gpCount = 0;
		Collections.sort(arr);
		for (Long element : set) {
			long a1 = element;
			long a2 = a1 * r;
			if (set.contains(a1)) {
				long a3 = a1 * r * r;
				if (set.contains(a3)) {
					gpCount = gpCount + map.get(a1) * map.get(a2) * map.get(a3);
				}
			}
		}
		return gpCount;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(Collectors.toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);

        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}