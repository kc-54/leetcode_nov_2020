package com.leet.leetcode_nov_2020;

import java.util.Arrays;

public class Nov27_Partition_Equal_Subset_Sum {

	//https://leetcode.com/problems/partition-equal-subset-sum/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,4,4};
		System.out.println(canPartition_2(nums));
	}

	
	//approach 2 using dp
    //run time : ~38ms
    public static boolean canPartition_2(int[] nums) {

    	Arrays.sort(nums);
    	
    	int total = 0;
    	for(int i : nums) {
    		total += i;
    	}
    	if(total%2==1)return false;

    	int half = total/2;
    	
    	if(nums[nums.length-1] > half) {
    		return false;
    	}
    	
    	boolean[] dp = new boolean[half + 1];
    	
    	dp[0] = true;

    	for(int num : nums) {
    		for(int j = half; j > 0; j--) {
    			if(j>=num) {
    				dp[j] = dp[j] || dp[j-num];
    			}
    			
    		}
    	}
    	
    	
    	return dp[half];
    }
	
	//approach 1 recursive, slow
    //run time : TLE
    public static boolean canPartition(int[] nums) {
    
    	Arrays.sort(nums);
    	
    	int total = 0;
    	for(int i : nums) {
    		total += i;
    	}
    	System.out.println(total);
    	if(total%2==1)return false;

    	int half = total/2;
    	
    	if(nums[nums.length-1] > half) {
    		return false;
    	}
    	
    	boolean[] used = new boolean[nums.length];
    	
    	return helper(nums, used, half, nums.length-1);
    }
    public static boolean helper(int[] nums, boolean[] used, int left, int pointer) {
    
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	boolean found = false;
    	int prev = -1;
    	System.out.println(left + " "+ pointer);
    	for(int i=pointer; i >= 0 ; i--) {
    		if(used[i]) {
    			continue;
    		}
    		if(left < nums[i])continue;
    		
    		if(left - nums[i] == 0) {
    			return true;
    		}
    		
    		if(prev == -1) {
    			prev=nums[i];
    		}else {
    			if(nums[i] == prev)continue;
    		}
    		
    		used[i] = true;
    		if(helper(nums, used, left-nums[i],i-1))return true;
    		
    		used[i] = false;
    	}
    	
    	
    	return found;
    }
}
