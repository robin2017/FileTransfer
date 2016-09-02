import java.util.Arrays;


/**
 * @author Robin
 * @date 2016年4月17日 上午11:28:00
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

class Integ {
	int val;
	void setVal(int val) {
		this.val = val;
	}
	Integ(int val) {
		this.val = val;
	}
}

public class Solution {
	public static void main(String[] args) {
		 
		
		TreeNode root = new TreeNode(10);
		TreeNode r2 = new TreeNode(5);
		TreeNode r3 = new TreeNode(15);
		TreeNode r4 = new TreeNode(6);
		TreeNode r5 = new TreeNode(20);

		 
		
		
		root.left = r2;
		root.right = r3;
		r3.left = r4;
		r3.right = r5;

		System.out.println(isValidBST(root));
	}
	

	public static boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
		return helper(root, new Integ(0), new Integ(0));
	}

	public static boolean helper(TreeNode root, Integ min, Integ max) {
		boolean result = true;
		boolean result1 = true, result2 = true;
		int rootMin = Integer.MAX_VALUE;
		int rootMax = Integer.MIN_VALUE;
		if (root.left == null && root.right == null) {
			min.setVal(root.val);
			max.setVal(root.val);
			return result;
		}
		Integ lmin = new Integ(0), lmax = new Integ(0), rmin = new Integ(0), rmax = new Integ(
				0);
		if (root.left != null) {
			lmin = new Integ(0);
			lmax = new Integ(0);
			result1 = helper(root.left, lmin, lmax);
			if (lmax.val >= root.val) // 2,1,3的最大最小值不能传回来
				result = false;
			rootMin = lmin.val;
		}
		if (root.right != null) {
			rmin = new Integ(0);
			rmax = new Integ(0);
			result2 = helper(root.right, rmin, rmax);
			if (rmin.val <= root.val) 
				result = false;
			rootMax = rmax.val;
		}
		min.setVal(Math.min(rootMin, root.val));
		max.setVal(Math.max(rootMax, root.val));
		return result && result1 && result2;
	}
}