package 网易游戏_3;

import java.util.Scanner;

/**
 * @author  Robin
 * @date 2016年4月21日 下午7:22:14 
 * @version 1.0 
 */

public class PreSolution {
	public static void main(String[] args){
		char[][] arr=new char[][]{{'.','D','.','M','.'},{'.','D','C','A','E'},{'.','A','A','A','B'},{'M','D','D','A','M'}};
		getNumber(arr);
	}
	private static int getNumber(char[][] arr){
		char spe='*';
		int n=arr.length;
		int m=arr[0].length;
		int[][] copy=new int[n][m];
		for(int i=0;i<n;i++){//逐行处理
			int start=0,end=0;
			int recordStart=-1,recordEnd=-1;
			boolean hasCancel=false;
			while(end<m){//每行只有一次 
				 if(arr[i][start]==arr[i][end]){
					 
					 if(end-start==2){
						 recordStart=start;
						 recordEnd=end;
						 hasCancel=true;
						 break;
					 }
					 end++;
				 }else{
					 
					 start=end;
				 }
			}
			while(hasCancel&&recordEnd<m-1&&arr[i][recordEnd]==arr[i][recordStart])
				recordEnd++;
			if(recordEnd!=m-1)
				recordEnd--;
			while(hasCancel&&arr[i][recordStart]!='.'&&recordStart<=recordEnd)
				copy[i][recordStart++]=1;
		}
		
		int a=9;
		a=8;
		
		for(int j=0;j<m;j++){//逐列处理
			int start=0,end=0;
			int recordStart=-1,recordEnd=-1;
			boolean hasCancel=false;
			while(end<n){//每行只有一次 
				 if(arr[start][j]==arr[end][j]){
				
					 if(end-start==2){
						 recordStart=start;
						 recordEnd=end;
						 hasCancel=true;
						 break;
					 }
					 end++;
				 }else{
					 
					 start=end;
				 }
			}
			while(hasCancel&&recordEnd<n-1&&arr[recordEnd][j]==arr[recordStart][j])
				recordEnd++;
			if(recordEnd!=n-1)
				recordEnd--;
			while(hasCancel&&arr[recordStart][j]!='.'&&recordStart<=recordEnd)
				copy[recordStart++][j]=1;
		}

		

		return 0;
	}
}
