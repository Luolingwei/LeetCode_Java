package Design;

import java.util.HashMap;
import java.util.Stack;

public class Q895_MaximumFrequencyStack {

    HashMap<Integer,Integer> freq=new HashMap<>();
    HashMap<Integer, Stack<Integer>> stack=new HashMap<>();
    int maxfreq=0;

    public void push(int x) {
        int newfreq=freq.getOrDefault(x,0)+1;
        freq.put(x,newfreq);
        maxfreq=Math.max(maxfreq,newfreq);
        if (!stack.containsKey(newfreq))
            stack.put(newfreq,new Stack<Integer>());
        stack.get(newfreq).add(x);
    }

    public int pop() {
        int x=stack.get(maxfreq).pop();
        freq.put(x,maxfreq-1);
        if (stack.get(maxfreq).size()==0)
            maxfreq-=1;
        return x;

    }

}