package 逆波兰;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author  Robin
 * @date 2016年4月10日 下午4:14:07 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args) throws Exception{
		String str=new String("9-2*4");
		//System.out.println(new Solution().midToPost(str));
		String postString=new Solution().midToPost(str);
		System.out.println(postString);
		System.out.println(calcute(postString));
	}
	private static double calcute_YTY(String[] arr){
		//杨天宇版本，直接撸，
		//两个栈，一个为数字栈，一个为符号栈
		//基本规则：符号比栈顶的符号优先级大，则先处理优先级大的！！
		//默认输入都是符合规矩的，所以只判断是不是符号
		Stack<Double> number=new Stack<Double>();
		Stack<String> symbol=new Stack<String>();
		for(int i=0;i<arr.length;i++){
			if(!isSymbol(arr[i]))//数字
				number.push(getValue(arr[i]));
			else{//符号
			//四种情况：空栈，左括号，右括号，比较优先级
				if(symbol.isEmpty())
					symbol.push(arr[i]);
				else if(arr[i].equals("("))
					symbol.push(arr[i]);
				else if(arr[i].equals(")")){
					while(!symbol.peek().equals("("))
						handle(number,symbol);
					symbol.pop();
				}else{//比较优先级
					if(getPriority(arr[i])>getPriority(symbol.peek()))
						symbol.push(arr[i]);
					else{
						while(!symbol.isEmpty()&&getPriority(arr[i])<=getPriority(symbol.peek()))
							handle(number,symbol);
						symbol.push(arr[i]);
					}
				}		
			}
		}
		while(!symbol.isEmpty())
			handle(number,symbol);
		return number.pop();
	}
 
	private static void handle(Stack<Double> number, Stack<String> symbol) {
		// TODO Auto-generated method stub
		String sym=symbol.pop();
		double num2=number.pop();
		double num1=number.pop();
		double result=0;
		if(sym.equals("+"))
			result=num1+num2;
		else if(sym.equals("-"))
			result=num1-num2;
		else if(sym.equals("*"))
			result=num1*num2;
		else if(sym.equals("/"))
			result=num1/num2;
		number.push(result);
	}
	private static boolean isSymbol(String str){
		if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")||str.equals("(")||str.equals(")"))
			return true;
		else
			return false;
	}
	private static double getValue(String str){
		double value=0;
		int base=1;
		for(int i=str.length()-1;i>=0;i--){
			value+=base*(str.charAt(i)-'0');
			base*=10;
		}
		return value;
	}
	private static int getPriority(String str){
		if(str.equals("+")||str.equals("-"))
			return 1;
		else if(str.equals("*")||str.equals("/"))
			return 2;
		else 
			return 0;
	}
	
	
	
	
	
	
	
	
	
	private static int calcute(String str) throws Exception{  
		//这里只能做一位运算，因为所有元素都是char表示，若多位表示，则用String表示
		int result=0;
		char[] arr=str.toCharArray();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<arr.length;i++){
			if(getType(arr[i])==1)
				stack.push(arr[i]);
			else if(getType(arr[i])==2){
				int num2=stack.pop()-'0';
				int num1=stack.pop()-'0';
				int re;
				if(arr[i]=='+')
					re=num1+num2;
				else if(arr[i]=='-')
					re=num1-num2;
				else if(arr[i]=='*')
					re=num1*num2;
				else if(arr[i]=='/')
					re=num1/num2;
				else
					throw new Exception("错误2");
				stack.push((char)(re+'0'));
			}else
				throw new Exception("错误");
		}
		return stack.pop()-'0';
	}
	private static String midToPost(String mid) throws Exception{
		char[] arr=mid.toCharArray();
		List<Character> list=new ArrayList<Character>();
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<arr.length;i++){
			System.out.println("读到第"+i+"个数："+arr[i]);
			switch(getType(arr[i])){
			case 1:
				list.add(arr[i]);
				break;
			case 2:
				if(stack.isEmpty())
					stack.push(arr[i]);
				else if(getPriority(arr[i])>getPriority(stack.peek()))
					stack.push(arr[i]);
				else{
					list.add(stack.pop());
					i--; //与下一个栈顶比较
				}
				break;
			case 3:
				if(arr[i]=='(')
					stack.push(arr[i]);
				else{
					while(stack.peek()!='(')
						list.add(stack.pop());
					stack.pop();
				}
				break;
			case 0:
					throw new Exception("非法输入！！");
			}
		}
		//将stack中弹出到list
		while(!stack.isEmpty())
			list.add(stack.pop());
		char[] re=new char[list.size()];
		for(int i=0;i<re.length;i++)
			re[i]=list.get(i);
		return new String(re);
	}
	private static int getPriority(char c){
		if(c=='+'||c=='-')
			return 1;
		else if(c=='*'||c=='/')
			return 2;
		else
			return 0;
	}
	private static int getType(char c){//数字为1，运算符为2，括号为3，其他为0
		if(Character.isDigit(c)||Character.isLetter(c))
			return 1;
		else if(c=='+'||c=='-'||c=='*'||c=='/')
			return 2;
		else if(c=='('||c==')')
			return 3;
		else 
			return 0;
	}
}
