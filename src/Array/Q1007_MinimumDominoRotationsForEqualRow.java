package Array;


public class Q1007_MinimumDominoRotationsForEqualRow {


    public static void main(String[] args) {
        Q1007_MinimumDominoRotationsForEqualRow a = new Q1007_MinimumDominoRotationsForEqualRow();
        System.out.println(a.minDominoRotations1(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println(a.minDominoRotations1(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));

        System.out.println(a.minDominoRotations2(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println(a.minDominoRotations2(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }


    public int minDominoRotations1 (int[] A, int[] B) {
        int[] memo = new int[7];
        for (int n: A) memo[n]++;
        for (int n: B) memo[n]++;
        int maxf = 0, maxN = -1;
        for (int i = 0; i<7; i++) {
            if (memo[i]>maxf) {
                maxf = memo[i];
                maxN = i;
            }
        }
        int rA = 0, rB = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i]!=maxN && B[i]!=maxN) return -1;
            if (A[i]!=maxN) rA++;
            if (B[i]!=maxN) rB++;
        }
        return Math.min(rA,rB);
    }


    public int minDominoRotations2 (int[] A, int[] B) {
        int[] countA = new int[7], countB = new int[7], countSame = new int[7];
        for (int i = 0; i<A.length; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i]==B[i]) countSame[A[i]]++;
        }
        for (int i=0; i<7; i++) {
            if (countA[i] + countB[i] - countSame[i] == A.length)
                return Math.min(A.length-countA[i], B.length-countB[i]);
        }
        return -1;
    }

}
