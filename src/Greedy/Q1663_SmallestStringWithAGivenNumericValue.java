package Greedy;

public class Q1663_SmallestStringWithAGivenNumericValue {


    public static void main(String[] args) {

        System.out.println(getSmallestString(3,27));
        System.out.println(getSmallestString(5,73));

        System.out.println(getSmallestString2(3,27));
        System.out.println(getSmallestString2(5,73));
    }


    public static String getSmallestString(int n, int k) {
        String res = "";
        while (k>0) {
            int left = (n-1)*26;
            if (k-1<left) {
                res += "a";
                n--;
                k--;
            } else {
                res += (char)((int)'a' + (k-1-left));
                n--;
                break;
            }
        }
        return res + "z".repeat(n);
    }

    public static String getSmallestString2(int n, int k) {

        // fill all 'a'
        k-=n;
        String res = "";
        int z_num = k/25;
        int single_num = k%25;

        res += "a".repeat(n-1-z_num);
        res += (char)((int)'a' + single_num);
        res += "z".repeat(z_num);
        return res;
    }
}
