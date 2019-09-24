package Array;

import java.util.Arrays;

public class Q48_RotateImage {

    public static void main(String[] args){
        Q48_RotateImage a=new Q48_RotateImage();
        System.out.println(Arrays.deepToString(a.rotate(new int [][]{{1,2,3},{4,5,6},{7,8,9}})));
    }

    //顺时针Rotate
    public int [][] rotate(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int i=0,j=m-1;
        while (i<j){
            int [] temp=matrix[j];
            matrix[j]=matrix[i];
            matrix[i]=temp;
            i+=1;j-=1;
        }
        for (int x=0;x<m;x++){
            for (int y=x+1;y<n;y++){
                int temp=matrix[x][y];
                matrix[x][y]=matrix[y][x];
                matrix[y][x]=temp;
            }
        }
        return matrix;
    }
        //逆时针Rotate
//        public int [][] rotate(int[][] matrix) {
//            int m=matrix.length,n=matrix[0].length;
//            int l=0,r=n-1;
//            while (l<r){
//                for (int row=0;row<m;row++){
//                    int temp=matrix[row][l];
//                    matrix[row][l]=matrix[row][r];
//                    matrix[row][r]=temp;
//                }
//                l++;r--;
//            }
//        for (int x=0;x<m;x++){
//            for (int y=x+1;y<n;y++){
//                int temp=matrix[x][y];
//                matrix[x][y]=matrix[y][x];
//                matrix[y][x]=temp;
//            }
//        }
//        return matrix;
//        }
}
