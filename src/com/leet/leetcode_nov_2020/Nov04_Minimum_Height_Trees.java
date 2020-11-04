package com.leet.leetcode_nov_2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Nov04_Minimum_Height_Trees {
	
	//https://leetcode.com/problems/minimum-height-trees/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 2;
		int [][] edges = {{1,0}};
		
		for(int i : findMinHeightTrees(n, edges)) {
			System.out.print(i + " ");
		}
	}
	
	//2nd solution, remove all leaves until only 1 to 2 vertices left. Based on hint : MHT only can have at most 2 vertices.
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

		List<Set<Integer>> vertices = new ArrayList<>();
		List<Integer> leaves = new ArrayList<>();

		if(n == 1) {
			leaves.add(0);
			return leaves;
		}
		
		for(int i = 0; i < n; i++) {
			vertices.add(new HashSet<>());
		}
		for(int i = 0; i < n-1; i++) {
			vertices.get(edges[i][0]).add(edges[i][1]);
			vertices.get(edges[i][1]).add(edges[i][0]);
		}
		for(int i = 0; i < n; i++) {
			if(vertices.get(i).size() == 1)leaves.add(i);
		}
		
		while(n > 2) {
			n -= leaves.size();
			List<Integer> new_leaves = new ArrayList<>();
			for (int i : leaves) {
	            int j = vertices.get(i).iterator().next();
	            vertices.get(j).remove(i);
	            if (vertices.get(j).size() == 1) new_leaves.add(j);
	        }
	        leaves = new_leaves;
		}
		
		return leaves;
		
	}
	
	//1st solution, reconstruct all treenode and iterate through them
	public static List<Integer> findMinHeightTrees_1(int n, int[][] edges) {
        
		int min = n + 1;
		List<Integer> rs = new ArrayList<Integer>();
		
		if(n == 1) {
			rs.add(0);
			return rs;
		}
		
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		
		for(int i = 0; i < n; i++) {
			nodes.add(new TreeNode(i));
		}
		for(int i = 0; i < n-1; i++) {
			nodes.get(edges[i][0]).neighbour.add(nodes.get(edges[i][1]));
			nodes.get(edges[i][1]).neighbour.add(nodes.get(edges[i][0]));
		}

		for(int i = 0; i < n; i++) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(nodes.get(i));
			int h = height(nodes.get(i), stack, 1);
			
			if(h < min) {
				min = h;
				rs = new ArrayList<Integer>();
				rs.add(i);
			}else if(h==min) {
				rs.add(i);
			}
		}
		return null;
	}
	
	public static int height(TreeNode t, Stack<TreeNode> s, int h) {
		int curr_rs = 0;
		for(TreeNode temp : t.neighbour) {
			if(s.contains(temp))continue;
			else {
				s.add(temp);
				int temp_height = height(temp, s, 1);
				if(temp_height > curr_rs)curr_rs = temp_height;
			}
			
		}
		
		return h + curr_rs;
	}
	public static class TreeNode {
		int val;
		List<TreeNode> neighbour = new ArrayList<TreeNode>();

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

	}
}
