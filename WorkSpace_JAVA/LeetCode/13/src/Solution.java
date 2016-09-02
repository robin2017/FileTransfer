public class Solution {
	public static void main(String[] args){
		System.out.print(new Solution().romanToInt("MCMXCVI"));
	}
    public int romanToInt(String s) {
        int[] table=new int[256];

        int base=1000;
        
        table['I']=1;
        table['V']=5;
        table['X']=10;
        table['L']=50;
        table['C']=100;
        table['D']=500;
        table['M']=1000;
        
        int result=0;
        for(int i=0;i<s.length();i++){
             
                result+=table[s.charAt(i)];
                
                if(table[s.charAt(i)]>base)	
                	result-=2*table[s.charAt(i-1)];
                
                base=table[s.charAt(i)];
             
        }
        return result;
    }
}