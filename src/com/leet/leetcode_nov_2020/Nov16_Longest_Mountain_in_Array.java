package com.leet.leetcode_nov_2020;

public class Nov16_Longest_Mountain_in_Array {
	
	//https://leetcode.com/problems/longest-mountain-in-array/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2,1,4,7,3,2,5,7,8,9,10,1,2};
		System.out.println(longestMountain(A));
	}
    public static int longestMountain(int[] A) {

        if(A.length < 3)return 0;
        
    	int rs = 0;
    	int temp = 0;
    	
    	boolean up = false;
    	boolean down = false;
    	int prev = A[0];

    	for(int i : A) {

			if(prev < i) {
				if(!up || down) {
					up = true;
					down = false;
					temp = 2;
				}else {
					temp++;
				}
			}else if(prev > i) {
				down = true;
				if(up) {
					temp++;
					rs = rs>temp?rs:temp;
				}else {
					temp = 0;
				}
			}else {
				up = false;
		    	down = false;
				temp = 0;
				continue;
			}
    		prev = i;
    		
    	}
    	
    	return rs;
    }
}
