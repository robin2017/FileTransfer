/**
 * @author  Robin
 * @date 2016年4月18日 下午3:39:50 
 * @version 1.0 
 */

  class ListNode {
      int val;
      ListNode next;
       ListNode(int x) {
          val = x;
          next = null;
      }
   }
 
public class Solution {
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode h=new ListNode(2);
		head.next=h;
		h.next=head;
		ListNode result=detectCycle(head);
	}
    public static ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode fast=head,slow=head;
        while(true){
            if(fast.next==null||fast.next.next==null)
                return null;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                break;
        }
        int length=0;
        while(true){
            fast=fast.next.next;
            slow=slow.next;
            length++;
            if(fast==slow)
                break;
        }
        slow=head;
        fast=head;
        while(length-->0)
            fast=fast.next;
        if(fast==slow)
        	return fast;
        while(true){
            fast=fast.next;
            slow=slow.next;
            if(fast==slow)
                return fast;
        }
    }
}