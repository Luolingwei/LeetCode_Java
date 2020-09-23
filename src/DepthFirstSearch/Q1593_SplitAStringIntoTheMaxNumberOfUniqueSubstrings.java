package DepthFirstSearch;

import java.util.HashSet;
import java.util.Set;

public class Q1593_SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    public static void main(String[] args) {
        Q1593_SplitAStringIntoTheMaxNumberOfUniqueSubstrings a = new Q1593_SplitAStringIntoTheMaxNumberOfUniqueSubstrings();
        System.out.println(a.maxUniqueSplit("aba"));
        System.out.println(a.maxUniqueSplit("ababccc"));
        System.out.println(a.maxUniqueSplit("aaaaaaaaaaaaaaa"));
        System.out.println(a.maxUniqueSplit("hmadataa"));
    }

    public int maxUniqueSplit(String s) {
        return dfs(s, new HashSet<>());
    }

    public int dfs(String s, Set<String> path) {
        int res = 0;
        if (s.isEmpty()) return path.size();
        for (int i=1; i<s.length()+1; i++) {
            String curS = s.substring(0,i);
            if (!path.contains(curS)) {
                path.add(curS);
                res = Math.max(res, dfs(s.substring(i,s.length()),path));
                path.remove(curS);
            }
        }
        return res;
    }

}
