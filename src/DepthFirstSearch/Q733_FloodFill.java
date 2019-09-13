package DepthFirstSearch;

import java.util.*;

public class Q733_FloodFill {

    public static void main(String[] args){
        Q733_FloodFill a=new Q733_FloodFill();
        System.out.println(Arrays.deepToString(a.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length,n=image[0].length;
        boolean [][] used=new boolean[m][n];
        dfs(sr,sc,m,n,image,image[sr][sc],newColor,used);
        return image;
    }

    public void dfs(int i,int j,int m, int n, int [][] image, int oldcolor, int newcolor, boolean [][] visited){
        if (i>=0 && i<m && j>=0 && j<n && image[i][j]==oldcolor && !visited[i][j]){
            image[i][j]=newcolor;
            visited[i][j]=true;
            dfs(i,j+1,m,n,image,oldcolor,newcolor,visited);
            dfs(i,j-1,m,n,image,oldcolor,newcolor,visited);
            dfs(i+1,j,m,n,image,oldcolor,newcolor,visited);
            dfs(i-1,j,m,n,image,oldcolor,newcolor,visited);
        }
    }
}