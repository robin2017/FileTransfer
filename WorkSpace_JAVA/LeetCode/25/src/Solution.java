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
		ListNode h5=new ListNode(5);
		ListNode h6=new ListNode(6);
		
		head.next=h2;
		h2.next=h3;
		h3.next=h4;
		h4.next=h5;
	 
		ListNode result=reverseKGroup(head,3);
		
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode voidHead = new ListNode(0);
		ListNode resultHead = voidHead;
		voidHead.next = head;
		int times;
		boolean isDotail=false;
		while (head.next != null) {
			times = k;
			while (head.next != null && times-- > 1) {
				ListNode tmp = head.next;
				head.next = head.next.next;
				tmp.next = voidHead.next;
				voidHead.next = tmp;
			}
			if(times>1){
				isDotail=true;
				break;
			}
			times = k;
			while (times-- >= 1)
				voidHead = voidHead.next;
			head = voidHead.next;
			if(head==null)
				break;
		}
		if(isDotail){
			head=voidHead.next;
			while(head.next!=null){
				ListNode tmp=head.next;
				head.next=head.next.next;
				tmp.next=voidHead.next;
				voidHead.next=tmp;
			}
		}
		return resultHead.next;
	}
}