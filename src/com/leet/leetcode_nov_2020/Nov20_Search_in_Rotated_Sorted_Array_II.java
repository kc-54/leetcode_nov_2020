package com.leet.leetcode_nov_2020;

public class Nov20_Search_in_Rotated_Sorted_Array_II {
	//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {2,5,6,0,0,1,2};
		int target = 3;
		
		System.out.println(search(nums, target));
	}
	
    public static boolean search(int[] nums, int target) {
    	if(nums.length == 0)return false;
    	
    	if(target < nums[0]) {
    		int prev = nums[nums.length-1];
    		for(int i = nums.length-1; i >= 0; i--) {
    			if(nums[i] == target) {
    				return true;
    			}
    			if(nums[i] < target) {
    				break;
    			}
    			if(prev < nums[i]) {
    				break;
    			}
    			prev = nums[i];
    		}
    	}else if(target >= nums[0]) {
    		int prev = nums[0];
    		for(int i = 0; i < nums.length; i++) {
    			if(nums[i] == target) {
    				return true;
    			}
    			if(nums[i] > target) {
    				break;
    			}
    			if(prev > nums[i]) {
    				break;
    			}
    			prev = nums[i];
    		}
    	}
    	
    	return false;
    }
}
