package 大整数乘法;

import java.util.Scanner;

/**
 * @author  Robin
 * @date 2016年3月25日 下午10:05:33 
 * @version 1.0 
 */
public class Test {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		char[] ch1=str1.toCharArray();
		char[] ch2=str2.toCharArray();
		swapArray(ch1);
		swapArray(ch2);
		int[] arr1=new int[ch1.length];
		int[] arr2=new int[ch2.length];
		int[] arr3=new int[ch1.length+ch2.length];
		arr1=charToInt(ch1);
		arr2=charToInt(ch2);
		multity(arr1,arr2,arr3);
		swapResult(arr3);  //引用没有指定大小,错误！！！
		printResult(arr3);
	}

	private static void printResult(int[] result) {
		// TODO Auto-generated method stub
		if(result.length==2&&result[0]==0&&result[1]==0)
			System.out.println(0);
		else{
			int first=0;
			while(result[first]==0)
				first++;
			
			for(int i=first;i<result.length;i++)
					System.out.print(result[i]);
			
		}
	}

	private static void swapResult(int[] arr) {
		// TODO Auto-generated method stub
		int first=0,last=arr.length-1;
		 
		 
		int tmp;
		while(first<=last){
			tmp=arr[first];
			arr[first]=arr[last];
			arr[last]=tmp;
			first++;
			last--;
		}
		 
	}

	private static void multity(int[] arr1, int[] arr2, int[] arr3) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr1.length;i++)
			for(int j=0;j<arr2.length;j++) 
				arr3[i+j]+=arr1[i]*arr2[j];
			 
		for(int i=0;i<arr3.length-1;i++){
			arr3[i+1]+=arr3[i]/10;
			arr3[i]=arr3[i]%10;
		}
		
	}

	private static int[] charToInt(char[] ch) {
		// TODO Auto-generated method stub
		int[] arr=new int[ch.length];
		for(int i=0;i<ch.length;i++) 
			arr[i]=ch[i]-'0';
		 
		
		return arr;
	}

	private static void swapArray(char[] arr) {
		// TODO Auto-generated method stub
		int first=0,last=arr.length-1;
		char tmp;
		while(first<=last){
			tmp=arr[first];
			arr[first]=arr[last];
			arr[last]=tmp;
			first++;
			last--;
		}
	}

}