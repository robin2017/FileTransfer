/**
 * @author  Robin
 * @date 2016年3月26日 上午11:08:14 
 * @version 1.0 
 */

class Solution {
 public static void main(String[] args){
	 int[] a=new int[2];
	 System.out.println(a[1]);
	 System.out.println(new Solution().myAtoi("d7fgd89"));
 }
    int myAtoi(String str) {
        if(str.length()==0)
            return 0;
        boolean zheng=str.charAt(0)!='-'?true:false;
        int num[]=new int[str.length()];
        int length=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                num[length++]=str.charAt(i)-'0';
            }
        }
        int result=0;
        int bei=1;
        for(int i=length-1;i>=0;i--){
            result+=num[i]*bei;
            bei*=10;
        }
        return result*(zheng?1:-1);
        
    }
};