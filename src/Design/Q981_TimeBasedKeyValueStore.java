package Design;
import java.util.*;

public class Q981_TimeBasedKeyValueStore {

    public static void main(String[] args){
        Q981_TimeBasedKeyValueStore a=new Q981_TimeBasedKeyValueStore();
        a.set("love","high",10);
        a.set("love","low",20);
        System.out.println(a.get("love",5));
        System.out.println(a.get("love",10));
        System.out.println(a.get("love",15));
        System.out.println(a.get("love",20));
        System.out.println(a.get("love",25));
    }

    /** Initialize your data structure here. */

    Map<String,List<Integer>> dicT=new HashMap<>();
    Map<String,List<String>> dicV=new HashMap<>();

    public void set(String key, String value, int timestamp) {
        if (!dicT.containsKey(key)){
            dicT.put(key,new ArrayList<>());
            dicV.put(key,new ArrayList<>());
        }
        dicT.get(key).add(timestamp);
        dicV.get(key).add(value);
    }

    public String get(String key, int timestamp) {
        int i=binary_search(timestamp,dicT.get(key));
        return i>=0?dicV.get(key).get(i):"";
    }

    int binary_search(int timestamp, List<Integer> times){
        int l=0,r=times.size()-1;
        while (l<r){
            int mid=(l+r+1)/2;
            if (times.get(mid)>timestamp)
                r=mid-1;
            else
                l=mid;
        }
        return (l==0 && times.get(l)>timestamp)?-1:l;
    }
}
