package com.leet.leetcode_nov_2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nov02_Insertion_Sort_List {

	//https://leetcode.com/problems/insertion-sort-list/solution/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		
		ListNode node = insertionSortList(head);
		System.out.println(node.val);
		while(node.next!=null) {
			System.out.println(node.next.val);
			node = node.next;
		}
		
	}

	//insertion sort list using helper node to help point to result
	//reconstruct the list instead of swapping value;
	//runtime : 30ms
	public static ListNode insertionSortList(ListNode head) {
		if(head==null || head.next == null)return head;
		
		ListNode helper = new ListNode(0);
		ListNode curr = head;
		ListNode pre = helper;
		ListNode next = null;
		
		while(curr!=null) {
			
			next = curr.next;
			
			while(pre.next != null && pre.next.val < curr.val) {
				pre = pre.next;
				
			}
			
			curr.next = pre.next;
			pre.next = curr;
			pre = helper;
			curr = next;
		}
		
		
		return helper.next;
		
		
	}
	
	//similar to above solution but not optimized
	//Time Limit Exceeded;
	public static ListNode insertionSortList_1(ListNode head) {
		if(head==null || head.next == null)return head;

    	ListNode node = head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	while(node!= null) {
    		ListNode temp = dummy.next;
    		ListNode prev = null;
    		ListNode next_node = node.next;
    		
    		while(temp != node.next && node.next !=null) {
    			
    			if(temp.val > node.next.val) {
    				ListNode next = node.next;
    				node.next = node.next.next;
    				if(prev == null) {
    					dummy.next = next;
    					next.next = temp;
    					break;
    				}else {
    					next.next = prev.next;
    					prev.next = next;
    				}
    				
    			}
    			prev = temp;
    			temp = temp.next;
    		}
    		
    		node = next_node;

    	}
    	return dummy.next;
	}
	
	//get all the value and sort it in array list
	//and replace all the value in the list
	//not insertion sort
	//runtime : 2ms
	public static ListNode insertionSortList_3(ListNode head) {
		if(head==null)return null;
		
		List<Integer> list = new ArrayList<>();
		
		ListNode node = head;
		while(node!=null) {
			list.add(node.val);
			node = node.next;
		}
		Collections.sort(list);
		
		node = head;
		for(Integer i : list) {
			if(node.val != i) {
				node.val = i;
			}
			node = node.next;
		}
		
		return head;
	}
	
	//insertion sort using value swapping
	//runtime : 72ms
    public static ListNode insertionSortList_2(ListNode head) {

        if(head == null){
            return head;
        }
        
    	ListNode node = head;
    	boolean changed = false;
    	
    	while(node.next!= null || changed == true) {
    		if(node.next == null && changed) {
    			node = head;
    			changed = false;
    			continue;
    		}
    		
    		if(node.next.val < node.val) {
    			int temp = node.val;
    			node.val = node.next.val;
    			node.next.val = temp;
    			changed = true;
    		}
    		node = node.next;
    	}
    	
    	return head;
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
