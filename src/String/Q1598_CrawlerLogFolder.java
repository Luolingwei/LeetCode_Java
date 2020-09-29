package String;

public class Q1598_CrawlerLogFolder {

    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
    }

    public static int minOperations(String[] logs) {
        int depth = 0;
        for (String log: logs) {
            if (log.substring(0, 2).equals("..") && depth>0) depth--;
            else if (!log.substring(0, 1).equals(".")) depth++;
        }
        return depth;
    }
}
