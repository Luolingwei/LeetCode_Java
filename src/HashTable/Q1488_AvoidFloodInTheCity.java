package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q1488_AvoidFloodInTheCity {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 0, 1, 2})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{69, 0, 0, 0, 69})));
        System.out.println(Arrays.toString(avoidFlood(new int[]{10, 20, 20})));

    }

    public static int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> posMemo = new HashMap<>();
        TreeSet<Integer> slots = new TreeSet<>();
        int[] res = new int[rains.length];
        Arrays.fill(res,-1);
        for (int i=0;i<rains.length;i++){

            if (rains[i]==0){
                slots.add(i);
            } else {
                if (posMemo.containsKey(rains[i])){
                    Integer slot = slots.ceiling(posMemo.get(rains[i]));
                    if (slot == null) return new int[0];
                    res[slot] = rains[i];
                    slots.remove(slot);
                }
                posMemo.put(rains[i],i);

            }
        }
        for (int s: slots) res[s] = 1;
        return res;
    }

}
