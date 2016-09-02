package 其他排序;
/**
 * @author  Robin
 * @date 2016年4月6日 下午7:44:56 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		int[] arr=new int[]{3,8,6,4,9,1,2,5,7};
		mergeSort(arr,0,8);
		bubbleSort(arr);
		
		int a=0;
		
	}
	private static void selectSort(int[] arr){  //系数3
		//选最小与第一个交换，次小于第二个交换
		int minIndex;
		for(int i=0;i<arr.length;i++){
			minIndex=i;
			for(int j=i;j<arr.length;j++){
				if(arr[j]<arr[minIndex])
					minIndex=j;
			}
			if(i!=minIndex)  //类似于堆排的maxHeapify
				swap(arr,i,minIndex);
		}
	}
	private static void insertSort(int[] arr){  //系数4
		//将每个元素插入前面已排好序的数组中
		for(int i=1,j;i<arr.length;i++){ //第一个元素已排序
			int key=arr[i];
			for(j=i;j>0&&arr[j-1]>key;j--)  
				arr[j]=arr[j-1];//右移
			arr[j]=key;
		}
	}
	private static void bubbleSort(int[] arr){ //系数2
		//相邻比较，一轮下来最大在最后
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length-1-i;j++)
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
	}
	private static void mergeSort(int[] arr,int start,int end){
		if(start<end){
			int mid=(start+end)/2;
			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
	}
	
	private static void merge(int[] arr,int start,int mid,int end){
		//将两个已排序的arr[start,mid],arr[mid+1,end]合并
		//必须开辟两个新的数组，空间复杂度为O(n)
		//为了防止检测两个堆是否为空，设置了哨兵Integer.MAX_VALUE   ************
		int[] arr1=new int[mid-start+2];
		int index1=0;
		for(int i=start;i<=mid;i++)
			arr1[index1++]=arr[i];
		arr1[index1]=Integer.MAX_VALUE;
		
		int[] arr2=new int[end-mid+1];
		int index2=0;
		for(int i=mid+1;i<=end;i++)
			arr2[index2++]=arr[i];
		arr2[index2]=Integer.MAX_VALUE;
		 
		index1=0;index2=0;
		for(int i=0;i<end-start+1;i++){
			if(arr1[index1]<arr2[index2])
				arr[start+i]=arr1[index1++];
			else
				arr[start+i]=arr2[index2++];
		}
	}
	
	
	private static void swap(int[] arr,int i,int j){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
