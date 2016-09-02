/**
 * @author  Robin
 * @date 2016年3月30日 下午8:35:26 
 * @version 1.0 
 */
  class ListNode {
	   int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
public class Solution {
	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		head.next=node2;
		node2.next=node3;
		node3.next=node4;
		int n=2;
		
		ListNode result=new ListNode(0);
	    result=new Solution().removeNthFromEnd(head, n);
	    
	    int a=9;
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode voidHead = new ListNode(-1);
	    voidHead.next = head;
	    ListNode p1 = voidHead;
	    ListNode p2 = voidHead;
	    while (p1.next!=null){
	        p1=p1.next;
	        if (n--<=0)p2=p2.next;
	    }
	    if (p2.next!=null) p2.next=p2.next.next;
	    return voidHead.next;
	}
	
	
    public ListNode removeNthFromEnd1(ListNode head, int n) {
       ListNode fast=new ListNode(0);
       ListNode slow=fast;
       fast.next=head; //此时slow的next也是head
       while(n-->1)
            fast=fast.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        return slow;
 
    }
    
    
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode start=new ListNode(0),slow=start,fast=start;
        start.next=head;
        for(int i=0;i<n;i++) fast=fast.next;
        while(fast.next!=null) {fast=fast.next;slow=slow.next;}
        slow.next=slow.next.next;
        return start.next;
    }
}