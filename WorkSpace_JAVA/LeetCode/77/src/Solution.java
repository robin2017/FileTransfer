import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author  Robin
 * @date 2016年4月13日 下午8:26:05 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		Stack<Integer> sta;
		 
		list=combine(4,2);
	}
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        	arr[i]=i+1;
        combination(0,k,arr,new ArrayList(),list);
        return list;
    }
    private static void combination(int start,int num,int[] arr,List<Integer> li,List<List<Integer>> list){
    	if(num==0){
    		List<Integer> copy=new ArrayList<Integer>();
    		copy.addAll(li);
    		list.add(copy);
    		return;
    	}
    	if(start==arr.length)
    		return;
    	li.add(arr[start]);
    	combination(start+1,num-1,arr,li,list);
     
    	li.remove(li.size()-1);
    	combination(start+1,num,arr,li,list);
    	
    		
    }
}