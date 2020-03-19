package com.leewan.solutions.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {
	
	public static void print(int[] nums) {
		StringBuilder sb = new StringBuilder("{");
		for(int i=0;i<nums.length;i++) {
			sb.append(nums[i]);
			if(i != nums.length-1) {
				sb.append(", ");
			}
		}
		sb.append("}");
		System.out.println(sb);
	}

	public static int[] sort(int[] nums){
		if(nums.length == 1) {
			return nums;
		}
		int len1 = nums.length/2;
		int len2 = nums.length - len1;
		int[] nums1 = new int[len1];
		int[] nums2 = new int[len2];
		for(int i=0;i<nums.length;i++) {
			if(i<len1) {
				nums1[i] = nums[i];
			}else {
				nums2[i-len1] = nums[i];
			}
		}
		
		return merge(sort(nums1), sort(nums2));
	}
	
	private static int[] merge(int[] nums1, int[] nums2) {
		int[] rs = new int[nums1.length + nums2.length];
		int idx_1 = 0;
		int idx_2 = 0;
		
		for(int i=0;i<rs.length;i++) {
			if(idx_2 >= nums2.length) {
				rs[i] = nums1[idx_1];
				idx_1++;
			} 
			else
			if(idx_1 >= nums1.length) {
				rs[i] = nums2[idx_2];
				idx_2++;
			}
			else
			if(nums1[idx_1] < nums2[idx_2]) {
				rs[i] = nums1[idx_1];
				idx_1++;
			}else {
				rs[i] = nums2[idx_2];
				idx_2++;
			}
		}
		return rs;
	}
	
}
