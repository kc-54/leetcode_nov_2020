package com.leet.leetcode_nov_2020;

import java.util.HashSet;
import java.util.Set;

public class Nov22_Unique_Morse_Code_Words {
	
	//https://leetcode.com/problems/unique-morse-code-words/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
	}
	
    public static int uniqueMorseRepresentations(String[] words) {
        
    	String[] morse = {".-","-...","-.-.","-..",".","..-."
    			,"--.","....","..",".---","-.-"
    			,".-..","--","-.","---",".--.",
    			"--.-",".-.","...","-","..-",
    			"...-",".--","-..-","-.--","--.."};
    	
    	Set<String> decoded = new HashSet<>();
    	
    	for(String word : words) {
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < word.length(); i++) {
    			sb.append(morse[(int)word.charAt(i)-97]);
    		}
    		decoded.add(sb.toString());
    	}
    	
    	
    	
    	return decoded.size();
    }
}
