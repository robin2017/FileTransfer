/**
 * @author  Robin
 * @date 2016年4月16日 上午10:47:46 
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
	
	//用到一个子函数
    public boolean isSymmetric(TreeNode root) {
        return isSym(root,root);
    }
    private boolean isSym(TreeNode p,TreeNode q){
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        return p.val==q.val&&isSym(p.left,q.right)&&isSym(p.right,q.left);
    }
	
	//用到两个子函数
    public boolean isSymmetric2(TreeNode root) {
        if(root==null)
            return true;
        reverse(root.left);
        return isSame(root.left,root.right);
    }
    private void reverse(TreeNode root){
        if(root==null)
            return;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        reverse(root.left);
        reverse(root.right);
    }
    
    private boolean isSame(TreeNode p,TreeNode q){
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        return (p.val==q.val)&&isSame(p.left,q.left)&&isSame(p.right,q.right);
    }
}
