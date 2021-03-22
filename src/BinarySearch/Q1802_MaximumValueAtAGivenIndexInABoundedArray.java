package BinarySearch;

public class Q1802_MaximumValueAtAGivenIndexInABoundedArray {


    public static void main(String[] args) {
        Q1802_MaximumValueAtAGivenIndexInABoundedArray a = new Q1802_MaximumValueAtAGivenIndexInABoundedArray();
        System.out.println(a.maxValue(4,2,6));
        System.out.println(a.maxValue(6,1,10));
        System.out.println(a.maxValue(3,0,815094800));
        System.out.println(a.maxValue(8257285, 4828516, 850015631));
    }


    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        int leftN = index, rightN = n-index-1;
        while (l<r) {
            int mid = (l+r+1)/2;
            long curS = cal(leftN, mid) + cal(rightN, mid) - mid;
            if (curS > maxSum) r = mid-1;
            else l = mid;
        }
        return l;
    }

    private long cal(int sideN, int mid) {
        long sideSum;
        if (sideN>=mid-1) sideSum = (long) mid*(mid+1)/2 + sideN - (mid-1);
        else sideSum = (long) (sideN+1)*(2*mid-sideN)/2;
        return sideSum;
    }

}
