/**
 * @author  Robin
 * @date 2016年4月13日 下午4:48:54 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		int[] arr=new int[]{1,2,2};
		System.out.println(removeDuplicates(arr));
		int a=0;
	}
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=2)
            return nums.length;
        int cnt=2;
        int p1=2,p2=2;
        while(p2<nums.length&&nums[p2]==nums[p2-1])
            p2++;
        int pre=nums[p1];
        int times=1;
        while(p2<nums.length){
            if(times<=2){
                pre=nums[p2];
                times++;
                nums[p1++]=nums[p2++];
                cnt++;
            }else{
                times=1;
                while(p2<nums.length&&nums[p2]==nums[p2-1])
                    p2++;
            }
            
        }    
        return cnt;
        
    }
}