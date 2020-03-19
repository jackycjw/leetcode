package com.leewan.solutions.subject18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[] {-5,5,4,-3,0,0,4,-2};
		int target = 4;
		Solution solution = new Solution();
		System.out.println(solution.fourSum(nums, target)); 
	}
	

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> rs = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for(int i=0;i<nums.length-3;i++) {
			for(int j=i+1;j<nums.length-2;j++) {
				for(int k=j+1;k<nums.length-1;k++) {
					for(int l=k+1;l<nums.length;l++) {
						if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
							
							int[] tmp = new int[] {nums[i], nums[j], nums[k], nums[l]};
							Arrays.sort(tmp);
							
							StringBuilder sb = new StringBuilder().append(tmp[0]).append(",")
									.append(tmp[1]).append(",")
									.append(tmp[2]).append(",")
									.append(tmp[3]);
							if(set.contains(sb.toString())) {
								continue;
							}else {
								set.add(sb.toString());
							}
							List<Integer> item = new ArrayList<>();
							item.add(nums[i]);
							item.add(nums[j]);
							item.add(nums[k]);
							item.add(nums[l]);
							
							rs.add(item);
						}
					}
				}
			}
		}
		
		return rs;
    }
	
}
