package String;

public class QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters {

    public static void main(String[] args){
        QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters a=new QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters();
        System.out.println((a.Count("abc",2)));
        System.out.println((a.Count("aba",2)));
        System.out.println((a.Count("aa",1)));
    }

    public int Count(String S,int k){
        int N=S.length();
        int res=0;
        for (int i=0;i<N;i++){
            int distinct=0;
            int [] memo_c=new int [26];
            for (int j=i;j<N;j++){
                if (memo_c[S.charAt(j)-'a']==0){
                    distinct+=1;
                    memo_c[S.charAt(j)-'a']=1;
                }
                if (distinct>=k){
                    if (distinct==k) res+=1;
                    else break;
                }
            }
        }
        return res;
    }

}
