/**
 * @author Robin
 * @date 2016年4月14日 上午9:56:05
 * @version 1.0
 */

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 8 };
		System.out.println(search(nums, 3));
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 1) {
			if (target == nums[0])
				return 0;
			else
				return -1;
		}

		int start = 0, end = nums.length - 1;
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			int num;
			if (nums[0] > nums[nums.length - 1]) {//旋转
				num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
						: (target < nums[0] ? Integer.MIN_VALUE
								: Integer.MAX_VALUE);
			} else//升序
				num = nums[mid];
			if (num == target)
				return mid;
			else if (num < target) {
				start = mid + 1;
			} else
				end = mid - 1;
		}
		if (nums[mid] != target)
			return -1;
		return mid;
	}
}
