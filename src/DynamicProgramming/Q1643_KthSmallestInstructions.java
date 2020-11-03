package DynamicProgramming;

public class Q1643_KthSmallestInstructions {

    public static void main(String[] args) {
        System.out.println(kthSmallestPath(new int[]{2,3}, 1));
        System.out.println(kthSmallestPath(new int[]{2,3}, 2));
        System.out.println(kthSmallestPath(new int[]{2,3}, 3));
        System.out.println(kthSmallestPath(new int[]{10,13}, 970514));
    }

    public static String kthSmallestPath(int[] destination, int k) {

        int v = destination[0], h = destination[1];
        int[][] comb = new int[v+h+1][v+h+1];

        for (int i = 0; i<v+h+1; i++){
            for (int j = 0; j<=i; j++){
                if (j==0) comb[i][j] = 1;
                else comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
            }
        }
        int count = v+h;
        StringBuilder res = new StringBuilder();
        for (int i=0; i<count; i++){
            if (v==0 || h==0) break;
            int left_count = count-i;
            int hstart = comb[left_count-1][h-1];
            if (k>hstart){
                res.append("V");
                k -= hstart;
                v-- ;
            } else {
                res.append("H");
                h-- ;
            }
        }
        res.append("V".repeat(v));
        res.append("H".repeat(h));
        return res.toString();
    }

}
