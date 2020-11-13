package com.leet.leetcode_nov_2020;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class Nov13_Populating_Next_Right_Pointers_in_Each_Node {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root = connect(root);
	}
	
	
    public static Node connect(Node root) {
        
    	List<Node> nodes = new ArrayList<Node>();
    	nodes.add(root);
    	connect_helper(nodes);
    	return root;
    }
    
    public static void connect_helper ( List<Node> nodes ) {
    	List<Node> child_nodes = new ArrayList<Node>();
    	for(int i = 0 ; i < nodes.size(); i ++) {
    		if(i +1 != nodes.size()) {
        		nodes.get(i).next = nodes.get(i+1);
    		}
    		if(nodes.get(i).left != null) {
        		child_nodes.add(nodes.get(i).left);
        		child_nodes.add(nodes.get(i).right);
    		}
    	}
    	if(child_nodes.size()>0)connect_helper(child_nodes);
    }
    
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
