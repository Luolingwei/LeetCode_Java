package Array;

import java.util.Arrays;

public class Q1672_RichestCustomerWealth {

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
        System.out.println(maximumWealth(new int[][]{{1,5},{7,3},{3,5}}));
        System.out.println(maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}}));
    }

    public static int maximumWealth(int[][] accounts) {

        // 二维数组 使用Arrays.stream, 每个元素i变成一维数组, 用mapToInt将一行转为sum, 然后取max
        return Arrays.stream(accounts).mapToInt(i->Arrays.stream(i).sum()).max().getAsInt();
    }
}
