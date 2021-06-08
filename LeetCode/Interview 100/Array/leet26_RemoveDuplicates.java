package Array;

import java.util.Arrays;

public class leet26_RemoveDuplicates {
	public static void main(String[] args) {
		
		int[] nums = {1,1,2,3,4,4}; // ans => 4
		System.out.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		int cnt = 1;
		
		if(nums == null || nums.length == 0)
			return 0;
		
		// O(1)
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i] != nums[i+1]) {
				nums[cnt] = nums[i+1];
				cnt++;
			}
		}
		return cnt;
	}
}
