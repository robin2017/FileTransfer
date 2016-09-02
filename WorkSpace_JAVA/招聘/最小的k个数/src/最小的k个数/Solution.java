package 最小的k个数;
/**
 * @author  Robin
 * @date 2016年4月6日 上午9:32:30 
 * @version 1.0 
 */


//用快排的思想得到的是O(nlogn)(不动原来数组),而用最好的思想得到是O(n)(改动原来数组)
public class Solution {
	public static void main(String[] args){
		int[] arr=new int[]{4,5,1,6,2,7,3,8};
		int k=4;
		getMinK(arr,4);
		int i=0;
	}
	private static void getMinK(int[] arr,int k){
		int start=0,end=arr.length-1;
		int index=partition(arr,start,end);
		while(index!=k-1){
			if(index<k-1){
				index=partition(arr,index+1,end);
			}else{
				index=partition(arr,start,index-1);
			}
		}
	}
	
	private static int partition(int[] arr,int start,int end){
		int key=arr[end];
		int low=start-1;
		for(int i=start;i<end;i++){
			if(arr[i]<key){
				low++;
				swap(arr,i,low);
			}
		}
		swap(arr,++low,end);
		return low;
	}
	private static void swap(int[] arr, int i, int low) {
		// TODO Auto-generated method stub
		int tmp=arr[i];
		arr[i]=arr[low];
		arr[low]=tmp;
	}
}
