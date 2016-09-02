package 先序;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Robin
 * @date 2016年4月15日 下午8:47:05
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
		list=preorderTraversal2(root);
		
	}
	//递归(1ms,击败56.9%)
	private static List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		helper(root,list);
		
		return list;
	}
	private static void helper(TreeNode root,List<Integer> list){
		if(root==null)
			return;
		list.add(root.val);
		helper(root.left,list);
		helper(root.right,list);
	}
	
	//迭代(2ms,击败1.25%，因为有容器栈的引入！！)
	private static List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null)
			return list;
		Stack<TreeNode> stack=new Stack<TreeNode>();
	
		while(!stack.isEmpty()||root!=null){
			if(root!=null){
				list.add(root.val);
				stack.push(root);
				root=root.left;
				
			}else{
				root=stack.pop();
				root=root.right;
			}
		}
		return list;
	}
}
