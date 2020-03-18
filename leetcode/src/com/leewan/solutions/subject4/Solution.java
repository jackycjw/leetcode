package com.leewan.solutions.subject4;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出中位数
 * @author JackyCjw
 *
 */
public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] list = new int[nums1.length + nums2.length];
		
		int idx1 = 0;
		int idx2 = 0;
		
		for(int i=0;i<list.length;i++) {
			if(idx2>= nums2.length) {
				list[i] = nums1[idx1];
				idx1++;
				continue;
			}
			if(idx1>= nums1.length) {
				list[i] = nums2[idx2];
				idx2++;
				continue;
			}
			if(idx2>= nums2.length ||  nums1[idx1] < nums2[idx2]) {
				list[i] = nums1[idx1];
				idx1++;
			}else {
				list[i] = nums2[idx2];
				idx2++;
			}
		}
		if(list.length % 2 == 0) {
			return (list[list.length/2-1] + list[list.length/2])/2.0;
		}else {
			return list[list.length/2];
		}
    }
	

	public static void main(String[] args) {
		int[] nums2 = new int[] {1, 3};
		int[] nums1 = new int[] {1, 2};
		
		Solution solution = new Solution();
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));
	}
}
