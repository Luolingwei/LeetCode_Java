package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Q1673_FindTheMostCompetitiveSubsequence {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4)));
        System.out.println(Arrays.toString(mostCompetitive(new int[]{2,4,3,3,5,4,9,6,1}, 4)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> s = new Stack<>();
        Class clazz = s.getClass();
        int L = nums.length;
        for (int i=0; i<L; i++) {
            int n = nums[i];
            while (!s.isEmpty() && n<s.peek() && L-i>k-s.size())
                s.pop();
            if (s.size()<k) s.push(n);
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}
