package com.leet.leetcode_nov_2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Nov28_Sliding_Window_Maximum {
	//https://leetcode.com/problems/sliding-window-maximum/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,3,1,2,0,5};
		int k = 3;
		int [] rs = maxSlidingWindow_2(nums, k);
		for(int i : rs) {
			System.out.print(i);
		}
		System.out.println();

	}
	public static int[] maxSlidingWindow_2(int[] nums, int k) {
		

    	if(k==1)return nums;
    	int len = nums.length - k + 1;
    	int[] rs = new int[len];
    	int[] left = new int[nums.length];
    	int[] right = new int[nums.length];
		
    	left[0] = nums[0];
    	right[nums.length-1] = nums[nums.length-1];
    	for(int i = 1; i < nums.length; i++) {
    		
    		if(i%k == 0) {
    			left[i] = nums[i];
    		}else {
    			left[i] = Math.max(left[i-1],nums[i]);
    		}
    		
    		int j = nums.length - i - 1;
    		if(j%k==0) {
    			right[j] = nums[j];
    		}else {
    			right[j] = Math.max(nums[j], right[j+1]);
    		}
    		
    	}
		
    	for(int i = 0; i < len; i++) {
    		rs[i] = Math.max(right[i], left[i+k-1]);
    	}
    	
		return rs;
		
	}
	public static int[] maxSlidingWindow_1(int[] nums, int k) {

    	if(k==1)return nums;
    	int len = nums.length - k + 1;
    	int[] rs = new int[len];
    	
		List<Integer> list = new ArrayList<Integer>();
		
    	for(int i = 0; i < k; i++) {
    		list.add(nums[i]);
    	}
    	Collections.sort(list);
    	rs[0] = list.get(list.size()-1);
    	for(int i = 1; i < len; i++) {
    		int pos = list.indexOf(nums[i-1]);
    		int temp = nums[i+k-1];
    		if(list.get(list.size()-2) < temp ) {
    			rs[i] = list.get(list.size()-2);
        		list.remove(pos);
        		list.add(0, temp);
    		}else {
        		list.remove(pos);
        		list.add(temp);
            	Collections.sort(list);
            	rs[i] = list.get(list.size()-1);
    		}
    		
    	}
    	
		return rs;
	}
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
    	if(k==1)return nums;
    	
    	int len = nums.length - k + 1;
    	
    	int[] rs = new int[len];
    	Queue< Integer > queue = new LinkedList<>();
    	
    	int max1= -10001;
    	int max2= -10001;
    	int count1=0;
    	int count2=0;
    	
    	for(int i = 0; i < k; i++) {
    		if(nums[i] > max1) {
    			max2 = max1;
    			count2 = count1;
    			max1 = nums[i];
    			count1 = 1;
    			
    		}else if(nums[i] > max2) {
    			max2 = nums[i];
    			count2 = 1;
    		}else if(nums[i] == max1) {
    			count1++;
    		}else if(nums[i] == max2) {
    			count2++;
    		}
    		System.out.println(max1 + " "+ max2);
    		queue.add(nums[i]);
    	}
    	rs[0] = max1;
    	
    	for(int i = 1; i < len; i++) {
    		int head = queue.remove();
    		queue.add(nums[i+k-1]);
    		if(max1==head) {
    			if(nums[i+k-1]!=max1)count1--;
    		}else if(max2==head) {
    			if(nums[i+k-1]!=max2)count2--;
    		}
    		
    		if(count1==0) {
    			int[] temp = findNext(queue, max2);
    			if(temp[0] > max2) {
    				max1=temp[0];
    				count1=temp[1];
    			}else if(max2 > temp[0]) {
    				max1 = max2;
    				count1=count2;
    				max2=temp[0];
    				count2=temp[1];
    			}
    			
			}else if(count2==0) {
    			int[] temp = findNext(queue, max1);
    			if(max1 > temp[0]) {
    				max2=temp[0];
    				count2=temp[1];
    			}else if(temp[0] > max1) {
    				max2 = max1;
    				count2 = count1;
    				max1=temp[0];
    				count1=temp[1];
    			}
			}
//    		System.out.println("max1 " + max1 + " " + count1);
//    		System.out.println("max2 " + max2 + " " + count2);
//    		System.out.println(nums[i+k-1]);
    		if(nums[i+k-1] > max1) {
    			max2 = max1;
    			count2 = count1;
    			max1 = nums[i+k-1];
    			count1 = 1;
    			
    		}else if(nums[i+k-1] > max2) {
    			max2 = nums[i+k-1];
    			count2 = 1;
    		}else if(nums[i+k-1] == max1) {
    			count1++;
    		}else if(nums[i+k-1] == max2) {
    			count2++;
    		}
    		
    		System.out.println("max1 " + max1 + " " + count1);
    		System.out.println("max2 " + max2 + " " + count2);
    		System.out.println();
    		rs[i] = max1;
    	}
    	
    	return rs;
    }
    
    public static int[] findNext(Queue<Integer> q, int num) {
    	
    	int [] max = {-10001,0};
    	for(int i : q) {
    		if(i != num) {
    			if(i==max[0]) {
    				max[1]++;
    			}else if(i>max[0]){
    				max[0] = i;
    				max[1] = 1;
    			}
    		}
    	}
    
    	return max;
    }
}
