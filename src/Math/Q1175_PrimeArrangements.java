package Math;

import java.util.Arrays;

public class Q1175_PrimeArrangements {

    public static void main(String[] args){
        Q1175_PrimeArrangements a=new Q1175_PrimeArrangements();
        System.out.println(a.numPrimeArrangements(5));
        System.out.println(a.numPrimeArrangements(100));
    }

    public int numPrimeArrangements(int n) {
        int primes=countprimes(n);
        long res=1;
        for (int j=1;j<=primes;j++)
            res=(res*j)%1000000007;
        for (int j=1;j<=n-primes;j++)
            res=(res*j)%1000000007;
        return (int)res;
    }

    public int countprimes(int n) {
        int [] A=new int[n+1];
        int primes=0;
        Arrays.fill(A,1);
        A[0]=0;A[1]=0;
        for (int i=2;i*i<=n;i++){
            if (A[i]==1){
                for (int j=i*i;j<=n;j+=i){
                    A[j]=0;
                }
            }
        }
        for (int i=0;i<=n;i++){
            primes+=A[i];
        }
        return primes;
    }
}
