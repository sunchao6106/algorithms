package com.sunchao.tree;

/**
 * Get the tree height(recursive)
 * 
 * @author sunchao
 *
 */
public class GetTheBinaryTreeHeight {
	
	
	public static int getTreeHeight(TreeNode root){
		if(root == null)
			return 0;
		int left = getTreeHeight(root.left);
		int right = getTreeHeight(root.right);
		return (left > right) ? left + 1 : right +1;
	}
	

	public static void main(String args[]){
		TreeNode root  = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 =  new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 =  new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 =  new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left =node5;
		node2.right = node6;
		int height = getTreeHeight(root);
		System.out.println(height);
	}
	protected static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode(int value){
		      this.value = value;
		}
	}

}
