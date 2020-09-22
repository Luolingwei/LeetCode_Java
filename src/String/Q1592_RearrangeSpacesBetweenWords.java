package String;


public class Q1592_RearrangeSpacesBetweenWords {

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));
        System.out.println(reorderSpaces("a"));
    }

    public static String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int space = text.chars().map(c -> c==' '?1:0).sum();
        if (words.length<=1) return words[0]+" ".repeat(space);
        int perSpace = space/(words.length-1), left = space%(words.length-1);
        return String.join(" ".repeat(perSpace),words) + " ".repeat(left);
    }

}
