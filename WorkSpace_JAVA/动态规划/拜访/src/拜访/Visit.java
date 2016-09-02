package 拜访;
import java.util.*;

public class Visit {
	    public static int countPath(int[][] map, int n, int m) {
	        // write code here
	        int x_from=0,y_from=0,x_to=0,y_to=0;
	        for(int i=0;i<n;i++)
	            for(int j=0;j<m;j++){
	            	if(map[i][j]==1){
	                    x_from=i;
	            		y_from=j;
	                }
	            	if(map[i][j]==2){
	                    x_to=i;
	                    y_to=j;
	                }
	        }
	        //得到两个坐标点
	        
	        boolean diction=true;
	        
	        //正常情况是x_to>x_from&&y_to>y_from
	        if(x_to>x_from&&y_to>y_from){
	        	
	        }
	        else if(x_to<x_from&&y_to<y_from){
	        	int tmp=x_to;
	        	x_to=x_from;
	        	x_from=tmp;
	        	
	        	tmp=y_to;
	        	y_to=y_from;
	        	y_from=tmp;
	        }else{
	        	x_from=x_from<x_to?x_from:x_to;//较小值
	        	x_to=x_from>x_to?x_from:x_to;
	        	y_from=y_from>y_to?y_from:y_to;
	        	y_to=y_from<y_to?y_from:y_to;
	        	diction=false;
	        }
 
	        if(diction){
	        	  for(int i=x_from;i<=x_to;i++)
	        	     if(map[i][y_from]!=-1)	
	        		  map[i][y_from]=1;
	        	   for(int i=y_from;i<=y_to;i++)
	        		   if(map[x_from][i]!=-1)
	        	     	map[x_from][i]=1;
	        	   
	        	     for(int i=x_from+1;i<=x_to;i++)
	        	    	 for(int j=y_from+1;j<=y_to;j++) 
	        	    		 if(map[i][j]!=-1){
	        		    		 if(map[i-1][j]>0&&map[i][j-1]>0)
	        		    			 map[i][j]=map[i-1][j]+map[i][j-1];
	        		    		 else if(map[i-1][j]==-1) 
	        		    			 map[i][j]=map[i][j-1];
	        		    		 else
	        		    			 map[i][j]=map[i-1][j];
	        	    		 }
	        	     return map[x_to][y_to];
	        }else{
	        	return 0;
	        }
	        
	        
	    }
 
    public static void main(String[] args){
    	int[][] arr={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,2}};
    	System.out.println(countPath(arr,7,5));
    }
}