import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Robin
 * @date 2016年4月14日 上午10:49:26
 * @version 1.0
 */

public class Solution {
	public static void main(String[] args) {
		//System.out.println(tableSizeFor(5));
		List<String> list = new ArrayList<String>();
		HashMap<String,String> hm=new HashMap<String,String>();
		hm.put("a", "a");
		hm.put("b", "b");
		hm.put("c", "a");
		hm.put("a1", "a");
		hm.put("b2", "b");
		Object o;
		Integer in=8;
		String str="12";
		System.out.println(str.hashCode());
		hm.put("c3", "a");
		hm.put("a6", "a");
		hm.put("b6", "b");
		hm.put("c6", "a");
		hm.put("a61", "a");
		hm.put("b62", "b");
		hm.put("c63", "a");
		hm.put("a9", "a");
		hm.put("b9", "b");
		hm.put("c9", "a");
		hm.put("a91", "a");
		hm.put("b92", "b");
		hm.put("c93", "a");
		hm.put("a96", "a");
		hm.put("b96", "b");
		hm.put("c96", "a");
		hm.put("a691", "a");
		hm.put("b692", "b");
		hm.put("c693", "a");
		
		int a=0;
	
		
	}
    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static int MAXIMUM_CAPACITY=1<<30;
	public List<String> solveNQueens(int n) {
		List<String> list = new ArrayList<String>();

		return list;
	}
	
}
