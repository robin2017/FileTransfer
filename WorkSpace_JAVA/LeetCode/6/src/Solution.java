/**
 * @author  Robin
 * @date 2016年3月26日 上午10:25:26 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		System.out.println(new Solution().convert("ab", 1));
	}
    public String convert(String s, int numRows) {
    	int length=s.length();
    	int numLines=length/2+1;
    	char[][] arr=new char[numRows][numLines];
    	boolean down=true;
    	
    	int row=0,line=0;
    	for(int i=0;i<s.length();i++){
    		arr[row][line]=s.charAt(i);
    		if(down){
    			if(row+1<numRows)
    				row++;
    			else{  //转
    				down=false;
    				row--;
    				line++;
    			}
    		}else{
    			if(row-1>=0){
    				row--;
    				line++;
    			}else{//转
    				down=true;
    				row++;
    			}
    		}
    	}
    	
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<numRows;i++)
    		for(int j=0;j<numLines;j++) 
    			if(arr[i][j]!=0)
    				sb.append(arr[i][j]);
    		
    	
		return sb.toString();
        
    }
}