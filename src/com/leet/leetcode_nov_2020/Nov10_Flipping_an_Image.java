package com.leet.leetcode_nov_2020;

public class Nov10_Flipping_an_Image {

	//https://leetcode.com/problems/flipping-an-image/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
		A = flipAndInvertImage(A);
		
		for(int i = 0; i < A.length; i++) {
			for(int k : A[i]) {
				System.out.print(k + " " );
			}
			System.out.println();
		}
	}
	
	
	public static int[][] flipAndInvertImage(int[][] A) {
        
        int len = A.length;
        int len_2 = A[0].length;
        
        
        for(int i = 0; i < len; i++) {
        	for(int k = 0; k < (len_2+1)/2; k++) {
        		int temp = (A[i][k]+1)%2;
        		A[i][k] = (A[i][len_2-1-k]+1)%2;
        		A[i][len_2-1-k] = temp;
        	}
        	
        }
        
        return A;
    }
}
