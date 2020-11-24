package com.leet.leetcode_nov_2020;

public class Nov24_Basic_Calculator_II {
	
	//https://leetcode.com/problems/basic-calculator-ii/
	public static void main (String [] arg) {
		
		String s = "3*3 + 2*2";
		System.out.println(calculate(s));
	}
	
    public static int calculate(String s) {
    	//trim and remove space
    	s = s.trim().replace(" " ,"");
        int rs = 0;
        int i = 0;

        //get the first num
        while(i < s.length() && s.charAt(i) >= 48 && s.charAt(i)<= 57) {
        	rs *= 10;
        	rs += s.charAt(i) - 48;
        	i++;
        }
        
        //temp and multiplication to store multiplication number and flag
        int temp = 1;
        boolean multiplication = false;
        
        while(i < s.length()) {
        	//k is the position of the operator
    		int k = i;
    		int num = 0;
    		i++;
    		
    		//get the next number
        	while(i < s.length() && s.charAt(i) >= 48 && s.charAt(i)<= 57) {
        		num *= 10;
        		num += s.charAt(i) - 48;
        		
            	i++;
            }
        	
        	
    		if(s.charAt(k) == '*') {
    			if(!multiplication) {
    				temp = rs;
    				rs = 0;
    				multiplication = true;
    			}
            	temp *= num;
            }else if(s.charAt(k) == '/') {
    			if(!multiplication) {
    				temp = rs;
    				rs = 0;
    				multiplication = true;
    			}
            	temp /= num;
            }else {
            	
            	//if operator is addition or substraction
            	
            	//check if there is any next operator that is multiplication/division
            	//if yes, dont add/subs the current number from rs
            	//instead multiply it to temp variable
            	if(s.charAt(k) == '+') {
            		//if multiplication flag is true; means the prev multiplication is done, 
            		//add the temp to rs and reset it to 1
        			if(multiplication) {
        				rs+= temp;
        				temp = 1;
        			}
        			//for checking next operator 
            		if(i<s.length() && (s.charAt(i)!= '*' || s.charAt(i)!= '/')) {
            			temp *= num;
            			multiplication = true;
            		}else {
    	            	rs += num;
    	            	temp = 1;
    	            	multiplication = false;
            		}
	            }else if(s.charAt(k) == '-') {
        			if(multiplication) {
        				rs+= temp;
        				temp = 1;
        			}
            		if(i<s.length() && (s.charAt(i)!= '*' || s.charAt(i)!= '/')) {
            			temp *= -num;
            			multiplication = true;
            		}else {
    	            	rs -= num;
    	            	temp = 1;
    	            	multiplication = false;
            		}
	            }
            }
        }
        //if there is left over multiplication, add it to temp
        if(multiplication)rs+= temp;
        
        return rs;
    }
    
    //solution 2 using recursive
    public static int calculate_1(String s) {
    	s = s.trim().replace(" " ,"");
        int rs = 0;
        int left = 0;
        int i = 0;
        if(s.charAt(0) == '-') {
        	i++;
        }
        while(i < s.length() && s.charAt(i) >= 48 && s.charAt(i)<= 57) {
        	left *= 10;
        	left += s.charAt(i) - 48;
        	i++;
        }

        rs = left;
        if(s.charAt(0) == '-') {
        	rs = -rs;
        }
        while(i < s.length()) {
        	
        }
    	while(i < s.length() && (s.charAt(i) != '+' && s.charAt(i) != '-' )) {
    		int k = i;
    		int right = 0;
    		i++;

            while(i < s.length() && s.charAt(i) >= 48 && s.charAt(i)<= 57) {
            	right *= 10;
            	right += s.charAt(i) - 48;
            	i++;
            }
            
    		if(s.charAt(k) == '*') {
            	rs *= right;
            }else if(s.charAt(k) == '/') {
            	rs /= right;
            }
    	}
        if(i < s.length() && s.charAt(i) == '+') {
        	rs += calculate_1(s.substring(i+1));
        }else if(i < s.length() && s.charAt(i) == '-') {
        	rs += calculate_1(s.substring(i));
        }
        return rs;
    }
    

}
