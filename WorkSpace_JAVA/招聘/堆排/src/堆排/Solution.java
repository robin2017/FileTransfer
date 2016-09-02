package 堆排;
public class Solution{
	public static void main(String[] args){
		int[] arr=new int[]{4,1,3,2,16,9,10,14,8,7};
		maxHeapSort(arr,10);
		int a=0;
	}
	
	//O(nlgn)
	private static void maxHeapSort(int[] arr,int length){ //由于输入需要length，则底层函数都要带length参数
		buildMaxHeap(arr,length);
		for(int i=length-1;i>0;i--){//i==0不用管，
			swap(arr,0,i);  //数组头尾互换
			length--;
			maxHeapify(arr,length,0); //只需维护根节点
		}
	}
	//貌似O(nlgn)，实际为O(n)
	private static void buildMaxHeap(int[] arr,int length){
		for(int i=length/2-1;i>=0;i--){  //一半为叶子节点，不用管
			maxHeapify(arr,length,i);
		}
	}
	//O(lgn)
	private static void  maxHeapify(int[] arr,int length,int i){//最大堆的维护，假设下标i的元素不满足性质
		int l=left(i);
		int r=right(i);
		int largest=i;
		if(l<length&&arr[l]>arr[largest])
			largest=l;
		if(r<length&&arr[r]>arr[largest])
			largest=r;
		if(largest!=i){
			swap(arr,i,largest);
			maxHeapify(arr,length,largest);
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	private static int parent(int i){
		return (i-1)/2;
	}
	private static int left(int i){
		return 2*i+1;
	}
	private static int right(int i){
		return 2*i+2;
	}
}