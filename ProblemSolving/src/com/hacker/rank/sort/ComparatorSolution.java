package com.hacker.rank.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
		
		int scoreDiff = a.score - b.score;
		if(scoreDiff == 0) {
			return a.name.compareTo(b.name);
		}else {
			return scoreDiff;
		}
    }
}

class Player{
	
	String name;
	int score;
	
	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}


public class ComparatorSolution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].getName(), player[i].getScore());
        }
    }
}
