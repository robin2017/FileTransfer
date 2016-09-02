import java.util.Stack;

/**
 * @author  Robin
 * @date 2016年3月25日 下午3:14:43 
 * @version 1.0 
 */

public class Solution {
    public static int longestValidParentheses(String s) {
    	 int length=0;
    	 Stack<Integer> sta=new Stack<Integer>();
    	 sta.push(-1);
    	 for(int i=0;i<s.length();i++){
    		 char c=s.charAt(i);
    		 if(c==')'&&sta.size()>1&&s.charAt(sta.peek())=='('){
    			 sta.pop();
    			 length=Math.max(length,i-sta.peek());
    		 }else{
    			 sta.push(i);
    		 }
    			 
    			 
    	 }
    	 
    	 return length;
    }
    public static void main(String[] args){
    	String str=new String("()(())");
    	System.out.println(longestValidParentheses(str));
    }
}