/**
 * @author  Robin
 * @date 2016年3月31日 上午10:08:25 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		int[] nums=new int[]{3,2,2,3};
		System.out.println(new Solution().removeElement(nums,3));
	}
    public int removeElement(int[] nums, int val) {
        int first=0,last=nums.length-1;
        while(first<last){
            
            while(first<last&&nums[first]!=val)
                first++;
            while(first<last&&nums[last]==val)
                last--;
            
            int tmp=nums[first];
            nums[first]=nums[last];
            nums[last]=tmp;
            first++;
            last--;
        }
        return first+1;
    }
}
