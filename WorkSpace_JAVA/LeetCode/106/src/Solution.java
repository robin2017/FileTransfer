import java.util.Arrays;

/**
 * @author  Robin
 * @date 2016年4月17日 下午10:10:23 
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
		int[] a1=new int[]{3,2,1};
		int[] a2=new int[]{3,2,1};
		TreeNode root=buildTree(a1,a2);
	}
    public static TreeNode buildTree(int[] in, int[] post) {
        if(in==null||in.length==0)
            return null;
        if(in.length==1)
            return new TreeNode(in[0]);
        TreeNode root=new TreeNode(post[post.length-1]);
        int index=-1;
        for(int i=0;i<in.length;i++)
            if(post[post.length-1]==in[i]){
                index=i;
                break;
            }
        int[] lin=Arrays.copyOfRange(in,0,index);
        int[] rin=Arrays.copyOfRange(in,index+1,in.length);
        int[] lpost=Arrays.copyOfRange(post,0,index);
        int[] rpost=Arrays.copyOfRange(post,index,in.length-1);
        root.left=buildTree(lin,lpost);
        root.right=buildTree(rin,rpost);
        return root;
    }
}