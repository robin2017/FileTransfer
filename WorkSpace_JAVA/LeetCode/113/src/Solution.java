import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> li = new ArrayList<Integer>();
		helper(root, sum, li, list);
		return list;
	}
	private void helper(TreeNode root, int sum, List<Integer> li,
			List<List<Integer>> list) {
		if (root == null)
			return;
		if (!(root.left == null && root.right == null)) {// 内部节点
			li.add(root.val);
			helper(root.left, sum - root.val, li, list);
			helper(root.right, sum - root.val, li, list);
		} else {// 叶子节点
			if (sum == root.val) {
				li.add(root.val);
				list.add(li);
			} else
				return;
		}
	}
}