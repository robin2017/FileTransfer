/**
 * @author  Robin
 * @date 2016年4月9日 下午3:00:49 
 * @version 1.0 
 */
public class Solution {
	public static void main(String[] args){
		int[] arr1=new int[]{2};
		int[] arr2=new int[]{3};
		System.out.println(new Solution().findMedianSortedArrays(arr1,arr2));
	}
	
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int ind=0;
        for(int i=0;i<nums1.length;i++)
            arr[ind++]=nums1[i];
   
        for(int i=0;i<nums2.length;i++)
            arr[ind++]=nums2[i];
            
        int midIndex1=(nums1.length+nums2.length-1)/2;
        int midIndex2=(nums1.length+nums2.length)/2;
        double midValue1=0,midValue2=0;
        
        
        int start=0,end=arr.length-1;
        
        while(start<=end){
            int index=partition(arr,start,end);
            if(index==midIndex1){
                midValue1= (double)arr[midIndex1];
                break;
            }
            else if(index<midIndex1){
                start=index+1;
            }else{
                end=index-1;
            }
        }
        
        
        if(arr.length%2==1)
            return midValue1;
        else{
        int minv=Integer.MAX_VALUE;  
        for(int i=midIndex1+1;i<arr.length;i++)
            minv=minv>arr[i]?arr[i]:minv;
            
        
         return (midValue1+minv)/2.0;   
        }
            
    }
    private int partition(int[] arr,int start,int end){
        int key=arr[end];
        int lower=start-1;
        for(int i=start;i<end;i++){
            if(arr[i]<key){
                lower++;
                swap(arr,i,lower);
            }
        }
        swap(arr,++lower,end);
        return lower;
    }
    
    private void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}