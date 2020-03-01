package com.leewan.solutions.subject991;

/**
 * https://leetcode-cn.com/problems/broken-calculator/
 * Ҫ��������˼ά��
 * ��X��Y��ת��ΪY��X
 * ��YΪ��������϶�����double�õ��Ľ��
 * ���YΪż�����򿴳���double�õ���
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
