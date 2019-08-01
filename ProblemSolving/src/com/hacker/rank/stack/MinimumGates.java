package com.hacker.rank.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumGates {
	public static void main(String[] args) {
		int a[] = {1300,1340,1350,1500,1900,2200};
		int d[] = {1310,1600,1520,1530,2300,2400};
		
		Queue<Integer> queue = new LinkedList<>();
		
		int len = a.length;
		int gatesize = 0;
		for(int i=0; i<len; i++) {
			if(i==0) {
				queue.add(d[i]);
				gatesize = queue.size();
			}else {
				if(a[i]>queue.peek()) {
					queue.poll();
					queue.add(d[i]);
				}else {
					queue.add(d[i]);
					gatesize++;
				}
			}
		}
		System.out.println(gatesize);
	}
}
