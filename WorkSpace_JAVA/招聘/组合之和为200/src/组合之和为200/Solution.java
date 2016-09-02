package 组合之和为200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author  Robin
 * @date 2016年4月9日 上午8:47:43 
 * @version 1.0 
 */

public class Solution {
	public static int cnt=0;
	public static void main(String[] args){
		int[] nums=new int[100];
		for(int i=0;i<100;i++)
			nums[i]=i+1;
		combinationSum(nums,200);
	}
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		DFS(list,new ArrayList<Integer>(),0,nums,target);
		return list;
	}
	private static void DFS(List<List<Integer>> list,ArrayList<Integer> l,int start,int[] nums,int targ){
		if(targ==0){
			cnt++;
			if(cnt%1000000==0){
			System.out.print(cnt/1000000+"(百万)--->");
			//list.add((ArrayList<Integer>) l.clone());//不能为原来的，否者会变化，要用复制版本
			for(Integer i:l)
				System.out.print(i+" ");
			System.out.println();
			}
		}
		else if(targ<0)
			return;
		else{//targ>0
			for(int i=start+1;i<nums.length;i++){
				l.add(nums[i]);
				DFS(list,l,i,nums,targ-nums[i]);  //这里的第三个参数不是start，否者结果会有重复
				l.remove(l.size()-1);//消除前面的影响！！！
			}
		}
	}
	
	public static void mySolution(){
		int cnt=1;
		int[] arr=new int[100];
		int num=1;
		for(int i=0;i<100;i++)
			arr[i]=num++;
		int sum=0;
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		Stack<Integer> sta=new Stack<Integer>();
		int index=99;
		boolean isRun=true;
		while(isRun){
			for(int i=index;i>=0;i--){
				if(sum+arr[i]<200){
					sta.push(arr[i]);
					sum+=arr[i];
				}
				else if(sum+arr[i]==200){
					Stack<Integer> ss=(Stack<Integer>) sta.clone();
					ArrayList<Integer> l=new ArrayList<Integer>();
					l.add(arr[i]);
					System.out.print(cnt+++"--->");
					System.out.print(arr[i]);
					while(!ss.empty()){
						System.out.print(" "+ss.peek());
						l.add(ss.pop());
					}
					//list.add(l);
					System.out.println();
				}	
			}
			do{
			sum-=sta.peek();
			index=sta.pop()-2;
			}while(index<0);
			sta.push(arr[index]);
			sum+=arr[index];
			index--;
			if(sta.empty()){
				isRun=false;
				break;
			}
		}
	}
	
}
