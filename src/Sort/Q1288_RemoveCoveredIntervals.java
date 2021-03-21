package Sort;

import java.util.Arrays;

public class Q1288_RemoveCoveredIntervals {


    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
        System.out.println(removeCoveredIntervals(new int[][]{{0,10},{5,12}}));
        System.out.println(removeCoveredIntervals(new int[][]{{3,10},{4,10},{5,11}}));
        System.out.println(removeCoveredIntervals(new int[][]{{1,2},{1,4},{3,4}}));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y)->(x[0]==y[0]?y[1]-x[1]:x[0]-y[0]));
        int curEnd = -1, duplicate = 0;
        for (int[] interval: intervals) {
            int i = interval[0], j = interval[1];
            if (j<=curEnd) duplicate++;
            else curEnd = j;
        }
        return intervals.length - duplicate;
    }
}
