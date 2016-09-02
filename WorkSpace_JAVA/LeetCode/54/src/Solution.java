import java.util.ArrayList;
import java.util.List;

/**
 * @author  Robin
 * @date 2016年4月12日 上午10:32:35 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		int[][] arr=new int[][]{{2,5},{8,4},{0,-1}};
		List<Integer> list=new ArrayList<Integer>();
	 
		list=new Solution().spiralOrder(arr);
		int a=0;
	}
 
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> list=new ArrayList<Integer>();
	        if(matrix==null||matrix.length==0)
	            return list;
	        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
	        while(true){
	            //打印top
	            for(int i=left;i<=right;i++)
	                list.add(matrix[top][i]);
	            top++;
	            if(outBoundy(left,right,top,bottom))
	                break;
	            //right
	            for(int i=top;i<=bottom;i++)
	                list.add(matrix[i][right]);
	            right--;
	            if(outBoundy(left,right,top,bottom))
	                break;
	            //bottom
	            for(int i=right;i>=left;i--)
	                list.add(matrix[bottom][i]);
	            bottom--;
	            if(outBoundy(left,right,top,bottom))
	                break;
	            //left
	            for(int i=bottom;i>=top;i--)
	                list.add(matrix[i][left]);
	            left++;
	            if(outBoundy(left,right,top,bottom))
	                break;
	        }
	        return list;
	    }
	    private boolean outBoundy(int left,int right,int top,int botton){
	        if(left>right||top>botton)
	            return true;
	        else
	            return false;
	    }
	 
}
