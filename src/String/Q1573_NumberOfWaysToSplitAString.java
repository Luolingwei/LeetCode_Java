package String;

public class Q1573_NumberOfWaysToSplitAString {

    public static void main(String[] args) {
        Q1573_NumberOfWaysToSplitAString a = new Q1573_NumberOfWaysToSplitAString();
        System.out.println(a.numWays("10101"));
        System.out.println(a.numWays("1001"));
        System.out.println(a.numWays("0000"));
        System.out.println(a.numWays("100100010100110"));
    }

    public int numWays(String s) {
        int total = 0, mod = 1000000007;
        long L = s.length();
        for (char c: s.toCharArray()){
            if (c=='1') total++;
        }

        if (total%3!=0) return 0;
        if (total==0) return (int) ((L-1)*(L-2)/2 % mod);
        int n = total/3;

        long[] index1 = find(s,0,1,n);
        long[] index2 = find(s,L-1,-1,n);
        return (int)((index1[1]-index1[0])*(index2[0]-index2[1])%mod);

    }

    public long[] find(String s, long start, int move, int n) {
        long i = start, count = 0;
        long i0 = -1, i1 = -1;
        while (i>=0 && i<s.length()) {
            if (s.charAt((int)i)=='1') {
                count++;
                if (count==n) i0 = i;
                if (count>n) {
                    i1 = i;
                    break;
                }
            }
            i+=move;
        }
        return new long[]{i0,i1};
    }

}
