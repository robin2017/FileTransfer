import java.util.HashMap;

/**
 * @author  Robin
 * @date 2016年3月25日 下午4:17:51 
 * @version 1.0 
 */

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])==null)
                hm.put(target-nums[i],i);
            else{
                int[] arr=new int[2];
                arr[0]=hm.get(nums[i]);
                arr[1]=i;
                return arr;
            }
        }
        return new int[]{0,0};
    }
    public static void main(String[] args){
    	int[] arr={3,2,4};
    	int[] result=new int[2];
    	result=twoSum(arr,6);
    }
}
