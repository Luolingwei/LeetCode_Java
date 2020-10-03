package Greedy;

public class Q1599_MaximumProfitOfOperatingACentennialWheel {

    public static void main(String[] args) {
        System.out.println(minOperationsMaxProfit(new int[]{8,3},5,6));
        System.out.println(minOperationsMaxProfit(new int[]{10,9,6},6,4));
        System.out.println(minOperationsMaxProfit(new int[]{3,4,0,5,1},1,92));
        System.out.println(minOperationsMaxProfit(new int[]{10,10,6,4,7},3,8));
    }


    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int i = 0, count = 0, left = 0, curp = 0, maxp = Integer.MIN_VALUE, res = 0;

        while (left>0 || i<customers.length) {
            count ++;
            if (i<customers.length) left += customers[i];
            int processN = Math.min(4,left);
            left -= processN;
            curp += processN*boardingCost - runningCost;

            if (curp>maxp) {
                maxp = curp;
                res = count;
            }
            i++;
        }
        return maxp>0?res:-1;
    }
}
