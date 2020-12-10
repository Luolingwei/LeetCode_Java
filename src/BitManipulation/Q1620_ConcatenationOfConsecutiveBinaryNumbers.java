package BitManipulation;

public class Q1620_ConcatenationOfConsecutiveBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(12));
    }


    public static int concatenatedBinary(int n) {
        long res = 0;
        int size = 0;
        int mod = 1000000007;
        for (int i=1; i<n+1; i++) {
            if ((i&(i-1))==0) size ++;
            res = ((res<<size)|i)%mod;
        }
        return (int)(res%mod);
    }
}
