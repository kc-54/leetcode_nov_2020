package com.leet.leetcode_nov_2020;

public class Nov25_Smallest_Integer_Divisible_by_K {
	
	//https://leetcode.com/problems/smallest-integer-divisible-by-k/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int K = 9999;
		System.out.println(smallestRepunitDivByK(K));
	}
    public static int smallestRepunitDivByK(int K) {
        
        int mod = 0;
        int counter  = 1;
        
        if(K%2 == 0 || K%5 == 0) {
        	return -1;
        }
        
        while(true) {

        	if((mod*10+1)%K == 0) {
        		return counter;
        	}else {
        		mod = (mod*10+1)%K;
        		counter++;
        	}
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
