package TwoPointers;

public class Q1574_ShortestSubarrayToBeRemovedToMakeArraySorted {

    public static void main(String[] args) {
        Q1574_ShortestSubarrayToBeRemovedToMakeArraySorted a = new Q1574_ShortestSubarrayToBeRemovedToMakeArraySorted();
        System.out.println(a.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
        System.out.println(a.findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while (left+1<arr.length && arr[left]<=arr[left+1]) left++;
        if (left==arr.length-1) return 0;

        int right = arr.length-1;
        while (right-1>=0 && arr[right]>=arr[right-1]) right--;

        int low = 0, high = right, res = Math.min(arr.length-left-1,right);
        while (low<=left && high<=arr.length-1){
            if (arr[high]>=arr[low]){
                res = Math.min(res, high-low-1);
                low++;
            } else {
                high++;
            }
        }
        return res;

    }

}
