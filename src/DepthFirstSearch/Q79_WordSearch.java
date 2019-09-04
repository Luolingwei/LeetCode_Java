package DepthFirstSearch;

import java.util.*;

public class Q79_WordSearch {

    public static void main(String[] args){
        Q79_WordSearch a=new Q79_WordSearch();
        System.out.println(a.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
        System.out.println(a.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABC"));
    }

    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length,L=word.length();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dfs(board,i,j,m,n,0,word,L))
                    return true;
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, int i, int j, int m, int n, int pos, String word, int L){
        if (pos==L)
            return true;
        if (i>=0 && i<m && j>=0 && j<n && board[i][j]==word.charAt(pos)){
            board[i][j]='$';
            if (dfs(board,i+1,j,m,n,pos+1,word,L) || dfs(board,i-1,j,m,n,pos+1,word,L)
                || dfs(board,i,j+1,m,n,pos+1,word,L) || dfs(board,i,j-1,m,n,pos+1,word,L))
                return true;
            board[i][j]=word.charAt(pos);
        }
        return false;

    }

}