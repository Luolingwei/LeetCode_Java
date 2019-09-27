package String;

import java.util.*;

public class QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters {

    public static void main(String[] args){
        QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters a=new QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters();
        System.out.println((a.Count("abcabc",3)));
        System.out.println((a.Count("abacab",3)));
        System.out.println((a.Count("awaglknagawunagwkwagl",4)));
    }

    // 1: 长度不固定，计算distinct 字母=k的子串个数
//    public int Count(String S,int k){
//        int N=S.length();
//        int res=0;
//        for (int i=0;i<N;i++){
//            int distinct=0;
//            int [] memo_c=new int [26];
//            for (int j=i;j<N;j++){
//                if (memo_c[S.charAt(j)-'a']==0){
//                    distinct+=1;
//                    memo_c[S.charAt(j)-'a']=1;
//                }
//                if (distinct>=k){
//                    if (distinct==k) res+=1;
//                    else break;
//                }
//            }
//        }
//        return res;
//    }

        // 2: 长度固定，长度=k，distinct 也是 k sliding window
        public List<String> Count(String S,int k){
            int distinct=0,i=0;
            int [] memo=new int[26];
            Set<String> set=new HashSet<>();
            for (;i<k;i++){
                if (memo[S.charAt(i)-'a']==0)
                    distinct+=1;
                memo[S.charAt(i)-'a']+=1;
            }
            if (distinct==k) {
                set.add(S.substring(i-k,i));
            }
            while (i<S.length()){
                if (memo[S.charAt(i)-'a']==0)
                    distinct+=1;
                memo[S.charAt(i)-'a']+=1;
                memo[S.charAt(i-k)-'a']-=1;
                if (memo[S.charAt(i-k)-'a']==0)
                    distinct-=1;
                if (distinct==k)
                    set.add(S.substring(i-k+1,i+1));
                i+=1;
                }

            return new ArrayList<>(set);
        }
}
