package HashTable;


public class Q1781_SumOfBeautyOfAllSubstrings {


    public static void main(String[] args) {
        Q1781_SumOfBeautyOfAllSubstrings a = new Q1781_SumOfBeautyOfAllSubstrings();
        System.out.println(a.beautySum("aabcb"));
        System.out.println(a.beautySum("aabcbaa"));
    }

    public int beautySum(String s) {
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            int[] memo = new int[26];
            for (int j=i; j<s.length(); j++) {
                memo[s.charAt(j) - 'a']++;
                res += check(memo);
            }
        }
        return res;
    }

    private int check(int[] memo) {
        int maxCount = Integer.MIN_VALUE, minCount = Integer.MAX_VALUE;
        for (int n: memo) {
            maxCount = Math.max(maxCount,n);
            if (n>0) minCount = Math.min(minCount,n);
        }
        return maxCount-minCount;
    }
}
