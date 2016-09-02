import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Robin
 * @date 2016年4月12日 下午1:29:37
 * @version 1.0
 */

class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> list=new ArrayList<Interval>();
		list.add(new Interval(1,3));
		list.add(new Interval(2,6));
		list.add(new Interval(8,10));
		list.add(new Interval(15,18));
		merge(list);
	}
	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals,new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.end-o2.end;//从小到大
			}});
		for(int i=intervals.size()-1;i>0;i--){//此处可以用size(),因为就一次
			Interval i2=intervals.get(i);
			Interval i1=intervals.get(i-1);
			if(isConnect(i1,i2)){
				i1.start=i1.start<i2.start?i1.start:i2.start;
				i1.end=i2.end;
				intervals.remove(i);
			}
				
		}
		return intervals;
	}
	private static boolean isConnect(Interval i1,Interval i2){
		if(i1.end>=i2.start)
			return true;
		else
			return false;
		
	}
}
