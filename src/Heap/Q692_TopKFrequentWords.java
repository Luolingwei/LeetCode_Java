package Heap;
import java.util.*;

public class Q692_TopKFrequentWords {

    public static void main(String[] args){
        Q692_TopKFrequentWords a=new Q692_TopKFrequentWords();
        System.out.println(a.topKFrequent(new String []{"i", "love", "leetcode", "i", "love", "coding"},2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> dic=new HashMap<>();
        List<String> ans=new ArrayList<>();
        for (String w: words)
            dic.put(w,dic.getOrDefault(w,0)+1);
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (dic.get(s1)==dic.get(s2)){
                    return s1.compareTo(s2);
                }
                return dic.get(s2)-dic.get(s1);
            }
        });
        for (String w:dic.keySet())
            pq.add(w);
        for (int i=0;i<k;i++)
            if (!pq.isEmpty())
                ans.add(pq.poll());
        return ans;
    }
}
