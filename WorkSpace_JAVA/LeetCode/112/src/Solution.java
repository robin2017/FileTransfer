import java.util.ArrayList;
import java.util.List;

 

/**
 * @author  Robin
 * @date 2016年4月16日 上午10:13:48 
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
	
		root.left = r2;
		System.out.println(hasPathSum1(root,2));
	}
	//自上往下的递归，效率高
    public static boolean hasPathSum1(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        else
            return hasPathSum1(root.left,sum-root.val)||hasPathSum1(root.right,sum-root.val);
    }
	//自下向上的递归，效率低
    public static boolean hasPathSum2(TreeNode root, int sum) {
        List<Integer> list=new ArrayList<Integer>();
        list=helper(root);
        for(Integer i:list){
            if(sum==i)
                return true;
        }
        return false;
    }
    private static List<Integer>  helper(TreeNode root){
        List<Integer> list=new ArrayList<Integer>();
        if(root==null)
            return list;
        list.addAll(helper(root.left));
        list.addAll(helper(root.right));
        if(list.isEmpty())
        	list.add(root.val);
        else{
        	List<Integer> li=new ArrayList<Integer>();
        	for(Integer i:list){
        		li.add(i+root.val);
        	}
        	list=li;
        }
        return list;
    }
}
