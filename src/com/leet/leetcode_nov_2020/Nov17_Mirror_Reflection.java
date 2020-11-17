package com.leet.leetcode_nov_2020;

public class Nov17_Mirror_Reflection {
	
	//https://leetcode.com/problems/mirror-reflection/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mirrorReflection(5, 1));
	}
	
    public static int mirrorReflection(int p, int q) {
    	
    	int x = 0;
     	int y = 0;
     	boolean down = false;
     	if(q==0)return 0;
         
     	while(true) {
     		if(x == p & y == p) {
     			if(down)return 0;
     			if(!down)return 1;
     		}
     		if(x == 0 & y == p) {
     			return 2;
     		}

     		x = x==p?0:p;
     		y += q;
     		if(y>p) {
     			y %= p;
     			down = !down;
     		}
     	}
    	
    }
}
