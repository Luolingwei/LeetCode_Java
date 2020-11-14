package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q1648_SellDiminishingValuedColoredBalls {

    public static void main(String[] args) {
        Q1648_SellDiminishingValuedColoredBalls a = new Q1648_SellDiminishingValuedColoredBalls();
        System.out.println(a.maxProfit(new int[]{2,5}, 4));
        System.out.println(a.maxProfit(new int[]{3,5}, 6));
        System.out.println(a.maxProfit(new int[]{2,8,4,10,6}, 20));
        System.out.println(a.maxProfit(new int[]{1000000000}, 1000000000));
        System.out.println(a.maxProfit(new int[]{773160767}, 252264991));
        System.out.println(a.maxProfit(new int[]{565259708,715164401,716563713,958255469,844600740,823949511,180479359,287829385,164248818,73361150,230686692,322986846,598720034,338241127,748922260,181241085,833659853,509571179,250093451,690995620,703292727,595636202}, 650114768));
    }

    public int maxProfit(int[] inventory, int orders) {
        List<Integer> balls = Arrays.stream(inventory).boxed().collect(Collectors.toList());
        balls.add(0);
        Collections.sort(balls, Collections.reverseOrder());
        int i = 0, times = 1, mod = 1000000007;
        long res = 0;
        while (i<balls.size()-1 && orders>0) {
            int n = balls.get(i) - balls.get(i+1);
            if (orders<n*times){
                long m = orders/times, reminder = orders%times;
                res += sum(balls.get(i),m) * times;
                res += reminder * (balls.get(i)-m);
                return (int) (res%mod);
            }
            res += sum(balls.get(i),n) * times;
            res %= mod;
            orders -= n*times;
            times++;
            i++;
        }
        return (int) (res%mod);
    }

    private long sum(long first, long n){
        return (n * first) - ((n * (n-1))/2);
    }
}
