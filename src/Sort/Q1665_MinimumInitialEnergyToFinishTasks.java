package Sort;

import java.util.Arrays;

public class Q1665_MinimumInitialEnergyToFinishTasks {

    public static void main(String[] args) {

        System.out.println(minimumEffort(new int[][]{{1,2},{2,4},{4,8}}));
        System.out.println(minimumEffort(new int[][]{{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}}));
        System.out.println(minimumEffort(new int[][]{{1,3},{2,4},{10,11},{10,12},{8,9}}));
        System.out.println(minimumEffort(new int[][]{{1,1},{1,3}}));
    }


    public static int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b)->(b[1]-b[0])-(a[1]-a[0]));
        int res = 0, energy = 0;
        for (int[] task: tasks) {
            res += Math.max(0, task[1]-energy);
            energy = Math.max(task[1], energy) - task[0];
        }
        return res;

    }
}
