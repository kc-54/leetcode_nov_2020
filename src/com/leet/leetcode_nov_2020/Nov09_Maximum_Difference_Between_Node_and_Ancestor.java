package com.leet.leetcode_nov_2020;


public class Nov09_Maximum_Difference_Between_Node_and_Ancestor {
	//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.right = new TreeNode(13);
		
		
		System.out.println(maxAncestorDiff(root));
		
		root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(4);
		
		System.out.println(maxAncestorDiff(root));
	}
    public static int maxAncestorDiff(TreeNode root) {
    	return dfs(root, root.val, root.val);
    }
    
    public static int dfs(TreeNode node, int curr_min, int curr_max) {
    	
    	if(node == null)return 0;
    	
    	int val = node.val;
    	
    	int curr = 0;
		if(Math.abs(curr_min-val) > curr)curr=Math.abs(curr_min-val);
		if(Math.abs(curr_max-val) > curr)curr=Math.abs(curr_max-val);
    	
		curr_min = val<curr_min?val:curr_min;
		curr_max = val>curr_max?val:curr_max;
		
    	int left = dfs(node.left, curr_min, curr_max);
    	int right = dfs(node.right, curr_min, curr_max);
    	
    	curr = left>curr?left:curr;
    	curr = right>curr?right:curr;
    	
    	
    	return curr;
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
