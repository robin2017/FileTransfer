package 钢条切割;
/**
 * @author  Robin
 * @date 2016年3月24日 上午9:27:56 
 * @version 1.0 
 */

public class Test {
	public static void main(String[] args){
		int test=9;
		int[] arr=new int[]{0,1,5,8,9,10,17,17,20,24,30};
		System.out.println(cut1(arr,test));
		System.out.println(cut2(arr,test));
	}
	
	private static int cut1(int[] arr,int n){ //递归方法，自顶向下
		if(n==0)
			return 0;
		int max=0;
		int get=0;
		for(int i=1;i<=n;i++){
			get=i<=10?arr[i]+cut1(arr,n-i):0;
			if(get>max)
				max=get;
			get=0;
		}
		
		return max;
	}
	
	private static int cut2(int[] arr,int n){ //动态规划，自底向上
		int[] result=new int[n+1];
		int[] method=new int[n+1];
		for(int i=1;i<=n;i++){
			int max=0;
			int get=0;
			int met=0;
			for(int j=1;j<=i;j++){
				get=j<=10?arr[j]+result[i-j]:0;
				if(get>max){
					max=get;
					met=j;
				}
				get=0;
			}
			result[i]=max;
			method[i]=met;
			met=0;
			max=0;
		}
		System.out.println(method[n]);
		return result[n];
		
	}
	
	private static int getMax(int a,int b){
		return a>b?a:b;
	}
}
