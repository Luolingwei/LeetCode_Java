package Heap;

import java.util.*;

public class QAmazon_HighFive {

    public static void main(String[] args){
        QAmazon_HighFive a=new QAmazon_HighFive();
        List<Score> results=new ArrayList<Score>();
        results.add(new Score(1,80));
        results.add(new Score(1,90));
        results.add(new Score(1,34));
        results.add(new Score(1,23));
        results.add(new Score(1,90));
        results.add(new Score(1,100));
        results.add(new Score(2,67));
        results.add(new Score(2,54));
        results.add(new Score(2,65));
        System.out.println(a.highfive(results));
    }

    public static class Score{
        int id;
        int score;
        public Score(int id, int score){
            this.id = id;
            this.score = score;
        }
    }

    public Map<Integer,Double> highfive(List<Score> results){
        Map<Integer,PriorityQueue<Integer>> dic=new HashMap<>();
        Map<Integer,Double> ans=new HashMap<>();
        for (Score s:results){
            PriorityQueue<Integer> pq=dic.getOrDefault(s.id,new PriorityQueue<>(Collections.reverseOrder()));
            pq.add(s.score);
            dic.put(s.id,pq);
        }

        for (int id: dic.keySet()){
            PriorityQueue<Integer> pq=dic.get(id);
            int curS=0,count=0;
            for (int i=0;i<5;i++){
                if (!pq.isEmpty()){
                    curS+=pq.poll();
                    count+=1;
                }
                else break;
            }
            ans.put(id,curS*1.0/count);
        }
        return ans;

    }
}
