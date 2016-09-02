package 后序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



/**
 * @author  Robin
 * @date 2016年4月15日 下午9:47:10 
 * @version 1.0 
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);
		TreeNode r7 = new TreeNode(7);
		root.left = r2;
		root.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.left = r6;
		r3.right = r7;
		
		List<Integer> list=new ArrayList<Integer>();
		list=postorderTraversal2(root);
		
	}

	//后序递归
	private static List<Integer> postorderTraversal1(TreeNode root) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		helper(root,list);
		return list;
	}
	private static void helper(TreeNode root,List<Integer> list){
		if(root==null)
			return;
		helper(root.left,list);
		helper(root.right,list);
		list.add(root.val);
	}
	//后序栈1：先序栈遍历镜像，再取反list
	//后序栈2：先序栈遍历镜像，linkedList.add(0,val);
	//后序栈3：while(if(node.right!=null);if(node.left!=null)):if-if比if-else简洁
		
	public static List<Integer> postorderTraversal2(TreeNode root) {
	    List<Integer> list = new LinkedList<Integer>();
	    if (root == null) return list;
	    Stack<TreeNode> stack = new Stack();
	    stack.push(root);
	    while (!stack.empty()) {
	        TreeNode node = stack.pop();
	        list.add(0, node.val);
	        if (node.left != null) stack.push(node.left);
	        if (node.right != null) stack.push(node.right);
	    }
	    return list;
	}
}
