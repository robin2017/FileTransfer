/**
 * @author Robin
 * @date 2016年4月12日 上午11:24:19
 * @version 1.0
 */

public class Solution {
	public static void main(String[] args) {
		int[] nums = { 2,5,0,0};
		System.out.println(canJump1(nums));
	}
    public static boolean canJump1(int[] nums) {
        int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++)
			max = nums[i] > max ? nums[i] : max;
		nums[nums.length - 1] = -1;
		int err=nums.length-1;
		for (int i = nums.length - 1; i >= 0; i--) {
		    if(nums[i]!=-1)
		        continue;
			 if(i>err)
			    continue;
			for(int j=i-1;i-j<=max&&j>=0;j--){
				if(nums[j]>=i-j){
					nums[j]=-1;
					err=err>j?j:err;
				}
			}
		}
		if(nums[0]==-1)
		    return true;
		else 
		    return false;
   }
	
	
	
    public boolean canJump(int[] nums) {
        int start=0,end=nums.length-1;
        return jump(nums,start,end);
    }
    private boolean jump(int[] nums,int start,int end){
        if(start==end)
            return true;
        else if(start>end)
            return false;
        else if(nums[start]==0)
            return false;
        else{
             
            for(int i=1;i<=nums[start];i++) //这里必须从1，开始否者死循环
                if(jump(nums,start+i,end))
                    return true;
            return false;
        }
    }
	
}
