/**
 * @author  Robin
 * @date 2016年3月25日 下午4:40:04 
 * @version 1.0 
 */
 class ListNode {
   int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

public class Solution {
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		    int sum=1,add=0,fac1=0,fac2=0;
	        ListNode head=null;
	        ListNode pre=null;
	        boolean first=true;
	        
	        boolean suc=true;
	        while(suc){
	            fac1=l1!=null?l1.val:0;
	            fac2=l2!=null?l2.val:0;
	            sum=fac1+fac2+add;
	            add=sum/10;
	            sum=sum%10;
	            
	            if(add==0&&sum==0&&!first){
	                suc=false;
	            }else{
	                ListNode node=new ListNode(sum);
	                if(first){
	                    head=node;
	                    pre=node;
	                    first=false;
	                }else{
	                    pre.next=node;
	                    pre=node;
	                }
	                
	                l1=l1!=null?l1.next:null;
	                l2=l2!=null?l2.next:null;
	            }
	            
	        }
	        return head;
	        
	    }
	 public static void main(String[] args){
		 ListNode l1=new ListNode(1);
		 ListNode l2=new ListNode(9);
		 ListNode node=new ListNode(9);
		 l2.next=node;
		 ListNode result=addTwoNumbers(l1,l2);
		 System.out.println(result.val);
	 }
}
