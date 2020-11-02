package com.leet.leetcode_nov_2020;

public class Nov01_Convert_Binary_Number_in_a_Linked_List_to_Integer {

	//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		
		System.out.println(getDecimalValue(head));
	}

	public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(head.val);
        
        ListNode node = head;
        
        while(node.next!=null){
            node = node.next;
            sb.append(node.val);
        }
        
        return Integer.parseInt(sb.toString(),2);  
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
