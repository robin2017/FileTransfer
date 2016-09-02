import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Robin
 * @date 2016年4月17日 上午10:10:14
 * @version 1.0
 */

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode r2 = new TreeLinkNode(2);
		TreeLinkNode r3 = new TreeLinkNode(3);
		root.left = r2;
		root.right = r3;
		connect(root);
	}

	public static void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> stack = new LinkedList<TreeLinkNode>();
		if (root == null)
			return;
		stack.offer(root);
		int size = 0;
		TreeLinkNode pre = null;
		while (!stack.isEmpty()) {
			size = stack.size();
			pre = null;
			for (int i = 0; i < size; i++) {
				root = stack.poll();
				if (pre != null)
					pre.next = root;
				pre = root;
				if (root.left != null)
					stack.offer(root.left);
				if (root.right != null)
					stack.offer(root.right);
			}
			pre.next = null;
		}
	}
}