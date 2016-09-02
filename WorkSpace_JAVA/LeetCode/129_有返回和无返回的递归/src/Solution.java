 

/**
 * @author  Robin
 * @date 2016年4月18日 上午8:07:22 
 * @version 1.0 
 */

  class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
       TreeNode(int x) { val = x; }
  }

public class Solution {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
	
		root.left = r2;
		root.right = r3;
		int result=sumNumbers2(root);
		System.out.println(result);
	}
	//方案一：无返回的递归，要有成员变量（击败28.93%）
	  private int totalSum=0;
	    public int sumNumbers1(TreeNode root){
	       int pathSum=0;
	       helper1(root,pathSum);
	       return totalSum;
	    }
	    private void helper1(TreeNode root,int pathSum){
	        if(root==null)
	            return;
	        pathSum=pathSum*10+root.val;
	        if(root.left==null&&root.right==null){//叶子节点，终止条件
	            totalSum+=pathSum;
	            return;
	        }
	        helper1(root.left,pathSum);
	        helper1(root.right,pathSum);
	    }
	    //方案二：有返回的递归(击败89.79%)
	    public static int sumNumbers2(TreeNode root) {
	        int sum=0;
	        return helper2(root,sum);
	    }
	    public static int helper2(TreeNode root,int sum){
	        if(root==null)
	            return 0;
	        sum=sum*10+root.val;
	        if(root.left==null&&root.right==null)
	        	return sum;
	        return helper2(root.left,sum)+helper2(root.right,sum) ;
	    }
}
