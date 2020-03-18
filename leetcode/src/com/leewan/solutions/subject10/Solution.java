package com.leewan.solutions.subject10;

import java.util.ArrayList;
import java.util.List;

/**
 * :正则表达式匹配
 * :回溯算法， 对于*的通配符，长度均从0开始递增，如果当前元素不匹配，将退后至上一个通配*的位置，再通配
 * @author JackyCjw
 *
 */
public class Solution {
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "a";
		String p = "ab*";
		System.out.println(solution.isMatch(s, p));
	}
 
	public boolean isMatch(String s, String p) {
		List<Item> pattern = compile(p);
		
		int idx_s = 0;
 		int idx_p = 0;
		for(;idx_s<s.length();) {
			char charAt = s.charAt(idx_s);
			Item item = idx_p < pattern.size()?pattern.get(idx_p):null;
			if(item != null && item.isMatch(charAt, idx_s)) {
				idx_p++;
				idx_s = item.start + item.len;
			} else {
				idx_p = getLast(pattern, idx_p);
				Item resetlast = pattern.get(idx_p);
				if(resetlast == null) {
					return false;
				}
				idx_s = resetlast.start + resetlast.len;
			}
		}
		if(idx_p<pattern.size()) {
			return canIgnore(idx_p, pattern);
		}
		format(pattern, s);
		return true;
    }
	
	public boolean canIgnore(int idx_p, List<Item> pattern) {
		for(;idx_p<pattern.size();idx_p++) {
			if(!pattern.get(idx_p).canIgnore()) {
				return false;
			}
		}
		return true;
	}
	
	public void format(List<Item> pattern, String s) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sbp = new StringBuffer();
		for(Item item : pattern) {
			sbp.append("(");
			sb.append("(");
			sbp.append(item.toString());
			for(int i=0;i<item.len;i++) {
				sb.append(s.charAt(i+item.start));
				
			}
			sb.append(")");
			sbp.append(")");
		}
		System.out.println(sbp);
		System.out.println(sb);
		
	}
	public int getLast(List<Item> pattern, int idx) {
		idx--;
		for(;idx>=0;idx--) {
			Item item = pattern.get(idx);
			if(item.item == '*') {
				return idx;
			}
			item.reset();
		}
		
		for(int i=idx;i<pattern.size();i++) {
			pattern.get(i).reset();
		}
		return idx;
	}
	
	public Item resetlast(List<Item> pattern, int idx) {
		int start = idx+1;
		for(;start < pattern.size();start++) {
			pattern.get(start).reset();
		}
		
		for(;idx>=0;idx--) {
			Item item = pattern.get(idx);
			if(item.item == '*') {
				return item;
			}
			item.reset();
		}
		return null;
	}
	
	public List<Item> compile(String p){
		List<Item> rs = new ArrayList<Solution.Item>();
		for(int i=0;i<p.length();) {
			char chr = p.charAt(i);
			if(i<p.length()-1) {
				char next = p.charAt(i+1);
				if(next == '*') {
					rs.add(new Item(chr, next));
					i+=2;
				}else {
					rs.add(new Item(chr));
					i++;
				}
			}else {
				rs.add(new Item(chr));
				i++;
			}
				
		}
		return rs;
	}
	
	class Item{
		
		Character replace;
		
		Character item;
		
		int start = -1;
		
		int len = -1;
		
		
		@Override
		public String toString() {
			if(replace == null) {
				return item+"";
			}
			return replace+""+item;
		}

		boolean canIgnore() {
			return item == '*';
		}
		public Item(char item) {
			this.item = item;
		}
		

		public Item(char replace, char item) {
			if(item == '*') {
				this.replace = replace;
				this.item = item;
			}
		}


		void reset() {
			this.start = -1;
			this.len = -1;
		}
		

		boolean isMatch(char c, int idx) {
			if(this.item == '*') {
				if(this.start<0) {
					this.start = idx;
					this.len++;
					return true;
				}
				boolean isMatch = replace=='.' || c == replace;
				if(isMatch) {
					this.len++;
					return true;
				}else {
					return false;
				}
			}
			if(this.item == '.') {
				this.len = 1;
				this.start = idx;
				return true;
			}
			
			boolean isMatch = c == this.item;
			if(isMatch) {
				this.start = idx;
				this.len = 1;
			}
				
			return isMatch;
		}
	}
	
}
