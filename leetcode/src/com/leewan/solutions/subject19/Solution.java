package com.leewan.solutions.subject19;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[] {1};
		int target = 1;
		ListNode head = new ListNode(nums[0]);
		ListNode cur = head; 
		for(int i=1;i<nums.length;i++) {
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
		Solution solution = new Solution();
		head = solution.removeNthFromEnd(head,target);
		do {
			System.out.print(head.val+",");
			head = head.next;
		}while(head != null);
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode rs = head;
		List<ListNode> list = new ArrayList<ListNode>();
		do {
			list.add(head);
			head = head.next;
		}while(head != null);
		int idx_self = list.size()-n;
		if(idx_self==0) {
			return rs.next;
		}
		ListNode last = list.get(idx_self-1);
		ListNode cur = list.get(idx_self);
		last.next = cur.next;
		return rs;
    }
}
