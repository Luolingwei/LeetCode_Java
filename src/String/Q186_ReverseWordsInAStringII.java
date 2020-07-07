package String;

public class Q186_ReverseWordsInAStringII {

    public static void main(String[] args) {
        Q186_ReverseWordsInAStringII a = new Q186_ReverseWordsInAStringII();
        a.reverseWords(new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
    }

    public void reverseWords(char[] s) {
        reverse(0,s.length-1,s);
        int i = 0;
        for (int j=0;j<s.length+1;j++){
            if (j==s.length || s[j]==' '){
                reverse(i,j-1,s);
                i = j+1;
            }
        }
    }

    private void reverse(int i, int j, char[] words){
        while (i<j){
            char temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
    }

}
