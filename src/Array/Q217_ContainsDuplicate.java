package Array;
import java.util.*;

public class Q217_ContainsDuplicate {

    public static void main(String[] args){
        Q217_ContainsDuplicate a=new Q217_ContainsDuplicate();
        System.out.println(a.containsDuplicate(new int []{1,2,3,1}));
        System.out.println(a.containsDuplicate(new int []{1,1,1,3,3,4,3,2,4,2}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for (int n:nums){
            if (!s.contains(n))
                s.add(n);
            else
                return true;
        }
        return false;
    }
}
