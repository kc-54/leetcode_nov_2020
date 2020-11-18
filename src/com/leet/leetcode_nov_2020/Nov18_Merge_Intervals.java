package com.leet.leetcode_nov_2020;

public class Nov18_Merge_Intervals {
	//https://leetcode.com/problems/merge-intervals/
	public static void main (String [] args) {
		int [][] intervals = {{3,3},{1,1},{0,2},{2,2},{1,2},{1,3},{1,1},{3,3},{2,3},{4,6}};
		merge(intervals);
	}
	
    public static int[][] merge(int[][] intervals) {
        
    	
    	int[]numbers = new int[10001];
    	int final_interval = 0;
    	
    	for(int[] interval : intervals) {
    		if(interval[0] == interval[1]) {
    			if(numbers[interval[0]] == 0) {
        			numbers[interval[0]] = 4;
    			}
            	for(int i = 0; i < 10; i++) {
            		System.out.print(numbers[i]);
            	}
            	System.out.print( "  " + interval[0] + " " + interval[1] );
            	System.out.println();
    			continue;
    		}
    		
    		numbers[interval[0]] = numbers[interval[0]]==1||numbers[interval[0]]==3?1:2;
    		numbers[interval[1]] = numbers[interval[1]]==1||numbers[interval[1]]==2?1:3;
    		for(int i = interval[0]+1; i < interval[1]; i++) {
				numbers[i] = 1;
    		}
        	for(int i = 0; i < 10; i++) {
        		System.out.print(numbers[i]);
        	}
        	System.out.print( "  " + interval[0] + " " + interval[1] );
        	System.out.println();
    	}
    	
    	for(int i = 0; i < numbers.length; i++) {
    		System.out.print(numbers[i]);
    		if(numbers[i] == 2 || numbers[i] == 4) {
				final_interval ++;
    		}
    	}
    	System.out.println();
    	int[][] rs = new int[final_interval][2];
    	int pointer = -1;
    	for(int i = 0; i < numbers.length; i++) {
    		if(numbers[i] == 2 ) {
				pointer++;
				rs[pointer][0] = i;
    		}else if(numbers[i] == 3) {
    			rs[pointer][1] = i;
    		}else if(numbers[i] == 4) {
				pointer++;
    			rs[pointer][0] = i;
    			rs[pointer][1] = i;
    		}
    	}
    	for(int[] interval : rs) {
    		System.out.println(interval[0] + " " + interval[1]);
    	}
    	
    	return null;
    }
}
