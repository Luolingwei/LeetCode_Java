package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1610_MaximumNumberOfVisiblePoints {


    public static void main(String[] args) {
        System.out.println(visiblePoints(Arrays.asList(Arrays.asList(2,1), Arrays.asList(2,2), Arrays.asList(3,3)),90, Arrays.asList(1,1)));
        System.out.println(visiblePoints(Arrays.asList(Arrays.asList(2,1), Arrays.asList(2,2), Arrays.asList(3,4), Arrays.asList(1,1)),
                90, Arrays.asList(1,1)));

    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int plus = 0;
        List<Double> degree = new ArrayList<>();

        for (List<Integer> p: points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx==0 && dy==0) plus++;
            else {
                double curd = Math.toDegrees(Math.atan2(dy,dx));
                double curd2 = curd>0? curd-360:curd+360;
                degree.add(curd);
                degree.add(curd2);
            }
        }

        Collections.sort(degree);
        int l = 0, res = 0;

        for (int r = 0; r<degree.size(); r++) {
            while (degree.get(r) - degree.get(l) > angle) l++;
            res = Math.max(res, r-l+1);
        }

        return res + plus;
    }
}
