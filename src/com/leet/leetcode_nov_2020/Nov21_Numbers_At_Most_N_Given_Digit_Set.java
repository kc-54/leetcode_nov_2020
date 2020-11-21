package com.leet.leetcode_nov_2020;

public class Nov21_Numbers_At_Most_N_Given_Digit_Set {
	
	//https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] digits = {"1"};
		int n = 1 ;
		System.out.println(atMostNGivenDigitSet(digits, n));
	}
	
	
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        
    	int lowest = (int) Math.floor(Math.log10(n));
    	int r = digits.length;
    	int sum = 0;
    	if(r>1) {
    		sum = (1-(int)Math.pow(r, lowest+1))/(1-r)-1;
    	}else if(r==1){
    		sum = lowest;
    	}
    	
    	int [] digit = new int[r];
    	for(int i = 0; i < r; i++) {
    		digit[i] = Integer.valueOf(digits[i]);
    	}
    	
    	for(int i = 0; i <= lowest; i++) {
    		int first = n / (int) Math.pow(10, lowest-i);
    		
    		boolean same = false;
    		for(int j : digit) {
    			int low = Math.max(0, lowest-i);
    			if(j < first) {
    				sum += Math.pow(r, low);
    			}else if(j==first) {
    				same = true;
    				if(n/10 == 0)sum++;
    			}
    			
    		}
    		n %= (int) Math.pow(10, lowest-i);
    		if(!same)break;
    	}
    	return sum;
    }
}
