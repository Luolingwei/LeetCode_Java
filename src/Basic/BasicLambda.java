package Basic;

import java.util.Arrays;

public class BasicLambda {

    public static void main(String[] args) {

        // 1 lambda in sort
        int[][] double_array = new int[][]{{1,4},{1,2},{2,3},{5,0},{3,2}};
        Arrays.sort(double_array,(a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        System.out.println(Arrays.deepToString(double_array));

        // 2 lambda in Thread
        Runnable r =  () -> System.out.println("Thread 1 run");
        while (true) {
            new Thread(r).start();
            new Thread(()-> System.out.println("Thread 2 Run")).start();
            new Thread(()-> System.out.println("Thread 3 Run")).start();
        }


    }
}
