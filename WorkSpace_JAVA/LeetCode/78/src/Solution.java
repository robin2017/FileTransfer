import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  Robin
 * @date 2016年4月13日 下午9:18:10 
 * @version 1.0 
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{1,2,3,4};
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		list=subsets(arr);
	}
	   public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> ans = new ArrayList<>();
	        if (nums == null) { return ans; }
	        Arrays.sort(nums);  // non-descending order
	        dfs(ans, nums, new ArrayList<Integer>(), 0);
	        return ans; 
	    }

	    private static void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
	        if (index == nums.length) { ans.add(new ArrayList<Integer>(list)); return; }
	        dfs(ans, nums, list, index+1);  // not pick the number at this index
	        list.add(nums[index]);
	        dfs(ans, nums, list, index+1);  // pick the number at this index
	        list.remove(list.size()-1);
	    }
}
