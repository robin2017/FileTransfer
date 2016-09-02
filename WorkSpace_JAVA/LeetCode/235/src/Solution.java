

/**
 * @author  Robin
 * @date 2016年4月16日 上午9:42:29 
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
    TreeNode res=null;
    boolean get=false;
    
    //方案1：针对一般的二叉树
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        getNum(root,p,q);
        return res;
    }
    private int getNum(TreeNode root,TreeNode p,TreeNode q){
        int result=0;
        if(root==null)
            return 0;
        if(root==q||root==p)
            result=1;
        result+=getNum(root.left,p,q);
        result+=getNum(root.right,p,q);
        if(result==2&&!get){
            get=true;
            res=root;
        }
       
       return result;
    }
    
    //方案二：针对特殊二叉树：BST
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<=q.val)
            return helper(root,p,q);
        else
            return helper(root,q,p);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root.val>=p.val&&root.val<=q.val)
            return root;
        else if(q.val<root.val) 
            return helper(root.left,p,q);
        else 
            return helper(root.right,p,q);
}
}
