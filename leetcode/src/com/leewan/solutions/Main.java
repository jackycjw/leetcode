package com.leewan.solutions;

import com.leewan.solutions.util.ArrayUtils;

public class Main {

	static int len = 4000000;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10000;i++) {
			int n = (int)((Math.random()-0.3)*1000);
			sb.append(n).append(",");
		}
		System.out.println(sb);
	}
	
	
	
	static void print(int[] nums) {
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
}
