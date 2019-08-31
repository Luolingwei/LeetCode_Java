package BreadthFirstSearch;

import java.util.*;

public class Q127_WordLadder {

    public static void main(String[] args){
        Q127_WordLadder a=new Q127_WordLadder();
        System.out.println(a.ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
        System.out.println(a.ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        LinkedList<String> bfs=new LinkedList<>();
        HashSet<String> wordset=new HashSet<>(wordList);
        HashSet<String> visited=new HashSet<>();
        bfs.add(beginWord);
        visited.add(beginWord);
        int dist=1;

        while (!bfs.isEmpty()){
            LinkedList<String> newbfs=new LinkedList<>();
            for (String word:bfs){
                if (word.equals(endWord))
                    return dist;
                else
                    for (int i=0;i<word.length();i++){
                        for (char c='a';c<='z';c++){
                            String newword=word.substring(0,i)+c+word.substring(i+1,word.length());
                            if ((!visited.contains(newword)) && wordset.contains(newword))
                                newbfs.add(newword);
                                visited.add(newword);
                        }
                    }
            }
            bfs=newbfs;
            dist++;
        }
        return 0;
    }
}
