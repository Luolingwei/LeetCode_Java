package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Q503_NextGreaterElementII {


    public static void main(String[] args) {
        Q503_NextGreaterElementII a = new Q503_NextGreaterElementII();
        System.out.println(Arrays.toString(a.nextGreaterElements(new int[]{1, 2, 1})));
    }


    public int[] nextGreaterElements(int[] nums) {
        int m = nums.length;
        int[] res = new int[m];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<2*m; i++){
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i%m]){
                res[stack.pop()] = nums[i%m];
            }
            if (i<m) stack.push(i);
        }
        return res;

    }

}
