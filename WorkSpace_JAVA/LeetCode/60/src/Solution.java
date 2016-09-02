import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  Robin
 * @date 2016年4月12日 下午2:59:43 
 * @version 1.0 
 */

public class Solution {
    public static int index=1;
    public static String result=new String();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Solution().getPermutation1(4, 14));
	}
	public String getPermutation0(int n, int k) {
	    int pos = 0;
	    List<Integer> numbers = new ArrayList<>();
	    int[] factorial = new int[n+1];
	    StringBuilder sb = new StringBuilder();

	    // create an array of factorial lookup
	    int sum = 1;
	    factorial[0] = 1;
	    for(int i=1; i<=n; i++){
	        sum *= i;
	        factorial[i] = sum;
	    }
	    // factorial[] = {1, 1, 2, 6, 24, ... n!}

	    // create a list of numbers to get indices
	    for(int i=1; i<=n; i++){
	        numbers.add(i);
	    }
	    // numbers = {1, 2, 3, 4}

	    k--;

	    for(int i = 1; i <= n; i++){
	        int index = k/factorial[n-i];
	        sb.append(String.valueOf(numbers.get(index)));
	        numbers.remove(index);
	        k-=index*factorial[n-i];
	    }

	    return String.valueOf(sb);
	}
	
	
	 public String getPermutation1(int n, int k) {
	        List<Integer> list=new LinkedList<Integer>();
	        for(int i=0;i<n;i++)
	            list.add(i+1);
	        StringBuilder sb=new StringBuilder();
	        k--;
	        while(list.size()>1){
	            int index=(k)/jiec(n-1);
	            sb.append(String.valueOf(list.get(index)));
	            list.remove(index);
	            k=k%jiec(n-1);
	            n--;
	        }
	        sb.append(list.remove(0));
	        return sb.toString();
	    }
	    private int jiec(int n){
	        int result=1;
	        for(int i=1;i<=n;i++)
	            result*=i;
	        return result;
	    }
	
	
	
	    
	    
	    
	 public String getPermutation2(int n, int k) {
         
	        int[] nums=new int[n];
	        for(int i=0;i<n;i++)
	            nums[i]=i+1;
	        permu2(nums,0,n-1,k);
	        return result;
	    }
	    private void permu2(int[] nums,int start,int end,int k){
	        if(start==end){
	            if(index++==k){
	                StringBuilder sb=new StringBuilder();
	                for(int i=0;i<nums.length;i++)
	                    sb.append(nums[i]);
	                result=sb.toString();
	            }
	        }else{
	        
	            for(int i=start;i<=end;i++){
	                swap(nums,start,end);
	                permu2(nums,start+1,end,k);
	                swap(nums,start,end);
	            }
	        }
	    }
	    private void swap(int[] nums,int i,int j){
	        int tmp=nums[i];
	        nums[i]=nums[j];
	        nums[j]=tmp;
	    }
}
