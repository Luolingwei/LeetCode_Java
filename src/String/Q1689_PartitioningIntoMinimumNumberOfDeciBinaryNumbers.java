package String;

public class Q1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(minPartitions("27346209830709182346"));
        System.out.println(minPartitions("82734"));
    }

    public static int minPartitions(String n) {
        int res = -1;
        for (char c: n.toCharArray()) {
            res = Math.max(res, c-'0');
        }
        return res;
    }

}
