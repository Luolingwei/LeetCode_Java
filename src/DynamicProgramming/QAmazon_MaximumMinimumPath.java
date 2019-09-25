package DynamicProgramming;

public class QAmazon_MaximumMinimumPath {

    public static void main(String[] args){
        QAmazon_MaximumMinimumPath a=new QAmazon_MaximumMinimumPath();
        System.out.println(a.find(new int [][]{{8,5,7},{6,5,9}}));
        System.out.println(a.find(new int [][]{{5,4,5},{1,2,6},{7,4,6}}));
        System.out.println(a.find(new int [][]{{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}}));
    }

    public int find (int [][] matrix){
        int m=matrix.length,n=matrix[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                 if (i+j==0)
                     continue;
                int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE;
                if (i!=0) a=Math.max(a,matrix[i-1][j]);
                if (j!=0) b=Math.max(a,matrix[i][j-1]);
                matrix[i][j]=Math.min(Math.max(a,b),matrix[i][j]);
            }
        }
        return matrix[m-1][n-1];
    }
}
