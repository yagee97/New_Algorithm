package Array;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		
		rotate(nums, k);
	}
	
    static public void rotate(int[] nums, int k) {
        // 이동한 자리 찾기 공식 => (i + k) % N => 외운보람이 있군!
    	
    	int[] copyNums = Arrays.copyOf(nums, nums.length);
    	
    	int n = nums.length;
    	for (int i = 0; i < nums.length; i++) {
    		// i번째 요소는 (i+k) % n 자리로 이동
			nums[(i + k) % n] = copyNums[i];
		}

    }
}
