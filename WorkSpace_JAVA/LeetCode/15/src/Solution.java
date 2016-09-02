import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public static void main(String[] args){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		int[] nums={0,0,0};
		list=new Solution().threeSum0(nums);
		int a=1;
	}
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        
        int len=nums.length;
        
        
        for(int i=0;i<len&&nums[i]<=0;i++){
            int target=0-nums[i];
            int j=i+1,k=len-1;
            while(j<k){
                if(nums[j]+nums[k]==target){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                  
                    while(j < k && nums[j] == nums[j + 1]) j++;  // Skip same results
                    while(j < k && nums[k] == nums[k - 1]) k--;  // Skip same results
                  
                    
                    k--;
                    j++;
                }else if(nums[j]+nums[k]<target)
                    j++;
                else
                    k--;
                    
            }
        }
        
        
        return list;
    }
    public List<List<Integer>> threeSum0(int[] nums) { //最优答案
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);

        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;        // Skip same results
            int target = 0 - nums[i];
            int j = i + 1, k = len - 1;
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) j++;  // Skip same results
                    while(j < k && nums[k] == nums[k - 1]) k--;  // Skip same results
                    j++; k--;
                } else if(nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            if(i>0&&num[i]==num[i-1])continue;
            for(int j=i+1; j<num.length-2; j++){
                if(j>i+1&&num[j]==num[j-1])continue;
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high&&num[low]==num[low+1])low++;
                        while(low<high&&num[high]==num[high-1])high--;
                        low++;
                        high--;
                    }
                    else if(sum<target)low++;
                    else high--;
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSum0(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
           // if(nums[i]>0) //表明后面不会可能   //++++++++++++++++++++++++++++++++不能要！！！
           //     break;
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int target1=target-nums[i];
            for(int j=i+1;j<nums.length-2;j++){
              //  if(nums[j]>target1)
              //      break;
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                int target2=target1-nums[j];
                int start=j+1,end=nums.length-1;
                while(start<end){
                if(nums[start]+nums[end]==target2){
                    list.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                    while(start<end&&nums[start]==nums[start+1]) start++;
                    while(start<end&&nums[end]==nums[end-1]) end--;
                    
                    start++;
                    end--;
                }
                else if(nums[start]+nums[end]<target2) 
                    start++;
                else
                    end--;
                
                }
            }
        }
        
        return list;
    }
    public List<List<Integer>> threeSum1(int[] nums) { //我的原版答案，超时
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int sum=0-nums[i];
            for(int j=0;j<nums.length;j++){
                if(j==i)
                    break;
                if(hm.get(nums[j])!=null){
                    ArrayList l=new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(1-nums[i]-nums[j]);
                    list.add(l);
                }else
                    hm.put(nums[j],sum-nums[j]);
            }
            hm.clear();
        }
        return list;
    }
}