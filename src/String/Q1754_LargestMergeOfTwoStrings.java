package String;

public class Q1754_LargestMergeOfTwoStrings {

    public static void main(String[] args) {
        System.out.println(largestMerge("cabaa", "bcaaa"));
        System.out.println(largestMerge("abcabc", "abdcaba"));
    }


    public static String largestMerge(String word1, String word2) {
        String res = "";
        while (!word1.isEmpty() && !word2.isEmpty()) {
            if (word1.compareTo(word2)>=0) {
                res += word1.charAt(0);
                word1 = word1.substring(1);
            } else {
                res += word2.charAt(0);
                word2 = word2.substring(1);
            }
        }
        return res + word1 + word2;
    }
}
