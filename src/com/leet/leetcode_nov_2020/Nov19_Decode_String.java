package com.leet.leetcode_nov_2020;

public class Nov19_Decode_String {

	//https://leetcode.com/problems/decode-string/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc3[cd]xyz";
		System.out.println(decodeString(s));
	}

    public static String decodeString(String s) {
    	int k = 0;
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < s.length(); i++) {
    		
    		//if it is number record it in k
    		if(s.charAt(i) >= 48 && s.charAt(i) <= 57) {
    			k = k*10 + (int)s.charAt(i) - 48;
    			continue;
    		}
    		//if it is open bracket
    		if(s.charAt(i) == '[') {
    			int count = 1;
    			
    			//decode the sub encoded in []
    			String con = decodeString(s.substring(i+1));
    			
    			//skip the decoded string
    			while(count >0) {
    				i++;
    				if(s.charAt(i)=='[')count++;
    				if(s.charAt(i)==']')count--;
    			}
        		if(k == 0) {
        			sb.append(con);
        		}else {
        			for(int j = 0; j < k; j++) {
        				sb.append(con);
        			}
        		}
    			k = 0;
    			continue;
    		}
    		//if it is close bracket, return the decoded string
    		if(s.charAt(i) == ']') {
    			return sb.toString();
    		}
    		
    		//if it is only character append to the string builder
    		if(k == 0) {
    			sb.append(s.charAt(i));
    		}
    	}
    	return sb.toString();
    }
    
}
