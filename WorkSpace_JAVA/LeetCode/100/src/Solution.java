import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/**
 * @author  Robin
 * @date 2016年4月16日 上午9:01:36 
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
		TreeNode p = new TreeNode(10);
		TreeNode r2 = new TreeNode(5);
		TreeNode r3 = new TreeNode(15);
		TreeNode q = new TreeNode(10);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(15);
		TreeNode r7 = new TreeNode(7);
		p.left=r2;
		p.right=r3;
		q.left=r5;
		r5.right=r6;
		
		System.out.println(isSameTree(p,q));
	
		
	}

	 public static boolean isSameTree(TreeNode p, TreeNode q) {
	        Stack<TreeNode> sta1=new Stack<TreeNode>();
	        Stack<TreeNode> sta2=new Stack<TreeNode>();
	        if(p==null&&q==null)
	            return true;
	        else if(p==null&&q!=null)
	            return false;
	        else if(p!=null&&q==null)
	            return false;
	        else{
	            sta1.push(p);
	            sta2.push(q);
	            while(!sta1.empty()&&!sta2.empty()){
	                p=sta1.pop();
	                q=sta2.pop();
	                if(p.val!=q.val)
	                    return false;
	                if(p.right!=null)
	                    sta1.push(p.right);
	                if(p.left!=null)
	                    sta1.push(p.left);
	                if(q.right!=null)
	                    sta2.push(q.right);
	                if(q.left!=null)
	                    sta2.push(q.left);
	                    
	            }
	            if(sta1.empty()==sta2.empty())
	                return true;
	            else 
	                return false;
	        }
	    }
}
