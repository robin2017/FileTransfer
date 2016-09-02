package 循环打印矩阵;
/**
 * @author  Robin
 * @date 2016年4月4日 下午8:06:18 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		new Solution().PrintN(2);
	}
	public static void PrintN(int n){
		int state=1;
		int times=n*n;
		int xStart=0,yStart=0,xEnd=n,yEnd=n;
		int[][] arr=new int[n][n];
		final int NUM=n*n+1;
		int i=0,j=0;
		boolean isRun=true;
		while(isRun){
			if(times<=0)
				isRun=false;
			switch(state){
			case 1:{
				for(;j<yEnd;j++){
					arr[i][j]=NUM-times;
					times--;
				}
				j--;
				i++;
				state++;
				xStart++;
			}
				break;
			case 2:{
				for(;i<xEnd;i++){
					arr[i][j]=NUM-times;
					times--;
				}
				i--;
				j--;
				state++;
				yEnd--;
			}
			
				break;
			case 3:{
				for(;j>=yStart;j--){
					arr[i][j]=NUM-times;
					times--;
				}
				j++;
				i--;
				state++;
				xEnd--;
			}
				break;
			case 4:{
				for(;i>=xStart;i--){
					arr[i][j]=NUM-times;
					times--;
					
				}
				i++;
				j++;
				state++;
				yStart++;
			}
				break;
			case 5:state=1;
				break;
			}
		}
		
		for(int ii=0;ii<n;ii++){
			for(int jj=0;jj<n;jj++){
				System.out.print(arr[ii][jj]+" ");
			}
			System.out.println();
		}
		
	}
}
