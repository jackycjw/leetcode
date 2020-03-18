package com.leewan.solutions.subject0106;

public class Solution {

	public String compressString(String S) {
		if(S == null || S.length()<=1) {
			return S;
		}
		StringBuilder sb = new StringBuilder();
		Character cur = null;
		int len = 0;
		for(int i=0;i<S.length();i++) {
			if(cur == null) {
				cur = S.charAt(i);
				len = 1;
				continue;
			}
			char c = S.charAt(i);
			if(cur.equals(c)) {
				len++;
			}else {
				sb.append(cur).append(len);
				cur = c;
				len = 1;
			}
		}
		sb.append(cur).append(len);
		
		String string = sb.toString();
		return string.length() < S.length()?string: S;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.compressString("abbccd"));
	}
}
