package HashTable;
import java.util.*;

public class Q1178_NumberofValidWordsforEachPuzzle {

    public static void main(String[] args){
        Q1178_NumberofValidWordsforEachPuzzle a=new Q1178_NumberofValidWordsforEachPuzzle();
        System.out.println(a.findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}));
    }    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        // 构建words的count
        Map<Integer,Integer> count = new HashMap<>();
        for (String w:words){
            int bits=0;
            for (char c:w.toCharArray())
                bits|=1<<(c-'a');
            count.put(bits,count.getOrDefault(bits,0)+1);
        }

        List<Integer> res=new ArrayList<>();
        for (String p: puzzles){
            List<Integer> subs=new ArrayList<>();
            Set<Character> set=new HashSet<>();
            subs.add(1<<(p.charAt(0)-'a'));
            for (int i=1;i<p.length();i++){
                set.add(p.charAt(i));
            }
            for (char c: set){
                List<Integer> plus=new ArrayList<>();
                for (int sub:subs)
                    plus.add(sub|1<<(c-'a'));
                subs.addAll(plus);
            }
            int temp=0;
            for(int sub: subs){
                temp+=count.getOrDefault(sub,0);
            }
            res.add(temp);
        }
        return res;
    }


}
