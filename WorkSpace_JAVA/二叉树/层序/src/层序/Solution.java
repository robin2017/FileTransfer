package 层序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 

/**
 * @author  Robin
 * @date 2016年4月16日 下午1:37:21 
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
		
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		list=levelTraversal(root);
		
	}

	private static List<List<Integer>> levelTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		if(root==null)
			return list;
		queue.offer(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			List<Integer> li=new ArrayList<Integer>();
			for(int i=0;i<size;i++){
				root=queue.poll();
				li.add(root.val);
				if(root.left!=null)
					queue.offer(root.left);
				if(root.right!=null)
					queue.offer(root.right);
			}
			list.add(li);
		}
		return list;
	}
}
