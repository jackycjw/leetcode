package com.leewan.solutions.subject991;

/**
 * https://leetcode-cn.com/problems/broken-calculator/
 * 要运用逆向思维。
 * 将X至Y，转换为Y到X
 * 如Y为奇数，则肯定不是double得到的结果
 * 如果Y为偶数，则看成是double得到的
 * @author JackyCjw
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int brokenCalc = s.brokenCalc(1024, 1);
		System.out.println(brokenCalc);
	}

	public int brokenCalc(int X, int Y) {
		if(X == Y) {
			return 0;
		}
		if(X > Y) {
			return X-Y;
		}
		int rs = 0;
		
		while(true) {
			if(Y % 2 == 0 && Y > X) {
				Y = Y/2;
				rs++;
			}else {
				Y += 1;
				rs++;
			}
			if(X == Y) {
				break;
			}
		}
		
		return rs;

    }
	
	public int doubleCalc(int n) {
		return 2 * n;
	}
	
	public int decrement(int n) {
		return n-1;
	}
}
