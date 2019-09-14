package BreadthFirstSearch;
import java.util.*;

public class QAmazon_Maze {
    public static void main(String[] args){
        QAmazon_Maze a=new QAmazon_Maze();
        System.out.println(a.Maze(new int[][]{{1,1,1,1,1,1},{1,1,1,1,0,0},{0,0,1,0,0,0},{1,1,1,1,1,1},{1,0,0,0,1,0},{1,1,1,0,9,0}}));
        System.out.println(a.Maze(new int[][]{{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,0},{0,0,9,0,0}}));
        System.out.println(a.Maze(new int[][]{{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,1},{0,0,9,1,1}}));
        System.out.println(a.Maze(new int[][]{{1,1,1,1},{1,0,0,0},{1,9,0,0}}));
        System.out.println(a.Maze(new int[][]{{1,9}}));
        System.out.println(a.Maze(new int[][]{{9}}));
        System.out.println(a.Maze(new int[][]{{1}}));
        System.out.println(a.Maze(new int[][]{{0}}));
    }

    public boolean Maze(int[][] board) {
        if (board[0][0]!=1)
            return board[0][0]==9;
        int [][] moves=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m=board.length,n=board[0].length;
        Queue<int []> bfs=new LinkedList<>();
        bfs.add(new int[]{0,0});
        while (!bfs.isEmpty()){
            Queue<int []> new_bfs=new LinkedList<>();
            for (int [] p:bfs){
                for (int [] move: moves){
                    int x=p[0]+move[0],y=p[1]+move[1];
                    if (x>=0 && x<m && y>=0 && y<n && board[x][y]!=0){
                        if (board[x][y]==9) return true;
                        else{
                            new_bfs.add(new int []{x,y});
                            board[x][y]=0;
                        }
                    }
                }
            }
            bfs=new_bfs;
        }
        return false;
    }
}