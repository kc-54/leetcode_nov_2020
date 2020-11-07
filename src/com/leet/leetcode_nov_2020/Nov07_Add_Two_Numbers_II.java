package com.leet.leetcode_nov_2020;

public class Nov07_Add_Two_Numbers_II {
	
	//https://leetcode.com/problems/add-two-numbers-ii/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode res = addTwoNumbers(l1, l2);
		
		while(res!=null) {
			System.out.print(res.val);
			res = res.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int len1 = 0;
		int len2 = 0;
		
		ListNode templ1 = l1;
		ListNode templ2 = l2;
		
		//find the longest number
		while(templ1!=null) {
			len1++;
			templ1 = templ1.next;
		}
		while(templ2!=null) {
			len2++;
			templ2 = templ2.next;
		}
		
		
		//create temp array to store all number in array with size of longest number
		int max = len1>len2?len1:len2;
		int[] nums1 = new int[max];
		int[] nums2 = new int[max];
		int[] sums = new int[max+1];
		
		templ1 = l1;
		templ2 = l2;
		
		int pointer = max==len1?0:max-len1;
		
		//store the number from listnode to array
		while(templ1!=null) {
			nums1[pointer] = templ1.val;
			templ1 = templ1.next;
			pointer++;
		}
		
		pointer = max==len2?0:max-len2;
		while(templ2!=null) {
			nums2[pointer] = templ2.val;
			templ2 = templ2.next;
			pointer++;
		}

		//add the number into sum array
		for(int i = nums1.length-1; i >= 0; i--) {
            int temp_sum = sums[i+1] + nums1[i] + nums2[i];
			sums[i+1] = (temp_sum)%10;
			sums[i] = (temp_sum)/10;
		}

		//reconstruct listnode from sums array
		int start = sums[0] == 0?2:1;
		ListNode rs = new ListNode(sums[start-1]);
		//if result only 1 digit return result
		if(sums.length == 2 && start == 2)return rs;
		
		ListNode next = new ListNode();
		rs.next = next;
        
		for(int i = start; i< sums.length; i++) {
			next.val = sums[i];
			//if last number found, break to prevent additional next listnode
			if(i == sums.length-1)break;
			next.next = new ListNode();
			next = next.next;
			
		}
        return rs;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
