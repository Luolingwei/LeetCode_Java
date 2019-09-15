package BinarySearch;


public class Q240_SearchA2DMatrixII {
    public static void main(String[] args){
        Q240_SearchA2DMatrixII a=new Q240_SearchA2DMatrixII();
        System.out.println(a.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
        System.out.println(a.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
        System.out.println(a.searchMatrix(new int[][]{},20));
        System.out.println(a.searchMatrix(new int[][]{{}},20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int r=m-1,c=0;
        while (r>=0 && c<n){
            if (matrix[r][c]==target)
                return true;
            else if (matrix[r][c]<target)
                c+=1;
            else
                r-=1;
        }
        return false;
    }
}
