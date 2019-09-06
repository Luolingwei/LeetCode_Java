package BreadthFirstSearch;
import java.util.*;

public class Q773_SlidingPuzzle {

    public static void main(String[] args){
        Q773_SlidingPuzzle a=new Q773_SlidingPuzzle();
        System.out.println(a.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
        System.out.println(a.slidingPuzzle(new int[][]{{1,2,3},{5,4,0}}));
        System.out.println(a.slidingPuzzle(new int[][]{{4,1,2},{5,0,3}}));
    }

    public int slidingPuzzle(int[][] board) {

        int [][] moves=new int[][] {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        int dist=0;
        Set<String> visited=new HashSet<>();
        String start="", target="123450";
        for (int i=0;i<2;i++){
            for (int j=0;j<3;j++)
                start+=board[i][j];
        }
        Queue<String> bfs=new LinkedList<>();
        bfs.add(start);
        while (!bfs.isEmpty()){
            Queue<String> new_bfs=new LinkedList<>();
            for (String state: bfs){
                if (state.equals(target)) return dist;
                int pos0=state.indexOf('0');
                for (int posj:moves[pos0]){
                    String new_state=swap(state,pos0,posj);
                    if (!visited.contains(new_state))
                        new_bfs.add(new_state);
                        visited.add(new_state);
                }
            }
            bfs=new_bfs;
            dist++;
        }
        return -1;
    }


    public String swap(String state,int i,int j) {
        char [] chars=state.toCharArray();
        char temp=chars[j];
        chars[j]=chars[i];
        chars[i]=temp;
        return new String(chars);
    }
}
