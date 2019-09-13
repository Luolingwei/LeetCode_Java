package Sort;

import java.util.*;

public class Q973_follow_KClosestPointstoPointA {

    public static void main(String[] args){
        Q973_follow_KClosestPointstoPointA a=new Q973_follow_KClosestPointstoPointA();
        System.out.println(Arrays.deepToString(a.kClosest(new int [][] {{1,1},{3,3}},new int [] {3,3}, 2)));
    }

    public int[][] kClosest(int[][] points, int [] A, int K) {
        Arrays.sort(points,Comparator.comparing(p->Math.pow((p[0]-A[0]),2)+Math.pow((p[1]-A[1]),2)));
        return Arrays.copyOfRange(points,0,K);
    }

}
