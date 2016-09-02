public class Solution {
	public static void main(String[] args){
		int[] result=new int[2];
		result=new Solution().searchRange(new int[]{1,4}, 4);
	}
    public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int index=-1;
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if(nums[mid]<target)
                start=mid+1;
            else if(nums[mid]>target)
                end=mid-1;
            else{
                index=mid;
                break;
            }
        }
        if(index==-1)
            return new int[]{-1,-1};
        
        int ind1=-1,ind2=-1;
        start=0;
        end=index;
        while(start<=end){
            mid=(start+end)/2;
            if(mid==0&&nums[mid]==target){
                ind1=0;
                break;
            }
            else if(nums[mid-1]<target&&nums[mid]==target){
                ind1=mid;
                break;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        start=index;
        end=nums.length-1;
        while(start<=end){
            mid=(start+end)/2;
            if(mid==nums.length-1&&nums[mid]==target){
                ind2=end;
                break;
            }
            if(nums[mid]==target&&nums[mid+1]>target){
                ind2=mid;
                break;
            }
            else if(nums[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return new int[]{ind1,ind2};
    }
}