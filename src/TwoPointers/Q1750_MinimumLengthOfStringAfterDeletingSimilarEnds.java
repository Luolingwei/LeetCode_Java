package TwoPointers;

public class Q1750_MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("aa"));
        System.out.println(minimumLength("abaa"));
        System.out.println(minimumLength("cabaabac"));
    }


    public static int minimumLength(String s) {
        int l = 0, r = s.length()-1;
        while (l<r && s.charAt(l)==s.charAt(r)) {
            char c = s.charAt(l);
            while (l<=r && s.charAt(l)==c) l++;
            while (l<=r && s.charAt(r)==c) r--;
        }
        return r-l+1;
    }

}
