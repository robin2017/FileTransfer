/**
 * @author  Robin
 * @date 2016年3月31日 上午9:55:48 
 * @version 1.0 
 */
public class Solution {
	public static void main(String[] args){
		int[] nums=new int[]{1,1,2};
		System.out.println(new Solution().removeDuplicates(nums));
	}
    public int removeDuplicates(int[] nums) {
        int n1=0,n2=1;
         
        while(n2<nums.length){
            while(n2<nums.length&&nums[n2]==nums[n2-1])
                n2++;
            if(n2<nums.length)
                nums[++n1]=nums[n2];
            n2++;
        }
        return n1+1;
    }
}