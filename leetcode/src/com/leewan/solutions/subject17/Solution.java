package com.leewan.solutions.subject17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * :利用数字进制的模式，遍历每个数字对应字符串的下标
 * @author JackyCjw
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		String digits = "";
		Solution solution = new Solution();
		System.out.println(solution.letterCombinations(digits).size());
	}

	Map<Character, String> chrs;
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if(digits == null || digits.length()==0) {
			return list;
		}
		this.init();
		
		List<Integer> idxs = new ArrayList<Integer>();
		List<Integer> idx_max = new ArrayList<Integer>();
		
		for(int i=0;i<digits.length();i++) {
			Character  charAt = digits.charAt(i);
			idxs.add(0);
			idx_max.add(chrs.get(charAt).length()-1);
		}
		
		do {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<digits.length();i++) {
				Character  charAt = digits.charAt(i);
				String string = chrs.get(charAt);
				sb.append(string.charAt(idxs.get(i)));
			}
			list.add(sb.toString());
			
		}while(next(idxs, idx_max, 0));
		return list;
    }
	
	boolean next(List<Integer> idxs, List<Integer> idx_max, int idx) {
		Integer i = idxs.get(idx);
		Integer max = idx_max.get(idx);
		if(i == max) {
			if(idx == idxs.size()-1) {
				return false;
			}else {
				idxs.set(idx, 0);
				return next(idxs, idx_max, idx+1);
			}
		}else {
			idxs.set(idx, i+1);
		}
		return true;
	}
	void init() {
		chrs = new HashMap<Character, String>();
		chrs.put('2', "abc");
		chrs.put('3', "def");
		chrs.put('4', "ghi");
		chrs.put('5', "jkl");
		chrs.put('6', "mno");
		chrs.put('7', "pqrs");
		chrs.put('8', "tuv");
		chrs.put('9', "wxyz");
	}
}
