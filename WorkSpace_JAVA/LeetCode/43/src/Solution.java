/**
 * @author  Robin
 * @date 2016年4月11日 下午9:38:07 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		System.out.println(new Solution().multiply("999", "945"));
	}
	public String multiply(String num1, String num2){
		//这个是大整数乘法的精简版本
		
		if(num1.equals("0")||num2.equals("0"))
		    return "0";
		
		int[] result=new int[num1.length()+num2.length()];
		for(int i=0;i<num1.length();i++)
			for(int j=0;j<num2.length();j++)
				result[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
		 
		for(int i=result.length-1;i>1;i--){
			result[i-1]+=result[i]/10;
			result[i]=result[i]%10;
		}	
		StringBuilder sb=new StringBuilder();
		if(result[0]!=0)
			sb.append(result[0]);
		for(int i=1;i<result.length;i++)
			sb.append(result[i]);
		return sb.toString();
	}
}
