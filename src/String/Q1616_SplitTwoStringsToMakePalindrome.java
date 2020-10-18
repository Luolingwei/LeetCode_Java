package String;

public class Q1616_SplitTwoStringsToMakePalindrome {

    public static void main(String[] args) {
        Q1616_SplitTwoStringsToMakePalindrome a = new Q1616_SplitTwoStringsToMakePalindrome();
        System.out.println(a.checkPalindromeFormation("x", "y"));
        System.out.println(a.checkPalindromeFormation("abdef", "fecab"));
        System.out.println(a.checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(a.checkPalindromeFormation("xbdef", "xecab"));
    }

    public boolean checkPalindromeFormation(String a, String b) {
        return check(a,b) || check(b,a);
    }

    private boolean check(String a, String b) {
        int L = a.length();
        int i = 0, j = L-1;
        while (i<j && a.charAt(i)==b.charAt(j)) {
            i++;
            j--;
        }
        return Pal(a.substring(i,j+1)) || Pal(b.substring(i,j+1));
    }


    private boolean Pal(String s) {
        int i = 0, j = s.length()-1;
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
