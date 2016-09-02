package 第一个只出现一次的字符;
/**
 * @author  Robin
 * @date 2016年3月23日 下午7:20:39 
 * @version 1.0 
 */

public class Test {
	public static void main(String[] args){
		String str="abaccdeff";
		System.out.println(getFirstOnce(str));
	}
	
	private static char getFirstOnce(String str){
		char[] arr=str.toCharArray();
		int[] times=new int[256];
		 
		
		for(int i=0;i<arr.length;i++)
			times[arr[i]]++;
		
		for(int i=0;i<arr.length;i++)
			if(times[arr[i]]==1)
				return arr[i];
		
		return ' ';
	}

}
