package Heap;
import java.util.*;

public class Q239_SlidingWindowMaximum {

    public static void main(String[] args){
        Q239_SlidingWindowMaximum a=new Q239_SlidingWindowMaximum();
        System.out.println(Arrays.toString(a.maxSlidingWindow(new int []{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(a.maxSlidingWindow(new int []{1,3,1,2,0,5},3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque= new LinkedList<>();
        List<Integer> ans=new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++){
            while (!deque.isEmpty() && nums[i]>nums[deque.getLast()])
                deque.removeLast();
            deque.add(i);
            if (deque.getFirst()==i-k)
                deque.poll();
            if (i-k>=-1)
                ans.add(nums[deque.get(0)]);
        }
        return transfer(ans);

    }

    public int [] transfer(List<Integer> A){
        int [] res=new int[A.size()];
        for (int i=0;i<A.size();i++){
            res[i]=A.get(i);
        }
        return res;
    }
}
