package 快排;
/**
 * @author  Robin
 * @date 2016年4月6日 上午9:44:29 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		int[] arr=new int[]{2,8,7,1,3,5,6,4};
		quickSort(arr,0,8);
		int a=0;
	}
	private static void quickSort(int[] arr,int start,int end){
		if(start<0||end>=arr.length){
			System.out.println("invalid input");
			return;
		}
		if(start<end){
			int re=partition(arr,start,end);
			quickSort(arr,start,re-1);
			quickSort(arr,re+1,end);
		}
	}
	private static int partition(int[] arr,int start,int end){
		int key=arr[end]; //最后一个做主元
		int low=start-1; 
		for(int i=start;i<end;i++){
			if(arr[i]<key){
				low++;
				swap(arr,i,low);
			}
		}
		int mid=low+1; //不是low++;
		swap(arr,mid,end); //此时的low不是小于，而是主元
		return mid;
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
