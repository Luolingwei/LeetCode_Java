package Array;

public class Q1583_CountUnhappyFriends {

    public static void main(String[] args) {
        Q1583_CountUnhappyFriends a = new Q1583_CountUnhappyFriends();
        System.out.println(a.unhappyFriends(4,new int[][]{{1, 2, 3},{3, 2, 0},{3, 1, 0},{1, 2, 0}},new int[][]{{0, 1},{2, 3}}));
        System.out.println(a.unhappyFriends(4,new int[][]{{1, 3, 2},{2, 3, 0},{1, 3, 0},{0, 2, 1}},new int[][]{{1, 3},{0, 2}}));
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] memo = new int[n];
        int res = 0;
        for (int[] pair: pairs) {
            memo[pair[0]] = pair[1];
            memo[pair[1]] = pair[0];
        }

        for (int i=0; i<n; i++){
            int pair_n = memo[i];
            for (int prefer: preferences[i]) {
                if (prefer == pair_n) break;
                if (search(preferences[prefer],i)<search(preferences[prefer],memo[prefer])){
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    public int search (int[] nums, int n) {
        for (int i=0; i<nums.length; i++)
            if (nums[i] == n) return i;
        return -1;
    }

}
