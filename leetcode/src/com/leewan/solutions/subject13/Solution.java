package com.leewan.solutions.subject13;

import java.util.LinkedHashMap;
import java.util.Map;


public class Solution {

	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.romanToInt("MCMXCIV"));
	}
	
	public int romanToInt(String s) {
		this.init();
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			sb.append(s.charAt(i));
			String string = sb.toString();
			if(!map.containsKey(string)) {
				String key = string.substring(0, string.length()-1);
				num += map.get(key);
				i--;
				sb = new StringBuilder();
			}
		}
		String key = sb.toString();
		num += map.get(key);
		return num;
    }
	
	Map<String, Integer> map;
	
	void init() {
		if(map == null) {
			map = new LinkedHashMap<>();
		}
		map.put("",0);
		map.put("I",1);
		map.put("II",2);
		map.put("III",3);
		map.put("IV",4);
		map.put("V",5);
		map.put("VI",6);
		map.put("VII",7);
		map.put("VIII",8);
		map.put("IX",9);
		map.put("X",10);
		map.put("XX",20);
		map.put("XXX",30);
		map.put("XL",40);
		map.put("L",50);
		map.put("LX",60);
		map.put("LXX",70);
		map.put("LXXX",80);
		map.put("XC",90);
		map.put("C",100);
		map.put("CC",200);
		map.put("CCC",300);
		map.put("CD",400);
		map.put("D",500);
		map.put("DC",600);
		map.put("DCC",700);
		map.put("DCCC",800);
		map.put("CM",900);
		map.put("M",1000);
		map.put("MM",2000);
		map.put("MMM",3000);
	}
	
	
}
