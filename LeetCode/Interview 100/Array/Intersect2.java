package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Intersect2 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1}; 
		int[] nums2 = {2,2};
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

	static public int[] intersect(int[] nums1, int[] nums2) {

		// 교집합

		List<Integer> list = new ArrayList<>();
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		if(nums1.length <= nums2.length) {
			for (int i = 0; i < nums1.length; i++) {
				int num = nums1[i];
				for (int j = 0; j < nums2.length; j++) {
					if(num == nums2[j]) {
						nums2[j] = -1;
						list.add(num);
						break;
					}
				}
			}
		}else if(nums1.length > nums2.length) {
			for (int i = 0; i < nums2.length; i++) {
				int num = nums2[i];
				for (int j = 0; j < nums1.length; j++) {
					if(num == nums1[j]) {
						nums1[j] = -1;
						list.add(num);
						break;
					}
				}
			}
		}
		
		int[] ret = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
}
