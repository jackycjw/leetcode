package com.leewan.solutions.subject16;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author JackyCjw
 *
 */
public class Solution {


	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int rs = nums[0] + nums[1] + nums[2];
		
		for(int i=0;i<nums.length-2;i++) {
			int start = i+1;
			int end = nums.length - 1;
			
			while(start < end) {
				int tmp = nums[i] + nums[start] + nums[end];
				if(tmp == target) {
					return tmp;
				}
				if(Math.abs(tmp - target) < Math.abs(rs - target)) {
					rs = tmp;
				}
				if(tmp > target) {
					end--;
				}
				if(tmp < target) {
					start++;
				}
			}
		}
		return rs;
    }
	
}
