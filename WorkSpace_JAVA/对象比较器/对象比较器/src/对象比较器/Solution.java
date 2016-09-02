package 对象比较器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Robin
 * @date 2016年4月12日 下午1:08:44
 * @version 1.0
 */
class Person implements Comparable<Person>{
	int age;
	int height;
	String name;

	Person(int age, int height) {
		this.age = age;
		this.height = height;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return o.height-height;
	}
}

public class Solution {
	public static void main(String[] args) {
		Person p1 = new Person(21, 167);
		Person p2 = new Person(22, 180);
		Person p3 = new Person(23, 165);
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list);
		int a=0;
	}
}
