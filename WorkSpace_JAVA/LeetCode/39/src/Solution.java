import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  Robin
 * @date 2016年4月11日 下午8:43:41 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		int[] nums=new int[]{2,3,6,7};
		int target=7;
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		list=combinationSum(nums,target);
		int a=0;
		 
	}
	
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		DFS(list,new ArrayList<Integer>(),0,nums,target);
		return list;
	}
	private static void DFS(List<List<Integer>> list,ArrayList<Integer> l,int start,int[] nums,int targ){
		if(targ==0)
			list.add((ArrayList<Integer>) l.clone());//不能为原来的，否者会变化，要用复制版本
		else if(targ<0)
			return;
		else{//targ>0
			for(int i=start;i<nums.length;i++){
				l.add(nums[i]);
				DFS(list,l,i,nums,targ-nums[i]);  //这里的第三个参数不是start，否者结果会有重复
				l.remove(l.size()-1);//消除前面的影响！！！
			}
		}
	}
}
