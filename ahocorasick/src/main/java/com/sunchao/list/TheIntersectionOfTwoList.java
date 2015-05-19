package com.sunchao.list;
/**
 * 
 * A:          a1 → a2
 *                     ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * 
 * 
 * 
 * the intersectionOfTwoList
 * @author sunchao
 *
 */

public class TheIntersectionOfTwoList {
	
	public static ListNode getIntersection(ListNode head1,ListNode head2){
		
		if(head1 == null || head2 == null)
			return null;
		
		ListNode dummy1 = head1;
		ListNode dummy2 = head2;
		
		while(dummy1 != null && dummy2 != null && dummy1 != dummy2){
			dummy1 = dummy1.next;
			dummy2 = dummy2.next;
			
			if(dummy1 == dummy2)
				return dummy1;
			
			dummy1 = dummy1 == null ? head2 : dummy1;
			dummy2 = dummy2 == null ? head1 : dummy2;
			
		}
		return dummy1;
	}
	
	public static ListNode getIntersection1(ListNode head1,ListNode head2){
		
		if(head1 == null || head2 == null)
			return null;
		ListNode dummy1 = head1;
		ListNode dummy2 = head2;
		int count1 = 0;
		int count2 = 0;
		while(dummy1 != null){
			count1++;
			dummy1 = dummy1.next;
		}
		while(dummy2 != null){
			count2++;
			dummy2 = dummy2.next;
		}
		int diff1 = 0,diff2 = 0;
		if(count1 > count2){
			diff1 =count1-count2;
		}
		else
			diff2 =count2 - count1;
		while(diff1 != 0){
			head1 = head1.next;
			diff1--;
		}
		while(diff2 != 0){
			head2 = head2.next;
			diff2--;
		}
		while(head1 != null && head2 != null && head1 != head2){
			 head1 = head1.next;
			 head2 = head2.next;
		}
		return head1;
	}
	public static void main(String[] args){
		ListNode b1 = new ListNode(4);
		ListNode a1 = new ListNode(2);
		ListNode b2 = new ListNode(3);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(2);
		ListNode c1 = new ListNode(5);
		ListNode c2 = new ListNode(6);
		ListNode c3 = new ListNode(7);
		b1.next = b2;
		b2.next = c1;
		c1.next =c2;
		c2.next = c3;
		a1.next =a2;
		a2.next =a3;
		a3.next = c1;
		
		ListNode in = getIntersection1(a1, b1);
		System.out.println(in.value);
		
	}
	protected static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value){
			this.value = value;
		}
	}

}
