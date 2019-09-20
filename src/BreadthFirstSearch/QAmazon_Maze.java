package BreadthFirstSearch;
import java.util.*;

public class QAmazon_Maze {
    public static void main(String[] args){
        QAmazon_Maze a=new QAmazon_Maze();
        System.out.println(a.Maze(new int[][]{{1,1,1,1,1,1},{1,1,1,1,0,0},{0,0,1,0,0,0},{1,1,1,1,1,1},{1,0,0,0,1,0},{1,1,1,0,9,0}},6,6));
        System.out.println(a.Maze(new int[][]{{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,0},{0,0,9,0,0}},4,5));
        System.out.println(a.Maze(new int[][]{{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,1},{0,0,9,1,1}},4,5));
        System.out.println(a.Maze(new int[][]{{1,1,1,1},{1,0,0,0},{1,9,0,0}},3,4));
        System.out.println(a.Maze(new int[][]{{1,9}},1,2));
        System.out.println(a.Maze(new int[][]{{9}},1,1));
        System.out.println(a.Maze(new int[][]{{1}},1,1));
        System.out.println(a.Maze(new int[][]{{0}},1,1));
    }

    public int Maze(int[][] board,int rows,int columns) {
        int [][] moves=new int [][] {{1,0},{-1,0},{0,1},{0,-1}};
        List<int []> bfs=new ArrayList<>();
        bfs.add(new int []{0,0});
        int dist=1;
        while (!bfs.isEmpty()){
            List<int []> newbfs=new ArrayList<>();
            for (int [] p: bfs){
                for (int [] move:moves){
                    int x=p[0]+move[0],y=p[1]+move[1];
                    if (x>=0 && x<rows && y>=0 && y<columns){
                        if (board[x][y]!=0){
                            if (board[x][y]==9) return dist;
                            else{
                                board[x][y]=0;
                                newbfs.add(new int []{x,y});
                            }
                        }
                    }
                }
            }
            bfs=newbfs;
            dist+=1;
        }
        return -1;
    }
}