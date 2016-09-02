/**
 * @author  Robin
 * @date 2016年4月11日 下午3:55:57 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
 
		System.out.println(new Solution().divide(Integer.MAX_VALUE, 1));
	}
    public int divide(int dividend, int divisor) {
        boolean isNeg=(dividend^divisor)>>>31==1;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
  	  int digit=0;
  	  while((dividend>>1)>=divisor){
  		  divisor<<=1;
  		  digit++;
  	  }
  	  int result=0;
  	  while(digit>=0){
  		  if(dividend>=divisor){
  			  result+=(1<<digit);
  			  dividend-=divisor;
  		  }
  		  digit--;
  		  divisor>>=1;
  	  }
  	  return isNeg==false?result:-result;
  	}
     
}
