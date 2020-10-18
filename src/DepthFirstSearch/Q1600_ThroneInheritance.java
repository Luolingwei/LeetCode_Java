package DepthFirstSearch;

import java.util.*;

public class Q1600_ThroneInheritance {

    public static void main(String[] args) {
        Q1600_ThroneInheritance t = new Q1600_ThroneInheritance("king");
        t.birth("king", "andy"); // order: king > andy
        t.birth("king", "bob"); // order: king > andy > bob
        t.birth("king", "catherine"); // order: king > andy > bob > catherine
        t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // return ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }

    private Map<String, List<String>> memo = new HashMap<>();
    private Set<String> dead = new HashSet<>();
    private List<String> res;

    public Q1600_ThroneInheritance(String kingName) {

    }

    public void birth(String parentName, String childName) {
        if (!memo.containsKey(parentName)) memo.put(parentName,new ArrayList<>());
        memo.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        res = new ArrayList<>();
        dfs("king");
        return res;
    }

    private void dfs(String name){
        if (!dead.contains(name)) res.add(name);
        if (memo.containsKey(name))
            for (String child: memo.get(name))
                dfs(child);
    }

}
