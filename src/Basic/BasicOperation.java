package Basic;

import java.util.*;
import java.util.stream.Collectors;

public class BasicOperation {


    public static void main(String[] args) {

        // 1 array 转 list (基本类型)
        int[] intArray = new int[5];
        intArray[2] = 5;
        intArray[4] = 10;
        // stream 方法, boxed
        List<Integer> integerList1 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        System.out.println(integerList1);

        // 2 array 转 list (非基本类型)
        Integer[] integerArray = new Integer[5];
        integerArray[2] = 5;
        integerArray[4] = 10;
        // Arrays.stream 方法
        List<Integer> integerList2 = Arrays.stream(integerArray).collect(Collectors.toList());
        System.out.println(integerList2);
        // Arrays.asList 方法
        List<Integer> integerList3 = new ArrayList<>(Arrays.asList(integerArray));
        System.out.println(integerList3);
        // Collections.addAll 方法
        List<Integer> integerList4 = new ArrayList<>();
        Collections.addAll(integerList4, integerArray);
        System.out.println(integerList4);

        // 3 list 转 array (基本类型)
        // list.stream 方法 + mapToInt
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int[] intArray1 = integerList.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(intArray1));

        // 4 list 转 array (非基本类型)
        // list.stream 方法
        Integer[] integerArray1 = integerList.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integerArray1));
        // list.toArray方法
        Integer[] integerArray2 = integerList.toArray(new Integer[integerList.size()]);
        System.out.println(Arrays.toString(integerArray2));


    }
}
