package DynamicProgramming;

public class QAmazon_MaximumMinimumPath {

    public static void main(String[] args){
        QAmazon_MaximumMinimumPath a=new QAmazon_MaximumMinimumPath();
        System.out.println(a.find(new int [][]{{8,5,7},{6,5,9}}));
    }

    public int find (int [][] matrix){
        int m=matrix.length,n=matrix[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i+j==0) continue;
                int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE;
                if (i-1>=0) a=matrix[i-1][j];
                if (j-1>=0) b=matrix[i][j-1];
                matrix[i][j]=Math.min(matrix[i][j],Math.max(a,b));
            }
        }
        return matrix[m-1][n-1];
    }
}
