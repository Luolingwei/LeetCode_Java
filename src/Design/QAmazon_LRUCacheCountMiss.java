package Design;
import java.util.*;

public class QAmazon_LRUCacheCountMiss {


    public static void main(String[] args){
        QAmazon_LRUCacheCountMiss a=new QAmazon_LRUCacheCountMiss();
        System.out.println(a.Count(new int []{1, 2, 3, 1, 4, 3, 5},3));
    }

    public int Count(int [] array, int size){
        int miss=0;
        LinkedList<Integer> cache=new LinkedList<>();
        for (int i=0;i<array.length;i++){
            if (cache.contains(array[i]))
                cache.remove(new Integer(array[i]));
            else {
                miss++;
                if (cache.size()>=size)
                    cache.removeFirst();
            }
            cache.add(array[i]);
        }
        return miss;
    }

}
