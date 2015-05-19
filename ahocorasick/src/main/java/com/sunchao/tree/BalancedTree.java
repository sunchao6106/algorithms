package com.sunchao.tree;

import com.sunchao.tree.GetTheBinaryTreeHeight.TreeNode;

/**
 * figure out whether the tree is balanced?
 * 
 * @author sunchao
 *
 */
public class BalancedTree {
/**
 * Repeat get the height of an tree node
 * @param root
 * @return
 */
	public static boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
	    int left = treeHeight(root.left);
		int right = treeHeight(root.right);
		int diff = left - right;
		if(diff > 1 || diff < -1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static int treeHeight(TreeNode node){
		if(node == null)
			return 0;
		int left  = treeHeight(node.left);
		int right = treeHeight(node.right);
		return left > right ? left + 1 : right +1;
	}
	public static boolean isBalanced2(TreeNode root){
		Height height = new Height(0);
		System.out.println(height.height);
		return isBalanced1(root, height);
		
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
	   // node2.right = node6;
		boolean flag =  isBalanced2(root);
		System.out.println(flag);
	}
	/**
	 * java 基本数据类型是值传递，所以
	 * 传递int height 没用，只能传递个封装个高度的引用进去
	 * @param root
	 * @param height1
	 * @return
	 */
	public static boolean isBalanced1(TreeNode root,Height height1){
		if(root ==  null){
			height1.height = 0;
			return true;
		}
		Height left = new Height(0) ;
		Height right = new Height(0);
		if(isBalanced1(root.left,left) && isBalanced1(root.right,right)){
			int diff  = left.height - right.height;
			if(Math.abs(diff) <= 1){
				height1.height = 1 + (left.height > right.height ? left.height : right.height);
				return true;
			}
		}
		
		return false;
		
	}
	protected static class Height{
		int height;
		Height(int value){
			this.height =value;
		}
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
