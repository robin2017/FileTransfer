package hashCode_equal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author  Robin
 * @date 2016年4月15日 下午4:00:33 
 * @version 1.0 
 */
class People{
    private String name;
    private int age;
    
    public People(String name,int age) {
        this.name = name;
        this.age = age;
    }   
    
    public void setAge(int age){
        this.age = age;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.name.equals(((People)obj).name) && this.age== ((People)obj).age;
    }
    public int hashCode() {
        // TODO Auto-generated method stub
        return name.hashCode()*37+age;
    }
}

 
public class Solution {
	   public static void main(String[] args) {
		   Vector v;
		   CopyOnWriteArrayList vco;
		   ArrayList list;
		  // test1();
		  // test2();
		   test3();
		 
		   
		   

	    }
	   private static void test1(){
		   People pp=new People("robin",24);
		   People ppp=new People("robin",24);
		   System.out.println("--->"+pp.hashCode());
		   
		   System.out.println("--->"+ppp.hashCode());
	   }
	   private static void test2(){
	        People p1 = new People("Jack", 12);
	        System.out.println(p1.hashCode());
	        HashMap<People, Integer> hashMap = new HashMap<People, Integer>();//这里的键是一个对象
	        hashMap.put(p1, 1); 
	        System.out.println(hashMap.get(new People("Jack", 12))); //这里的键equal，但是不==，正常情况下，hashCode应该一样，但是没有定义

	   }
	   private static void test3(){
		    People p1 = new People("Jack", 12);
	        System.out.println(p1.hashCode());
	        HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
	        hashMap.put(p1, 1);
	        p1.setAge(13);
	        System.out.println(hashMap.get(p1));
	   }
}
