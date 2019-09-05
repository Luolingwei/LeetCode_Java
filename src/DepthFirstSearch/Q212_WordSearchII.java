package DepthFirstSearch;
import java.util.*;

public class Q212_WordSearchII {

    public static void main(String[] args){
        Q212_WordSearchII a=new Q212_WordSearchII();
        System.out.println(a.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},new String [] {"oath","pea","eat","rain"}));
        System.out.println(a.findWords(new char[][]{{'a'}},new String [] {"a"}));
    }

    class Trienode{
        Trienode [] next=new Trienode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trienode root=bulidTrie(words);
        int m=board.length,n=board[0].length;
        List<String> res=new ArrayList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                dfs(i,j,m,n,board,root, res);
            }
        }
        return res;

    }

    public void dfs(int i, int j, int m, int n, char[][] board, Trienode p, List<String> res){
        if (i>=0 && i<m && j>=0 && j<n){
            char c=board[i][j];
            int v=c-'a';
            if (c=='$'|| p.next[v]==null) return;
            p=p.next[v];
            if (p.word!=null) {
                res.add(p.word);
                p.word=null;
            }

            board[i][j]='$';
            dfs(i-1,j,m,n,board,p,res);
            dfs(i+1,j,m,n,board,p,res);
            dfs(i,j-1,m,n,board,p,res);
            dfs(i,j+1,m,n,board,p,res);
            board[i][j]=c;

        }
    }

    public Trienode bulidTrie(String[] words){
        Trienode root=new Trienode();
        for (String word: words){
            Trienode p=root;
            for (char c:word.toCharArray()){
                int i=c-'a';
                if (p.next[i]==null) p.next[i]=new Trienode();
                p=p.next[i];
            }
            p.word=word;
        }
        return root;
    }
}