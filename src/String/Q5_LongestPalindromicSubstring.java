package String;

public class Q5_LongestPalindromicSubstring {

    public static void main(String[] args){
        Q5_LongestPalindromicSubstring a=new Q5_LongestPalindromicSubstring();
          System.out.println(a.longestPalindrome("a"));
          System.out.println(a.longestPalindrome("babad"));
          System.out.println(a.longestPalindrome("cbbd"));
          System.out.println(a.longestPalindrome(""));
    }


    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int l=0,r=0;
        for(int i=0;i<s.length()-1;i++){
            int [] A=check(s,i,i);
            if ((A[1]-A[0])>(r-l)){
                l=A[0];r=A[1];
            }
            int [] B=check(s,i,i+1);
            if ((B[1]-B[0])>(r-l)){
                l=B[0];r=B[1];
            }

        }
        return s.substring(l,r+1);
    }

    public int [] check(String s,int l,int r){
        int L=s.length();
        while (l>=0 && r<L && s.charAt(l)==s.charAt(r)){
            l-=1;r+=1;
        }
        return new int []{l+1,r-1};
    }
}
