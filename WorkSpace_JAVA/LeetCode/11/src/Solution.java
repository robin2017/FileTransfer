/**
 * @author  Robin
 * @date 2016年3月26日 下午12:21:20 
 * @version 1.0 
 */
public class Solution{
	public static void main(String[] args){
		int[] arr={2,1,5,6,2,3};
		System.out.println(new Solution().maxArea(arr));
	}
	public int maxArea(int[] height) {
	    int maxA = 0;

	    int i = 0, j = height.length-1;

	    while(i < j) {
	        int H = Math.min(height[i], height[j]);
	        int W = j - i;
	        maxA = Math.max(maxA, H*W);

	        while(i < j && height[i] <= H) {
	            ++i;
	        }
	        while(i < j && height[j] <= H) {
	            --j;
	        }
	    }
	    return maxA;
	}
}