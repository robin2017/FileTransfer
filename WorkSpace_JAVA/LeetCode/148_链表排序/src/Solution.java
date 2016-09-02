/**
 * @author  Robin
 * @date 2016年4月18日 下午2:40:17 
 * @version 1.0 
 */
class ListNode {
       int val;
      ListNode next;
       ListNode(int x) { val = x; }
  }
public class Solution {
	public static void main(String[] args){
		ListNode head=new ListNode(7);
		ListNode h2=new ListNode(6);
		ListNode h3=new ListNode(5);
		ListNode h4=new ListNode(4);
		ListNode h5=new ListNode(3);
		ListNode h6=new ListNode(2);
		ListNode h7=new ListNode(1);
		head.next=h2;
		h2.next=h3;
		h3.next=h4;
	/*	h4.next=h5;
		h5.next=h6;
		h6.next=h7;*/
		ListNode result=sortList(head);
	}
	public static ListNode sortList(ListNode head) {
	    if (head == null || head.next == null) return head;

	    //Use two runners to break list into two halfs.
	    ListNode fast = head, slow = head, prev = null;
	    while (fast != null && fast.next != null) {
	        prev = slow;
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    ListNode second = prev.next;
	    prev.next = null;
	    //sort each half
	    ListNode first = sortList(head);
	    second = sortList(second);
	    //merge them.
	    head = mergeList(first, second);
	    return head;
	}

	private static ListNode mergeList(ListNode first, ListNode second) {
	    ListNode dummy = new ListNode(0), merged = dummy;
	    while (first != null && second != null) {
	        if (first.val <= second.val) {
	            merged.next = first;
	            merged = merged.next;
	            first = first.next;
	        } else {
	            merged.next = second;
	            merged = merged.next;
	            second = second.next;
	        }
	    }
	    if (first != null || second != null)
	        merged.next = (first != null)? first :second;

	    return dummy.next;
	}
}
