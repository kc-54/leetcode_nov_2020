package com.leet.leetcode_nov_2020;

import java.util.Arrays;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class Nov26_Longest_Substring_with_At_Least_K_Repeating_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbaaacbd";
				
		int k = 3;
		//approach brute force . Run time ~413ms
		System.out.println(longestSubstring(s, k));
		//approach sliding window . Run time ~10ms
		System.out.println(longestSubstring_2(s, k));
		//approach dfs . Run time 0ms
		System.out.println(longestSubstring_3(s, k));
	}
	
	//approach 1 brute force
    public static int longestSubstring(String s, int k) {
        if(s.isEmpty() || s.length() < k) {
        	return 0;
        }
        if(k==1)return s.length();
        
        int[] alphabets = new int[26];
        int length = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	alphabets = new int[26];
        	for(int l = i; l < s.length(); l++) {
        		int chars = (int)s.charAt(l)-97;
            	alphabets[chars]++;
            	boolean match = true;
            	for(int a : alphabets) {
            		if(a!= 0 && a < k) {
            			match = false;
            			break;
            		}
            	}
            	if(match) {
            		length = Math.max(length, l-i + 1);
            	}
        	}
        	
        }
        
        return length;
    }
    
    
    //approach 2 sliding window
    public static int longestSubstring_2(String s, int k) {
        if(s.isEmpty() || s.length() < k) {
        	return 0;
        }
        if(k==1)return s.length();
        
        int[] alphabets = new int[26];
        char[] str = s.toCharArray();
        int length = 0;
        int maxUniq = countUnique(s);
        
        for(int i = 1; i <= maxUniq; i++) {
        	Arrays.fill(alphabets, 0);
        	int start = 0, end = 0, id = 0, unique = 0, countAtLeastK = 0;
        	while(end < s.length()) {
        		
        		if(unique <= i) {
        			id = str[end] - 'a';
        			if(alphabets[id]==0)unique++;
        			alphabets[id]++;
        			if(alphabets[id]==k)countAtLeastK++;
        			end++;
        		}else {
        			id = str[start] - 'a';
        			start++;
        			if(alphabets[id]==k)countAtLeastK--;
        			alphabets[id]--;
        			if(alphabets[id]==0)unique--;
        		}
        		if(unique == i && unique == countAtLeastK) {
        			length = Math.max(length, (end-start));
        		}
        	}
        }
        return length;
    }
    
    public static int countUnique(String s) {
    	int rs = 0;
    	boolean [] countMap = new boolean[26];
    	
    	for(int i = 0 ; i < s.length(); i++) {
    		if(!countMap[s.charAt(i)-'a'])rs++;
    		countMap[s.charAt(i)-'a'] = true;
    	}
    	
    	
    	return rs;
    }
    
    //approach 3 dfs
    public static int longestSubstring_3(String s, int k) {
        return dfs(s, k,  0, s.length());
    }
    private static int dfs(String s, int k, int begin, int end){
        int[] charNums = new int[26];
        for (int i = begin; i < end; i++){
            int idx = s.charAt(i) - 'a';
            charNums[idx]++;
        }
        int res = 0;
        int new_begin = begin;
        for (int i = begin; i < end; i++){
            int idx = s.charAt(i) - 'a';
            if (charNums[idx] > 0 && charNums[idx] < k) {
                if (i - new_begin >= k) res = Math.max(res, dfs(s, k, new_begin, i));
                new_begin = i+1;
            }
        }
        if (new_begin == begin) return end - begin;
        return Math.max(res, dfs(s, k, new_begin, end));
    }
}
