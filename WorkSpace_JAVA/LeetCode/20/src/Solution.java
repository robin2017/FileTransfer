import java.util.HashMap;
import java.util.Stack;

/**
 * @author  Robin
 * @date 2016年3月30日 下午9:24:25 
 * @version 1.0 
 */

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Boolean> hm=new HashMap<Character,Boolean>();
        hm.put('(',false);
        hm.put('{',false);
        hm.put('[',false);
        hm.put(')',true);
        hm.put('}',true);
        hm.put(']',true);
        
        HashMap<Character,Character> pair=new HashMap<Character,Character>();
        pair.put(')','(');
        pair.put('}','{');
        pair.put(']','[');
        
        Stack<Character> sta=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(!hm.get(s.charAt(i)))
                sta.push(s.charAt(i));
            else{
                if(sta.empty())
                    return false;
                if(pair.get(s.charAt(i))!=sta.pop())
                    return false;
            }
        }
        if(sta.empty())
            return true;
        else
            return false;
    }
}