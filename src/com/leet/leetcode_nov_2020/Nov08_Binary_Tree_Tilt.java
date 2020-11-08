package com.leet.leetcode_nov_2020;

import java.util.ArrayList;
import java.util.List;

public class Nov08_Binary_Tree_Tilt {
	
	//https://leetcode.com/problems/binary-tree-tilt/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);
		node.right = new TreeNode(9);
		node.right.right = new TreeNode(7);
		System.out.println(findTilt(node));
	}
	
	//solution run time is 2ms. 
	//0ms can be achieved by using global int var to keep track of total tilts 
	//instead of using List to keep track of total tilts
    public static int findTilt(TreeNode root) {
        int rs = 0;
        
        List<Integer> tilts = new ArrayList<Integer>();
        sums(root,tilts);
        
        for(int i : tilts) {
        	rs += i;
        }
        
        return rs;
    }
    
    public static int sums(TreeNode node, List<Integer> tilts) {
    	
    	if(node == null)return 0;
    	
    	int	left = sums(node.left, tilts);
    	int	right = sums(node.right, tilts);
    	
    	tilts.add(Math.abs(left-right));
    
    	return left+right + node.val;
    }
    
    
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
