import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 

/**
 * @author Robin
 * @date 2016年4月18日 上午9:16:14
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
		System.out.println(serialize1(root));
		String str = "[-1,2,3,4,95]";
		//System.out.println(deserialize(str));

	}
	public static String serialize1(TreeNode root) 
	{
	    if(root == null) return "#";

	    return "" + root.val + " " + serialize1(root.left) + " " + serialize1(root.right);
	}
	public static String serialize2(TreeNode root) {
		if (root == null)
			return "[]";
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int size = 0;
		boolean isAllLeaf = true;
		while (!queue.isEmpty()) {
			size = queue.size();
			isAllLeaf = true;
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				if (root == null) {
					sb.append("null,");
					continue;
				}
				if (root.left != null || root.right != null)
					isAllLeaf = false;
				sb.append(String.valueOf(root.val) + ",");
				queue.offer(root.left);
				queue.offer(root.right);
			}
			if (isAllLeaf)
				break;
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		return sb.toString();
	}

	public static TreeNode deserialize(String data) {

		Queue<String> list = new LinkedList<String>();
		String regex = "-?\\d+|null";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(data);
		while (m.find()) {
			list.offer(m.group());
		}
		if(list.size()==0)
			return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int size = 0;
		TreeNode pointer = null;
		TreeNode root = new TreeNode(Integer.parseInt(list.poll()));
		queue.offer(root);
		while (!list.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				pointer = queue.poll();
				if(list.isEmpty()) break;
				String val1 = list.poll();
				if (!val1.equals("null"))
					pointer.left = new TreeNode(Integer.parseInt(val1));
				if(list.isEmpty()) break;
				String val2 = list.poll();
				if (!val2.equals("null"))
					pointer.right = new TreeNode(Integer.parseInt(val2));
				if (pointer.left != null)
					queue.offer(pointer.left);
				if (pointer.right != null)
					queue.offer(pointer.right);
			}
		}
		return root;
	}
}
