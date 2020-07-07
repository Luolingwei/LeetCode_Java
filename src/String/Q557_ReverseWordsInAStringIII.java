package String;

public class Q557_ReverseWordsInAStringIII {

    public static void main(String[] args) {
        System.out.println(reverseWords("hello world"));
    }

    public static String reverseWords(String s) {
        String[] result = s.split(" ");
        for (int i=0; i<result.length; i++){
            result[i] = new StringBuilder(result[i]).reverse().toString();
        }
        return String.join(" ", result);
    }

}
