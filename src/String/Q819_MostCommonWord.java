package String;

import java.util.*;

public class Q819_MostCommonWord {

    public static void main(String[] args){
        Q819_MostCommonWord a=new Q819_MostCommonWord();
        System.out.println(a.mostCommonWord("Bob hit ball a ball, the hit BALL flew far after it was hit.",new String [] {"was"}));
    }

    public List<String> mostCommonWord(String express, String [] banned) {
        int maxN=0;
        List<String> ans=new ArrayList<>();
        Set<String> ban=new HashSet<>(Arrays.asList(banned));
        String [] strs=express.toLowerCase().split("\\W+");
        Map<String, Integer> dic=new HashMap<>();
        for (String s:strs){
            if (!ban.contains(s)) dic.put(s,dic.getOrDefault(s,0)+1);
        }
        for (String s:dic.keySet()){
            int N=dic.get(s);
            if (N>=maxN){
                if (N>maxN){
                    ans=new ArrayList<>();
                    maxN=N;
                }
                ans.add(s);
            }
        }
        return ans;
    }
}