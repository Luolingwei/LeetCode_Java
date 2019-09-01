package String;
import java.util.*;

public class Q1177_CanMakePalindromefromSubstring {


    public static void main(String[] args){
        Q1177_CanMakePalindromefromSubstring a=new Q1177_CanMakePalindromefromSubstring();
        System.out.println((a.canMakePaliQueries("abcda",new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}})));
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res=new ArrayList<>();
        for (int [] q: queries)
            res.add(judege(s,q[0],q[1],q[2]));
        return res;
    }

    public Boolean judege(String s,int l, int r, int k) {
        if (k>=13) return true;
        Set<Character> dic=new HashSet<>();
        for (int i=l;i<=r;i++){
            if (!dic.add(s.charAt(i))) dic.remove(s.charAt(i));
        }
        return dic.size()/2<=k;
    }
}