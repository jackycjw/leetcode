package com.leewan.solutions.subject12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.intToRoman(10));
	}
	
	Map<Integer, String> map;
	
	void init() {
		if(map == null) {
			map = new LinkedHashMap<>();
		}
		map.put(0, "");
		map.put(1, "I");
		map.put(2, "II");
		map.put(3, "III");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(6, "VI");
		map.put(7, "VII");
		map.put(8, "VIII");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(20, "XX");
		map.put(30, "XXX");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(60, "LX");
		map.put(70, "LXX");
		map.put(80, "LXXX");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(200, "CC");
		map.put(300, "CCC");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(600, "DC");
		map.put(700, "DCC");
		map.put(800, "DCCC");
		map.put(900, "CM");
		map.put(1000, "M");
		map.put(2000, "MM");
		map.put(3000, "MMM");
	}
	public String intToRoman(int num) {
		this.init();
		for(Integer i : map.keySet()) {
			System.out.println(i + ":" + (i%31));
		}
		System.out.println(map.size());
		StringBuilder sb = new StringBuilder();
		if(num >= 1000) {
			sb.append(map.get(num - num%1000));
			num %= 1000;
		}
		
		if(num >= 100) {
			sb.append(map.get(num - num%100));
			num %= 100;
		}
		
		if(num >= 10) {
			sb.append(map.get(num - num%10));
			num %= 10;
		}
		sb.append(map.get(num));
		
		return sb.toString();
    }
}
