package 直方图内最大矩阵;
/**
 * @author  Robin
 * @date 2016年3月24日 下午3:06:31 
 * @version 1.0 
 */
/*方法一:复杂度 为  n*n
 * 如果对于每个直方块，找到从它开始往左边数第一个比它小的，和往右边数第一个比他小的，则可以确定出以该直方块为最矮一块的矩阵的最大面积
 * */
import java.util.ArrayList;  
import java.util.List;  
import java.util.Stack;  
  
public class Rectangle {  
      
    private int index;  
    private int height;  
    private int left;  
    private int right;  
      
    @Override  
    public String toString() {  
        return "Rectangle [height=" + height + ", index=" + index + ", left="  
                + left + ", right=" + right + "]";  
    }  
  
    protected static int getMaxRectangle(List<Rectangle> lists){  
          
        Stack<Rectangle> stack = new Stack<Rectangle>();  
          
        //输入检测  
        if(lists == null || lists.size() == 0){  
            System.out.println("非法输入！");  
            System.exit(0);  
        }  
          
        //从左往右入栈  
        for(int i = 0; i < lists.size(); i++){  
              
            Rectangle rectangle = lists.get(i);  
                      
            while(!stack.isEmpty() && stack.peek().height >= lists.get(i).height){  
                stack.pop();  
            }                         
              
            if(stack.isEmpty()){  
                rectangle.left = 0;  
            }else {  
                rectangle.left = stack.peek().index;  
            }  
              
            lists.set(i, rectangle);  
              
            stack.push(rectangle);  
        }  
          
        stack.clear();  
          
        //从右往左入栈  
        for(int i = lists.size() - 1; i >= 0; i--){  
              
            Rectangle rectangle = lists.get(i);  
              
            while(!stack.isEmpty() && stack.peek().height >= lists.get(i).height){  
                    stack.pop();  
            }     
              
            if(stack.isEmpty()){  
                rectangle.right = lists.size() + 1;  
            }else {  
                rectangle.right = stack.peek().index;  
            }  
              
            lists.set(i, rectangle);  
              
            stack.push(rectangle);  
        }  
          
        //计算面积最大值  
        int max = (lists.get(0).right - lists.get(0).left - 1)*lists.get(0).height;  
        System.out.println(lists.get(0));  
          
        for(int i = 1; i < lists.size(); i++){  
            int temp = (lists.get(i).right - lists.get(i).left - 1)*lists.get(i).height;  
            System.out.println(lists.get(i));  
            if(max < temp){  
                max = temp;  
            }  
        }  
          
        return max;  
    }  
  
  
    public static void main(String[] args) {  
          
        int [] values = new int[]{2, 1, 5, 6, 2, 3};  
        System.out.println(countArea(values,6));
        List<Rectangle> lists = new ArrayList<Rectangle>();  
          
        for (int i = 0; i < values.length; i++) {  
            Rectangle rectangle = new Rectangle();  
            rectangle.height = values[i];  
            rectangle.index = i + 1;  
            lists.add(rectangle);  
        }  
          
        System.out.println(Rectangle.getMaxRectangle(lists));         
    }  
    public static int countArea(int[] A, int n) {
        // write code here
        //用最直接的方法，复杂度为平方
        int[] result=new int[n];
        int first,last;
        for(int i=0;i<n;i++){
            first=last=i;
            while(first>=0&&A[first]>=A[i])
                first--;
            first++;
            while(last<n&&A[last]>=A[i])
                last++;
            last--;
            result[i]=A[i]*(last-first+1);
        }
        int max=0;
        for(int i=0;i<n;i++)
            if(result[i]>max)
            	max=result[i];
        return max;
    }
  
}  