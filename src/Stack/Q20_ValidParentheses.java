package Stack;

import java.util.*;

public class Q20_ValidParentheses {
    public static void main(String[] args){
        Q20_ValidParentheses a=new Q20_ValidParentheses();
        System.out.println(a.isValid("()"));
        System.out.println(a.isValid("([)]"));
        System.out.println(a.isValid("{[]}"));
        System.out.println(a.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Map<Character,Character> dic=new HashMap<>();
        dic.put(')','(');dic.put('}','{');dic.put(']','[');
        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()){
            if (c==')' || c=='}' || c==']'){
                if (stack.isEmpty() || stack.peek()!=dic.get(c))
                    return false;
                stack.pop();
            }
            else
                stack.add(c);
        }
        return stack.isEmpty();
    }
}
