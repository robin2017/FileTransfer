public class Solution {
	public static void main(String[] args){
		String[] strs=new String[]{"abab","aba","abc"};
		System.out.println(new Solution().longestCommonPrefix(strs));
	}
	
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        char tmp;
        boolean isRun=true;
        int length=Integer.MAX_VALUE;
        
        for(int i=0;i<strs.length;i++)
            length=length>strs[i].length()?strs[i].length():length;
        
        if(length==0)
            return "";
        if(strs.length==0)
            return "";
        
        for(int i=0;i<length;i++){
            tmp=strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(tmp!=strs[j].charAt(i)){
                    isRun=false;
                    break;
                }
            }
            if(!isRun)
                break;
            sb.append(tmp);
        }
        
        return sb.toString();
        
        
    }
}