package com.leet.leetcode_nov_2020;

public class Nov11_Valid_Square {

	//https://leetcode.com/problems/valid-square/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] p1 = {0,1};
		int [] p2 = {1,2};
		int [] p3 = {0,2};
		int [] p4 = {0,0};
		
		System.out.println(validSquare(p1, p2, p3, p4));
	}
	
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
    	//find distance between all points
    	int len1 = (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    	int len2 = (p1[0]-p3[0])*(p1[0]-p3[0]) + (p1[1]-p3[1])*(p1[1]-p3[1]);
    	int len3 = (p1[0]-p4[0])*(p1[0]-p4[0]) + (p1[1]-p4[1])*(p1[1]-p4[1]);
    	int len4 = (p2[0]-p3[0])*(p2[0]-p3[0]) + (p2[1]-p3[1])*(p2[1]-p3[1]);
    	int len5 = (p2[0]-p4[0])*(p2[0]-p4[0]) + (p2[1]-p4[1])*(p2[1]-p4[1]);
    	int len6 = (p3[0]-p4[0])*(p3[0]-p4[0]) + (p3[1]-p4[1])*(p3[1]-p4[1]);
    	
    	//find min distance for the length of the side square
    	int min = Math.min(len1, len2);
    	min = Math.min(min, len3);
    	min = Math.min(min, len4);
    	min = Math.min(min, len5);
    	min = Math.min(min, len6);
    	
    	//find max distance for the length of diagonal 
    	int max = Math.max(len1, len2);
    	max = Math.max(max, len3);
    	max = Math.max(max, len4);
    	max = Math.max(max, len5);
    	max = Math.max(max, len6);
    	
    	//if the diagonal is not 2 times side length return false;
    	//the length supposed to be squared but for convenience, leave 
    	//the calculation at the sum
    	if(max != 2*min)return false;
    	
    	//the distance must have 4 side length and 2 diagonal length
    	//if not fullfill return false;
    	int num_min = 4;
    	int num_max = 2;
    	if(len1 == min)num_min--;
    	if(len2 == min)num_min--;
    	if(len3 == min)num_min--;
    	if(len4 == min)num_min--;
    	if(len5 == min)num_min--;
    	if(len6 == min)num_min--;
    	if(len1 == max)num_max--;
    	if(len2 == max)num_max--;
    	if(len3 == max)num_max--;
    	if(len4 == max)num_max--;
    	if(len5 == max)num_max--;
    	if(len6 == max)num_max--;
    	
    	
    	return num_min==0 && num_max ==0;
    	
    }
}
