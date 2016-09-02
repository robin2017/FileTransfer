/**
 * @author  Robin
 * @date 2016年4月13日 下午10:47:16 
 * @version 1.0 
 */
  class ListNode {
    int val;
     ListNode next;
   ListNode(int x) { val = x; }
  }
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(3);
		ListNode h2=new ListNode(5);
		head.next=h2;
		
		ListNode result=reverseBetween(head,1,2);
	}
	  public static ListNode reverseBetween(ListNode head, int m, int n) {
	        if(m==n||head==null)
	            return head;
	        ListNode voidHead=new ListNode(0);
	        voidHead.next=head;
	        ListNode pre=voidHead;
	        int step=m;
	        while(step-->1)
	            pre=pre.next;
	        head=pre.next;
	        int length=n-m;
	        ListNode tail=head;
	        while(length-->=1)
	            tail=tail.next;
	        ListNode next=tail.next;
	        tail.next=null;
	        
	        pre.next=reverseList(head);
	        head.next=next;
	        
	        return voidHead.next;
	        
	        
	        
	    }
	    
	      public static ListNode reverseList(ListNode head) {
	        if(head==null)
	            return null;
	        ListNode voidHead=new ListNode(0);
	        voidHead.next=head;
	        
	        while(head.next!=null){
	            ListNode tmp=head.next;
	            head.next=head.next.next;
	            
	            tmp.next=voidHead.next;
	            voidHead.next=tmp;
	        }
	        return voidHead.next;
	    }
}
