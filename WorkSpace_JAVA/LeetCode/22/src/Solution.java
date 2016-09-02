import java.util.ArrayList;
import java.util.List;

/**
 * @author  Robin
 * @date 2016年4月11日 下午3:21:13 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		System.out.println(Integer.MIN_VALUE);
		List<String> list=new ArrayList<String>();
		list=new Solution().generateParenthesis(1);
		int i=0;
	}
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<String>();
        combination("",n,n,0,list);
        return list;
    }
    private void combination(String dest,int left,int right,int sum,List<String> list){
        if(left==0&&right==0)
            list.add(dest);
        else if(left>=0&&right>=0){
            if(sum==0){//只能存放左括号
                dest+='(';
                sum+=1;
                left-=1;
                combination(dest,left,right,sum,list);
            }else if(sum>=1){//可以存放左右括号
                //左括号
                for(int i=0;i<2;i++){
                    if(i==0){//left
                        dest+='(';
                        sum+=1;
                        left-=1;
                        combination(dest,left,right,sum,list);
                    }else{//right
                    	//消除影响
                    	dest=dest.substring(0,dest.length()-1);
                    	sum-=1;
                    	left+=1;
                    	
                        dest+=')';
                        sum-=1;
                        right-=1;
                        combination(dest,left,right,sum,list);
                    }
                }
            }
        }
    }
}