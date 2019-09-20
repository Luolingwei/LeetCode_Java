package String;

public class QAmazon_RemoveVowel {

    public static void main(String[] args){
        QAmazon_RemoveVowel a=new QAmazon_RemoveVowel();
        System.out.println((a.remove("abc")));
        System.out.println((a.remove("abbbbaaaaAUUuiNcdUos")));
        System.out.println((a.remove("aaoipi")));
    }

    public String remove(String A){
        String ban="aeiouAEIOU";
        String ans="";
        for (int i=0;i<A.length();i++){
            if (ban.indexOf(A.charAt(i))!=-1)
                continue;
            else
                ans+=A.charAt(i);
        }
        return ans;
    }

}