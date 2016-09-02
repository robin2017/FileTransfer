import java.util.Arrays;

/**
 * @author  Robin
 * @date 2016年4月11日 上午9:49:00 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		int[] nums=new int[]{
			0,2,1,-3
						
				 };
		int target=1;
		System.out.println(threeSumClosest(nums,target));
	}
	  public static int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        int result=0;
	        int distance=1000;
	        for(int i=0;i<nums.length;i++){
	            int j=i+1,k=nums.length-1; //j,k,targ等要在内部还是外部定义？？？
	            int targ=target-nums[i];
	            while(j<k){
	                int sum=nums[j]+nums[k];
	                if(sum<targ+distance&&sum>targ-distance){
	                    distance=(sum>targ?sum-targ:targ-sum);
	                    result=sum+nums[i];
	                    //此处还有判断！！
	                    if(abs(nums[j+1]+nums[k],targ)<abs(nums[j]+nums[k-1],targ))
	                    	j++;
	                    else
	                    	k--;
	                }else if(sum<=targ-distance){
	                    j++;
	                }else if(sum>=targ+distance){
	                    k--;
	                }
	                while(j<k&&nums[j]==nums[j+1])
	                    j++;
	                while(j<k&&nums[k]==nums[k-1])
	                    k--;
	            }
	        }
	        return result;
	  }
	   
	  
	    private static int abs(int i, int j) {
		// TODO Auto-generated method stub
		return i>j?i-j:j-i;
	}
		public static int threeSumClosest1(int[] nums, int target) {
	           Arrays.sort(nums);
	    int closest=nums[0]+nums[1]+nums[2];
	    int low,high;
	    for(int i=0;i<nums.length-1;i++){
	        low=i+1;
	        high=nums.length-1;
	        while(low<high){
	            if(nums[low]+nums[high]==target-nums[i]) return target;
	            else if(nums[low]+nums[high]>target-nums[i]){
	                while(low<high&&nums[low]+nums[high]>target-nums[i]) high--;
	                if(Math.abs(nums[i]+nums[low]+nums[high+1]-target)<Math.abs(closest-target))
	                    closest=nums[i]+nums[low]+nums[high+1];
	            }
	            else{
	                while(low<high&&nums[low]+nums[high]<target-nums[i]) low++;
	                if(Math.abs(nums[i]+nums[low-1]+nums[high]-target)<Math.abs(closest-target))
	                    closest=nums[i]+nums[low-1]+nums[high];
	            }
	        }
	    }
	    return closest;
	    }
}
