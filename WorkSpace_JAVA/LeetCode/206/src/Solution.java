/**
 * @author Robin
 * @date 2016年4月13日 下午10:13:21
 * @version 1.0
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode h2=new ListNode(2);
		ListNode h3=new ListNode(3);
		ListNode h4=new ListNode(4);
		head.next=h2;
		h2.next=h3;
		h3.next=h4;
		
		ListNode result=reverse(null,head);
		
	}
	private static ListNode reverse(ListNode first,ListNode last){
		if(last==null)
			return first;
		ListNode tmp=last.next;
		last.next =first;
		return reverse(last,tmp); //一直从最底层传到最高层！！！
	}
	
	
	
	public static ListNode reverseList22(ListNode head) {
		return helper(null, head);
	}

	static ListNode helper(ListNode reversed, ListNode remaining) {
		if (remaining == null)
			return reversed;
		ListNode tmp = remaining.next;
		remaining.next = reversed;

		return helper(remaining, tmp);
	}

	public ListNode reverseList11(ListNode head) {
		if (head == null)
			return head;

		ListNode newhead = new ListNode(0);
		newhead.next = head;

		while (head.next != null) {
			ListNode tmp = head.next;
			head.next = head.next.next;

			tmp.next = newhead.next;
			newhead.next = tmp;
		}
		return newhead.next;
	}

	public ListNode reverseList1(ListNode head) {
		// is there something to reverse?
		if (head != null && head.next != null) {
			ListNode pivot = head;
			ListNode frontier = null;
			while (pivot != null && pivot.next != null) {
				frontier = pivot.next;
				pivot.next = pivot.next.next;
				frontier.next = head;
				head = frontier;
			}
		}

		return head;
	}

	public ListNode reverseList2(ListNode head) {
		ListNode curr = null;
		ListNode temp = head;
		ListNode prev = null;
		while (temp != null) {
			prev = curr;
			curr = temp;
			temp = curr.next;
			curr.next = prev;
		}
		return curr;
	}

	public ListNode reverseList3(ListNode head) {
		if (head == null)
			return null;

		ListNode next = head.next;

		// Used to set next of root to null. It will get overridden by
		// "next.next = head" in the method that
		// called this one if "head" is not root
		head.next = null;

		if (next != null) {
			ListNode root = reverseList3(next);
			next.next = head;
			return root;
		}

		return head;
	}

	public ListNode reverseList4(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode root = reverseList4(head.next);

		head.next.next = head;
		head.next = null;
		return root;
	}

}
