package com.leet.leetcode_nov_2020;

public class Nov23_House_Robber_III {
	
	//https://leetcode.com/problems/house-robber-iii/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(11);
		//test case 1
//		root = new TreeNode(11);
//		root.left = new TreeNode(14);
//		root.left.left = new TreeNode(7);
//		root.left.right = new TreeNode(3);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(1);
//		root.left.right.right = new TreeNode(5);
//		root.right = new TreeNode(5);
//		root.right.right = new TreeNode(1);
//		root.right.right.right = new TreeNode(2);
		
		//test case 2
//		root = new TreeNode(100);
//		root.left = new TreeNode(11);
//		root.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(2);
//		root.left.left.right.left = new TreeNode(5);
//		root.left.left.left = new TreeNode(14);
//		root.left.left.left.right = new TreeNode(3);
		
		//test case 3
//		root = new TreeNode(11);
//		root.left = new TreeNode(1);
//		root.left.left = new TreeNode(2);
//		root.left.left.right = new TreeNode(3);
		

		//test case 4
//		root = new TreeNode(3);
//		root.left = new TreeNode(2);
//		root.left.right = new TreeNode(3);
//		root.right = new TreeNode(3);
//		root.right.right = new TreeNode(1);
		

		//test case 5
//		root = new TreeNode(3);
//		root.left = new TreeNode(4);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(3);
//		root.right = new TreeNode(5);
//		root.right.right = new TreeNode(1);
		
		//test case 6
		root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		System.out.println(rob(root));
	}

	public static int rob(TreeNode root) {
		if(root == null ) return 0;
		int[] rs = rob_helper(root);
		return Math.max(rs[0], rs[1]);
	}
	public static int[] rob_helper(TreeNode node) {
		
		int [] dp = new int[3];
		
		dp[0] = node.val;
		
		if(node.left != null) {
			int [] rs = rob_helper(node.left);
			dp[0] += Math.max(rs[1],rs[2]);
			dp[1] += rs[0];
			dp[2] += Math.max(Math.max(rs[0], rs[1]),rs[2]);
		}
		if(node.right != null) {
			int [] rs = rob_helper(node.right);
			dp[0] += Math.max(rs[1],rs[2]);
			dp[1] += rs[0];
			dp[2] += Math.max(Math.max(rs[0], rs[1]),rs[2]);
		}
		//for debug
//		System.out.println("node"+node.val + " " + dp[0]+ " " + dp[1]+ " " + dp[2]);
		
		return dp;
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
