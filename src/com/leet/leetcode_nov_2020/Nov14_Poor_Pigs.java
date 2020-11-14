package com.leet.leetcode_nov_2020;

public class Nov14_Poor_Pigs {
	
	//https://leetcode.com/problems/poor-pigs/
	
	public static void main (String[] args) {
		System.out.println(poorPigs(1000, 15, 60));
	}
	
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //detailed explanation:
    	//https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
    	return (int) Math.ceil((Math.log(buckets)/Math.log(minutesToTest/minutesToDie + 1)));
    }
}
