package String;

public class Q1427_PerformStringShifts {

    public static void main(String[] args) {
        System.out.println(stringShift("abcdefg", new int[][]{{1,1},{1,1},{0,2},{1,3}}));
    }

    public static String stringShift(String s, int[][] shift) {
        Integer a = 5;
        int length = s.length();
        int t = 0;
        for (int[] sh: shift)
            t += sh[0]==0? sh[1]: -sh[1];
        t = t%length;
        if (t<0) t+=length;
        return s.substring(t) + s.substring(0,t);
    }

}
