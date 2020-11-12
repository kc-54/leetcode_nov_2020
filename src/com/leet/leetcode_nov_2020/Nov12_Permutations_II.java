package com.leet.leetcode_nov_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Nov12_Permutations_II {
	
	//https://leetcode.com/problems/permutations-ii/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {2,2,1,1};
		permuteUnique(nums);
	}
	
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
        
    	Arrays.sort(nums);
    	List<List<Integer>> rs = new ArrayList<List<Integer>>();
    	int len = nums.length;
    	Map<Integer,Integer> nums_list = new HashMap<Integer,Integer>();
    	
    	
    	for(int i : nums) {
    		if(nums_list.containsKey(i)) {
    			int val = nums_list.get(i);
    			val++;
    			nums_list.put(i, val);
    		}else {
    			nums_list.put(i, 1);
    		}
    	}
    	
    	listing(rs,new ArrayList<Integer>(), nums_list, len);
    	System.out.println(rs);
    	
    	return rs;
    }
    
    public static void listing(List<List<Integer>> rs, List<Integer> curr, 
    		Map<Integer,Integer> nums_list, int len) {
    	
    	for(Entry<Integer, Integer> entry : nums_list.entrySet()) {
    		if(entry.getValue() != 0) {
    			curr.add(entry.getKey());
    			if(curr.size() == len) {
    				List<Integer> copy = new ArrayList<Integer>();
    				copy.addAll(curr);
    				rs.add(copy);
    			}else {

        			int temp = entry.getValue() -1;
        			nums_list.put(entry.getKey(), temp);
        			listing(rs,curr,nums_list, len);
        			nums_list.put(entry.getKey(), temp + 1);
    			}
    			curr.remove(curr.size()-1);
    		}
    	}
    	
    }
}
