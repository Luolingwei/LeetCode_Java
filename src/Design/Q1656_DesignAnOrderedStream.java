package Design;

import java.util.ArrayList;
import java.util.List;

public class Q1656_DesignAnOrderedStream {


    public static void main(String[] args) {

        Q1656_DesignAnOrderedStream os= new Q1656_DesignAnOrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // Inserts (3, "ccccc"), returns [].
        System.out.println(os.insert(1, "aaaaa")); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        System.out.println(os.insert(2, "bbbbb")); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        System.out.println(os.insert(5, "eeeee")); // Inserts (5, "eeeee"), returns [].
        System.out.println(os.insert(4, "ddddd")); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
    }

    private int idx;
    private String[] stream;

    public Q1656_DesignAnOrderedStream(int n) {
        idx = 1;
        stream = new String[n+2];
    }

    public List<String> insert(int id, String value) {
        stream[id] = value;
        List<String> res = new ArrayList<>();
        while (stream[idx]!=null){
            res.add(stream[idx]);
            idx++;
        }
        return res;
    }
}
