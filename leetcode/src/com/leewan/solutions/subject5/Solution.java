package com.leewan.solutions.subject5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找出最长回文字符串
 * @author JackyCjw
 *
 */
public class Solution {
	
	public Map<Character, List<Integer>> map = new HashMap<>();

	public String longestPalindrome(String s) {
		for(int i=0;i<s.length();i++) {
			char chr = s.charAt(i);
			if(!map.containsKey(chr)) {
				map.put(chr, new ArrayList<>());
			}
			map.get(chr).add(i);
		}
		
		
		
		String max = "";
		for(int i=0;i<s.length()-max.length();i++) {
			
			char chr = s.charAt(i);
			
			List<Integer> idxs = map.get(chr);
			
			for(int j=idxs.size()-1; j>=0 && idxs.get(j)-i>=max.length() ;j--) {
				String tmp = s.substring(i, idxs.get(j)+1);
				if(check(tmp) && tmp.length() > max.length()) {
					max = tmp;
					break;
				}
			}
		}
		return max;
    }
	

	public boolean check(String s) {
		int len = s.length();
		for(int i=0;i<len/2;i++) {
			if(s.charAt(i) != s.charAt(len - i -1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] nums2 = new int[] {1, 3};
		int[] nums1 = new int[] {1, 2};
		
		Solution solution = new Solution();
		System.out.println(solution.longestPalindrome("a"));
	}
}
