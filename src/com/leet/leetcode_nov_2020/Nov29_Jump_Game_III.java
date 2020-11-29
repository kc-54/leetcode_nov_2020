package com.leet.leetcode_nov_2020;

import java.util.ArrayList;
import java.util.List;

public class Nov29_Jump_Game_III {
	//https://leetcode.com/problems/jump-game-iii/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {0,1};
		int start = 1;
		System.out.println(canReach_1(arr, start));
	}

	//recursive approach
	//run time 0 ms
    public static boolean canReach_1(int[] arr, int start) {
        
    	if(start >= 0 && start < arr.length && arr[start] >= 0) {
    		if(arr[start]==0)return true;
    		arr[start] = -arr[start];
    		return canReach_1(arr, start+arr[start]) || canReach_1(arr, start-arr[start]);
    	}
    	
    	return false;
    }
    
    //memoization approach
	//run time 1 ms
    public static boolean canReach(int[] arr, int start) {
        
    	boolean [] visited = new boolean [arr.length];
    	
    	List<Integer> zeros = new ArrayList<Integer>();
    	
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] == 0) {
    			zeros.add(i);
    		}
    	}
    	
    	List<Integer> points = new ArrayList<Integer>();
    	List<Integer> toAdd = new ArrayList<Integer>();
    	
    	points.add(start);
    	while(points.size()> 0) {
    		for(int k = 0; k < points.size(); k++) {
    			Integer i = points.get(k);
    			if(zeros.contains(i))return true;
    			
    			if(i-arr[i] >= 0 && !visited[i-arr[i]]) {
    				visited[i-arr[i]] = true;
    				toAdd.add(i-arr[i]);
    			}

    			if(i+arr[i] < arr.length && !visited[i+arr[i]]) {
    				visited[i+arr[i]] = true;
    				toAdd.add(i+arr[i]);
    			}
    		}
    		
    		points.clear();
    		points = toAdd;
    		
    	}
    	
    	
    	return false;
    }
}
