package 蘑菇阵;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[] x=new int[k];
        int[] y=new int[k];
        for(int i=0;i<k;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }
        //在没有障碍的情况下
        int[][] arr1=new int[n][m];
        //第一行第一列分别为1;
        for(int i=0;i<n;i++)
        	arr1[i][0]=1;
        for(int i=0;i<m;i++)
        	arr1[0][i]=1;
        for(int i=1;i<n;i++) 
        	for(int j=1;j<m;j++) 
        		arr1[i][j]=arr1[i-1][j]+arr1[i][j-1];
        	 
         
        
        int result1=arr1[n-1][m-1];
 
    // System.out.println(result1);
     
      //有障碍的时候
     int[][] arr2=new int[n][m];
     //第一行第一列分别为1;
     for(int i=0;i<n;i++)
     	arr2[i][0]=1;
     for(int i=0;i<m;i++)
     	arr2[0][i]=1;
     for(int i=0;i<k;i++) 
    	 arr2[x[i]-1][y[i]-1]=-1;
     for(int i=1;i<n;i++)
    	 for(int j=1;j<m;j++) 
    		 if(arr2[i][j]==0){
	    		 if(arr2[i-1][j]>0&&arr2[i][j-1]>0)
	    			 arr2[i][j]=arr2[i-1][j]+arr2[i][j-1];
	    		 else if(arr2[i-1][j]==-1) 
	    			 arr2[i][j]=arr2[i][j-1];
	    		 else
	    			 arr2[i][j]=arr2[i-1][j];
    		 }
    int result2=arr2[n-1][m-1];
   // System.out.println(result2);
   
    DecimalFormat    df   = new DecimalFormat("######0.00");  
     double d=(double)result2/result1;
    System.out.println(df.format(d));
    }
}
