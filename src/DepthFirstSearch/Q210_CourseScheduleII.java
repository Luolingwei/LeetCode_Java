package DepthFirstSearch;

import java.util.Set;
import java.util.*;

public class Q210_CourseScheduleII {

    public static void main(String[] args){
        Q210_CourseScheduleII a=new Q210_CourseScheduleII();
        System.out.println(Arrays.toString(a.findOrder(2,new int[][]{{1,0}})));
        System.out.println(Arrays.toString(a.findOrder(2,new int[][]{{1,0},{0,1}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] ans=new int[numCourses];
        int j=0;
        Map<Integer, Set<Integer>> restrict=new HashMap<>(),course_conn=new HashMap<>();
        for (int [] p:prerequisites){
            Set<Integer> R=restrict.getOrDefault(p[0],new HashSet<>());
            R.add(p[1]);
            restrict.put(p[0],R);
            Set<Integer> C=course_conn.getOrDefault(p[1],new HashSet<>());
            C.add(p[0]);
            course_conn.put(p[1],C);
        }
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<numCourses;i++){
            if (!restrict.containsKey(i))
                stack.add(i);
        }
        while (!stack.isEmpty()){
            int c=stack.pop();
            ans[j]=c;
            j+=1;
            if (course_conn.containsKey(c)){
                for (int c_affect:course_conn.get(c)){
                    restrict.get(c_affect).remove(c);
                    if (restrict.get(c_affect).isEmpty()){
                        stack.add(c_affect);
                    }
                }
            }
        }
        return j==numCourses?ans:new int[0];
    }
}
