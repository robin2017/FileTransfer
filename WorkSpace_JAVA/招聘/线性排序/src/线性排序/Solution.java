package 线性排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author  Robin
 * @date 2016年4月9日 下午4:12:08 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		//System.out.println(indexHash(14,93,3,88));
		//System.out.println(getRadixValue(1234,0));
		int[] arr=new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39};
		bucketSort(arr,3); //9个数，三个桶
		//int[] result=stableCountSort(arr);
		int a=9;
	}
	private static int[] unstableCountSort(int[] arr){ //不稳定的计数排序
		int[] result=new int[arr.length];
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			min=min<arr[i]?min:arr[i];
			max=max>arr[i]?max:arr[i];
		}
		int[] count=new int[max-min+1];
	
		for(int i=0;i<arr.length;i++)
			count[arr[i]-min]++;
		int index=0;
		for(int i=min;i<=max;i++)
			while(--count[i-min]>=0)
				result[index++]=i;
		return result;
	}
	private static int[] stableCountSort(int[] arr){
		int[] result=new int[arr.length];
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			min=min<arr[i]?min:arr[i];
			max=max>arr[i]?max:arr[i];
		}
		int[] count=new int[max-min+1];
		for(int i=0;i<arr.length;i++)  //统计个数
			count[arr[i]-min]++;
		for(int i=1;i<=max-min;i++) //统计顺序
			count[i]=count[i]+count[i-1];
		for(int i=arr.length-1;i>=0;i--){
			result[count[arr[i]-min]-1]=arr[i];  //此处有-1，-min
			count[arr[i]-min]--;
		}
		return result;
	}
	private static void radixSort(int[] arr){ //基数排序,不用返回！
		HashMap<Integer,Queue<Integer>> hm=new HashMap<Integer,Queue<Integer>>();
		for(int i=0;i<10;i++)
			hm.put(i, new LinkedList<Integer>()); //指定Queue为链表！！
		int radix=0;
		for(int i=0;i<arr.length;i++)
			radix=radix>=getRadix(arr[i])?radix:getRadix(arr[i]);
		for(int i=1;i<=radix;i++){
			for(int j=0;j<arr.length;j++)
				hm.get(getRadixValue(arr[j],i)).offer(arr[j]);
			int index=0;
			//遍历HashMap中的Queue ***********************
			Iterator<Integer> it=hm.keySet().iterator();
			while(it.hasNext()){
				Queue<Integer> qu=hm.get(it.next());
				while(!qu.isEmpty())
					arr[index++]=qu.poll();
			}
		}
	}
	private static int getRadix(int num){//得到位数
		int result=1;
		while((num/=10)!=0)
			result+=1;
		return result;
	}
	private static int getRadixValue(int num,int radix){//得到位数的值
		if(radix<1)
			return 0;
		while(radix--!=1)
			num/=10;
		return num%10;
	}
	
	private static void bucketSort(int[] arr,int number){
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			min=min<arr[i]?min:arr[i];
			max=max>arr[i]?max:arr[i];
		}
		HashMap<Integer,Queue<Integer>> hm=new HashMap<Integer,Queue<Integer>>();
		for(int i=0;i<number;i++)
			hm.put(i, new LinkedList<Integer>()); //指定Queue为链表
		for(int i=0;i<arr.length;i++)
			hm.get(indexHash(min,max,number,arr[i])).offer(arr[i]);
		//对每个链表进行排序（算法导论推荐插入排序，我使用Arrays.sort）
		int index=0;
		for(int i=0;i<number;i++){
			Queue<Integer> qu=hm.get(i);
			int[] ar=new int[qu.size()];
			int ind=0;
			while(!qu.isEmpty())
				ar[ind++]=qu.poll();
			Arrays.sort(ar);
			for(int j=0;j<ar.length;j++)
				arr[index++]=ar[j];
		}
	}
	private static int indexHash(int min,int max,int number,int value){
		int result;
		if(value<min||value>max)
			return -1;
		int length=max-min+1;
		int period=length/number;
		result= (value-min)/period;
		return result==number?result-1:result;
	}
}
