package String;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters {

    public static void main(String[] args){
        QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters a=new QAmazon_CountNumberofSubstringsWithExactlykDistinctCharacters();
        System.out.println((a.Count("abc",2)));
        System.out.println((a.Count("abbbbaaaa",2)));
        System.out.println((a.Count("aa",2)));
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

        // 2: 长度固定，长度=k，distinct 字母=k-1
        public int Count(String S,int k){
            int N=S.length(),res=0;
            for (int i=0;i<=N-k;i++){
                Set<Character> dic=new HashSet<>();
                for (int j=i;j<i+k;j++){
                    dic.add(S.charAt(j));
                }
                if (dic.size()==k-1)
                    res+=1;
            }
            return res;
        }
}
