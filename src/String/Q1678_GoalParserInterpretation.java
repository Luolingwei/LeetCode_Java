package String;

public class Q1678_GoalParserInterpretation {

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
        System.out.println(interpret("(al)G(al)()()G"));
    }

    public static String interpret(String command) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i<command.length()){
            if (command.substring(i,i+1).equals("G")) {
                sb.append("G");
                i+=1;
            } else if (command.substring(i,i+2).equals("()")) {
                sb.append("o");
                i+=2;
            } else if (command.substring(i,i+4).equals("(al)")) {
                sb.append("al");
                i+=4;
            }
        }
        return sb.toString();
    }
}
