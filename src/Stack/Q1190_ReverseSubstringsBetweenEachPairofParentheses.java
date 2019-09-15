package Stack;

import java.util.Stack;

public class Q1190_ReverseSubstringsBetweenEachPairofParentheses {

    public static void main(String[] args){
        Q1190_ReverseSubstringsBetweenEachPairofParentheses a=new Q1190_ReverseSubstringsBetweenEachPairofParentheses();
        System.out.println(a.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(a.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(a.reverseParentheses("(u(love)i)"));
        System.out.println(a.reverseParentheses(""));

    }

    public String reverseParentheses(String s) {
        Stack<String> stack=new Stack<>();
        String str="";
        for (Character c: s.toCharArray()){
            if (c=='('){
                stack.push(str);
                str="";
            }
            else if (c==')'){
                String a=stack.pop();
                String b=new StringBuilder(str).reverse().toString();
                str=a+b;
            }
            else
                str+=c;
        }
        return str;
    }
}