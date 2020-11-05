package com.leet.leetcode_nov_2020;

public class Nov05_Minimum_Cost_to_Move_Chips_to_The_Same_Position {

	//https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] position = {1,1000};
		
		System.out.println(minCostToMoveChips(position));
	}
	
    public static int minCostToMoveChips(int[] position) {

    	int slot_0 = 0;
    	int slot_1 = 0;
    	//move all position by 2 to either position 0/1
    	//then take min number between two slots and move them by 1.
    	
    	for(int i : position) {
    		if(i%2 == 0) {
    			slot_0++;
    		}else {
    			slot_1++;
    		}
    	}
    	
    	return Math.min(slot_0, slot_1);
    	
    }
}
