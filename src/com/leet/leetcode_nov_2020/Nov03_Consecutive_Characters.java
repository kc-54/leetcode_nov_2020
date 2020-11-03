package com.leet.leetcode_nov_2020;

public class Nov03_Consecutive_Characters {
	
	//https://leetcode.com/problems/consecutive-characters/solution/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxPower("leetcode"));
	}
	
    public static int maxPower(String s) {
    	//if empty string return 0
    	if(s == null)return 0;
    	
    	//if length = 1; return 1
    	if(s.length() == 1)return 1;
    	
    	
    	int rs = 1;
    	
    	//curr len to store current streak length
    	int curr_len = 1;
    	//current character on streak
    	char curr = s.charAt(0);
    	
    	for(int i = 1; i < s.length(); i++) {
    		if(s.charAt(i) == curr) {
    			curr_len++;
    			rs = rs>curr_len?rs:curr_len;
    		}else {
    			curr = s.charAt(i);
    			curr_len = 1;
    		}
    		
    	}
    	
    	return rs;
    }
}
