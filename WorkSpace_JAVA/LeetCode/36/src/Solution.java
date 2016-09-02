/**
 * @author  Robin
 * @date 2016年4月5日 下午4:55:09 
 * @version 1.0 
 */

public class Solution {
	public static void main(String[] args){
		char[][] board=new char[][]{{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
		System.out.println(new Solution().isValidSudoku(board));
	}
    public boolean isValidSudoku(char[][] board) {
        int[] nums=new int[10];
        //检测每行
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    ;
                else if(nums[board[i][j]-'0']==0)
                    nums[board[i][j]-'0']=1;
                else 
                    return false;
            }
            for(int j=0;j<=9;j++)
                nums[j]=0;
        }
        //检测每列
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]=='.')
                	;
                else if(nums[board[j][i]-'0']==0)
                    nums[board[j][i]-'0']=1;
                else 
                    return false;
            }
            for(int j=0;j<=9;j++)
                nums[j]=0;
        }
        //检测每个小格(四层循环)
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int ii=0;ii<3;ii++){
                    for(int jj=0;jj<3;jj++){
                        if(board[i*3+ii][j*3+jj]=='.');
                        else if(nums[board[i*3+ii][j*3+jj]-'0']==0)
                            nums[board[i*3+ii][j*3+jj]-'0']=1;
                        else
                            return false;
                    }
                }
                for(int k=0;k<=9;k++){
                    nums[k]=0;
                }
            }
        }
        return true;
    }
}