public class Solution {
	
	
	   public static void main(String[] args){
	    	System.out.println(longestPalindrome1("abcba"));
	    }
	   
	   
	   public static String longestPalindrome1(String s) {
		    char[] ca = s.toCharArray();
		    int rs = 0, re = 0;
		    int max = 0;
		    for(int i = 0; i < ca.length; i++) {
		        if(isPalindrome1(ca, i - max - 1, i)) {
		            rs = i - max - 1; re = i;
		            max += 2;
		        } else if(isPalindrome1(ca, i - max, i)) {
		            rs = i - max; re = i;
		            max += 1;
		        }
		    }
		    return s.substring(rs, re + 1);
		}

		private static boolean isPalindrome1(char[] ca, int s, int e) {
		    if(s < 0) return false;

		    while(s < e) {
		        if(ca[s++] != ca[e--]) return false;
		    }
		    return true;
		}
	   
	   
	   //上面是网上优化，下面是我的
	   
    public static String longestPalindrome(String s) {   //太复杂！！！！！！
    	int length=1;
    	int lastIndex=0;
    	for(int index=0;index<s.length();index++){
    		while(isPalin(s,index-length/2,index+length/2)||isPalin(s,index-length/2,index+length/2+1)||isPalin(s,index-length/2-1,index+length/2+1)){
    			if(isPalin(s,index-length/2,index+length/2)&&length%2==0){
    				length++;
    				lastIndex=index;
    			}
    			else if(isPalin(s,index-length/2,index+length/2+1)&&length%2==0){
    				length+=2;lastIndex=index;
    			}
    			else if(isPalin(s,index-length/2,index+length/2+1)&&length%2==1){
    				length+=1;lastIndex=index;}
    			else if(isPalin(s,index-length/2-1,index+length/2+1)&&length%2==1){
    				length+=2;lastIndex=index;}
    			else
    				break;
    				
    		}
    	}
    	return length%2==0?s.substring(lastIndex-length/2+1,lastIndex+length/2+1):s.substring(lastIndex-length/2, lastIndex+length/2+1);
    }
    
    private static boolean isPalin(String str,int first,int last){
    	//输入
    	if(first<0||last>=str.length())
    		return false;
        while(first<=last) 
            if(!(str.charAt(first++)==str.charAt(last--)))
                return false;
        
        return true;
    }
    
    
 
}