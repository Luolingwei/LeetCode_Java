package BitManipulation;

public class Q1611_MinimumOneBitOperationsToMakeIntegersZero {

    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(0));
        System.out.println(minimumOneBitOperations(3));
        System.out.println(minimumOneBitOperations(6));
        System.out.println(minimumOneBitOperations(9));
        System.out.println(minimumOneBitOperations(333));
    }

    public static int minimumOneBitOperations(int n) {
        int res = 0, sign = 1;
        while (n > 0) {
            res += n^(n-1)*sign;
            n &= (n-1);
            sign = -sign;
        }
        return Math.abs(res);
    }

}
