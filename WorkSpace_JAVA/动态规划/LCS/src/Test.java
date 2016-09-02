/**
 * @author  Robin
 * @date 2016年3月24日 上午10:43:38 
 * @version 1.0 
 */

public class Test {
	public static String str1=new String("10010101");
	public static String str2=new String("010110110");
	public static int result[][]=new int[str1.length()+1][str2.length()+1];
	public static char solution[][]=new char[str1.length()+1][str2.length()+1];
	
	
	public static void main(String[] args){
		LCS();
		int a=0;
		println_int(result);
		println_char(solution);
		System.out.println("打印最优解：");
		printSolution(str1.length(),str2.length());
	}
	
	private static void printSolution(int i, int j) {
		// TODO Auto-generated method stub
		 
		if(i==0||j==0)
			return;
		if(solution[i][j]=='o'){
			printSolution(i-1,j-1);
			System.out.print("-->"+str1.charAt(i-1));
		}else if(solution[i][j]=='u'){
			printSolution(i-1,j);
		}else
			printSolution(i,j-1);
	}

	private static void println_int(int[][] arr) {
		// TODO Auto-generated method stub
		System.out.println("打印最优值数组");
		for(int i=0;i<str1.length()+1;i++){
			for(int j=0;j<str2.length()+1;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void println_char(char[][] arr) {
		// TODO Auto-generated method stub
		System.out.println("打印最优方案数组");
		for(int i=0;i<str1.length()+1;i++){
			for(int j=0;j<str2.length()+1;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void LCS(){
		char[] arr1=str1.toCharArray();
		char[] arr2=str2.toCharArray();
		for(int i=1;i<=arr1.length;i++){
			for(int j=1;j<=arr2.length;j++){
				if(arr1[i-1]==arr2[j-1]){  //notice
					result[i][j]=result[i-1][j-1]+1;
					solution[i][j]='o';
				}
				else if(result[i-1][j]>=result[i][j-1]){
					result[i][j]=result[i-1][j];
					solution[i][j]='u';		
				}
				else{
					result[i][j]=result[i][j-1];
					solution[i][j]='l';
				}
			}
		}
	}
}
