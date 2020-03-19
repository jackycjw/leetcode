package com.leewan.solutions.subject16;

import com.leewan.solutions.util.ArrayUtils;

public class Test {

	static int len = 10000;
	public static void main(String[] args) {
		int[] nums = new int[len];
		for(int i=0;i<len;i++) {
			int n = (int)((Math.random()-0.3)*1000);
			nums[i] = n;
		}
		int target = 1;
		Solution solution1 = new Solution();
		Solution2 solution2 = new Solution2();
		long t = System.currentTimeMillis();
//		ArrayUtils.print(nums);
		System.out.println("结果："+solution1.threeSumClosest(nums, target));
		System.out.println(System.currentTimeMillis() - t);
		System.out.println("---------------");
//		ArrayUtils.print(nums);
		t = System.currentTimeMillis();
		System.out.println("结果："+solution2.threeSumClosest(nums, target));
		System.out.println(System.currentTimeMillis() - t);
	}
}
