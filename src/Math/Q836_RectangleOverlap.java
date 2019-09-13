package Math;

public class Q836_RectangleOverlap {

    public static void main(String[] args){
        Q836_RectangleOverlap a=new Q836_RectangleOverlap();
        System.out.println(a.isRectangleOverlap(new int[] {0,0,2,2},new int[] {1,1,3,3}));
        System.out.println(a.isRectangleOverlap(new int[] {0,0,1,1},new int[] {1,0,2,1}));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0]>=rec2[2] || rec2[0]>=rec1[2] || rec1[1]>=rec2[3] || rec2[1]>=rec1[3])
            return false;
        return true;
    }
}
