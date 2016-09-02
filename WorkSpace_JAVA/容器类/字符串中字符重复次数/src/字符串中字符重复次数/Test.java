package 字符串中字符重复次数;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
 

/**
 * @author  Robin
 * @date 2016年3月23日 下午4:34:10 
 * @version 1.0 
 */

public class Test {
	public static void main(String[] args){
		String str=new String("lhgdnweglkjlaskjylgkndskljfhikhngbkjas");
		
		HashMap<Character,Integer> tm=new HashMap<Character,Integer>();
		getTimes(tm,str);
		String result=getValues(tm);
		System.out.println(result);
	}

	private static String getValues(HashMap<Character, Integer> tm) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		Set<Character> keySet=tm.keySet();
		for(Iterator<Character> it=keySet.iterator();it.hasNext();){
			char key=it.next();
			int value=tm.get(key);
			sb.append(key+"("+value+")");
		}
		return sb.toString();
	}

	private static void getTimes(HashMap<Character, Integer> tm, String str) {
		// TODO Auto-generated method stub
		int cnt=0;
		char[] arr=str.toCharArray();
		for(int i=0;i<arr.length;i++){
			if(tm.get(arr[i])!=null)
				cnt=tm.get(arr[i]);
			cnt++;
			tm.put(arr[i], cnt);
			cnt=0;
		}
	}
}
