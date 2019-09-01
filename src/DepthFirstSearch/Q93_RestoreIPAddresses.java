package DepthFirstSearch;
import java.util.*;

public class Q93_RestoreIPAddresses {

    public static void main(String[] args){
        Q93_RestoreIPAddresses a=new Q93_RestoreIPAddresses();
        System.out.println(a.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s,0,"",ans);
        return ans;
    }

    public void dfs(String s, int length, String path, List<String> ans) {
        if (length==4){
            if (s.isEmpty())
                ans.add(path.substring(0,path.length()-1));
            return;
        }
        for (int i=1;i<4;i++){
            if (i<=s.length()){
                if (i==1)
                    dfs(s.substring(i,s.length()),length+1,path+s.substring(0,i)+'.',ans);
                if (i==2 && s.charAt(0)!='0')
                    dfs(s.substring(i,s.length()),length+1,path+s.substring(0,i)+'.',ans);
                if (i==3 && s.charAt(0)!='0' && Integer.valueOf(s.substring(0,i))<256)
                    dfs(s.substring(i,s.length()),length+1,path+s.substring(0,i)+'.',ans);
            }

        }
    }
}
