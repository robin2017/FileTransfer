/**
 * @author  Robin
 * @date 2016年3月31日 上午9:28:57 
 * @version 1.0 
 */


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Solution {
	public static void main(String[] args){
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		
		new Solution().swapPairs(n1);
	}
	
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode result=head.next,start=head,mid=start.next,end=mid.next,pre=mid;
        while(start!=null&&start.next!=null){
            mid=start;
            start=start.next;
            start.next=mid;
            mid.next=end;
            pre.next=start;
            //------
            start=end;
            mid=start!=null?start.next:null;
            end=mid!=null?mid.next:null;
            pre=mid;
        }
        return result;
    }
}